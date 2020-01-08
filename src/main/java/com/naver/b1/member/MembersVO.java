package com.naver.b1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members") //클래스명과 테이블명이 동일하지 않기 때문에 이렇게 직접 매핑해줘야 한다.
public class MembersVO { //클래스명과 테이블명을 동일하게 일치하면 좋다. 바로 매핑됨.
	
	@Id //primary key에게는 어노테이션 id를 준다.
	private String id; //변수명과 컬럼명을 일치하면 좋다. 다르면 설정을 따로 해줘야한다.
	
	//@Column(name = "pw") //primary key가 아닌 컬럼들은 어노테이션 column을 주고 name을 직접 설정해주면 된다.
	private String pw;
	
	/*
	 * @Transient private String pw2;
	 */
	
	private String name;
	private String email;
	
	//앞이 해당 클래스 TO 뒤에 다른 클래스 //mappedBy = "join하는 entity에 선언된  자기자신의 Entity변수명"
	@OneToOne(mappedBy = "membersVO", cascade = CascadeType.ALL) 
	private MemberFilesVO memberFilesVO;

}
