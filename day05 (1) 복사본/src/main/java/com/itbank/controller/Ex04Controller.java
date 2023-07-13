package com.itbank.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex04Controller {

	@GetMapping("/ex04")
	public ModelAndView ex04() {
		ModelAndView mav = new ModelAndView();
		File dir = new File("C:\\test0704");	// 지정한 디렉토리의
		String[] list = dir.list();				// 파일이름을 문자열 배열로 반환
		mav.addObject("list", list);
		return mav;
	}
}
