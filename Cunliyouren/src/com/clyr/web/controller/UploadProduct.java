package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.Product;
import com.clyr.service.IProductService;
import com.clyr.service.impl.ProductService;

public class UploadProduct extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadProduct() {
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
		Product p=new Product();
		IProductService service=new ProductService();
		if(request.getParameter("pId").equals("")){
			p.setOwnerId(Integer.parseInt(request.getParameter("uId")));
			p.setProductName(request.getParameter("productName"));
			p.setPrice(Double.valueOf(request.getParameter("price")));
			p.setUnit(request.getParameter("unit"));
			p.setDescription(request.getParameter("description"));
			p.setPicture1(request.getParameter("picture1"));
			p.setPicture2(request.getParameter("picture2"));
			p.setPicture3(request.getParameter("picture3"));
			p.setDeliveryPoint(request.getParameter("deliveryPoint"));
			service.uploadProduct(p);
		}
		else
		{
			p.setpId(Integer.parseInt(request.getParameter("pId")));
			p.setProductName(request.getParameter("productName"));
			p.setPrice(Double.valueOf(request.getParameter("price")));
			p.setUnit(request.getParameter("unit"));
			p.setDescription(request.getParameter("description"));
			p.setPicture1(request.getParameter("picture1"));
			p.setPicture2(request.getParameter("picture2"));
			p.setPicture3(request.getParameter("picture3"));
			p.setDeliveryPoint(request.getParameter("deliveryPoint"));
			service.updateProduct(p);
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
