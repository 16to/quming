package com.ftf.naming.biz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ftf.naming.biz.domain.dao.LunyuDAO;

@Mapper
public interface LunyuMapper {

	LunyuDAO listAll();
	
	LunyuDAO selectById(@Param("id") Integer id);
	
	int batchInsert(List<LunyuDAO> lunyuList);
}
