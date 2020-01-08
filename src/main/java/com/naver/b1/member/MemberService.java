package com.naver.b1.member;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {

	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private MemberFilesRepository memberFilesRepository;
	
	public List<MembersVO> memberLogin(MembersVO membersVO) throws Exception{
		  return membersRepository.findByIdAndPw(membersVO.getId(), membersVO.getPw());
	}
	
	public List<MemberFilesVO> memberFilelogin(MembersVO membersVO) throws Exception {
		return memberFilesRepository.findById(membersVO.getId());
	}
	
	public Optional<MembersVO> idCheck(String id) throws Exception {
		return membersRepository.findById(id);
	}
	
	public MembersVO memberJoin(MembersVO membersVO) throws Exception {
		return membersRepository.save(membersVO);
	}
}
