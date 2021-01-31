package com.ftf.naming.biz.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.naming.biz.domain.dao.XHWordDAO;
import com.ftf.naming.biz.domain.mapper.XHWordMapper;
import com.ftf.naming.biz.enums.ElementEnum;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.vo.WordVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class XHWordService {

	public Random r = new Random();
	
	@Autowired
	private XHWordMapper xhwordMapper;
	
	public WordVO getWordByKeyWord(String keyWord) {
		XHWordDAO name = xhwordMapper.selectByWord(keyWord);
		if(name == null) {
			log.error("{}在新华字典中不存在",keyWord);
			return null;
		}
		WordVO word = new WordVO();
		word.setWord(name.getWord());
		word.setOldword(name.getOldword());
		word.setStrokes(Integer.valueOf(name.getStrokes()));
		word.setPinyin(name.getPinyin());
		word.setExplanation(name.getExplanation());
		ElementEnum element = getElement(name);
		log.info("五行：{}",name.getWx());
		if(element != null) {
			word.setElement(new WordVO.Element(element.getType(),element.getName(),element.getExplanation()));
		}
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
		if(element !=null) {
			word.setElement(new WordVO.Element(element.getType(),element.getName(),element.getType()));
		}
		
		return word;
	}
	
	private ElementEnum getElement(XHWordDAO word) {
		return ElementEnum.getByName(word.getWx());
	}
}
