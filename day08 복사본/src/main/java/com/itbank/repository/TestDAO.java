package com.itbank.repository;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {

	Date selectSysdate();

}
