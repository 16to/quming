package com.ftf.naming.biz.service.intf;

import java.util.List;
import java.util.Random;

import com.ftf.naming.biz.vo.WordVO;

/**
 * 	出处
 * @author qumuasa
 *
 */
public interface CCInterface {

	public Random r = new Random();
	
	List<WordVO> getWord();
}
