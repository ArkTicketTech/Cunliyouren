package com.clyr.web.UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.clyr.domain.Order;
import com.clyr.domain.Product;
import com.clyr.domain.U_AccessToken;
import com.clyr.domain.User;
import com.clyr.service.IOrderService;
import com.clyr.service.IProductService;
import com.clyr.service.IUserService;
import com.clyr.service.impl.OrderService;
import com.clyr.service.impl.ProductService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.SignUtil;
import com.clyr.utils.WechatUtils;

public class MyShopUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MyShopUI() {
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
		String 	openId=request.getParameter("openId");
		String message=request.getParameter("message");
		System.out.println(openId);
		IUserService uservice=new UserService();
		IProductService pservice=new ProductService();
		User u=uservice.searchByOpenId(openId);
		System.out.println(u.getNickName());
		ArrayList<Product> a_p=pservice.myProduct(u.getuId());
		JSONArray ja=JSONArray.fromObject(a_p);
		
		long timestamp = SignUtil.create_timestamp();
		String nonceStr = SignUtil.create_nonce_str();
        StringBuffer requestUrl = request.getRequestURL();
        String queryString = request.getQueryString();
        String url = requestUrl +"?"+queryString;
		try {
			String signature = SignUtil.getSignature(WechatUtils.getTicket(), nonceStr, timestamp, url);
			request.setAttribute("timestamp", timestamp);
			request.setAttribute("nonceStr", nonceStr);
			request.setAttribute("signature", signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("myProduct", ja);
		request.setAttribute("openId", openId);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/pages/MyShop.jsp").forward(request, response);
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
