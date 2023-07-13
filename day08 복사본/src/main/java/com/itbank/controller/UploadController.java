package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload2")
public class UploadController {
	
	@GetMapping({"", "/"})
	public String list() {
		return "/upload2/list";
	}
}
