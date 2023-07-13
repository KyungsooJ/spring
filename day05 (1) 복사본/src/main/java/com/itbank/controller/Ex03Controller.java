package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.Ex03DTO;

@Controller
public class Ex03Controller {

	@GetMapping("/ex03")
	public void ex03() {}
	
	@PostMapping("/ex03")
	public String ex03(Ex03DTO dto) throws IllegalStateException, IOException {
		System.out.println(dto);
		File dest = new File("C:\\test0704", dto.getUpload().getOriginalFilename());
		dto.getUpload().transferTo(dest);
		return "redirect:/ex03";
	}
}
