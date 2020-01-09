package com.naver.b1.util;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.naver.b1.board.notice.NoticeVO;

public interface PageRepository extends PagingAndSortingRepository<NoticeVO, Integer> {

	List<NoticeVO> findAllByNum(int num, Pageable pageable) throws Exception;
	
}
