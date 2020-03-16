package com.calendar.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.calendar.dto.ApplyDto;
import com.calendar.dto.CalendarDto;
import com.calendar.dto.VolunteerDto;
import com.member.dto.MemberDto;
import com.mybatis.db.SqlMapConfig;

public class calendarDaoImpl extends SqlMapConfig implements calendarDao {

   String namespace = "calendar.";
   @Override
   public VolunteerDto selectOne(int center_seq,String yyyyMMdd) {
      
      SqlSession session = null;
      VolunteerDto volunteerDto = null;
      
      HashMap<String, Object> map = new HashMap<>();
      map.put("center_seq", center_seq);
      map.put("yyyyMMdd", yyyyMMdd);
      
      
      try {
         session = getSqlSessionFactory().openSession();
         volunteerDto = session.selectOne(namespace+"selectOne",map);
      } catch (Exception e) {
         System.out.println("selectOne 오류지롱");
         e.printStackTrace();
      }finally {
         session.close();
      }
      
      return volunteerDto;
   }

   @Override
   public int insert(VolunteerDto dto) {
      
      
      SqlSession session = null;
      int res = 0;
      try {
         session = getSqlSessionFactory().openSession();
         res = session.insert(namespace+"insert",dto);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("insert오류지롱");
         e.printStackTrace();
      }finally {
         session.commit();
         session.close();
      }
      
      return res;
      
   }

   @Override
   public int update(CalendarDto dto) {
      
      
      
      return 0;
   }

   @Override
   public int delete(int volunteer_seq) {
      
      SqlSession session = null;
      int res = 0;
      
      try {
         session = getSqlSessionFactory().openSession();
         res = session.delete(namespace+"volunteerDelete",volunteer_seq);
      } catch (Exception e) {
         System.out.println("volutneerDelete오류");
         e.printStackTrace();
      }finally {
         session.commit();
         session.close();
      }
      
      return res;
      
   }
   
   @Override
   public int countvolunteer(int volunteer_seq) {
      SqlSession session = null;
      int res = 0;
      
      try {
         session = getSqlSessionFactory().openSession();
         res = session.selectOne(namespace+"count", volunteer_seq);
      } catch (Exception e) {
         System.out.println("[error] : countvolunteer");
         e.printStackTrace();
      } finally {
         session.close();
      }
      
      
      return res;
   }
   
   @Override
   public List<VolunteerDto> getCalViewList(String member_id, String yyyyMM, int center_seq){
      
      
      SqlSession session = null;
      List<VolunteerDto> list = null;
      
      HashMap<String, String> map = new HashMap<>();
      map.put("member_id", member_id);
      map.put("yyyyMM", yyyyMM);
      map.put("center_seq", Integer.toString(center_seq));
      
      
      try {
         session = getSqlSessionFactory().openSession();
         list = session.selectList(namespace+"getCalView",map);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("getCalViewList 오류");
         e.printStackTrace();
      }finally {
         session.close();
      }
      return list;
   }
   
   @Override
   public int getCalCount(String id, String yyyyMMdd) {
      
      
      return 0;
   }

   @Override
   public int insertCalBoard(CalendarDto dto) {
      // TODO Auto-generated method stub
      return 0;
   }
   
   public int applyInsert(ApplyDto applyDto) {
      
      SqlSession session = null;
      int res = 0;
      try {
         session = getSqlSessionFactory().openSession();
         res = session.insert(namespace+"applyInsert",applyDto);
      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("applyInsert오류");
         e.printStackTrace();
      }finally {
         session.commit();
         session.close();
      }
      
      return res;
   }
   
   

}