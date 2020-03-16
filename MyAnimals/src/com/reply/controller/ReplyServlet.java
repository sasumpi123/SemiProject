package com.reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dto.BoardDto;
import com.member.dto.MemberDto;
import com.reply.biz.ReplyBiz;
import com.reply.dto.ReplyDto;

@WebServlet("/reply.do")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReplyServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		ReplyBiz biz = new ReplyBiz();

		if (command.equals("list")) {

			BoardDto dto = (BoardDto) request.getAttribute("boardDto");
            int board_seq = dto.getBoard_seq();
			List<ReplyDto> list = biz.selectList(board_seq);
			/*
			 * BoardDto dto2 = new BoardDto();
			 * 
			 * request.setAttribute("boardDto2", dto2);
			 */
			request.setAttribute("replyList", list);
			request.setAttribute("boardDto", dto);
			dispatch("Board/detail.jsp", request, response);

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
