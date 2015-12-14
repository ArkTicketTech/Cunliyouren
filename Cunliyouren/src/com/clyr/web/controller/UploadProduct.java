package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.Product;
import com.clyr.domain.User;
import com.clyr.service.IProductService;
import com.clyr.service.impl.ProductService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.SignUtil;
import com.clyr.utils.WechatUtils;

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
		IProductService service=new ProductService();
		String picurl1="";
		String picurl2="";
		String picurl3="";
		String message="";
		if(request.getParameter("productName")==null)
		{
			message="上传失败，请确保填写产品名";
		}
		else if(request.getParameter("productName").equals(""))
		{
			message="上传失败，请确保填写产品名";
		}
		else if(request.getParameter("pId").equals("")){
			Product p=new Product();
			User u=new User();
			UserService userv=new UserService();
			u=userv.searchByOpenId(request.getParameter("openId"));
			p.setOwnerId(u.getuId());
			p.setProductName(request.getParameter("productName"));
			p.setPrice(Double.valueOf(request.getParameter("price")));
			p.setUnit(request.getParameter("unit"));
			p.setDescription(request.getParameter("description"));
			WechatUtils.downloadMedia(request.getParameter("picture1"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			WechatUtils.downloadMedia(request.getParameter("picture2"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			WechatUtils.downloadMedia(request.getParameter("picture3"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			if(request.getParameter("picture1")!=null && !request.getParameter("picture1").equals("Resource/addOpe.png") && !request.getParameter("picture1").equals(""))
				picurl1="Resource/ProImg/"+request.getParameter("picture1")+".jpeg";
			else
				picurl1="Resource/addOpe.png";
			if(request.getParameter("picture2")!=null && !request.getParameter("picture2").equals("Resource/addOpe.png") && !request.getParameter("picture1").equals(""))
				picurl2="Resource/ProImg/"+request.getParameter("picture2")+".jpeg";
			else
				picurl2="Resource/addOpe.png";
			if(request.getParameter("picture3")!=null && !request.getParameter("picture3").equals("Resource/addOpe.png") && !request.getParameter("picture1").equals(""))
				picurl3="Resource/ProImg/"+request.getParameter("picture3")+".jpeg";
			else
				picurl3="Resource/addOpe.png";
			p.setPicture1(picurl1);
			p.setPicture2(picurl2);
			p.setPicture3(picurl3);
			p.setDeliveryPoint(request.getParameter("deliveryPoint"));
			System.out.println(p);
			service.uploadProduct(p);
			message= "上传产品成功";
		}
		else
		{
			Product p=service.searchByPId(Integer.parseInt(request.getParameter("pId")));
			p.setProductName(request.getParameter("productName")+"");
			p.setPrice(Double.valueOf(request.getParameter("price")));
			p.setUnit(request.getParameter("unit")+"");
			System.out.println(request.getParameter("deliveryPoint"));
			p.setDescription(request.getParameter("description")+"");
			WechatUtils.downloadMedia(request.getParameter("picture1"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			WechatUtils.downloadMedia(request.getParameter("picture2"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			WechatUtils.downloadMedia(request.getParameter("picture3"), request.getSession().getServletContext().getRealPath("/Resource/ProImg"));
			if(request.getParameter("picture1")!=null && !request.getParameter("picture1").equals("Resource/addOpe.png") && !request.getParameter("picture1").equals(""))
			{
				picurl1="Resource/ProImg/"+request.getParameter("picture1")+".jpeg";
				p.setPicture1(picurl1);
			}
			else if(request.getParameter("picture1").equals("Resource/addOpe.png"))
				p.setPicture1(picurl1);
			if(request.getParameter("picture2")!=null && !request.getParameter("picture2").equals("Resource/addOpe.png") && !request.getParameter("picture2").equals(""))
			{
				picurl2="Resource/ProImg/"+request.getParameter("picture2")+".jpeg";
				p.setPicture2(picurl2);
			}
			else if(request.getParameter("picture2").equals("Resource/addOpe.png"))
				p.setPicture2(picurl2);
			if(request.getParameter("picture3")!=null && !request.getParameter("picture3").equals("Resource/addOpe.png") && !request.getParameter("picture3").equals(""))
			{
				picurl3="Resource/ProImg/"+request.getParameter("picture3")+".jpeg";
				p.setPicture3(picurl3);
			}
			else if(request.getParameter("picture3").equals("Resource/addOpe.png"))
				p.setPicture3(picurl3);
			p.setDeliveryPoint(request.getParameter("deliveryPoint")+"");
			service.updateProduct(p);
			message="更新产品成功";
		}
		message=URLEncoder.encode(message,"UTF-8");
		response.sendRedirect("MyShopUI?openId="+request.getParameter("openId")+"&message="+message);
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
