package com.animalinfo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animalinfo.dao.AnimalinfoDao;
import com.animalinfo.dao.AnimalinfoDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

@WebServlet("/kind.do")
public class AnimalInfoKindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String kind = request.getParameter("kind");
		AnimalinfoDao dao = new AnimalinfoDaoImpl();
		System.out.println("controller kind : " + kind);
		if (kind.equals("전체")) {
			Map<String, Integer> map = dao.selectKindAll();
			request.setAttribute("map", map);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String gson = new Gson().toJson(map);
			try {
				// ajax로 리턴해주는 부분
				response.getWriter().write(gson);
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Map<String, Integer> map = dao.selectKindAnimal(kind);
			request.setAttribute("map", map);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String gson = new Gson().toJson(map);
			try {
				// ajax로 리턴해주는 부분
				response.getWriter().write(gson);
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
