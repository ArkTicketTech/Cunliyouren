package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.AMapUtils;

public class UserRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserRegister() {
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

		User u=new User();
		u.setAccessToken(request.getParameter("accessToken"));
		u.setOpenId(request.getParameter("openId"));
		u.setNickName(request.getParameter("nickName"));
		u.setTelNum(request.getParameter("telNum"));
		u.setHeadImgUrl(request.getParameter("headImgUrl"));
		u.setHomeTown(request.getParameter("province")+request.getParameter("city")+request.getParameter("district"));
		u.setHighSchool(request.getParameter("highSchool"));
		u.setUniversity(request.getParameter("university"));
		u.setHomeAddress(request.getParameter("homeAddressCity")+request.getParameter("homeAddressRoad")+request.getParameter("homeAddressNum"));
		u.setWorkingAddress(request.getParameter("workingAddressCity")+request.getParameter("workingAddressRoad")+request.getParameter("workingAddressNum"));
		u.setHomeAddressLocation(AMapUtils.getPosition(u.getHomeAddress()).getJSONArray("pois").getJSONObject(0).getString("location"));
		u.setWorkingAddressLocation(AMapUtils.getPosition(u.getWorkingAddress()).getJSONArray("pois").getJSONObject(0).getString("location"));
		IUserService service=new UserService();
		service.register(u);
		request.setAttribute("openId", u.getOpenId());
		request.getRequestDispatcher("/WEB-INF/pages/Main.jsp").forward(request, response);
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
