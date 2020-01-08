package com.naver.b1.board.notice;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.naver.b1.board.BoardVO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notice")
//@Data //getter, setter, equals, hashcode를 모두 포함한다.
public class NoticeVO extends BoardVO {
	
	//join을 위해 사용
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	//나는 연관관계 주인이 아닙니다. /mappedBy = "join하는 entity에 선언된  자기자신의 Entity변수명"
	//fetch = Lazy(게으르다. 나중에 하겠다. noticeFilesVO를 직접 가져오지는 않고, 대기를 했다가. 나중에 필요하다는 코드를 입력하면 그때 가져온다. 메모리낭비를 방지. 사용할 service에서 @Transactional이 필요.) 
	//fetch = Eager(그 즉시 하겠다. @OneToOne은 Lazy로 설정해도 무조건 Eager로 설정된다.)
	//cascade = all
	private List<NoticeFilesVO> noticeFilesVOs;
}
