package com.naver.b1.board.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naver.b1.board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer> {
	
	//select * from notice order by num desc
	public List<NoticeVO> findAllByOrderByNumDesc() throws Exception;
	
	//select * from notice where num>0 order by num desc
	List<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num) throws Exception;

	//List<BoardVO> findByNumGreaterThanOrderByNumDesc(int num) throws Exception;
	
}
