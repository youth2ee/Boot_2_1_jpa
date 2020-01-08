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
	
	@Test
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
		
		List<MembersVO> ar =  memberRepository.findByIdAndPw("admin", "admin");
		for(MembersVO membersVO : ar) {
			System.out.println(membersVO.getId());
			System.out.println(membersVO.getPw());
			System.out.println(membersVO.getName());
			System.out.println(membersVO.getEmail());
		}
		
		
		//
		MembersVO membersVO = new MembersVO();
		
		memberRepository.save(membersVO);
		
		
		
	}

}
