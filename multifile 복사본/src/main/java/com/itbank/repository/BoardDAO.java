package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {

	List<BoardDTO> select();

	int insertBoard(BoardDTO dto);

	int selectMaxIdx();

	int insertFile(HashMap<String, Object> param);

	BoardDTO selectOneBoard(int idx);

	List<String> selectFile(int idx);

	int updateBoard(BoardDTO dto);

	int deleteFile(int idx);

}
