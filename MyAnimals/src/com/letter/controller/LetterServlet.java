package com.letter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.letter.biz.LetterBiz;
import com.letter.biz.LetterBizImpl;
import com.letter.dto.LetterDto;

/**
 * Servlet implementation class LetterServlet
 */
@WebServlet("/letter.do")
public class LetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LetterBiz biz = new LetterBizImpl();
	
    public LetterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("letter : " + command);
		
		PrintWriter out = response.getWriter();
		
		if(command.equals("sendList")) {
			String id = request.getParameter("id");
			List<LetterDto> list = biz.sendList(id);
			request.setAttribute("letterList", list);
			dispatch("/Letter/sendList.jsp", request, response);
			
		}else if(command.equals("receiveList")) {
			String id = request.getParameter("id");
			List<LetterDto> list = biz.receiveList(id);
			request.setAttribute("letterList", list);
			dispatch("/Letter/letter.jsp", request, response);
			
		} else if(command.equals("detail")) {
			String id = request.getParameter("id");
			int seq = Integer.parseInt(request.getParameter("seq"));
			LetterDto dto = biz.selectOne(id, seq);
			request.setAttribute("letterDto", dto);
			dispatch("/Letter/detail.jsp", request, response);
			
		} else if(command.equals("write")) {
			response.sendRedirect("Letter/writeform.jsp");
			
		} else if(command.equals("insert")) {
			String to = request.getParameter("to");
			String from = request.getParameter("from");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			LetterDto dto = new LetterDto();
			dto.setMember_to(to);
			dto.setMember_from(from);
			dto.setLetter_title(title);
			dto.setLetter_content(content);
			
			int res = biz.insert_letter(dto);
			if(res > 0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('작성 성공');");
				out.println("opener.location.reload();");
				out.println("self.close();");
				out.println("</script>");
			} else {
				System.out.println("작성 실패");
				// jsResponse("작성 실패", "/Letter/letter.jsp", response);
			}
			
		} else if(command.equals("multidelete")) {
			String id = request.getParameter("id");
			String[] seq = request.getParameterValues("chk");
			
			int res = biz.delete_letter(id, seq);
			if(res > 0) {
				out.println("<script type='text/javascript'>");
				out.println("alert('삭제 성공');");
				out.println("opener.location.reload();");
				out.println("self.close();");
				out.println("</script>");
			} else {
				jsResponse("삭제 실패", "Letter/letter.jsp", response);
			}
			
		}
		
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('"+msg+"');");
		out.println("location.href='"+url+"';");
		out.println("</script>");
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	
	
	private void historyBack(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("history.back()");
		out.println("</script>");
	}

}
