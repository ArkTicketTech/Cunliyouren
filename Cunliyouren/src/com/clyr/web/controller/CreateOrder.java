package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.Order;
import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IOrderService;
import com.clyr.service.IProductService;
import com.clyr.service.IUserService;
import com.clyr.service.impl.OrderService;
import com.clyr.service.impl.ProductService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.WechatUtils;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Order o=new Order();
		IUserService userv=new UserService();
		IOrderService oserv=new OrderService();
		String openId=request.getParameter("openId");
		if(openId==null)
			response.sendRedirect("http://cunliyouren.cn/Cunliyouren/Wechat2Redirect&redi=Main");
		else if(openId.equals(""))
			response.sendRedirect("http://cunliyouren.cn/Cunliyouren/Wechat2Redirect&redi=Main");
		User u=userv.searchByOpenId(openId);
		o.setSellerId(Integer.parseInt(request.getParameter("sellerId")));
		o.setBuyerId(u.getuId());
		if(o.getBuyerId()==o.getSellerId())
		{
			String result="下单失败，不能对自己的商品下单";
			request.setAttribute("result", result);
			request.setAttribute("openId", openId);
			request.getRequestDispatcher("ProDetailUI?pId="+o.getProductId()).forward(request, response);
		}
		else
		{
			o.setProductId(Integer.parseInt(request.getParameter("productId")));
			o.setPruductNumber(Integer.parseInt(request.getParameter("pruductNumber")));
			oserv.createOrder(o);
			String result="下单成功";
			request.setAttribute("result", result);
			request.setAttribute("openId", openId);
			request.getRequestDispatcher("ProDetailUI?pId="+o.getProductId()).forward(request, response);
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
