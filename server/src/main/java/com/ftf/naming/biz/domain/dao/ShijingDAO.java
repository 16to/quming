package com.ftf.naming.biz.domain.dao;

import java.util.Arrays;

import com.ftf.naming.biz.dto.ShijingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShijingDAO {

	public ShijingDAO(ShijingDTO s) {
		this.title = s.getTitle();
		this.chapter = s.getChapter();
		this.section = s.getSection();
		this.content = Arrays.toString(s.getContent());
	}
	
	private String title;
	private String chapter;
	private String section;
	private String content;
}
