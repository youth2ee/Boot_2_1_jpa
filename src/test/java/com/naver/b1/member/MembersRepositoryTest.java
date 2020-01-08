package com.naver.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MembersRepositoryTest {

	@Autowired
	private MembersRepository memberRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	//@Test
	void test() throws Exception {
		//Long count = memberRepository.count();
		//System.out.println(count);
		
		//Boolean check = memberRepository.existsById("admin"); //아이디 중복체크할때 사용가능.
		//System.out.println(check);
		
		/*
		 * List<MemberVO> ar = memberRepository.findAll(); for(MemberVO memberVO : ar) {
		 * System.out.println(memberVO.getId()); }
		 */
		
		
		/*
		 * Optional<MemberVO> opt = memberRepository.findById("admin1");
		 * if(opt.isPresent()) { MemberVO memberVO = opt.get();
		 * System.out.println(memberVO.getEmail()); } else {
		 * System.out.println("no data"); }
		 */
	
		/*
		 * MembersVO memberVO = new MembersVO(); memberVO.setId("admin1");
		 * memberVO.setPw("admin1"); memberVO.setName("testname");
		 * memberVO.setEmail("admin1@admin1.com"); memberRepository.save(memberVO);
		 */
		//save는 insert와 update를 모두 이용함. pk가 이미 존재하면 update, 존재하지 않으면 insert
		//내가 사용하지 않는 컬럼값을 입력하지 않으면 자동으로 null로 입력된다.
		
		/*
		 * List<MembersVO> ar = memberRepository.findByIdAndPw("admin", "admin");
		 * for(MembersVO membersVO : ar) { System.out.println(membersVO.getId());
		 * System.out.println(membersVO.getPw());
		 * System.out.println(membersVO.getName());
		 * System.out.println(membersVO.getEmail()); }
		 */
		
		
		//
		/*
		 * MembersVO membersVO = new MembersVO(); memberRepository.save(membersVO);
		 */
		
	}
	
	
	
	//@Test
	public void selectTest() {
		Optional<MembersVO> opt = memberRepository.findById("iu4");
		MembersVO membersVO = opt.get();
		System.out.println(membersVO.getName());
		System.out.println(membersVO.getEmail());
		System.out.println(membersVO.getMemberFilesVO().getFname());
	}
	

	//@Test
	public void InsertTest() {
		MembersVO membersVO = new MembersVO();
		membersVO.setId("iu12");
		membersVO.setPw("iu12");
		membersVO.setName("iu12");
		membersVO.setEmail("iu12@iu12");

		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setMembersVO(membersVO);
		memberFilesVO.setFname("iu12Fname.jpg");
		memberFilesVO.setOname("iu12Oname.jpg");
		
		membersVO.setMemberFilesVO(memberFilesVO);
		memberRepository.save(membersVO);
		
		//memberFilesVO.setMembersVO(membersVO);
		//memberFilesRepository.save(memberFilesVO);
	}
	
	//@Test
	void deleteTest() {
		memberRepository.deleteById("han");
	}
	
	@Test
	void updateTest() {
		MembersVO membersVO = new MembersVO();
		membersVO.setId("cha7");
		membersVO.setPw("cha7");
		membersVO.setName("!!!enu!!!");
		membersVO.setEmail("cha7@cha7");
		
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setFnum(5);
		memberFilesVO.setFname("9064e15a-ceee-4a1a-887e-095537671221_cha7.gif");
		memberFilesVO.setOname("cha9.gif");
		
		membersVO.setMemberFilesVO(memberFilesVO);
		memberFilesVO.setMembersVO(membersVO);
		
		memberRepository.save(membersVO);
		
	}
	
	
}
