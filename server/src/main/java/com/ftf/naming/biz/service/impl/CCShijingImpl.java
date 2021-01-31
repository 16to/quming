package com.ftf.naming.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftf.naming.biz.domain.dao.ShijingDAO;
import com.ftf.naming.biz.domain.mapper.ShijingMapper;
import com.ftf.naming.biz.service.XHWordService;
import com.ftf.naming.biz.service.intf.CCInterface;
import com.ftf.naming.biz.vo.WordVO;
import com.ftf.naming.util.RuleUtil;

@Service
public class CCShijingImpl implements CCInterface {

	@Autowired
	private ShijingMapper shijingMapper;
	
	@Autowired
	private XHWordService xhWordService;
	
	@Override
	public List<WordVO> getWord() {
		List<WordVO> lastName = new ArrayList<WordVO>();
		int id = r.nextInt(305);
		ShijingDAO shijing = shijingMapper.selectById(id);
		String content = shijing.getContent();
		List<String> wordList = RuleUtil.run(content.split("，"));
		if(wordList != null) {
			wordList.stream().forEach(w->lastName.add(xhWordService.getWordByKeyWord(w)));
		}
		return lastName;
	}

}
