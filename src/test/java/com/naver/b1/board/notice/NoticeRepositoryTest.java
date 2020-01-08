package com.naver.b1.board.notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.naver.b1.member.MembersVO;

@SpringBootTest
@Transactional
public class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository noticeRepository;
	
	//@Test
	void test() {
		NoticeVO noticeVO = noticeRepository.findById(1).get();
		System.out.println(noticeVO.getTitle());
	}
	
	//@Test
	void test2() {
		NoticeVO noticeVO = noticeRepository.findById(6).get();
		System.out.println(noticeVO.getWriter());
		for(NoticeFilesVO noticeFilesVO : noticeVO.getNoticeFilesVOs()) {
			System.out.println(noticeFilesVO.getFname());
		}
	}
	
	@Test
	void test3() throws Exception {
		List<NoticeVO> ar = noticeRepository.findAllByOrderByNumDesc();
		for(NoticeVO noticeVO : ar) {
			System.out.println(noticeVO.getTitle());
			System.out.println(noticeVO.getWriter());
		}
		
		
		
	}
	
	
}
