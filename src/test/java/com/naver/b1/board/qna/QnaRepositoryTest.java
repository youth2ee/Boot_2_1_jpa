package com.naver.b1.board.qna;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.naver.b1.member.MembersVO;

@SpringBootTest
//@Transactional
public class QnaRepositoryTest {

	@Autowired
	private QnaRepository qnaRepository;
	
	@Autowired
	private QnaService qnaService;
	
	
	//@Test 
	void test() { 
		QnaVO qnaVO = new QnaVO(); 
		qnaVO.setTitle("title3");
		qnaVO.setWriter("writer3"); 
		qnaVO.setContents("contents3");


		List<QnaFilesVO> qnaFilesVOs = new ArrayList<QnaFilesVO>(); 
		QnaFilesVO
		qnaFilesVO = new QnaFilesVO();

		qnaFilesVO.setFname("fname3"); 
		qnaFilesVO.setOname("oname3");
		qnaFilesVO.setQnaVO(qnaVO);

		qnaFilesVOs.add(0, qnaFilesVO);

		qnaVO.setQnaFilesVOs(qnaFilesVOs);


		qnaVO = qnaRepository.save(qnaVO); 
		qnaVO.setRef(qnaVO.getNum());
		qnaRepository.save(qnaVO);

	}

	
	//@Test
	/*
	 * void select() throws Exception { List<QnaVO> page =
	 * qnaRepository.findByNumGreaterThanOrderByRefDescStepAsc(0);
	 * 
	 * for(QnaVO qnaVO : page) { System.out.println(qnaVO.getTitle()); }
	 * 
	 * }
	 */
	
/*	@Test
	void select() throws Exception{
		Pageable pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
		
		//List<QnaVO> ar =  qnaRepository.findByNumGreaterThan(0, pageable);
		//List<QnaVO> ar = qnaRepository.findByNumGreaterThan(0);
		
		for(QnaVO qnaVO : ar) {
			System.out.println(qnaVO.getTitle());
		}
		*/
		
		
		
	/* } */
	
	
	//@Test
	/*
	 * void test1() throws Exception { List<QnaVO> ar = qnaRepository.findQna();
	 * 
	 * for(QnaVO qnaVO : ar) { System.out.println(qnaVO.getTitle()); for(QnaFilesVO
	 * qnaFilesVO : qnaVO.getQnaFilesVOs()) {
	 * System.out.println(qnaFilesVO.getFname()); } } }
	 */
	
	//@Test
	/*
	 * void select1() throws Exception { QnaVO qnaVO = qnaRepository.findQnaVO(2);
	 * System.out.println(qnaVO.getTitle());
	 * System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
	 * 
	 * }
	 */
	
	//@Test
	void update() throws Exception{
		qnaService.update();
	}
	
	@Test
	void cselect() throws Exception{
 		List<Object[]> obj = qnaRepository.qnaSelect(2);
 		
 		for(Object[] o : obj) {
 			for(Object o2 : o) {
 				System.out.println(o2);
 			}
 			
 		}
	}
	
}
