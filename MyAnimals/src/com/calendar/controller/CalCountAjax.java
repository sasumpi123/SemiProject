package com.calendar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calendar.dao.calendarDao;
import com.calendar.dao.calendarDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CalCountAjax
 */
@WebServlet("/calcountajax.do")
public class CalCountAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalCountAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String yyyyMMdd = request.getParameter("yyyyMMdd");
		
		calendarDao dao = new calendarDaoImpl();
		int count = dao.getCalCount(id, yyyyMMdd);
		System.out.println("일정 갯수: "+ count);
		
		//data를 map으로 감싼다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("count",count);
		
		//map을 json으로 변환한다.
		JSONObject obj = JSONObject.fromObject(map);
		//map객체에서 가지고 와썽요 json으로
		
		//변환된 json을 응답한다.
		PrintWriter out = response.getWriter();
		obj.write(out);
		
		
	}

}
