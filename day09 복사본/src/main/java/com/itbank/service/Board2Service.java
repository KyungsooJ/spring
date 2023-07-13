package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Board2DTO;
import com.itbank.repository.Board2DAO;

@Service
public class Board2Service {

	@Autowired private Board2DAO dao;

	public List<Board2DTO> selectAll() {
		return dao.selectAll();
	}

	public int write(Board2DTO dto) {
		return dao.insertBoard(dto);
	}
	
	
}
