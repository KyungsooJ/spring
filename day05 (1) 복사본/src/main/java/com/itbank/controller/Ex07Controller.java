package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.Ex05DTO;

@Controller
public class Ex07Controller {

	@GetMapping("/ex07")
	public void ex07() {}
	
	@PostMapping("/ex07")
	public String ex07(Ex05DTO dto) {
		
		System.out.println(dto.getTitle());
		
		System.out.println(dto.getUpload());
		dto.getUpload().forEach(f -> System.out.println(f.getOriginalFilename()));
		
		dto.getUpload().forEach(f -> {
			File dest = new File("C:\\test0704", f.getOriginalFilename());
			try {
				f.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		});
		
		return "redirect:/ex07";
	}
}
