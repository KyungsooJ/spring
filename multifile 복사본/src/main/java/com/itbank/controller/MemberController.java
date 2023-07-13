package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired MemberService service;
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public ModelAndView join(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		int row = service.insert(dto);
		
		String msg = row != 0 ? "회원가입에 성공하셨습니다" : "회원가입에 실패하셨습니다";
		String url = row != 0 ? "/member/login" : "/member/join";
		
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		
		return mav;
	}
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(MemberDTO dto, HttpSession session) {
		ModelAndView mav = new ModelAndView("alert");
		MemberDTO login = service.login(dto);
		
		String msg = login != null ? dto.getUserId() + "님 환영합니다" : "아이디 또는 패스워드가 일치하지 않습니다";
		String url = login != null ? "/" : "/member/login";
		
		if(login != null) {
			session.setAttribute("login", login);
			session.setMaxInactiveInterval(300);
		}
		
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("alert");
		
		String msg = "로그아웃되었습니다";
		String url = "/member/login";

		session.invalidate();
		
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		
		return mav;
	}
}
