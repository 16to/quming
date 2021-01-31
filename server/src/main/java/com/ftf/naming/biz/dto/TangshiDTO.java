package com.ftf.naming.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 唐诗
 * @author qumuasa
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TangshiDTO {
	private String title;
	private String author;
	private String[] paragraphs;
}
