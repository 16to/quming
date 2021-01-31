package com.ftf.naming.biz.domain.dao;

import java.util.Arrays;

import com.ftf.naming.biz.dto.LunyuDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LunyuDAO {

	public LunyuDAO(LunyuDTO data) {
		this.chapter = data.getChapter();
		this.content = Arrays.toString(data.getParagraphs());
	}
	
	private String chapter;
	private String content;
}
