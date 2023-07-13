package com.itbank.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class Ex01Controller {

	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")		
	public String ex01(MultipartRequest request) throws IllegalStateException, IOException {
		// 이름만 같을뿐, 패키지가 다른 클래스이다
		// 생성자로 직접 생성하지 않는다
		MultipartFile f = request.getFile("upload");	// input의 name으로 지정한다
		
		File dir = new File("C:\\test0704");			// 파일 업로드 위치를 먼저 지정한다
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File dest = new File(dir, f.getOriginalFilename());	// 원본 파일 이름 그대로 사용
		f.transferTo(dest);		// 제출받은 파일 f를 dest 자리에 전송(복사)한다
		
		System.out.println(f.getSize());			// 파일의 크기
		System.out.println(f.getOriginalFilename());// 파일의 원래 이름
		System.out.println(f.getName());			// <input> 의 name
		System.out.println(f.getContentType());		// 컨텐츠 유형
		System.out.println();
		
		// 다수의 파일을 받기 위한 메서드도 제공된다
//		List<MultipartFile> list = request.getFiles("upload");
		
		return "redirect:/ex01";
	}
}
