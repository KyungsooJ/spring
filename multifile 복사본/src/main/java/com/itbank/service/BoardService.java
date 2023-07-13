package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	File dir = new File("/Users/jangkyungsoo/test0713"); // C:\\0713
	
	
	public BoardService() {
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}

	public List<BoardDTO> select() {
		List<BoardDTO> list = dao.select();
		
		list.forEach(board -> {
			String title = board.getTitle();
			if(title.length() > 25) {
				board.setTitle(title.substring(0, 25) + "...");
			}
		});
		
		return list;
	}

	public int insert(BoardDTO dto) {
		int row = 0;
		
		row = dao.insertBoard(dto);
		if(!dto.getUpload().get(0).getOriginalFilename().equals("")) {
			ArrayList<String> filePath = new ArrayList<String>();
			dto.getUpload().forEach(file -> {
				String ext = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
				String fileName = UUID.randomUUID().toString().replace("-", "");
				File dest = new File(dir, fileName + "." + ext);
				
				try {
					file.transferTo(dest);
					filePath.add(dest.getName());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();	
				}
			});
			int board = dao.selectMaxIdx();
			HashMap<String, Object> param = new HashMap<String, Object>();
			
			param.put("board", board);
			param.put("filePath", filePath);
			
			row += dao.insertFile(param);
		}
		
		return row;

	}

	public BoardDTO selectOne(int idx) {
		BoardDTO dto = dao.selectOneBoard(idx);
		
		dto.setFilePath(dao.selectFile(idx));
		return dto;
	}

	public int update(BoardDTO dto) {
		int row = 0;
		
		row = dao.updateBoard(dto);
		if(dto.getDeleteFile() != null) {
			List<String> fileList = dao.selectFile(dto.getIdx());
			
			for(String file : fileList) {
				File dest = new File(dir, file);
				
				if(dest.exists() && dest.isFile()) {
					dest.delete();
				}
				
			}
			
			row += dao.deleteFile(dto.getIdx());
		}
		if(!dto.getUpload().get(0).getOriginalFilename().equals("")) {
			ArrayList<String> filePath = new ArrayList<String>();
			dto.getUpload().forEach(file -> {
				String ext = file.getContentType().substring(file.getContentType().indexOf("/") + 1);
				String fileName = UUID.randomUUID().toString().replace("-", "");
				File dest = new File(dir, fileName + "." + ext);
				
				try {
					file.transferTo(dest);
					filePath.add(dest.getName());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			});
			HashMap<String, Object> param = new HashMap<String, Object>();
			
			param.put("board", dto.getIdx());
			param.put("filePath", filePath);
			
			row += dao.insertFile(param);
		}
		
		return row;
	}
}
