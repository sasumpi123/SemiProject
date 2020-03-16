package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

import com.member.biz.MemberBiz;
import com.member.biz.MemberBizImpl;
import com.member.dao.Util;
import com.member.dto.MemberDto;



@WebServlet("/emailchk.do")
public class MemberEmailController extends HttpServlet {
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

		MemberBiz biz = new MemberBizImpl();
		String command = request.getParameter("command");
		System.out.println("[" + command + "]");
		if (command.equals("emailchk")) {
			String email = (String) request.getParameter("email");
			final String user = "sasumpi1234"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
			final String password = "test123**"; // 패스워드
			String emailChkText = Util.emailConfirm(8);
			
			System.out.println(email);
			
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

				// Subject
				message.setSubject("메일 인증번호 입니다"); // 메일 제목을 입력

				// Text
				message.setText(emailChkText); // 메일 내용을 입력

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
			System.out.println(emailChkText);
			request.setAttribute("emailChkText", emailChkText);
			jsResponse("메일함을 확인해주세요!", "", response);
			dispatch("Member/emailChk.jsp", request, response);

		}else if(command.equals("emailChkRes")) {
			String inputEmailChkText = (String)request.getParameter("inputEmailChkText");
			String emailChkText = (String)request.getParameter("emailChkText");
			
			if(inputEmailChkText.equals(emailChkText)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('인증 완료하였습니다')");
				out.println("self.close()");
				out.println("</script>");
			}else {
				jsResponse("인증번호를 다시확인해주세요", "", response);
				dispatch("Member/emailChk.jsp", request, response);
			}
		}
		else if (command.equals("forgotinfo")) {
			dispatch("Member/forgotinfo.jsp", request, response);
			
		}else if(command.equals("forgotid")) {
			String email = request.getParameter("email");
			String id = biz.findId(email);
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('아이디는 :"+id+"입니다.')");
			out.println("self.close()");
			out.println("</script>");

		}else if (command.equals("forgotpw")) {
			String id = (String) request.getParameter("id");
			String email = (String) request.getParameter("email");
			int res = biz.findPw(id, email);
			if(res>0) {
				System.out.println("존재하는 회원");
				String tppw = Util.madePassword(10);
				int result = biz.changePw(id, tppw);
				if (result > 0) {
					request.setAttribute("tppw", tppw);
					request.setAttribute("email", email);

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
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

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
					jsResponse("비밀번호 변경 실패", "/MyAnimals/emailchk.do?command=forgotpw", response);
				}
			} else {
				System.out.println("틀림");
				jsResponse("회원정보가 일치하지 않습니다.", "", response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('회원정보가 일치하지 않습니다.')");
				out.println("self.close()");
				out.println("</script>");
			}
		}else if(command.equals("emailchk")) {
			String email = request.getParameter("email");
			
			MemberDto memberDto = new MemberDto();
			
			memberDto.setMember_email(email);
			
			dispatch("Member/emailChk.jsp", request, response);
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