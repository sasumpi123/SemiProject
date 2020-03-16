package com.letter.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.letter.dto.LetterDto;
import com.mybatis.db.SqlMapConfig;

public class LetterDaoImpl extends SqlMapConfig implements LetterDao {
	
	private String namespace = "letter.";

	@Override
	public List<LetterDto> sendList(String id) {
		SqlSession session = null;
		List<LetterDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"sendList", id);
		} catch (Exception e) { 
			System.out.println("[error] : sendList");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public List<LetterDto> receiveList(String id) {
		SqlSession session = null;
		List<LetterDto> list = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			list = session.selectList(namespace+"receiveList", id);
		} catch (Exception e) {
			System.out.println("[error] : receiveList");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public LetterDto selectOne(String id, int seq) {
		LetterDto dto = null;
		SqlSession session = null;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("seq", Integer.toString(seq));
		
		try {
			session = getSqlSessionFactory().openSession();
			dto = session.selectOne(namespace+"selectOne", map);
		} catch (Exception e) {
			System.out.println("[error] : selectOne");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	@Override
	public int letter_read(String id, int seq) {
		int res = 0;
		SqlSession session = null;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("seq", Integer.toString(seq));
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.update(namespace+"updateRead", map);
			if(res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("[error] : updateRead");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int insert_letter(LetterDto dto) {
		int res = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.insert(namespace+"insert" , dto);
			
			if(res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int delete_letter(String id, String[] seqs) {
		int res = 0;
		SqlSession session = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("seqs", seqs);
		
		try {
			session = getSqlSessionFactory().openSession();
			res = session.delete(namespace+"multiDelete", map);
			
			if(res == seqs.length) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("[error] : multidelete");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}
	



}
