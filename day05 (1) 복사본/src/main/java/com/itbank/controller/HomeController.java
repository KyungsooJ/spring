package com.itbank.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class HomeController {

	@RequestMapping("/")		// path
	public String home() {
		return "home";			// view-name
	}
}
