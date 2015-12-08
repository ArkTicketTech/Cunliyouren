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

public class LoginUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginUI() {
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
		JSONObject token=(JSONObject) request.getAttribute("token");
		IUserService uservice=new UserService();
		User u=uservice.searchByOpenId(token.getString("openId"));
		JSONObject ja=JSONObject.fromObject(token);
		if(u==null)
		{
			JSONObject j_info=WechatUtils.getUserInfo(token.getString("access_token"), token.getString("openId"));
			request.setAttribute("token", ja);
			request.setAttribute("headUrl", j_info.getString("headimgurl"));
		}
		else
		{
			request.setAttribute("token", ja);
			request.setAttribute("headUrl", u.getHeadImgUrl());
		}
		request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
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

		doGet(request, response);
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
