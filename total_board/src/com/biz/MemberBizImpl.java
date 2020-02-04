package com.biz;

import java.util.List;

import com.dao.MemberDao;
import com.dao.MemberDaoImpl;
import com.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {

	MemberDao dao = new MemberDaoImpl();
	@Override
	public List<MemberDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public List<MemberDto> selectEnabled() {
		// TODO Auto-generated method stub
		return dao.selectEnabled();
	}

	@Override
	public int updateRole(int mbno, String mbrole) {
		// TODO Auto-generated method stub
		return dao.updateRole(mbno, mbrole);
	}

	@Override
	public MemberDto login(String mbid, String mbpw) {
		// TODO Auto-generated method stub
		return dao.login(mbid, mbpw);
	}

	@Override
	public int idChk(String mbid) {
		// TODO Auto-generated method stub
		return dao.idChk(mbid);
	}

	@Override
	public int insertUser(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.insertUser(dto);
	}

	@Override
	public MemberDto selectUser(int mbno) {
		// TODO Auto-generated method stub
		return dao.selectUser(mbno);
	}

	@Override
	public int updateUser(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.updateUser(dto);
	}

	@Override
	public int deleteUser(int mbno) {
		// TODO Auto-generated method stub
		return dao.deleteUser(mbno);
	}

	@Override
	public int findPw(String mbid, String mbname, String mbemail) {
		// TODO Auto-generated method stub
		return dao.findPw(mbid, mbname, mbemail);
	}

	@Override
	public int changePw(String mbid, String mbpw) {
		// TODO Auto-generated method stub
		return dao.changePw(mbid, mbpw);
	}

}
