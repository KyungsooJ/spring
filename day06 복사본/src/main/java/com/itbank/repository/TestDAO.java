package com.itbank.repository;

import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {

	@Select("select * from v$version")
	String selectVersion();

	@Insert("insert into youtube_list (title, thumbnail, channel, iframe) "
			+ "values ( #{title}, #{thumbnail}, #{channel}, #{iframe} )")
	int insert(HashMap<String, Object> param);

	
}
