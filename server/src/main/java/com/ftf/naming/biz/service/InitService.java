package com.ftf.naming.biz.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ftf.naming.biz.domain.dao.XHWordDAO;
import com.ftf.naming.biz.domain.mapper.XHWordMapper;
import com.ftf.naming.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InitService {

	@Autowired
	private XHWordMapper xhwordMapper;
	
	private List<XHWordDAO> wordList;
	
	public void init() {
		InputStreamReader is = null;
		try{
			is = new InputStreamReader(this.getClass().getResourceAsStream("/word.json"),"utf-8");
			StringBuffer sb = new StringBuffer();
			int ch = 0;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
            TypeReference<List<XHWordDAO>> t = new TypeReference<List<XHWordDAO>>() {};
            wordList = JsonUtil.string2Obj(sb.toString(), t);
            
            xhwordMapper.batchInsert(wordList);
        }
		catch(Exception e) {
			log.error("xhword init error",e);
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
}
