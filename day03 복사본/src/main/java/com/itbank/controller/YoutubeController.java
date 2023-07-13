package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.service.YoutubeService;

@Controller
public class YoutubeController {
	
	@Autowired private YoutubeService youtubeService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<YoutubeDTO> list = youtubeService.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{idx}")	// PathVariable을 사용한다면, 반드시 viewName을 지정하자
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		YoutubeDTO dto = youtubeService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")	// 넘겨줄 데이터도 없고, 삭제하고 나면 다른 페이지로 이동(리다이렉트)
	public String delete(@PathVariable("idx") int idx) {
		
		int row = youtubeService.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		String viewName = "redirect:";
		viewName += row != 0 ? "/list" : "/view/" + idx;
		return viewName;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		int row = youtubeService.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("modify");
		YoutubeDTO dto = youtubeService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(YoutubeDTO dto) {
		int row = youtubeService.update(dto);
		System.out.println(row + "행이 수정되었습니다");
		return "redirect:/view/" + dto.getIdx();
	}
	
	@GetMapping("/searchList")
	public ModelAndView searchList(String search) {
		ModelAndView mav = new ModelAndView("list");	// view 재활용
		List<YoutubeDTO> list = youtubeService.searchList(search);
		mav.addObject("list", list);
		return mav;
	}
}








