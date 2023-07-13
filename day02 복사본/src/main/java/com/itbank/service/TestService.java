package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.YoutubeDTO;
import com.itbank.repository.TestDAO;

@Service
public class TestService {

	@Autowired private TestDAO dao;

	public String getDBVersion() {
		String dbVersion = dao.selectVersion();
		// 필요하다면 DB에서 불러온 데이터를 정제한다
		
		return dbVersion;
	}

	public List<YoutubeDTO> getYoutubeList() {
		List<YoutubeDTO> list = dao.selectYoutubeList();
		
		list.forEach(dto -> {
			String title = dto.getTitle();
			if(title.length() > 25) {
				dto.setTitle(title.substring(0, 25) + "...");
			}
		});
		
		return list;
	}

	public YoutubeDTO getYoutubeDTO(int idx) {
		return dao.selectOne(idx);
	}

	public int add(YoutubeDTO dto) {
		return dao.insert(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}
}




