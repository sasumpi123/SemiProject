package com.animalinfo.controller;

import java.io.IOException;
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

@WebServlet("/location.do")
public class AnimalInfoLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		AnimalinfoDao dao = new AnimalinfoDaoImpl();

		String sido = request.getParameter("sido");
		if (sido.equals("전국")) {
			Map<String, Integer> map = dao.selectLoactionAll();
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
		} else {
			System.out.println("controller sido : " + sido);
			Map<String, Integer> map = dao.selectLocation(sido);
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