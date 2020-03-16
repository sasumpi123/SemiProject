package com.member.biz;

import java.util.List;

import com.calendar.dto.ApplyDto;
import com.calendar.dto.VolunteerDto;
import com.member.dao.MemberDao;
import com.member.dao.MemberDaoImpl;
import com.member.dto.MemberDto;
import com.plan.dto.planDto;

public class MemberBizImpl implements MemberBiz {
   private MemberDao dao = new MemberDaoImpl();
	@Override
	public List<MemberDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public List<MemberDto> selectUser() {
		// TODO Auto-generated method stub
		return dao.selectUser();
	}

	@Override
	public List<MemberDto> selectCenter() {
		// TODO Auto-generated method stub
		return dao.selectCenter();
	}
	

	@Override
	public int updateRole(String id,String role) {
		// TODO Auto-generated method stub
		return dao.updateRole(id,role);
	}

	@Override
	public MemberDto selectOne(String id) {
		// TODO Auto-generated method stub
		return dao.selectOne(id);
	}

	@Override
	public int updateInfo(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.updateInfo(dto);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public MemberDto login(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

	@Override
	public int regist(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.regist(dto);
	}

	@Override
	public String findId(String email) {
		// TODO Auto-generated method stub
		return dao.findId(email);
	}

//	@Override
//	public int findPw(String id, String email) {
//		// TODO Auto-generated method stub
//		return dao.findPw(id, email);
//	}

	@Override
	public int findPw(String id, String email) {
		// TODO Auto-generated method stub
		return dao.findPw(id, email);
	}

	@Override
	public MemberDto idChk(String id) {
		// TODO Auto-generated method stub
		return dao.idChk(id);
	}

	@Override
	public MemberDto nicknameChk(String nickname) {
		// TODO Auto-generated method stub
		return dao.nicknameChk(nickname);
	}

	@Override
	public MemberDto emailChk(String email) {
		// TODO Auto-generated method stub
		return dao.emailChk(email);
	}
	public int changePw(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.changePw(id, pw);
	}

	@Override
	public int centerInsert(planDto planDto) {
		// TODO Auto-generated method stub
		return dao.centerInsert(planDto);
	}
	
	//센터 selectOneCenter
	@Override
    public planDto selecOneCenter(String id) {
       
       return dao.selecOneCenter(id);
    }
    
    
    //봉사 등록한 사람 applyVolunteer
	@Override
	public List<ApplyDto> applyVolunteer(int volunteer_seq) {
       
       return dao.applyVolunteer(volunteer_seq);
    }
 

//봉사일정list
	@Override
	public List<VolunteerDto> selectListVolunteer(String id){
       
       return dao.selectListVolunteer(id);
    }
	




	

}