package com.ftf.naming.biz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.naming.biz.domain.dao.ShijingDAO;
import com.ftf.naming.biz.domain.dao.XHWordDAO;
import com.ftf.naming.biz.domain.mapper.ShijingMapper;
import com.ftf.naming.biz.domain.mapper.XHWordMapper;
import com.ftf.naming.biz.enums.ConstellationEnum;
import com.ftf.naming.biz.enums.ElementEnum;
import com.ftf.naming.biz.enums.SourceEnum;
import com.ftf.naming.biz.enums.ZodiacEnum;
import com.ftf.naming.biz.param.CollectNameParam;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.vo.NameDetailVO;
import com.ftf.naming.biz.vo.NameVO;
import com.ftf.naming.biz.vo.WordVO;
import com.ftf.naming.util.UuidUtil;

@Service
public class NameService {
	
	@Autowired
	private XHWordMapper xhwordMapper;
	
	@Autowired
	private ShijingMapper shijingMapper;
	
	@Autowired
	private ZodiacService zodiacService;
	
	@Autowired
	private ConstellationService constellationService;
	
	private ConcurrentHashMap<String, NameVO> names = new ConcurrentHashMap<String, NameVO>();
	
	private ConcurrentHashMap<String, ConcurrentHashMap<String,NameVO>> collectNames = new ConcurrentHashMap<String, ConcurrentHashMap<String, NameVO>>();
	
	private Random r = new Random();
	
	public List<NameVO> generate(NewNameParam param){
		List<NameVO> result = new ArrayList<NameVO>();
		result.add(newName(param));
		return result;
	}
	
	public NameVO newName(NewNameParam param) {
		NameVO newName = new NameVO();
		String nameId = UuidUtil.create();
		newName.setId(nameId);
		newName.setFirstName(param.getFirstName());
		newName.setLength(3);
		newName.setZodiac(getZodiac(param.getBirth()).getName());
		newName.setConstellation(getConstellation(param.getBirth()).getName());
		newName.setSource(getSource(newName));
		
		//从新华字典获取名字
		List<WordVO> lastName = new ArrayList<WordVO>();
//		lastName.add(getWord(param));
		
		//从诗经获取名字
		lastName = getWordFromShijing(param);
		
		newName.setLastName(lastName);
		
		names.put(nameId, newName);
		
		return newName;
	}
	
	public List<WordVO> getWordFromShijing(NewNameParam param) {
		List<WordVO> lastName = new ArrayList<WordVO>();
		int id = r.nextInt(305);
		ShijingDAO shijing = shijingMapper.selectById(id);
		String content = shijing.getContent();
		//从诗经的句子冲取出字
		lastName.add(getWordByShijing(content,1));
		lastName.add(getWordByShijing(content,4));
		return lastName;
	}
	
	private WordVO getWordByShijing(String content,Integer index) {
		String keyWord = content.substring(index,index+1);
		XHWordDAO name = xhwordMapper.selectByWord(keyWord);
		WordVO word = new WordVO();
		word.setWord(name.getWord());
		word.setOldword(name.getOldword());
		word.setStrokes(Integer.valueOf(name.getStrokes()));
		word.setPinyin(name.getPinyin());
		word.setExplanation(name.getExplanation());
		ElementEnum element = getElement(name);
		word.setElement(new WordVO.Element(element.getType(),element.getName(),"五行的解释"));
		return word;
	}
	
	public WordVO getWord(NewNameParam param) {
		int id = r.nextInt(10000);
		XHWordDAO name = xhwordMapper.selectById(id);
		WordVO word = new WordVO();
		word.setWord(name.getWord());
		word.setOldword(name.getOldword());
		word.setStrokes(Integer.valueOf(name.getStrokes()));
		word.setPinyin(name.getPinyin());
		word.setExplanation(name.getExplanation());
		ElementEnum element = getElement(name);
		word.setElement(new WordVO.Element(element.getType(),element.getName(),"五行的解释"));
		
		return word;
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
		nameDetail.setSame(new NameDetailVO.Same(10, 10));
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
	
	private String getSource(NameVO name) {
		return SourceEnum.SHIJING.getName();
	}
	
	private String getCelebrity(NameVO name) {
		return "还名人呢？你就是个人名";
	}
	
	private ZodiacEnum getZodiac(String birth) {
		return zodiacService.getByBirth(birth);
	}
	
	private ElementEnum getElement(XHWordDAO name) {
		return ElementEnum.METAL;
	}

	private ConstellationEnum getConstellation(String birth) {
		return constellationService.getByBirth(birth);
	}
}
