package com.weather.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//순서
	//1.weatherview에서 ajax를통해서 servlet으로 갔다.
	//2.서블릿이 이걸 받고 바로 응답이 아닌 포워드(웨더인포)했다.
	//3.rss한테 웨더 인포가 요청(웨더뷰에서 보내준 코드)하고 해당 지역에 맞는 xml파일을 응답
	//4.응답시켜준 xml파일을 웨더인포가 json형태로 만들어 준다.()
	//5.웨더 인포 우리가 알고 있는 html에~ 앤드html로 만들어지는 문서가 아닌 
	//6.우리가 만들어 준것대로 응답. 웨더뷰에서ajax가 그 json형태를 파싱해서 화면에 뿌려주고 있다.
       
    
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String code= request.getParameter("code");
		request.setAttribute("code", code);//code 받아서 담아둔다. 이유 getParameter는 string 만 받을 수 있어서,,

		RequestDispatcher dispatch = request.getRequestDispatcher("weatherinfo.jsp");//최초로 들어온 것을 weatherinfo로 보내 준다. forward
		
		dispatch.forward(request, response);
		
		
	}

}
