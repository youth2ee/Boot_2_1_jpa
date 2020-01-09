package com.naver.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.naver.b1.board.BoardVO;
import com.naver.b1.member.MemberFilesVO;
import com.naver.b1.member.MembersVO;
import com.naver.b1.util.FilePathGenerator;
import com.naver.b1.util.FileSaver;


@Service("test")
@Transactional
//@Qualifier("test") : @Service에서 이름지정하지 않고 @Qualifier로 이름 지정해도 된다.
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;	
	
	@Autowired 
	private ServletContext servelContext;
	 
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	  public List<NoticeVO> noticeList(int curPage) throws Exception {
		  Pageable page = PageRequest.of(curPage, 10);
		  List<NoticeVO> list = noticeRepository.findByNumGreaterThanOrderByNumDesc(0, page);
		  
		  return list; 
	  }
	  
	  public Page<NoticeVO> noticePage(int curPage) {
		  Pageable page = PageRequest.of(curPage, 10, Sort.Direction.DESC, "num");
		  return noticeRepository.findAll(page);
	  }
	
	
	
	/*
	 * public List<NoticeVO> noticeList() throws Exception { //return
	 * //noticeRepository.findAllByOrderByNumDesc();
	 * 
	 * Pageable firstPageWithTwoElements = PageRequest.of(0, 10); //Pageable
	 * secondPageWithFiveElements = PageRequest.of(1, 5);
	 * 
	 * Page<NoticeVO> allList = noticeRepository.findAll(firstPageWithTwoElements);
	 * 
	 * //List<NoticeVO> allTenList = noticeRepository.findAllByNum(10,
	 * secondPageWithFiveElements);
	 * 
	 * for(NoticeVO list : allList) { System.out.println("list");
	 * System.out.println(list.getTitle()); }
	 * 
	 * 
	 * return noticeRepository.findByNumGreaterThanOrderByNumDesc(0); }
	 */
	 
	
	/*
	 * public List<BoardVO> noticeList() throws Exception { return
	 * noticeRepository.findByNumGreaterThanOrderByNumDesc(0); }
	 */
	
	
	/*
	 * public NoticeVO noticeSelect(NoticeVO noticeVO) { return
	 * noticeRepository.findById(noticeVO.getNum()).get(); }
	 */
	
	
	public Optional<NoticeVO> noticeSelect(NoticeVO noticeVO) {
		return noticeRepository.findById(noticeVO.getNum());
	}
	
	
	/*
	 * public Boolean noticeInsert(NoticeVO noticeVO, List<MultipartFile> files)
	 * throws Exception { List<NoticeFilesVO> ar = new ArrayList<NoticeFilesVO>();
	 * 
	 * System.out.println(files.size()); Boolean check = false;
	 * 
	 * if(files.size() > 0) { for(MultipartFile multipartFile : files) {
	 * //if(multipartFile.getSize() > 0) { // check = true; // break; // }
	 * if(multipartFile.getSize() <= 0) { files.remove(multipartFile); } }//for 끝
	 * 
	 * if(files.size() > 0) { for(MultipartFile multipartFile : files) {
	 * 
	 * NoticeFilesVO noticeFilesVO = new NoticeFilesVO(); File file =
	 * filePathGenerator.getUseClassPathResource("upload"); String filename =
	 * fileSaver.save(file, multipartFile);
	 * 
	 * noticeFilesVO.setNoticeVO(noticeVO);
	 * noticeFilesVO.setOname(multipartFile.getOriginalFilename());
	 * noticeFilesVO.setFname(filename);
	 * 
	 * 
	 * ar.add(noticeFilesVO); } }
	 * 
	 * noticeVO.setNoticeFilesVOs(ar); } noticeVO = noticeRepository.save(noticeVO);
	 * 
	 * if(noticeRepository.existsById(noticeVO.getNum())) { return true; }
	 * 
	 * return false; }
	 */
	 
	
	
	public Boolean noticeInsert(NoticeVO noticeVO, List<MultipartFile> files) throws Exception {
		List<NoticeFilesVO> ar = new ArrayList<NoticeFilesVO>();
		Boolean check = false;
		
		for(MultipartFile multipartFile : files) {
			if (!multipartFile.isEmpty()) {
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				File file = filePathGenerator.getUseClassPathResource("upload");
				String filename = fileSaver.save(file, multipartFile);
						
				noticeFilesVO.setNoticeVO(noticeVO);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				noticeFilesVO.setFname(filename);
						
				ar.add(noticeFilesVO);
			}
		}	
			
		noticeVO.setNoticeFilesVOs(ar);	
		noticeVO = noticeRepository.save(noticeVO);
		
		if(noticeRepository.existsById(noticeVO.getNum())) {
			return true;
		}
		
		return false;
	}
	
	
			
	
}
