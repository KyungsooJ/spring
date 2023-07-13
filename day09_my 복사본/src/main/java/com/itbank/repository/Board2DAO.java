package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.Board2DTO;
import com.itbank.model.PagingDTO;

@Repository
public interface Board2DAO {

	List<Board2DTO> selectAll(PagingDTO paging);

	int insertBoard(Board2DTO dto);

	Board2DTO selectOne(int idx);

	int updateViewCount(int idx);

	int delete(int idx);

	int modify(int idx);

	int update(Board2DTO dto);

	int selectCount(PagingDTO dto);

}
