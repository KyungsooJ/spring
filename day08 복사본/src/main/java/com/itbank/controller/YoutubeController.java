package com.itbank.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.service.TestService;

@Controller
@RequestMapping("/youtube_list")
public class YoutubeController {
	
	private TestService testService;
	
	@GetMapping({"/", ""})
	public String list() {
		Date date = testService.selectSysdate();
		System.out.println(date);
		return "/youtube_list/list";
	}

}
