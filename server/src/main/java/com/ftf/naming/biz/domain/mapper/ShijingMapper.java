package com.ftf.naming.biz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ftf.naming.biz.domain.dao.ShijingDAO;

@Mapper
public interface ShijingMapper {

	ShijingDAO listAll();
	
	ShijingDAO selectById(@Param("id") Integer id);
	
	int batchInsert(List<ShijingDAO> shijingList);
}
