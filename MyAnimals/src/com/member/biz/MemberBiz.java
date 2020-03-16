package com.member.biz;

import java.util.List;

import com.calendar.dto.ApplyDto;
import com.calendar.dto.VolunteerDto;
import com.member.dto.MemberDto;
import com.plan.dto.planDto;

public interface MemberBiz {
	
	// 관리자 메뉴
	// 전체 검색
	public List<MemberDto> selectList();
	// 봉사자 검색
	public List<MemberDto> selectUser();
	// 센처장 검색
	public List<MemberDto> selectCenter();
	// 등급변경
	public int updateRole(String id,String role);
	
	
	// 회원 메뉴
	// 내 정보
	public MemberDto selectOne(String id);
	// 내 정보 수정
	public int updateInfo(MemberDto dto);
	// 회원 탈퇴 (delflag로 관리)
	public int delete(String id);
		
	// 로그인 & 회원가입
	// 로그인
	public MemberDto login(String id, String pw);
	// 회원가입
	public int regist(MemberDto dto);
	// 아이디 찾기
	public String findId(String email);
	// 비밀번호 찾기
	public int findPw(String id, String email);
	
	// 중복체크
	// 아이디
	public MemberDto idChk(String id);
	// 닉네임
	public MemberDto nicknameChk(String nickname);
	// 이메일 
	public MemberDto emailChk(String email);

	// 비밀번호 확인 찾기
	public int changePw(String id, String pw);
	
	   public int centerInsert(planDto planDto);
	   
	 //센터 selectOneCenter
	   public planDto selecOneCenter(String id);
	   
	   //봉사 등록한 사람 applyVolunteer
	   public List<ApplyDto> applyVolunteer(int volunteer_seq);
	   
	   
	   //selectListVolunteer봉사일정
	   public List<VolunteerDto> selectListVolunteer(String id);



}