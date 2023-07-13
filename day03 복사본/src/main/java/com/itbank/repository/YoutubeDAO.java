package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.YoutubeDTO;

@Repository
public interface YoutubeDAO {

	@Select("select * from youtube_list order by idx")
	List<YoutubeDTO> selectList();	// ResultSet executeQuery()

	@Select("select * from youtube_list where idx = #{idx}")
	YoutubeDTO selectOne(int idx);

	@Delete("delete youtube_list where idx = #{idx}")
	int delete(int idx);			// int executeUpdate()

	@Insert("insert into youtube_list (title, channel, thumbnail, iframe) values ("
			+ "#{title}, #{channel}, #{thumbnail}, #{iframe} "
			+ ")")
	int insert(YoutubeDTO dto);
	// myBatis의 함수에 인자를 전달할때는 가급적 하나만 전달한다

	@Update("update youtube_list "
			+ "	set "
			+ "		title = #{title},"
			+ " 	channel = #{channel},"
			+ " 	thumbnail = #{thumbnail},"
			+ " 	iframe = #{iframe}"
			+ "	where"
			+ "		idx = #{idx}")
	int update(YoutubeDTO dto);

//	@Select("select * from youtube_list where title like '%${search}%'")
	@Select("select * from youtube_list where title like '%' || #{search} || '%'")
	List<YoutubeDTO> search(String search);

}








