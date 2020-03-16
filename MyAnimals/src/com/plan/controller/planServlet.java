package com.plan.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.calendar.biz.calendarBiz;
import com.calendar.biz.calendarBizImpl;
import com.calendar.dto.VolunteerDto;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.plan.biz.planBiz;
import com.plan.biz.planBizImpl;
import com.plan.dao.planDao;
import com.plan.dao.planDaoImpl;
import com.plan.dto.planDto;

/**
 * Servlet implementation class localxml
 */
@WebServlet("/planServlet")
public class planServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	planBiz biz = new planBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		System.out.println("command : " + command);


		if (session.getAttribute("memberDto") == null) {
			jsResponse("로그인을 먼저 해주세요", "Member/loginpage.jsp", response);
		} else {
		
			if (command.equals("select")) {
				response.sendRedirect("/MyAnimals/Plan/plantest.jsp");
				
			} else if (command.equals("showxml")) {
				planDao dao = new planDaoImpl(); 
	            String sido = request.getParameter("sido");
	            String gugun = request.getParameter("gugun");
	            Document doc;
	            List<planDto> list = new ArrayList<>();
	            List<planDto> plist = new ArrayList<>();
	            list = dao.selectList();
	            
	            if(sido.equals("전국")) {
	               response.setContentType("application/json");
	               response.setCharacterEncoding("UTF-8");

	               // DTO 타입의 어레이리스트를 json 형태로 바꿔주는 구문(라이브러리 필수, zip->jar 확장자명 꼭 확인)
	               String gson = new Gson().toJson(list);

	               try {
	                  // ajax로 리턴해주는 부분

	                  response.getWriter().write(gson);

	                  System.out.println(gson);
	               } catch (JsonIOException e) {
	                  e.printStackTrace();
	               } catch (IOException e) {
	                  e.printStackTrace();
	               }

	               /*
	                * request.setAttribute("list", list); int res = biz.insertList(list); if(res ==
	                * list.size()) { System.out.println("삽입 성공"); }
	                */

	            }else {
	               for(int i=0; i<list.size(); i++) {
	                  if(list.get(i).getCenter_addr().contains(sido)) {
	                     if(list.get(i).getCenter_addr().contains(gugun)) {
	                  planDto dto = new planDto();
	                  dto.setMember_id(list.get(i).getMember_id());
	                  dto.setCenter_addr(list.get(i).getCenter_addr());
	                  dto.setCenter_latitude(list.get(i).getCenter_latitude());
	                  dto.setCenter_name(list.get(i).getCenter_name());
	                  dto.setCenter_phone(list.get(i).getCenter_phone());
	                  dto.setCenter_seq(list.get(i).getCenter_seq());
	                  dto.setCneter_longitude(list.get(i).getCneter_longitude());
	                  
	                  plist.add(dto);
	                     }
	                  }
	                  
	               }
	               response.setContentType("application/json");
	               response.setCharacterEncoding("UTF-8");

	               // DTO 타입의 어레이리스트를 json 형태로 바꿔주는 구문(라이브러리 필수, zip->jar 확장자명 꼭 확인)
	               String gson = new Gson().toJson(plist);

	               try {
	                  // ajax로 리턴해주는 부분

	                  response.getWriter().write(gson);

	                  System.out.println(gson);
	               } catch (JsonIOException e) {
	                  e.printStackTrace();
	               } catch (IOException e) {
	                  e.printStackTrace();
	               }
	            
	            }
	            
	            
} else if (command.equals("detail")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			System.out.println(seq);

			planDto planDto = biz.selectOne(seq);
			

			session.setAttribute("planDto", planDto);
			
		
			dispatch("/Plan/planDetail.jsp", request, response);

		}
	}
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}

}