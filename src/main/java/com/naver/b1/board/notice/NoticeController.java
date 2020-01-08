package com.naver.b1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public void noticeList(Model model) throws Exception {
		List<NoticeVO> ar = noticeService.noticeList();
		model.addAttribute("list", ar);
	}
	
	@GetMapping("noticeSelect")
	public void noticeSelect(NoticeVO noticeVO, Model model) {
		noticeVO = noticeService.noticeSelect(noticeVO);
		model.addAttribute("noticeVO", noticeVO);
	}
	
	@GetMapping("noticeWrite")
	public void noticeWrite(NoticeVO noticeVO) {	
	}
	
	
	
}
