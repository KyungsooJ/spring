package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.UploadDTO;

@Repository
public interface UploadDAO {

	int insertUpload(UploadDTO dto);
	
	int selectMaxIdxFromUpload();

	int insertFile(HashMap<String, Object> param);

	List<UploadDTO> selectAll();

	List<String> selectFileList(int idx);

	int deleteFile(int idx);

	int delete(int idx);

}
