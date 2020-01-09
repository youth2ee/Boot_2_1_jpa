package com.naver.b1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.naver.b1.board.BoardVO;
import com.naver.b1.member.MembersVO;

@Service("test")
//@Qualifier("test") : @Service에서 이름지정하지 않고 @Qualifier로 이름 지정해도 된다.
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	
	
	  public List<NoticeVO> noticeList() throws Exception { //return
	  //noticeRepository.findAllByOrderByNumDesc(); 
		  return noticeRepository.findByNumGreaterThanOrderByNumDesc(0); 
	  }
	 
	
	/*
	 * public List<BoardVO> noticeList() throws Exception { return
	 * noticeRepository.findByNumGreaterThanOrderByNumDesc(0); }
	 */
	
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) {
		return noticeRepository.findById(noticeVO.getNum()).get();
	}
	
}
