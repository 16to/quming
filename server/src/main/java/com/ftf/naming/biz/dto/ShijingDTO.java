package com.ftf.naming.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 诗经
 * @author qumuasa
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShijingDTO {
	private String title;
	private String chapter;
	private String section;
	private String[] content;
}
