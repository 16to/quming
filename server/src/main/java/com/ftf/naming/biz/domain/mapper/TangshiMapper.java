package com.ftf.naming.biz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ftf.naming.biz.domain.dao.TangshiDAO;

@Mapper
public interface TangshiMapper {

	TangshiDAO listAll();
	
	TangshiDAO selectById(@Param("id") Integer id);
	
	int batchInsert(List<TangshiDAO> tangshiList);
}