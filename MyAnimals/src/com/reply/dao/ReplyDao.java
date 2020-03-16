package com.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.db.SqlMapConfig;

import com.reply.dto.ReplyDto;

public class ReplyDao extends SqlMapConfig{

	
	private String namespace = "reply.";
	
	public List<ReplyDto> selectList(int board_seq ) {
		System.out.println(board_seq);
		List<ReplyDto> list = null;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace + "selectList",board_seq);
		} catch (Exception e) {
			System.out.println("error:selectList");
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
		
	}

	

	public int insert(ReplyDto dto) {

		int res = 0;
		SqlSession session = null;
		
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

	public int update(ReplyDto dto) {
		int res = 0;
		SqlSession session = null;
		
		//System.out.println(dto.getContent()); 오류 잡는 방법
				try {
					session = getSqlSessionFactory().openSession(false);
					res = session.update(namespace + "update", dto);
					if(res > 0) {
						session.commit();
					}
				} catch (Exception e) {
					System.out.println("error:update");
					e.printStackTrace();
				} finally {
					session.close();
				}
				//System.out.println(res); 오류 잡는 방법
				return res;

		
	}

	public int delete(int reply_seq) {

		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.delete(namespace + "delete", reply_seq);
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
}
