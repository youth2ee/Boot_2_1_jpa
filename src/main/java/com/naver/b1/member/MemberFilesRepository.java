package com.naver.b1.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFilesRepository extends JpaRepository<MemberFilesVO, Integer> {

	//MemberFilesVO findById(String id);
	//MemberFilesVO findByOname(String oname);
	
	public List<MemberFilesVO> findById(String id) throws Exception; //매개변수의 변수명은 상관없다.
	
}
