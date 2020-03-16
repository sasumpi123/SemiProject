package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.biz.ShopBiz;
import com.shop.biz.ShopBizImpl;
import com.shop.dto.ShopDto;


@WebServlet("/shopinsert.do")
public class ShopInsertController extends HttpServlet {
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
	
        String  uploadDir = "C:\\Git_MyAnimals_branch\\MyAnimals\\WebContent\\image\\ShopImg";
        int maxSize = 1024 * 1024 * 100;
        String encoding = "UTF-8";
        MultipartRequest multipartRequest = new MultipartRequest(request, uploadDir, maxSize, encoding,
	               new DefaultFileRenamePolicy());
        
		ShopBiz biz = new ShopBizImpl();
		String command = multipartRequest.getParameter("command");
		
		if (command.equals("insertres")) {
			ShopDto shopDto = new ShopDto();
			MemberDto memberDto = (MemberDto)session.getAttribute("memberDto");
			shopDto.setShop_name(multipartRequest.getParameter("shop_name"));  
			shopDto.setShop_kind(multipartRequest.getParameter("shop_kind"));
			shopDto.setShop_price(Integer.parseInt(multipartRequest.getParameter("shop_price")));
			shopDto.setShop_quantity(Integer.parseInt(multipartRequest.getParameter("shop_quantity")));
			shopDto.setShop_content(multipartRequest.getParameter("shop_content")); 
			shopDto.setShop_owner(memberDto.getMember_id());
			
			String food_image_realname = "";
			if(multipartRequest.getFilesystemName("file")!=null) {
				food_image_realname = multipartRequest.getFilesystemName("file"); 
		        shopDto.setShop_photo("/MyAnimals/image/ShopImg/"+food_image_realname);
			}else {
				shopDto.setShop_photo("not");
			}
	        
	        
		    int res = biz.insertShopList(shopDto);
		    if(res>0) {
		    	jsResponse("물품을 등록하였습니다","shop.do?command=selectList", response);
		    }else {
		    	jsResponse("물품 등록에 실패하였습니다", "Shop/shopinsertform.jsp", response);
		    }
		}else if(command.equals("updateres")) {
			int shop_seq = Integer.parseInt(multipartRequest.getParameter("shop_seq"));
			ShopDto shopDto = new ShopDto();
			shopDto.setShop_name(multipartRequest.getParameter("shop_name"));  
			shopDto.setShop_kind(multipartRequest.getParameter("shop_kind"));
			shopDto.setShop_price(Integer.parseInt(multipartRequest.getParameter("shop_price")));
			shopDto.setShop_quantity(Integer.parseInt(multipartRequest.getParameter("shop_quantity")));
			shopDto.setShop_content(multipartRequest.getParameter("shop_content")); 
			shopDto.setShop_seq(shop_seq);
			
		    
			String food_image_realname = "";
			if(multipartRequest.getFilesystemName("file")!=null) {
				food_image_realname = multipartRequest.getFilesystemName("file"); 
		        shopDto.setShop_photo("/MyAnimals/image/ShopImg/"+food_image_realname);
			}else {
				shopDto.setShop_photo("not");
			}
	        
		    int res = biz.updateShopList(shopDto);
		    if(res>0) {
		    	jsResponse("물품수정을 성공하였습니다","shop.do?command=selectList", response);
		    }else {
		    	jsResponse("물품수정에 실패하였습니다", "shop.do?command=update&shop_seq="+shop_seq, response);
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
