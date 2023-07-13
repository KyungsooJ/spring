package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Ex02Controller {
	
	public Ex02Controller() {
		File dir = new File("C:\\test0704");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}

	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(MultipartFile upload) throws IllegalStateException, IOException {
		File dest = new File("C:\\test0704", upload.getOriginalFilename());
		upload.transferTo(dest);
		return "redirect:/ex02";
	}
}



