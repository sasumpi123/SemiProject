package com.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardDto;
import com.mybatis.db.SqlMapConfig;


public class BoardDao extends SqlMapConfig {




	private String namespace = "boardb.";

	public List<BoardDto> selectList(int to, int from) {
		
		List<BoardDto> list = null;


		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("to",to);
		map.put("from",from);


		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "selectList",map);
		} catch (Exception e) {
			System.out.println("error:selectList");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public BoardDto selectOne(int boardno) {

		BoardDto dto = new BoardDto();
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace + "selectOne", boardno);
		} catch (Exception e) {
			System.out.println("error:selectOne");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dto;
	}

	public int insert(BoardDto dto) {
		int res = 0;
		SqlSession session = null;
		System.out.println(dto.getBoard_title());
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "insert", dto);
			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("error:insert");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public int update(BoardDto dto) {
		int res = 0;
		SqlSession session = null;

		// System.out.println(dto.getContent()); 오류 잡는 방법
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "update", dto);
			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("error:update");
			e.printStackTrace();
		} finally {
			session.close();
		}
		// System.out.println(res); 오류 잡는 방법
		return res;
	}

	public int delete(int boardno) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "delete", boardno);
			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("error:delete");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int answerUpdate(int parentboardno) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "answerUpdate", parentboardno);
			if (res > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("error:answerUpdate");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int answerInsert(BoardDto dto) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.insert(namespace + "answerInsert", dto);
			if (res > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			System.out.println("error:answerInsert");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}

	public int updateHit(int boardno) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.update(namespace + "updateHit", boardno);

			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("error:updateHit");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}
	
	

	public int totalPage() {
		
		int res = 0;
		SqlSession session = null;
		
		try {
			session=getSqlSessionFactory().openSession();
			res = session.selectOne(namespace+"totalPage");
		} catch (Exception e) {
			System.out.println("error:totalPage");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}

}
