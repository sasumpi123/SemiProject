package com.calendar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.calendar.biz.calendarBiz;
import com.calendar.biz.calendarBizImpl;
import com.calendar.dao.Util;
import com.calendar.dao.calendarDao;
import com.calendar.dao.calendarDaoImpl;
import com.calendar.dto.ApplyDto;
import com.calendar.dto.CalendarDto;
import com.calendar.dto.VolunteerDto;
import com.plan.dto.planDto;

/**
 * Servlet implementation class calendarServlet
 */
@WebServlet("/calendar.do")
public class calendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void dispatch(String url, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String res = "<script type='text/javascript'>"+" alert('"+msg+"');"+" location.href='"+url+"';"+"</script>";
		
		PrintWriter out = response.getWriter();
		out.println(res);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		calendarBiz biz = new calendarBizImpl();

		PrintWriter out = response.getWriter();
		
		if(command.equals("insertCalendar")) {
			
			String Member_id = request.getParameter("Member_id");
			
			System.out.println("Member_id="+Member_id);
			
			request.setAttribute("Member_id", Member_id);
			
			dispatch("Plan/insertCalendarForm.jsp", request, response);
			
		}else if(command.equals("insert")) {
			
			String Member_id = request.getParameter("Member_id");
			String volunteer_title = request.getParameter("volunteer_title");
			String volunteer_content = request.getParameter("volunteer_content");
			int volunteer_maxvolunteer = Integer.parseInt(request.getParameter("volunteer_maxvolunteer"));
			String volunteer_date = request.getParameter("volunteer_date");
			int Center_seq = Integer.parseInt(request.getParameter("Center_seq"));
			
			String yy = volunteer_date.substring(0, 4);
			String mm = volunteer_date.substring(5, 7);
			String dd = volunteer_date.substring(8, 10);
			
			String yymmdd = yy+mm+dd;
			
			VolunteerDto volunteerDto = new VolunteerDto();
			volunteerDto.setVolunteer_title(volunteer_title);
			volunteerDto.setVolunteer_content(volunteer_content);
			volunteerDto.setVolunteer_maxvolunteer(volunteer_maxvolunteer);
			volunteerDto.setVolunteer_date(yymmdd);
			volunteerDto.setCenter_seq(Center_seq);
			volunteerDto.setMember_id(Member_id);
			
			System.out.println(volunteerDto.getMember_id());
			System.out.println(volunteerDto.getVolunteer_title());
			System.out.println(volunteerDto.getVolunteer_content());
			System.out.println(volunteerDto.getVolunteer_maxvolunteer());
			System.out.println(volunteerDto.getVolunteer_date());
			System.out.println(volunteerDto.getCenter_seq());
			
			int res = biz.insert(volunteerDto);
			
			
			if(res>0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('입력성공');");
				out.println("opener.location.reload();");
				out.println("self.close();");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('입력실패');");
				out.println("opener.location.onload();");
				out.println("self.close();");
				out.println("</script>");
			}
			
		}else if(command.equals("volunteerDetail")) {
			
			int center_seq = Integer.parseInt(request.getParameter("center_seq"));
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String date = request.getParameter("date");
			
			month = Util.isTwo(month);
			date = Util.isTwo(date);
			
			String yyyyMMdd = year+month+date;
			
			VolunteerDto volunteerDto = biz.selectOne(center_seq , yyyyMMdd);
			
			request.setAttribute("volunteerDto", volunteerDto);
			
			dispatch("Plan/calendarDetail.jsp", request, response);
			
			
		}else if(command.equals("applyInsert")) {
			
			int volunteer_seq = Integer.parseInt(request.getParameter("volunteer_seq"));
			
			request.setAttribute("volunteer_seq", volunteer_seq);
			
			dispatch("Plan/applyForm.jsp", request, response);
			
		}else if(command.equals("applyInserForm")) {
			
			String Member_id = request.getParameter("Member_id");
			int volunteer_seq = Integer.parseInt(request.getParameter("volunteer_seq"));
			String apply_name = request.getParameter("apply_name");
			String apply_phone = request.getParameter("apply_phone");
			String apply_email = request.getParameter("apply_email");
			
			System.out.println("Member_id ="+Member_id);
			System.out.println("volunteer_seq="+volunteer_seq);
			System.out.println("name="+apply_name);
			System.out.println("phone="+apply_phone);
			System.out.println("email="+apply_email);
			
			ApplyDto applyDto = new ApplyDto();
			
			applyDto.setMember_id(Member_id);
			applyDto.setVolunteer_seq(volunteer_seq);
			applyDto.setApply_name(apply_name);
			applyDto.setApply_phone(apply_phone);
			applyDto.setApply_email(apply_email);
			
			int res = biz.applyInsert(applyDto);
			
			if(res>0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('봉사 신청 성공');");
				out.println("self.close();");
				out.println("opener.location.reload();");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('입력실패');");
				out.println("self.close();");
				out.println("</script>");
			}
			
			
		}else if(command.equals("volunteerDelete")) {
			
			int volunteer_seq = Integer.parseInt(request.getParameter("volunteer_seq"));
			int center_seq = Integer.parseInt(request.getParameter("center_seq"));
			
			System.out.println("delete_seq:"+ volunteer_seq);
			
			int res = biz.delete(volunteer_seq);
			
			if(res>0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('일정 삭제 성공');");
				out.println("location.href='/MyAnimals/Plan/calendar.jsp'");
				out.println("</script>");
			}else{
				out.println("<script type='text/javascript'>");
				out.println("alert('입력실패');");
				out.println("history.back();");
				out.println("</script>");
			}
			
			
		}
		
		
	}

}
