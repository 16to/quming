package com.ftf.naming.biz.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ftf.naming.biz.dto.NameDTO;
import com.ftf.naming.biz.param.NewNameParam;
import com.ftf.naming.biz.vo.NameVO;
import com.ftf.naming.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NameService {
	
	private List<NameDTO> nameList;
	
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
            TypeReference<List<NameDTO>> t = new TypeReference<List<NameDTO>>() {};
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
	
	public NameVO newName(NewNameParam param) {
		NameDTO name = nameList.get(r.nextInt(nameList.size()));
		return new NameVO(param.getFirstName(),name);
	}
}
