package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping(value= {"/", ""})	// 서로 다른 두 개 이상의 주소값은 배열로 지정한다
									// [/board/], [/board]
	public String list() {
//		if(session.getAttribute("login") == null) {
//			return "redirect:/member/login";
//		}
		return "/board/list";
	}
}
