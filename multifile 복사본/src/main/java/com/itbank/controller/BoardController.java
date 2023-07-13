package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired private BoardService service;
	

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = service.select();
		
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		int row = service.insert(dto);
		
		String msg = row != 0 ? "글 작성이 완료되었습니다" : "글 작성에 실패했습니다";
		String url = row != 0 ? "/board/list" : "/board/add";
		
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		
		return mav;
		
	}
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		BoardDTO dto = service.selectOne(idx);
		
		mav.addObject("dto", dto);
		
		return mav;
	}
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("board/modify");
		BoardDTO dto = service.selectOne(idx);
		
		mav.addObject("dto", dto);
		
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		
		int row = service.update(dto);
		
		String msg = row != 0 ? "글 수정이 성공적으로 완료되었습니다" : "수정 실패 . . .";
		String url = row != 0 ? "/board/view/" + dto.getIdx() : "/board/modify/" + dto.getIdx();
		
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		
		return mav;
	}
}
