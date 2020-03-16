package com.member.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class NaverServlet
 */
@WebServlet("/naver.do")
public class NaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			System.out.println("NaverServlet 도착");

		
		    String clientId = "YCcGSt6BfvkHKq2CsQHK";//애플리케이션 클라이언트 아이디값";
		    String clientSecret = "35rph2VEQ1";//애플리케이션 클라이언트 시크릿값";
		    String code = request.getParameter("code");
		    String state = request.getParameter("state");
		    String redirectURI = URLEncoder.encode("/member.do?command=registselectres", "UTF-8");
		    String apiURL;
		    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		    apiURL += "client_id=" + clientId;
		    apiURL += "&client_secret=" + clientSecret;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&code=" + code;
		    apiURL += "&state=" + state;
		    String access_token = "";
		    String refresh_token = "";
		    System.out.println("apiURL="+apiURL);
		    String id = "";
		    String email = "";
		    String name= "";
		    String birthday = "";
		    
		    try {
		      URL url = new URL(apiURL);
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { // 정상 호출
		        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		      } else {  // 에러 발생
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		    		res.append(inputLine);
		    	}
		    	 br.close();
		    	if(responseCode==200) {
		    		System.out.println(res.toString());
		    		JSONParser parsing = new JSONParser();
		    		Object obj = parsing.parse(res.toString());
		    		JSONObject jsonObj = (JSONObject)obj;
		    			        
		    		access_token = (String)jsonObj.get("access_token");
		    		refresh_token = (String)jsonObj.get("refresh_token");
		    	}
		      br.close();
		      if(responseCode==200) {
		        out.println(res.toString());
		        String token = access_token;// 네이버 로그인 접근 토큰;
		        String header = "Bearer " + token; // Bearer 다음에 공백 추가
		        try {
		            String apiURL1 = "https://openapi.naver.com/v1/nid/me";
		            URL url1 = new URL(apiURL1);
		            HttpURLConnection con1 = (HttpURLConnection)url1.openConnection();
		            con1.setRequestMethod("GET");
		            con1.setRequestProperty("Authorization", header);
		            int responseCode1 = con1.getResponseCode();
		            BufferedReader br1;
		            if(responseCode1==200) { // 정상 호출
		                br1 = new BufferedReader(new InputStreamReader(con1.getInputStream()));
		            } else {  // 에러 발생
		                br1 = new BufferedReader(new InputStreamReader(con1.getErrorStream()));
		            }
		            String inputLine1;
		            StringBuffer response1 = new StringBuffer();
		            while ((inputLine1 = br1.readLine()) != null) {
		                response1.append(inputLine1);
		            }
		            br1.close();
		            System.out.println(response1.toString());
		            JSONParser parsing = new JSONParser();
		    		Object obj = parsing.parse(response1.toString());
		    		JSONObject jsonObj1 = (JSONObject)obj;
		    		JSONObject jsonObj = (JSONObject)jsonObj1.get("response");
		    		System.out.println(jsonObj.toString());
		    		
		    		id = (String)jsonObj.get("id");
		    		email = (String)jsonObj.get("email");
		    		name = (String)jsonObj.get("name");
		    		birthday = (String)jsonObj.get("birthday");
		    		
		    		System.out.printf("%s, %s, %s, %s \n", id, email, name, birthday);
		    		
		    		
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		      }
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		    request.setAttribute("name", name);
		    request.setAttribute("email", email);
		    dispatch("/member.do?command=registselectres", request, response);
		    
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doGet(request, response);
	}

}
