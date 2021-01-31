package com.ftf.naming.biz.domain.dao;

import java.util.Arrays;

import com.ftf.naming.biz.dto.TangshiDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TangshiDAO {

	public TangshiDAO(TangshiDTO data) {
		this.title = data.getTitle();
		this.author = data.getAuthor();
		this.content = Arrays.toString(data.getParagraphs());
	}
	
	private String title;
	private String author;
	private String content;
}
