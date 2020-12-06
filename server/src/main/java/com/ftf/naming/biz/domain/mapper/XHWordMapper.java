package com.ftf.naming.biz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ftf.naming.biz.domain.dao.XHWordDAO;

@Mapper
public interface XHWordMapper {

	XHWordDAO listAll();
	
	XHWordDAO selectById(@Param("id") Integer id);
	
	XHWordDAO selectByWord(@Param("word") String word);
	
	int batchInsert(List<XHWordDAO> wordList);
}
