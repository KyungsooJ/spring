package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.UploadDTO;
import com.itbank.service.UploadService;

@Controller
public class UploadController {

	@Autowired private UploadService uploadService;
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto) {
		
//		System.out.println(dto.getTitle());
//		dto.getUpload().forEach(f -> System.out.println(f.getOriginalFilename()));
//		System.out.println();
		
		int row = uploadService.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = uploadService.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/";
	}
	
	
	
	
	
	
}
