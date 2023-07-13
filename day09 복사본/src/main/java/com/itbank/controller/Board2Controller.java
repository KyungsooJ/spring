package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Board2DTO;
import com.itbank.service.Board2Service;

@Controller
@RequestMapping("/board")
public class Board2Controller {

	@Autowired private Board2Service board2Service;
	
	@GetMapping("")	// 주소는 /board, jsp는 /board/list.jsp
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/board/list");
		List<Board2DTO> list = board2Service.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(Board2DTO dto) {
		int row = board2Service.write(dto);
		System.out.println(row + " 행이 추가되었습니다");
		return "redirect:/board";
	}
	
}





