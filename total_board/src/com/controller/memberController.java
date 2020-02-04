package com.controller;

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

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

@WebServlet("/member.do")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		MemberBiz biz = new MemberBizImpl();
		HttpSession session = request.getSession();
		
		if (command.equals("login")) {
			String mbid = request.getParameter("id");
			String mbpw = request.getParameter("pw");
			MemberDto dto = biz.login(mbid, mbpw);
			System.out.println("ㅎㅇㅎ");
			if (dto != null) {
				System.out.println("뭔가있으면 여길와야지");
				// 세션에 로그인 정보 저장
				if (dto.getMbenabled().equals("N")) {
					System.out.println("여기오면 로그인불가임");
					response.sendRedirect("logindeny.jsp");
				} else if (dto.getMbrole().equals("USER") || dto.getMbrole().equals("MANAGER")) {
					System.out.println("여기면 일반 사용자");
					session.setAttribute("dto", dto);
					session.setMaxInactiveInterval(10 * 60000);
					response.sendRedirect("usermain.jsp");
				} else if (dto.getMbrole().equals("ADMIN")) {
					System.out.println("여기면 관리자");
					session.setAttribute("dto", dto);
					session.setMaxInactiveInterval(10 * 60000);
					response.sendRedirect("adminmain.jsp");
				}
			} else {
				jsResponse("id와 pw를 다시한번 확인해주세요", "login.jsp", response);
			}
		} else if (command.equals("logout")) {
			// 로그이웃 (세션 만료)
			session.invalidate();
			response.sendRedirect("index.jsp");

			System.out.println("로그아웃");
		} else if (command.equals("selectlist")) {
			// 회원리스트 검색(접속가능여부 상관없이 전부)
			List<MemberDto> list = biz.selectList();
			request.setAttribute("list", list);

			System.out.println("싹다검색");
			dispatch("userselectlist.jsp", request, response);
		} else if (command.equals("userselectenabled")) {
			// 회원리스트 enabled Y인 사람만 검색
			List<MemberDto> list = biz.selectEnabled();
			request.setAttribute("list", list);

			System.out.println("부분 검색");
			dispatch("userselectenabled.jsp", request, response);
		} else if (command.equals("updateroleform")) {
			// 등급 변경
			int mbno = Integer.parseInt(request.getParameter("mbno"));
			MemberDto dto = biz.selectUser(mbno);
			request.setAttribute("select", dto);

			System.out.println("등급 변경");
			dispatch("updaterole.jsp", request, response);
		} else if (command.equals("updateroleres")) {
			// 등급 변경
			String mbrole = request.getParameter("role");
			int mbno = Integer.parseInt(request.getParameter("mbno"));
			int res = biz.updateRole(mbno, mbrole);
			if (res > 0) {
				jsResponse("등급 변경 완료", "adminmain.jsp", response);
			} else {
				jsResponse("등급 변경 실패", "mmeber.do?command=updateroleform&mbno=" + mbno, response);
			}
		} else if (command.equals("regist")) {
			// 회원가입
			response.sendRedirect("registform.jsp");
		} else if (command.equals("idchk")) {
			// 아이디 중복체크
			String mbid = request.getParameter("mbid");
			int res = biz.idChk(mbid);
			boolean idnotused = true;

			if (res == 0) {
				idnotused = false;
			}
			response.sendRedirect("idchk.jsp?idnotused=" + idnotused);

		} else if (command.equals("registres")) {
			// 회원 가입
			MemberDto dto = new MemberDto();
			String mbid = request.getParameter("mbid");
			String mbpw = request.getParameter("mbpw");
			String mbname = request.getParameter("mbname");
			String mbaddr = request.getParameter("mbaddr");
			String mbphone = request.getParameter("mbphone");
			String mbemail = request.getParameter("mbemail");

			dto.setMbid(mbid);
			dto.setMbpw(mbpw);
			dto.setMbname(mbname);
			dto.setMbaddr(mbaddr);
			dto.setMbphone(mbphone);
			dto.setMbemail(mbemail);

			int res = biz.insertUser(dto);
			if (res > 0) {
				jsResponse("회원 가입 성공", "index.jsp", response);
			} else {
				jsResponse("회원 가입 실패", "member.do?command=registform", response);
			}
		} else if (command.equals("userinfo")) {
			// 회원정보
			dispatch("userinfo.jsp", request, response);
		} else if (command.equals("userinfoupdate")) {
			// 회원정보 수정
			dispatch("userinfoupdate.jsp", request, response);
		} else if (command.equals("userinfoupdateres")) {
			// 회원정보 수정
			MemberDto dto = new MemberDto();
			int mbno = Integer.parseInt(request.getParameter("mbno"));
			String mbpw = request.getParameter("mbpw");
			String mbaddr = request.getParameter("mbaddr");
			String mbphone = request.getParameter("mbphone");
			String mbemail = request.getParameter("mbemail");
			dto.setMbno(mbno);
			dto.setMbpw(mbpw);
			dto.setMbaddr(mbaddr);
			dto.setMbphone(mbphone);
			dto.setMbemail(mbemail);

			int res = biz.updateUser(dto);
			if (res > 0) {
				dto = biz.selectUser(dto.getMbno());
				session.setAttribute("dto", dto);
				System.out.println("회원정보 수정성공");
				dispatch("userinfo.jsp", request, response);
			} else {
				System.out.println("회원정보 수정실패");
				jsResponse("회원정보 수정 실패", "userinfoupdate.jsp", response);
			}
		} else if (command.equals("userdelete")) {
			MemberDto dto = (MemberDto) session.getAttribute("dto");
			int res = biz.deleteUser(dto.getMbno());
			if (res > 0) {
				jsResponse("회원 탈퇴 성공", "index.jsp", response);
				session.invalidate();
			} else {
				jsResponse("회원 탈퇴 실패", "userinfoupdate.jsp", response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		out.println("<script type=\"text/javascript\">");
		out.println("alert('" + msg + "')");
		out.println("location.href='" + url + "'");
		out.println("</script>");
	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
}
