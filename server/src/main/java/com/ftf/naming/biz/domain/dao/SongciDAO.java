package com.ftf.naming.biz.domain.dao;

import java.util.Arrays;

import com.ftf.naming.biz.dto.SongciDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongciDAO {

	public SongciDAO(SongciDTO data) {
		this.title = data.getRhythmic();
		this.author = data.getAuthor();
		this.content = Arrays.toString(data.getParagraphs());
	}
	
	private String title;
	private String author;
	private String content;
}
