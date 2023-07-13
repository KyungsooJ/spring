package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.Board2DTO;

@Repository
public interface Board2DAO {

	List<Board2DTO> selectAll();

	int insertBoard(Board2DTO dto);

	
}
