package com.naver.b1.board.notice;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	  @GetMapping("noticeList") 
	  public ModelAndView noticeList(Integer curPage) throws Exception {
	  ModelAndView mv = new ModelAndView();

	  if(curPage == null) {
		  curPage = 1;
	  }
	  
	  Page<NoticeVO> ar = noticeService.noticePage(curPage);
	  List<NoticeVO> br = ar.getContent();
	  
	  System.out.println(ar.getNumber());
	  System.out.println(ar.getNumberOfElements());
	  System.out.println(ar.getSize());
	  
	  System.out.println(ar.getTotalElements());
	  System.out.println(ar.getTotalPages());
	  
	  System.out.println(ar.getPageable());
	  System.out.println(ar.getSort());
	  
	 // List<NoticeVO> ar = noticeService.noticeList(curPage); 
	  mv.addObject("list", br);
	  mv.addObject("totalP", ar.getTotalPages());
	  mv.setViewName("board/boardList");
	  
	  return mv; 
	  }
	 
	
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
	public ModelAndView noticeSelect(NoticeVO noticeVO) { //매개변수에서 값이 null이면 @RequestParam(defaultValue = "0")으로 기본값 정해줄수 있다.
		//noticeVO = noticeService.noticeSelect(noticeVO);
		
		ModelAndView mv = new ModelAndView();
		Optional<NoticeVO> opt = noticeService.noticeSelect(noticeVO);
		if(opt.isPresent()) {
			mv.setViewName("board/boardSelect");
			mv.addObject("noticeVO", opt.get());
		} else {
			mv.setViewName("common/result");
			mv.addObject("msg", "not found");
			mv.addObject("path", "./noticeList");	
		}
				
		return mv;
		
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeVO", noticeVO);
		mv.setViewName("board/boardWrite");
		
		return mv;
		
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO, List<MultipartFile> files) throws Exception {
		ModelAndView mv =  new ModelAndView();
		Boolean check = noticeService.noticeInsert(noticeVO, files);
		String msg = "추가 실패";
		String path = "../";
		
		if(check) {
			msg = "추가 성공";
		}
		
		mv.setViewName("common/result");
		mv.addObject("msg",msg);
		mv.addObject("path",path);	
		
		return mv;
	}
	
	
	
}
