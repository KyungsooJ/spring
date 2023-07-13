package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	@Autowired private HashComponent hashComponent;

	public int join(MemberDTO dto) {
		// 사용자가 입력한 plain-text를 hash처리하여 dto에 새로 저장
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		int row = dao.insert(dto);
		return row;
	}

	public MemberDTO login(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		MemberDTO login = dao.selectLogin(dto);
		return login;
	}

	
}





