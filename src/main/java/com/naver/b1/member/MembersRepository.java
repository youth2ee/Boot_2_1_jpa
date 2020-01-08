package com.naver.b1.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<MembersVO, String> {
//내가 사용할 타입 : MemberVO  /  primary key인 id의 데이터 타입 : String (int면 Integer)

	public List<MembersVO> findByIdAndPw(String id, String pw) throws Exception; 

}
