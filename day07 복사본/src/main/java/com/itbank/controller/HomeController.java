package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.UploadDTO;
import com.itbank.service.TestService;
import com.itbank.service.UploadService;

@Controller
public class HomeController {

	@Autowired private TestService testService;
	@Autowired private UploadService uploadService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		
		String version = testService.getDBVersion();
		mav.addObject("version", version);
		
		List<UploadDTO> list = uploadService.selectAll();
//		for(UploadDTO dto : list) {
//			System.out.println(dto.getTitle());				// 제목은 하나
//			String[] arr = dto.getFilePath().split(",");
//			for(String s : arr) {
//				System.out.println(s);						// 파일은 여러개
//			}
//			System.out.println();
//		}
		
		mav.addObject("list", list);
		return mav;
	}
	
}
