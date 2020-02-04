package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dao.Util;

@WebServlet("/forgot.do")
public class forGotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		MemberBiz biz = new MemberBizImpl();
		if (command.equals("forgotinfo")) {
			dispatch("forgotinfo.jsp", request, response);
		} else if (command.equals("forgotpw")) {
			String mbid = (String) request.getParameter("mbid");
			String mbname = (String) request.getParameter("mbname");
			String mbemail = (String) request.getParameter("mbemail");
			int res = biz.findPw(mbid, mbname, mbemail);
			if (res > 0) {
				System.out.println("존재하는 회원");
				String tppw = Util.madePassword(10);
				int result = biz.changePw(mbid, tppw);
				if (result > 0) {
					request.setAttribute("tppw", tppw);
					request.setAttribute("mbemail", mbemail);

					final String user = "sasumpi1234"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
					final String password = "test123**"; // 패스워드

					// SMTP 서버 정보를 설정한다.
					Properties prop = new Properties();
					prop.put("mail.smtp.host", "smtp.gmail.com");
					prop.put("mail.smtp.port", 465);
					prop.put("mail.smtp.auth", "true");
					prop.put("mail.smtp.ssl.enable", "true");
					prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

					Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(user, password);
						}
					});

					try {
						MimeMessage message = new MimeMessage(session);
						message.setFrom(new InternetAddress(user));

						// 수신자메일주소
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(mbemail));

						// Subject
						message.setSubject("임시비밀번호 입니다"); // 메일 제목을 입력

						// Text
						message.setText("임시 비밀번호는 : " + tppw + " 입니다."); // 메일 내용을 입력

						// send the message
						Transport.send(message); //// 전송
						System.out.println("메일 전송 완료!");
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					out.println("<script type=\"text/javascript\">");
					out.println("alert('메일함에서 임시 비밀번호를 확인해주세요')");
					out.println("self.close()");
					out.println("</script>");

				} else {
					jsResponse("비밀번호 변경 실패", "", response);
				}
			} else {
				System.out.println("틀림");

				out.println("<script type=\"text/javascript\">");
				out.println("alert('회원정보가 일치하지 않습니다.')");
				out.println("self.close()");
				out.println("</script>");
			}
		}

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
