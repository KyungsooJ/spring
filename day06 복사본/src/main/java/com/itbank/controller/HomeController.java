package com.itbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.TestService;

@Controller
public class HomeController {
	
	@Autowired private TestService testService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		String version = testService.getVersion();
		mav.addObject("version", version);
		return mav; 
	}
	
	
	@PostMapping("/youtube_add")
	public String add(@RequestParam HashMap<String, Object> param) {
		int row = testService.add(param);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
}
