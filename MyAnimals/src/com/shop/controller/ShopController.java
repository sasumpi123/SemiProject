package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.biz.MemberBiz;
import com.member.biz.MemberBizImpl;
import com.member.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.biz.ShopBiz;
import com.shop.biz.ShopBizImpl;
import com.shop.dto.OrderDto;
import com.shop.dto.ShopDto;
import com.shop.biz.OrderBiz;
import com.shop.biz.OrderBizImpl;

@WebServlet("/shop.do")
public class ShopController extends HttpServlet {
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

		ShopBiz biz = new ShopBizImpl();
		OrderBiz biz1 = new OrderBizImpl();
		MemberBiz biz2 = new MemberBizImpl();
		String command = request.getParameter("command");
		if (session.getAttribute("memberDto") == null) {
			jsResponse("로그인을 먼저 해주세요", "Member/loginpage.jsp", response);
		} else {
			if (command.equals("selectList")) {
				List<ShopDto> shopList = biz.selectShopList();
				request.setAttribute("shopList", shopList);
				dispatch("Shop/shopmain.jsp", request, response);

			} else if (command.equals("detail")) {
				int shop_seq = Integer.parseInt(request.getParameter("shop_seq"));
				ShopDto shopDto = biz.selectShopOne(shop_seq);
				MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
				request.setAttribute("shopDto", shopDto);
				request.setAttribute("member_role", memberDto.getMember_role());
				dispatch("Shop/shopdetail.jsp", request, response);
			} else if (command.equals("insert")) {
				response.sendRedirect("Shop/shopinsertform.jsp");
			} else if (command.equals("search")) {
				String searchTitle = request.getParameter("searchTitle");
				String searchContent = request.getParameter("searchContent");
				List<ShopDto> shopList = biz.search(searchTitle, searchContent);
				request.setAttribute("shopList", shopList);
				dispatch("Shop/shopmain.jsp", request, response);
			} else if (command.equals("update")) {
				int shop_seq = Integer.parseInt(request.getParameter("shop_seq"));
				ShopDto shopDto = biz.selectShopOne(shop_seq);
				request.setAttribute("shopDto", shopDto);
				dispatch("Shop/shopupdateform.jsp", request, response);

			}else if(command.equals("flex")) {
				int shop_seq = Integer.parseInt(request.getParameter("shop_seq"));
				int opt = Integer.parseInt(request.getParameter("opt"));
				
				ShopDto shopDto = biz.selectShopOne(shop_seq);
				
				request.setAttribute("opt", opt);
				request.setAttribute("shopDto", shopDto);
				
				
				dispatch("Shop/shopflex.jsp", request, response);
			}else if(command.equals("buylistres")) {
				int shop_seq = Integer.parseInt(request.getParameter("shop_seq"));
				int opt = Integer.parseInt(request.getParameter("opt"));
				int res = biz1.updateOrderList(shop_seq, opt);
				if(res>0) {
					OrderDto orderDto = new OrderDto();
					MemberDto memberDto = (MemberDto) session.getAttribute("memberDto");
					orderDto.setShop_seq(shop_seq);
					orderDto.setMember_id(memberDto.getMember_id());
					orderDto.setOrder_stuff(request.getParameter("shop_name"));
					orderDto.setOrder_content(request.getParameter("shop_content"));
					orderDto.setOrder_count(opt);
					orderDto.setOrder_buymoney(Integer.parseInt(request.getParameter("order_buymoney")));
					
					int ui = biz1.insertOrderList(orderDto);

						if(ui > 0){
						
						dispatch("main.jsp", request, response);
						
					}
				}
			}else if(command.equals("buylistform")) {
				List<OrderDto> orderList = biz1.selectOrderList();
				request.setAttribute("orderList", orderList);
				
				dispatch("Shop/buylist.jsp", request, response);
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
