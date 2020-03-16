package com.plan.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.db.SqlMapConfig;
import com.plan.dto.planDto;

public class planDaoImpl extends SqlMapConfig implements planDao {
	
	private String namespace = "com.plan.mapper.";

	@Override
	public planDto selectOne(int seq) {
		String resource = "com/mybatis/db/config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[error] : selectOne");
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		planDto dto = session.selectOne("com.plan.mapper.selectOne",seq);
		session.close();
		
		return dto;
	}

	@Override
	public int insertList(List<planDto> list) {
		int res = 0;
		SqlSession session = null;
		
		try {
			
			session = getSqlSessionFactory().openSession();
			// res = session.insert(namespace+"insertList",list);
			for(int i = 0; i < list.size(); i++) {
				planDto dto = list.get(i);
				session.insert(namespace+"insert", dto);
				res++;
			}
			
			if(res == list.size()) {
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("[error] : insertList");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
		return res;
	}
	
	@Override
	public List<planDto> selectList() {
		List<planDto> list = null;
	      SqlSession session = null;
	      
	      try {
	         session = getSqlSessionFactory().openSession();
	         list = session.selectList(namespace+"selectList");
	         
	      } catch (Exception e) {
	         System.out.println("[error] : insertList");
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return list;

	}

}
