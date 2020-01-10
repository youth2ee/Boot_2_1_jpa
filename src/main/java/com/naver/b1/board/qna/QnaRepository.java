package com.naver.b1.board.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer> {

	//List<QnaVO> findByNumGreaterThanOrderByRefDescStepAsc (int num) throws Exception; 
	//List<QnaVO> findByNumGreaterThan (int num, Pageable pageable) throws Exception; 
	
	//@Query ("select q from QnaVO q order by q.ref desc, q.step asc")
	//List<QnaVO> findQna() throws Exception; 
	
	//@Query("Select q from QnaVO q where num= ?1") //순서주의
	//QnaVO findQnaVO(int num) throws Exception;
	
	//@Query("Select q from QnaVO q where num= :num") //변수명 맞추기
	//QnaVO findQnaVO(@Param("num") int num) throws Exception;
	
	/*
	 * @Modifying(clearAutomatically = true) //update와 delete는 이 어노테이션이 필요
	 * 
	 * @Query("update QnaVO q set title=:title, contents=:contents where num=:num")
	 * void qnaUpdate(@Param("title")String title, @Param("contents")String
	 * contents, @Param("num")int num) throws Exception;
	 */
	
	@Modifying(clearAutomatically = true) //update와 delete는 이 어노테이션이 필요 
	@Query("update QnaVO q set title=:title, contents=:contents where num=:num")
	int qnaUpdate(@Param("title")String title, @Param("contents")String contents, @Param("num")int num) throws Exception;
	
	/*
	 * @Modifying(clearAutomatically = true) //update와 delete는 이 어노테이션이 필요 - nativeQuery = true : * 사용가능
	 * 
	 * @Query(value =
	 * "update QnaVO q set title=:title, contents=:contents where num=:num",
	 * nativeQuery = true) int qnaUpdate(@Param("title")String
	 * title, @Param("contents")String contents, @Param("num")int num) throws
	 * Exception;
	 */
	
	@Query("select q.writer, q.contents from QnaVO q where num=?1") //VO로 리턴받지 못한다.
	List<Object[]> qnaSelect(int num) throws Exception;
	
	
}
