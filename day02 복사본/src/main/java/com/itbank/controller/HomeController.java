package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.service.TestService;

@Controller
public class HomeController {

	@Autowired private TestService testService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		
		String dbVersion = testService.getDBVersion();
		mav.addObject("dbVersion", dbVersion);
		
		List<YoutubeDTO> list = testService.getYoutubeList();
		mav.addObject("list", list);
		
		return mav;
	}

	@GetMapping("/youtube/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		
		ModelAndView mav = new ModelAndView("view");
		YoutubeDTO dto = testService.getYoutubeDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		int row = testService.add(dto);
		
		if(row != 0) {				// 추가에 성공하면
			return "redirect:/";	// 대문페이지로 이동
		}
		else {						// 추가에 실패하면
			return "redirect:/add";	// 추가페이지로 이동
		}
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = testService.delete(idx);
		if(row != 0) {
			return "redirect:/";
		}
		else {
			return "redirect:/youtube/" + idx;
		}
	}

}






