package com.alarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alarm.biz.AlarmBiz;
import com.alarm.biz.AlarmBizImpl;
import com.member.dto.MemberDto;
import com.alarm.dao.Util;
import com.alarm.dto.AlarmDateDto;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

@WebServlet("/alarm.do")
public class AlarmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		String date = request.getParameter("year") + Util.isTwo(request.getParameter("month"))
				+ Util.isTwo(request.getParameter("date"));
		AlarmBiz biz = new AlarmBizImpl();
		if ((MemberDto) session.getAttribute("memberDto") != null) {
			MemberDto MDto = (MemberDto) session.getAttribute("memberDto");
			List<AlarmDateDto> list = biz.getDate(MDto.getMember_id(), date);
			if (list.size() != 0) {
				request.setAttribute("alist", list);

				// 타입을 json으로 바꿔줘야됨
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				// DTO 타입의 어레이리스트를 json 형태로 바꿔주는 구문(라이브러리 필수, zip->jar 확장자명 꼭 확인)
				String gson = new Gson().toJson(list);

				try {
					// ajax로 리턴해주는 부분
					response.getWriter().write(gson);
				} catch (JsonIOException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("비로그인");
		}

	}
}
