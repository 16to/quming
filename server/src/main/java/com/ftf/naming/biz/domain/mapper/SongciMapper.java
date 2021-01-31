package com.ftf.naming.biz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ftf.naming.biz.domain.dao.SongciDAO;

@Mapper
public interface SongciMapper {

	SongciDAO listAll();
	
	SongciDAO selectById(@Param("id") Integer id);
	
	int batchInsert(List<SongciDAO> songciList);
}