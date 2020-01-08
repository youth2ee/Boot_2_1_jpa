 package com.naver.b1.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	//private String id; //밑에 OneToOne을 쓰면 FK로 쓰는 컬럼은 제거해주어야 한다.
	private String fname;
	private String oname;
	
	
	@OneToOne //memberfilesVO TO membersVO
	@JoinColumn(name = "id") //FK로 쓸 컬럼명을 입력한다.
	private MembersVO membersVO;

}
