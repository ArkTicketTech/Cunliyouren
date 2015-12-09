package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.U_AccessToken;
import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.WechatUtils;

public class UserLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLogin() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accessToken=request.getParameter("accessToken");
		String openId=request.getParameter("openId");
		IUserService service=new UserService();
		User u=service.searchByOpenId(openId);
		System.out.println(accessToken);
		System.out.println(openId);
		if(u.getuId()!=0)
		{
			u.setAccessToken(accessToken);
			service.update(u);
			request.setAttribute("openId", u.getOpenId());
			request.getRequestDispatcher("/WEB-INF/pages/Main.jsp").forward(request,response);
		}
		else
		{
			JSONObject ja=WechatUtils.getUserInfo(accessToken, openId);
			request.setAttribute("userInfo", ja);
			request.setAttribute("accessToken", accessToken);
			request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request,response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
