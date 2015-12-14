package com.clyr.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.U_AccessToken;
import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.WechatUtils;

public class PersonalCenterUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PersonalCenterUI() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		IUserService uservice=new UserService();
		String openId=request.getParameter("openId");
		User u=uservice.searchByOpenId(openId);
		JSONObject ja=WechatUtils.getUserInfo(u.getAccessToken(), u.getOpenId());
		JSONObject ju=JSONObject.fromObject(u);
		if(!u.getHomeTown().equals(""))
		{
			String[] str=(u.getHomeTown()).split(" ");
			if(str[0].equals("-"))
				str[0]="";
			if(str[1].equals("-"))
				str[1]="";
			if(str[2].equals("-"))
				str[2]="";
			request.setAttribute("province", str[0]);
			request.setAttribute("city", str[1]);
			request.setAttribute("country", str[2]);
		}
		if(!u.getHomeAddress().equals(""))
		{
			String[] str1=(u.getHomeAddress()).split(" ");
			if(str1[0].equals("-"))
				str1[0]="";
			if(str1[1].equals("-"))
				str1[1]="";
			if(str1[2].equals("-"))
				str1[2]="";
			request.setAttribute("homeAddressCity", str1[0]);
			request.setAttribute("homeAddressRoad", str1[1]);
			request.setAttribute("homeAddressNum", str1[2]);
		}
		if(!u.getWorkingAddress().equals(""))
		{
			String[] str2=(u.getWorkingAddress()).split(" ");
			if(str2[0].equals("-"))
				str2[0]="";
			if(str2[1].equals("-"))
				str2[1]="";
			if(str2[2].equals("-"))
				str2[2]="";
			request.setAttribute("workingAddressCity", str2[0]);
			request.setAttribute("workingAddressRoad", str2[1]);
			request.setAttribute("workingAddressNum", str2[2]);
		}
		request.setAttribute("accessToken", u.getAccessToken());
		request.setAttribute("userInfo", ja);
		request.setAttribute("user", ju);
		request.setAttribute("openId", openId);
		request.getRequestDispatcher("/WEB-INF/pages/PersonalCenter.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
