package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired MemberDAO dao;
	@Autowired private HashComponent hashComponent;

	public int insert(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserPw());
		
		dto.setUserPw(hash);
		
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserPw());
		
		dto.setUserPw(hash);
		return dao.login(dto);
	}
}
