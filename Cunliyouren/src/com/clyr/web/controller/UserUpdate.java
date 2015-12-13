package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.AMapUtils;

public class UserUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserUpdate() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		IUserService service=new UserService();
		User u=service.searchByOpenId(request.getParameter("openId"));
		System.out.println(request.getParameter("openId"));
		System.out.println(u.getNickName());
		u.setAccessToken(request.getParameter("accessToken"));
		u.setNickName(request.getParameter("nickName"));
		u.setHeadImgUrl(request.getParameter("headImgUrl"));
		String province=request.getParameter("province");
		if(province==null)
			province="-";
		String city=request.getParameter("city");
		if(city==null)
			city="-";
		String country=request.getParameter("country");
		if(country==null)
			country="-";
		u.setHomeTown(province+" "+city+" "+country);
		u.setHighSchool(request.getParameter("highSchool"));
		u.setUniversity(request.getParameter("university"));
		u.setHomeAddress(request.getParameter("homeAddressCity")+" "+request.getParameter("homeAddressRoad")+" "+request.getParameter("homeAddressNum"));
		u.setWorkingAddress(request.getParameter("workingAddressCity")+" "+request.getParameter("workingAddressRoad")+" "+request.getParameter("workingAddressNum"));
		JSONObject jhaDD=AMapUtils.getPosition(u.getHomeAddress());
		JSONObject jwaDD=AMapUtils.getPosition(u.getWorkingAddress());
		if(jhaDD.getString("info").equals("OK"))
			if(!jhaDD.getString("count").equals("0"))
				u.setHomeAddressLocation(jhaDD.getJSONArray("pois").getJSONObject(0).getString("location"));
		if(jwaDD.getString("info").equals("OK"))
			if(!jwaDD.getString("count").equals("0"))
				u.setWorkingAddressLocation(jwaDD.getJSONArray("pois").getJSONObject(0).getString("location"));
		service.update(u);
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
