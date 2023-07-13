package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	@Select("select * from board order by idx")
	List<BoardDTO> selectAll();

	@Insert("insert into board (nickName, title, content) values ("
			+ "#{nickName}, #{title}, #{content} "
			+")")
	int insert(BoardDTO dto);

	@Select("select * from board where idx=#{idx}")
	BoardDTO selectOne(int idx);

	
	@Delete("delete board where idx=#{idx}")
	int delete(int idx);

	@Update("update board "
			+ " set "
			+ " 	nickName = #{nickName},"
			+ " 	title = #{title}," 
			+ " 	content = #{content}"
			+ " where "
			+ " 	idx = #{idx}")
	int update(BoardDTO dto);

	@Select("select * from board where title like '%${search}%'")
	List<BoardDTO> search(String search);

}
