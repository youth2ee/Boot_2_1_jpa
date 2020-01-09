package com.naver.b1.board;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
	
	//@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date regDate; 
	
	@ColumnDefault("0")
	private int hit;
	
	
}
