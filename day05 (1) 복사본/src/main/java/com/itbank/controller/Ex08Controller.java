package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex08DTO;
import com.itbank.service.Ex08Service;

@Controller
public class Ex08Controller {

	@Autowired private Ex08Service ex08Service;
	
	@GetMapping("/ex08")
	public ModelAndView ex08() {
		ModelAndView mav = new ModelAndView();
		List<Ex08DTO> list = ex08Service.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/ex08")
	public String ex08(Ex08DTO dto) {
		int row = ex08Service.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/ex08";
	}
}
