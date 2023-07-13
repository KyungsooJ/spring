package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.Board2DTO;
import com.itbank.model.PagingDTO;
import com.itbank.repository.Board2DAO;

@Service
public class Board2Service {

	@Autowired private Board2DAO dao;

	public List<Board2DTO> selectAll(PagingDTO paging) {
	
		return dao.selectAll(paging);
	}

	public int write(Board2DTO dto) {
		return dao.insertBoard(dto);
	}

	// 하나의 서비스 함수에서 2개 이상의 dao 함수를 호출할 때
	@Transactional
	public Board2DTO selectOne(int idx) {
		int row = dao.updateViewCount(idx);
		System.out.println(row + "행이 수정되었습니다");
		System.out.println(idx + "번 조회수 증가");
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int update(Board2DTO dto) {
		return dao.update(dto);
	}

	public int selectCount(PagingDTO dto) {
		return dao.selectCount(dto);
	}

	
}
