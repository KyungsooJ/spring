package com.itbank.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.UploadDTO;
import com.itbank.repository.UploadDAO;

@Service
public class UploadService {

	@Autowired private UploadDAO dao;
	
	private File dir = new File("/Users/jangkyungsoo/test0706");
	
	public UploadService() {
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	// 파일을 전달받으면 새로운 이름을 문자열로 반환하는 함수
	private String generateNewFileName(MultipartFile f) {
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String contentType = f.getContentType();
		fileName += "." + contentType.substring(contentType.indexOf("/") + 1);
		return fileName;
	}

	// 해당 어노테이션이 명시된 메서드 내부에서의 dao함수는 하나의 트랜잭션으로 묶인다
	// 트랜잭션 내부 작업중 하나라도 예외가 발생하면 이전 작업을 모두 rollback 처리한다
	@Transactional
	public int insert(UploadDTO dto) {
		// 1) 파일이름 규칙 : UUID + contentType
		// 2) 업로드 위치 : C:\test0706
		
		List<MultipartFile> uploadList = dto.getUpload();	// 첨부파일의 목록 (2)
		ArrayList<String> fileNameList = new ArrayList<>();	// 비어있는 문자열 리스트 (0)
		
		for(MultipartFile f : uploadList) { // 2회 반복
//			File dest = new File(dir, generateNewFileName(f));
			File dest = new File(dir, f.getOriginalFilename());
			fileNameList.add(dest.getName());	// 0 -> 1 -> 2
			try {
				f.transferTo(dest);
			} catch (Exception e) {}
		}
//		dto.setFilePath(fileNameList);	// 길이 2짜리 리스트를 dto에 set
		
		int row = 0;
		
		row += dao.insertUpload(dto);
		int fk = dao.selectMaxIdxFromUpload();	// 가장 높은 idx 불러오기 (마지막에 넣은 값)
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("upload", fk);	// 마지막 넣은 글의 idx를 추가한다
		param.put("list", fileNameList);
		
		row += dao.insertFile(param);
		
		return row;
	}

	public List<UploadDTO> selectAll() {
		return dao.selectAll();
	}

	public int delete(int idx) {
		List<String> fileList = dao.selectFileList(idx);
		for(String fileName : fileList) {
			File f = new File(dir, fileName);	// 저장된 위치에 지정한 이름의 파일
			if(f.exists()) {		// 파일이 있으면
				f.delete();			// 파일을 삭제한다
			}
		}
		
		int row = 0;
		row += dao.deleteFile(idx);	// DB에서 파일이름을 먼저 삭제하고 (자식테이블)
		row += dao.delete(idx);		// 참조하는 자식 테이블 레코드가 없으면 부모테이블 삭제		
									// on delete cascade
		return row;
	}
}







