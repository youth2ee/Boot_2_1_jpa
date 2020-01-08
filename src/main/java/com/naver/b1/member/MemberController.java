package com.naver.b1.member;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller //@RestController 이 안의 모든 메서드 들이 responseBody일때 사용
@RequestMapping("/member/**")
@Transactional
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MembersRepository membersRepository;

	/*
	 * @GetMapping("memberJoin") public String memberJoin(Model model) throws
	 * Exception { model.addAttribute("membersVO", new membersVO()); return
	 * "member/memberJoin"; }
	 */

	/*
	 * 위의 코드와 같다 .
	 * 
	 * @GetMapping("memberJoin") public String memberJoin(membersVO membersVO) throws
	 * Exception { return "member/memberJoin"; }
	 */

	/*
	 * @ModelAttribute public membersVO getmembersVO() throws Exception { return new
	 * membersVO(); }
	 */
	// 이렇게 하면 이 안의 모든 메서드 들이 멤버VO를 가지고 간다.
	// 이 경우에는 매개변수로 membersVO를 안받아도 되고, 모델에 membersVO를 안넣어줘도 된다.

	
	/*
	 * @PostMapping("memberJoin") public ModelAndView memberJoin(@Valid membersVO
	 * membersVO, BindingResult bindingResult, MultipartFile files) throws Exception
	 * { ModelAndView mv = new ModelAndView(); // 검증 // membersVO앞에 @Valid 써줘야하고,
	 * 반드시 내가 검증할 아이 바로 뒤에 BindingResult bindingResult를 넣어줘야 한다. -> 순서 주의
	 * 
	 * 
	 * if (memberService.memberJoinValidate(membersVO, bindingResult)) {
	 * mv.setViewName("member/memberJoin"); } if (bindingResult.hasErrors()) { //에러가
	 * 발생하면 mv.setViewName("member/memberJoin"); } else { // int result =
	 * memberService.memberJoin(membersVO, files); String msg = "가입실패"; String path
	 * = "../";
	 * 
	 * if (result > 0) { msg = "가입성공"; }
	 * 
	 * mv.setViewName("common/result"); mv.addObject("msg", msg);
	 * mv.addObject("path", path); }
	 * 
	 * return mv; }
	 */
	
	@GetMapping("memberUpdate")
	public void memberUpdate(HttpSession session, Model model) {
		MembersVO membersVO = (MembersVO)session.getAttribute("member");
		model.addAttribute("membersVO", membersVO);	
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MembersVO membersVO, MultipartFile files, HttpSession session) throws Exception {
		Boolean check = memberService.memberUpdate(membersVO, files, session);
		String msg = "수정 실패"; 
		String path = "../";
		
		if(check) {
			msg = "수정 성공";
		}
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;
	}

	@GetMapping("memberLogin")
	public String memberLogin() {
		return "member/memberLogin";
	}

	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MembersVO membersVO, HttpSession session) throws Exception {
		List<MembersVO> ar = memberService.memberLogin(membersVO);
		String msg = "로그인 실패"; 
		String path = "../";
		
		if(ar.size() == 1) {
			msg = "로그인 성공";
			session.setAttribute("member", ar.get(0));
			session.setAttribute("file", ar.get(0).getMemberFilesVO());
		}
		
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;
	}

	@GetMapping("memberPage")
	public void memberPage() {
	}

	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("memberJoin")
	public MembersVO memberJoin(MembersVO membersVO) {
		return membersVO;
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(@Valid MembersVO membersVO, BindingResult bindingResult ,MultipartFile files) throws Exception {
		ModelAndView mv = new ModelAndView(); 
		String msg = "가입실패";
		String path = "../";
		
		if(memberService.memberJoinValidate(membersVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
		} else {
			Boolean check = memberService.memberJoin(membersVO, files);	
			
			if(check) {
				msg = "가입성공";				
			}
			mv.setViewName("common/result");
			mv.addObject("msg", msg);
			mv.addObject("path", path);
		}
		
		return mv;
	}
	
	@GetMapping("idCheck")
	@ResponseBody
	public String idCheck(MembersVO membersVO) {
		 Boolean check = memberService.idCheck(membersVO);
		 String msg = "가입할 수 있는 ID입니다.";
		 
		 if(check) {
			 msg = "가입할 수 없는 아이디입니다.";
		 }
	
		 return msg;
	}
	
	@GetMapping("memberDelete")
	public ModelAndView memberDelete(MembersVO membersVO, HttpSession session) {
		String msg = "삭제 실패";
		String path = "../";
		if(memberService.memberDelete(membersVO, session)) {
			session.invalidate();
			msg = "삭제 성공";
		}
		
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("common/result");
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		
		return mv;
	}
}