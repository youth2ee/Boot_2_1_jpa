package com.naver.b1.board;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@MappedSuperclass //부모클래스로 사용하겠다.
@Data
public class BoardVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	private String title;
	
	private String writer;
	
	private String contents;
	
	private Date regDate; 
	
	private int hit;
	
	
}
