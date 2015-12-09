package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.Order;
import com.clyr.domain.User;
import com.clyr.service.IOrderService;
import com.clyr.service.IUserService;
import com.clyr.service.impl.OrderService;
import com.clyr.service.impl.UserService;

public class CreateOrder extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CreateOrder() {
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
		Order o=new Order();
		IUserService userv=new UserService();
		IOrderService oserv=new OrderService();
		String openId=request.getParameter("openId");
		User u=userv.searchByOpenId(openId);
		o.setSellerId(u.getuId());
		o.setBuyerId(Integer.parseInt(request.getParameter("sellerId")));
		o.setProductId(Integer.parseInt(request.getParameter("productId")));
		o.setPruductNumber(Integer.parseInt(request.getParameter("pruductNumber")));
		oserv.createOrder(o);
		request.setAttribute("penId", openId);
		request.getRequestDispatcher("/WEB-INF/pages/LoginUI").forward(request, response);
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
