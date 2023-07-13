package com.itbank.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.repository.TestDAO;

@Service
public class TestService {

	@Autowired private TestDAO dao;

	public String getVersion() {
		return dao.selectVersion();
	}

	public int add(HashMap<String, Object> param) {
		return dao.insert(param);
	}
	
	
}
