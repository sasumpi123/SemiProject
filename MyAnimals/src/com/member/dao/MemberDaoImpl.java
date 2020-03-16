package com.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import com.mybatis.db.SqlMapConfig;
import com.plan.dto.planDto;
import com.calendar.dto.ApplyDto;
import com.calendar.dto.VolunteerDto;
import com.member.dto.MemberDto;
import com.mybatis.db.SqlMapConfig;

public class MemberDaoImpl extends SqlMapConfig implements MemberDao {
	
	String namespace = "member.";

	//관리자 메뉴
	
	//전체 검색
	@Override
	public List<MemberDto> selectList() {
	    SqlSession session = null;
	    List<MemberDto> list = null;
	    
	    try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return list;
	}
    //봉사자 검색
	@Override
	public List<MemberDto> selectUser() {
		SqlSession session = null;
		List<MemberDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"selectUser");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(list);
		}finally {
			session.close();
		}
		return list;
	}
	
	//센처장 검색
	@Override
	public List<MemberDto> selectCenter() {
		SqlSession session = null;
		List<MemberDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"selectCenter");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(list);
		}finally {
			session.close();
		}
		return list;
	}
	
	//등급 변경
	@Override
	public int updateRole(String id,String role) {
		SqlSession session = null;
		int res = 0;
		
		MemberDto dto = new MemberDto();
		dto.setMember_id(id);
		dto.setMember_role(role);
		System.out.println(id);
		System.out.println(role);
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"updateRole",dto);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}finally {
			session.close();
		}
		return res;
	}
	// 회원 메뉴
		// 내 정보
	@Override
	public MemberDto selectOne(String id) {
		SqlSession session = null;
		MemberDto dto = new MemberDto();
		
		dto.setMember_id(id);
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectOne",id);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return dto;
	}
	// 내 정보 수정
	@Override
	public int updateInfo(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"updateInfo",dto);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return res;
	}
	// 회원 탈퇴 (delflag로 관리)
	@Override
	public int delete(String id) {
		SqlSession session = null;
		int res = 0;
		
		MemberDto dto = new MemberDto();
		
		dto.setMember_id(id);
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"delete",id);
			
			if(res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return res;
	}
   //로그인 및 회원가입
	
	// 로그인
	@Override
	public MemberDto login(String id, String pw) {
		SqlSession session = null;
		MemberDto dto = null;
		Map<String, String> map = new HashMap<>();
		map.put("id",id);
		map.put("pw", pw);
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"login",map);
			
		} catch (Exception e) {
			System.out.println("[error] : login");
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	// 회원가입
	@Override
	public int regist(MemberDto dto) {
		SqlSession session = null;
		int res = 0;
		System.out.println(dto.getMember_id());
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace+"regist",dto);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}System.out.println(res);
		return res;
	}
	// 아이디 찾기
	@Override
	public String findId(String email) {
		SqlSession session = null;
		String id = "";
		
		try {
			session = getSqlSessionFactory().openSession();
			 id = session.selectOne(namespace+"selectOneFindId",email);
			System.out.println(email);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println("dao 아이디 :" +id);
		return id;
	}
	// 비밀번호 찾기
	@Override
	public int findPw(String id, String email) {
		SqlSession session = null;
		int res = 0;
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("email", email);
		System.out.println(id);
		System.out.println(email);
		try {
			session = getSqlSessionFactory().openSession();
			res = session.selectOne(namespace+"selectOneFindPw",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public int changePw(String id, String pw) {
		int res = 0;
		SqlSession session = null;
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		
		System.out.println("임시비번"+pw);
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"changePw",map);
			
			if(res>0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	@Override
	public MemberDto idChk(String id) {
		SqlSession session = null;
		MemberDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"idChk", id);
		} catch (Exception e) {
			System.out.println("[error] : idChk");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	@Override
	public MemberDto nicknameChk(String nickname) {
		SqlSession session = null;
		MemberDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"nicknameChk", nickname);
		} catch (Exception e) {
			System.out.println("[error] : nicknameChk");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	@Override
	public MemberDto emailChk(String email) {
		SqlSession session = null;
		MemberDto dto = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"emailChk", email);
		} catch (Exception e) {
			System.out.println("[error] : emailChk");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	@Override
	public int centerInsert(planDto planDto) {
		 SqlSession session = null;
         int res = 0;
         
         System.out.println(planDto.getMember_id());
         
         try {
            session = getSqlSessionFactory().openSession();
            res = session.insert(namespace+"centerInsert", planDto);
         } catch (Exception e) {
            System.out.println("[error] : centerInsert");
            e.printStackTrace();
         }finally {
            session.commit();
            session.close();
         }
         
         
         return res;

	}
	
	 //센터 selectOneCenter
	@Override
    public planDto selecOneCenter(String id) {
       
       SqlSession session = null;
       planDto planDto = null;
       
       try {
          session = getSqlSessionFactory().openSession();
          planDto = session.selectOne(namespace+"selecOneCenter", id);
       } catch (Exception e) {
          System.out.println("[error] : selecOneCenter");
          e.printStackTrace();
       } finally {
          session.close();
       }
       
       return planDto;
    }
    
    //봉사 등록한 사람 applyVolunteer
	@Override
    public List<ApplyDto> applyVolunteer(int volunteer_seq) {
       
       SqlSession session = null;
       List<ApplyDto> applyList = null;
       
       try {
          session = getSqlSessionFactory().openSession();
          applyList = session.selectList(namespace+"applyList",volunteer_seq);
       } catch (Exception e) {
          // TODO: handle exception
          System.out.println("[ERROR] : applyList=" +applyList);
       }finally {
          session.close();
       }
       
       return applyList;
    }
    
    
    //봉사 일정 가져오기
	@Override
    public List<VolunteerDto> selectListVolunteer(String id){
       
       
       SqlSession session = null;
       List<VolunteerDto> list = null;
       
       try {
          session = getSqlSessionFactory().openSession();
          list = session.selectList(namespace+"selectListVolunteer",id);
       } catch (Exception e) {
          // TODO: handle exception
          System.out.println("[ERROR] : selectListVolunteer=" +list);
       }finally {
          session.close();
       }
       
       return list;
    }


}
