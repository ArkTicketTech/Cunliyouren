package com.clyr.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IProductService;
import com.clyr.service.IUserService;
import com.clyr.service.impl.ProductService;
import com.clyr.service.impl.UserService;

public class ProDetailUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProDetailUI() {
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
		int pId=Integer.parseInt(request.getParameter("pId"));
		IProductService service=new ProductService();
		Product p=new Product();
		p=service.searchByPId(pId);
		IUserService userv=new UserService();
		User u=userv.searchByUId(p.getOwnerId());
		String openId=request.getParameter("openId");
		JSONObject jp=JSONObject.fromObject(p);
		JSONObject ju=JSONObject.fromObject(u);
		request.setAttribute("product", jp);
		request.setAttribute("seller", ju);
		request.setAttribute("openId", openId);
		request.getRequestDispatcher("/WEB-INF/pages/ProDetail.jsp").forward(request, response);
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
