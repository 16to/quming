package com.ftf.naming.biz.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ftf.naming.biz.dto.XHwordDTO;
import com.ftf.naming.biz.enums.ConstellationEnum;
import com.ftf.naming.biz.enums.ElementEnum;
import com.ftf.naming.biz.enums.SourceEnum;
import com.ftf.naming.biz.enums.ZodiacEnum;
import com.ftf.naming.biz.param.CollectNameParam;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.vo.NameDetailVO;
import com.ftf.naming.biz.vo.NameVO;
import com.ftf.naming.biz.vo.WordVO;
import com.ftf.naming.util.JsonUtil;
import com.ftf.naming.util.UuidUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NameService {
	
	private List<XHwordDTO> nameList;
	
	private ConcurrentHashMap<String, NameVO> names = new ConcurrentHashMap<String, NameVO>();
	
	private ConcurrentHashMap<String, NameVO> collectNames = new ConcurrentHashMap<String, NameVO>();
	
	private Random r = new Random();

	@PostConstruct
	public void init() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/word.json"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            TypeReference<List<XHwordDTO>> t = new TypeReference<List<XHwordDTO>>() {};
            nameList = JsonUtil.string2Obj(sb.toString(), t);
        }
		catch(Exception e) {
			log.error("name init error",e);
		}
		finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
	
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
		newName.setLength(2);
		newName.setZodiac(getZodiac(newName).getName());
		newName.setConstellation(getConstellation(newName).getName());
		newName.setSource(getSource(newName));
		
		List<WordVO> lastName = new ArrayList<WordVO>();
		lastName.add(getWord(param));
		
		newName.setLastName(lastName);
		
		names.put(nameId, newName);
		
		return newName;
	}
	
	public WordVO getWord(NewNameParam param) {
		XHwordDTO name = nameList.get(r.nextInt(nameList.size()));
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
		nameDetail.setZodiac(new NameDetailVO.Zodiac(getZodiac(name).getType(), getZodiac(name).getName(),
				"汪汪汪"));
		nameDetail.setConstellation(new NameDetailVO.Constellation(getConstellation(name).getType(),
				getConstellation(name).getName(), "七月份的尾巴你是狮子座"));
		nameDetail.setSame(new NameDetailVO.Same(10, 10));
		nameDetail.setLastName(name.getLastName());
		return nameDetail;
	}
	
	public void collectName(CollectNameParam param) {
		NameVO name = names.get(param.getNameId());
		collectNames.put(param.getUserId(), name);
	}
	
	public List<NameVO> getCollectNameList(String userId) {
		List<NameVO> result = new ArrayList<NameVO>();
		result.add(collectNames.get(userId));
		return result;
	}
	
	private String getSource(NameVO name) {
		return SourceEnum.SHIJING.getName();
	}
	
	private String getCelebrity(NameVO name) {
		return "还名人呢？你就是个人名";
	}
	
	private ZodiacEnum getZodiac(NameVO name) {
		return ZodiacEnum.DOG;
	}
	
	private ElementEnum getElement(XHwordDTO name) {
		return ElementEnum.METAL;
	}

	private ConstellationEnum getConstellation(NameVO name) {
		return ConstellationEnum.LEO;
	}
}
