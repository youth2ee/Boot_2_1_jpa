package com.naver.b1.board.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naver.b1.board.BoardVO;
@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	//@Autowired
	@Resource(name = "test") //service에서 이름을 test로 지정해줬으므로 그에 맞춰 매핑해야한다.
	private NoticeService noticeService;
	
	
	@ModelAttribute(name = "board") //모든 이 컨트롤러에서 model에 이 값을 넣어서 준다.
	public String getBoard() {
		return "notice";
	}
	
	
	
	/* <noticeList> 사용하기
	 * @GetMapping("noticeList")  
	 * public void noticeList(Model model) throws Exception { 
	 * List<NoticeVO> ar = noticeService.noticeList();
	 * model.addAttribute("list", ar); 
	 * }
	 */
	
	//<BoardList> 사용하기
	
	  @GetMapping("noticeList") public ModelAndView noticeList() throws Exception {
	  ModelAndView mv = new ModelAndView();
	  
	  List<NoticeVO> ar = noticeService.noticeList(); mv.addObject("list", ar);
	  mv.setViewName("board/boardList");
	  
	  return mv; }
	 
	
	//<BoardList - BoardVO> 사용하기
	/*
	 * @GetMapping("noticeList") public ModelAndView noticeList() throws Exception {
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * List<BoardVO> ar = noticeService.noticeList(); mv.addObject("list", ar);
	 * mv.setViewName("board/boardList");
	 * 
	 * return mv; }
	 */
	
	@GetMapping("noticeSelect")
	public void noticeSelect(NoticeVO noticeVO, Model model) {
		noticeVO = noticeService.noticeSelect(noticeVO);
		model.addAttribute("noticeVO", noticeVO);
	}
	
	@GetMapping("noticeWrite")
	public void noticeWrite(NoticeVO noticeVO) {	
	}
	
	
	
}
