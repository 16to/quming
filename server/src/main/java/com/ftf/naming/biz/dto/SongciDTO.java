package com.ftf.naming.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 宋词
 * @author qumuasa
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongciDTO {
	private String rhythmic;
	private String author;
	private String[] paragraphs;
}
