package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
public class BoardController {

	@Autowired private BoardService boardService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = boardService.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		BoardDTO dto = boardService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(BoardDTO dto) {
		int row = boardService.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		if(row != 0) {				// 추가에 성공하면
			return "redirect:/list";	// 대문페이지로 이동
		}
		else {						// 추가에 실패하면
			return "redirect:/add";	// 추가페이지로 이동
		}	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = boardService.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		if(row != 0) {				// 추가에 성공하면
			return "redirect:/list";	// 대문페이지로 이동
		}
		else {						// 추가에 실패하면
			return "redirect:/view";	// 추가페이지로 이동
		}
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("modify");
		BoardDTO dto = boardService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(BoardDTO dto) {
		int row = boardService.update(dto);
		System.out.println(row + "행이 수정되었습니다");
		if(row != 0) {				
			return "redirect:/list";	
		}
		else {						
			return "redirect:/view/" + dto.getIdx();	
		}
	}
	@GetMapping("/searchList")
	public ModelAndView searchList(String search) {
		ModelAndView mav = new ModelAndView("list");
		List<BoardDTO> list = boardService.searchList(search);
		mav.addObject("list", list);
		return mav;
	}
	
}
