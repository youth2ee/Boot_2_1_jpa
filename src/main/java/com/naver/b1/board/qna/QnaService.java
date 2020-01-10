package com.naver.b1.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QnaService {

	@Autowired
	private QnaRepository qnaRepository;
	
	public void update() throws Exception {
		int num = qnaRepository.qnaUpdate("yoo", "yoo", 6);
		System.out.println(num);
	}
	
	
}
