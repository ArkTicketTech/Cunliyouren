package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.U_AccessToken;
import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.WechatUtils;

public class Redirect2Web extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Redirect2Web() {
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
		U_AccessToken token=WechatUtils.getUAccessToken(request.getParameter("code"));
		IUserService userv=new UserService();
		User u=userv.searchByOpenId(token.getOpenId());
		if(u.getuId()!=0)
		{
			if(WechatUtils.validate(u.getAccessToken(), u.getOpenId()).getString("errmsg").equals("ok"))
			{
				request.setAttribute("openId", token.getOpenId());
				request.getRequestDispatcher(request.getParameter("state")+"UI").forward(request,response);
			}
			else
			{
				response.sendRedirect(WechatUtils.getALLUrl("Login"));
			}
		}
		else
		{
			response.sendRedirect(WechatUtils.getALLUrl("Login"));
		}
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
