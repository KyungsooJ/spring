package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.Ex08DTO;
import com.itbank.repository.Ex08DAO;

@Service
public class Ex08Service {

	@Autowired private Ex08DAO dao;
	
	private File dir = new File("C:\\test0704");
	
	public Ex08Service() {
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public List<Ex08DTO> selectList() {
		return dao.selectList();
	}

	public int insert(Ex08DTO dto) {
		// 파일을 디스크에 복사해서 저장한 이후
		MultipartFile f = dto.getUpload();
		
		// 1) 날짜를 포함시켜서 새로운 파일 이름 구성하기
//		String ymd = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//		String fileName = f.getOriginalFilename();
//		fileName = fileName.substring(0, fileName.lastIndexOf("."));
//		String ext = f.getContentType().substring(f.getContentType().indexOf("/") + 1);
//		File dest = new File(dir, fileName + "_" + ymd + "." + ext);
		
		// 2) 랜덤 UUID를 활용하여 파일 이름 만들기
		// Universaly Unique Identification (범용 고유 식별자)
		String ext = f.getContentType().substring(f.getContentType().indexOf("/") + 1);
		String fileName = UUID.randomUUID().toString().replace("-", "");
		File dest = new File(dir, fileName + "." + ext);
		
		int row = 0;
		try {
			f.transferTo(dest);
			
			// 파일의 이름을 dto에 넣어주고 dao에게 넘긴다
			dto.setFilePath(dest.getName());
			row = dao.insert(dto);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return row;
	}

}
