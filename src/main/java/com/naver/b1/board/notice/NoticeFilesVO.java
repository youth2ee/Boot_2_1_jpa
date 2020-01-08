package com.naver.b1.board.notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "noticeFiles")
@Data
public class NoticeFilesVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum; 
	
	//private int num; //FK는 지운다.
	
	private String fname; 
	private String oname; 
	
	//join을 위해 사용
	@ManyToOne
	@JoinColumn(name = "num")
	private NoticeVO noticeVO;
}
