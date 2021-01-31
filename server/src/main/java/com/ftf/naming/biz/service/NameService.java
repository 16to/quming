package com.ftf.naming.biz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ftf.naming.biz.domain.dao.ShijingDAO;
import com.ftf.naming.biz.domain.dao.XHWordDAO;
import com.ftf.naming.biz.domain.mapper.ShijingMapper;
import com.ftf.naming.biz.domain.mapper.XHWordMapper;
import com.ftf.naming.biz.dto.SameNameDTO;
import com.ftf.naming.biz.enums.ConstellationEnum;
import com.ftf.naming.biz.enums.ElementEnum;
import com.ftf.naming.biz.enums.SourceEnum;
import com.ftf.naming.biz.enums.ZodiacEnum;
import com.ftf.naming.biz.param.CollectNameParam;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.service.intf.CCInterface;
import com.ftf.naming.biz.vo.NameDetailVO;
import com.ftf.naming.biz.vo.NameVO;
import com.ftf.naming.biz.vo.WordVO;
import com.ftf.naming.util.RuleUtil;
import com.ftf.naming.util.UuidUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NameService {
	
	@Autowired
	private ZodiacService zodiacService;
	
	@Autowired
	private XHWordService xhWordService;
	
	@Autowired
	private CCInterface ccService;
	
	@Autowired
	private ConstellationService constellationService;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private ConcurrentHashMap<String, NameVO> names = new ConcurrentHashMap<String, NameVO>();
	
	private ConcurrentHashMap<String, ConcurrentHashMap<String,NameVO>> collectNames = new ConcurrentHashMap<String, ConcurrentHashMap<String, NameVO>>();
	
	private static final String SAME_URL = "http://api.16to.com/qm/sex?s=";
	
	public List<NameVO> generate(NewNameParam param){
		List<NameVO> result = new ArrayList<NameVO>();
		for(int i=0;i<10;i++) {
			try {
				result.add(newName(param));
			}
			catch(Exception e) {
				log.error("生成名字发生异常",e);
				continue;
			}
		}
		return result;
	}
	
	public NameVO newName(NewNameParam param) {
		NameVO newName = new NameVO();
		String nameId = UuidUtil.create();
		newName.setId(nameId);
		newName.setFirstName(xhWordService.getWordByKeyWord(param.getFirstName()));
		
		newName.setZodiac(getZodiac(param.getBirth()).getName());
		newName.setConstellation(getConstellation(param.getBirth()).getName());
		newName.setSource(getSource(newName));
		
		//从新华字典获取名字
		List<WordVO> lastName = new ArrayList<WordVO>();
//		lastName.add(getWord(param));
		
		lastName = ccService.getWord();
		
		newName.setLength(lastName.size());
		
		newName.setLastName(lastName);
		
		names.put(nameId, newName);
		
		return newName;
	}
	
	public NameDetailVO getNameDetail(String nameId) {
		NameDetailVO nameDetail = new NameDetailVO();
		NameVO name = names.get(nameId);
		if(name == null) {
			return null;
		}
		nameDetail.setId(nameId);
		nameDetail.setFirstName(name.getFirstName());
		nameDetail.setLength(name.getLength());
		nameDetail.setSource(name.getSource());
		nameDetail.setCelebrities(Collections.singletonList(getCelebrity(name)));
		nameDetail.setZodiac(new NameDetailVO.Zodiac(ZodiacEnum.getByName(name.getZodiac())));
		nameDetail.setConstellation(new NameDetailVO.Constellation(ConstellationEnum.getByName(name.getConstellation())));
		nameDetail.setSame(getSame(name));
		nameDetail.setLastName(name.getLastName());
		return nameDetail;
	}
	
	public void collectName(CollectNameParam param) {
		NameVO name = names.get(param.getNameId());
		ConcurrentHashMap<String,NameVO> nameMap = new ConcurrentHashMap<String,NameVO>();
		nameMap.put(param.getNameId(), name);
		collectNames.put(param.getUserId(), nameMap);
	}
	
	public void collectCancer(CollectNameParam param) {
		ConcurrentHashMap<String,NameVO> nameMap = collectNames.get(param.getUserId());
		if(nameMap != null) {
			nameMap.remove(param.getNameId());
		}
	}
	
	public List<NameVO> getCollectNameList(String userId) {
		List<NameVO> result = new ArrayList<NameVO>();
		for(NameVO name : collectNames.get(userId).values()) {
			result.add(name);
		}
		return result;
	}
	
	private NameDetailVO.Same getSame(NameVO nameVO) {
		NameDetailVO.Same same = null;
		try {
			SameNameDTO sameName = restTemplate.getForObject(SAME_URL + nameVO.generateFullName(), SameNameDTO.class);
			same = new NameDetailVO.Same(sameName.getAll(),sameName.getMan(),sameName.getFeman());
		}
		catch(Exception e) {
			log.error("获取同名信息失败",e);
		}
		
		return same; 
	}
	
	private String getSource(NameVO name) {
		return SourceEnum.SHIJING.getName();
	}
	
	private String getCelebrity(NameVO name) {
		return name.generateFullName();
	}
	
	private ZodiacEnum getZodiac(String birth) {
		return zodiacService.getByBirth(birth);
	}
	
	private ElementEnum getElement(XHWordDAO word) {
		return ElementEnum.getByName(word.getWx());
	}

	private ConstellationEnum getConstellation(String birth) {
		return constellationService.getByBirth(birth);
	}
}
