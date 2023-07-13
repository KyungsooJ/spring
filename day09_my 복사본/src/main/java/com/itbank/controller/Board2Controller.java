package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Board2DTO;
import com.itbank.model.PagingDTO;
import com.itbank.service.Board2Service;

@Controller
@RequestMapping("/board")
public class Board2Controller {

	@Autowired private Board2Service board2Service;
	
	// <a href=""> 링크 클릭
	// location.href = '주소', location.replace('주소')
	// <form method="GET">
	// response.sendRedirect("")
	@GetMapping("")	// 주소는 /board, jsp는 /board/list.jsp
	public ModelAndView list(@RequestParam(value="page", defaultValue="1") int page, 
			PagingDTO dto) {
	    
		int boardCount = board2Service.selectCount(dto);
		PagingDTO paging = new PagingDTO(page, boardCount);
		
//		System.out.println(page);
//		System.out.println(paging.getEnd());
//		System.out.println(paging.getPageCount());
//		System.out.println(paging.isPrev());
//		System.out.println(paging.isNext());
		
		if(dto.getColumn() != null && dto.getSearch() != null) {
			paging.setColumn(dto.getColumn());
			paging.setSearch(dto.getSearch());
		}
		
		ModelAndView mav = new ModelAndView("/board/list");
		List<Board2DTO> list = board2Service.selectAll(paging);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
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
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("board/view");
		Board2DTO dto = board2Service.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = board2Service.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/board";
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("board/modify");
		Board2DTO dto = board2Service.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(Board2DTO dto) {
	int row = board2Service.update(dto);
	System.out.println(row + "행이 수정되었습니다");
	return "redirect:/board/view/{idx}";
	}
	
	

}
