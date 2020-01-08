package com.naver.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberFilesRepositoryTest {

	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	//@Test
	void test() throws Exception {
		
		/*
		 * List<MemberFilesVO> ar = memberFilesRepository.findAll();
		 * 
		 * for(MemberFilesVO memberFilesVO : ar) {
		 * System.out.println(memberFilesVO.getFnum());
		 * System.out.println(memberFilesVO.getId());
		 * System.out.println(memberFilesVO.getFname());
		 * System.out.println(memberFilesVO.getOname()); }
		 */
		
		//
		/*
		 * long count = memberFilesRepository.count(); System.out.println(count);
		 */
		
		//
		/*
		 * Optional<MemberFilesVO> opt = memberFilesRepository.findById(1);
		 * Optional<MemberFilesVO> opt2 = memberFilesRepository.findById(1);
		 * MemberFilesVO memberFilesVO = opt.get(); MemberFilesVO memberFilesVO2 =
		 * opt2.get();
		 * 
		 * System.out.println(memberFilesVO == memberFilesVO2);
		 */
		
		//
		//MemberFilesVO memberFilesVO3 = new MemberFilesVO();
		//auto increment가 자동으로 생성됨.
		/*
		 * memberFilesVO3.setId("admin"); memberFilesVO3.setFname("admin.jpg");
		 * memberFilesVO3.setOname("cha.jpg");
		 * memberFilesRepository.save(memberFilesVO3);
		 */
		//
		//id가 admin의 파일을 조회
		//select * from memberFiles where id = ?
		/*
		 * MemberFilesVO memberFilesVO = memberFilesRepository.findById("qq4");
		 * System.out.println(memberFilesVO.getOname());
		 */
		
		/*
		 * MemberFilesVO memberFilesVO = memberFilesRepository.findByOname("qq1.jpg");
		 * System.out.println(memberFilesVO.getFname());
		 */
		
		/*
		 * List<MemberFilesVO> ar = memberFilesRepository.findById("admin");
		 * 
		 * for(MemberFilesVO memberFilesVO : ar) {
		 * System.out.println(memberFilesVO.getFname()); }
		 */
		
		
	}
	
	@Test
	void selectTest() {
		 MemberFilesVO memberFilesVO = memberFilesRepository.findById(2).get();
		System.out.println(memberFilesVO.getFname());
		System.out.println(memberFilesVO.getOname());
		System.out.println(memberFilesVO.getMembersVO().getId());
		
	}

}
