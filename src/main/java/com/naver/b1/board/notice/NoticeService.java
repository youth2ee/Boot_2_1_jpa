package com.naver.b1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.b1.member.MembersVO;

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	
	public List<NoticeVO> noticeList() throws Exception {
		return noticeRepository.findAllByOrderByNumDesc();
	}
	
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) {
		return noticeRepository.findById(noticeVO.getNum()).get();
	}
	
}
