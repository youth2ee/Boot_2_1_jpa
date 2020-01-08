 package com.naver.b1.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "memberFiles")
public class MemberFilesVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //fnum을 만들때 어떤걸 사용할래  - oracle:sequence / mysql:identity)
	private int fnum;
	private String id;
	private String fname;
	private String oname;
	

}
