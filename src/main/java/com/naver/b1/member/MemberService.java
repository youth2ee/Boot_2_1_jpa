package com.naver.b1.member;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.naver.b1.member.MemberFilesVO;
import com.naver.b1.member.MembersVO;
import com.naver.b1.util.FilePathGenerator;
import com.naver.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	@Autowired 
	private ServletContext servelContext;
	 
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public List<MembersVO> memberLogin(MembersVO membersVO) throws Exception{
		  return membersRepository.findByIdAndPw(membersVO.getId(), membersVO.getPw());
	}
	
	public List<MemberFilesVO> memberFilelogin(MembersVO membersVO) throws Exception {
		return memberFilesRepository.findById(membersVO.getId());
	}
	
//
	public Boolean idCheck(MembersVO membersVO) throws Exception {
		return membersRepository.existsById(membersVO.getId());
	}
	
	public Boolean memberJoin(MembersVO membersVO, MultipartFile files) throws Exception{
		membersVO = membersRepository.save(membersVO);
		
		if(membersRepository.existsById(membersVO.getId())) {
			File file = filePathGenerator.getUseClassPathResource("upload");
			String filename = fileSaver.save(file, files);
			
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			//memberFilesVO.setId(membersVO.getId());
			memberFilesVO.setFname(filename);
			memberFilesVO.setOname(files.getOriginalFilename());
			
			memberFilesVO = memberFilesRepository.save(memberFilesVO);
			
			return true; //memberFilesRepository.existsById(membersVO.getId());
			
		} else {
			return false;
		}
		
	}
	
	public MemberFilesVO memberFileSelect (MembersVO membersVO) throws Exception {
		List<MemberFilesVO> ar = memberFilesRepository.findById(membersVO.getId());
		return ar.get(0);
	}
	
	
	
	
}
