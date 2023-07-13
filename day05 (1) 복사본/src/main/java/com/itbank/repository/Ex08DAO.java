package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.Ex08DTO;

@Repository
public interface Ex08DAO {

	List<Ex08DTO> selectList();

	int insert(Ex08DTO dto);

}
