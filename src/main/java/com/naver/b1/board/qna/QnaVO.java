package com.naver.b1.board.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.naver.b1.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity//(name = "qna")
@Table(name = "qna")
public class QnaVO extends BoardVO {

	
	private int ref;
	
	@ColumnDefault("0")
	private int step;
	
	@ColumnDefault("0")
	private int depth;
	
	@OneToMany(mappedBy = "qnaVO", cascade = CascadeType.ALL)
	private List<QnaFilesVO> qnaFilesVOs;


}
