package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.Admin;
import com.clyr.service.IAdminService;
import com.clyr.service.impl.AdminService;
import com.clyr.utils.WebUtils;
import com.clyr.web.formbean.LoginFormBean;

public class AdminLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminLoginServlet() {
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
		//将客户端提交的表单数据封装到LoginFormBean对象中
        LoginFormBean formbean = WebUtils.request2Bean(request,LoginFormBean.class);
        //校验用户注册填写的表单数据
        if (formbean.validate() == false) {//如果校验失败
        	request.setAttribute("formbean", formbean);
        	request.getRequestDispatcher("/ManagementLogin.jsp").forward(request, response);
        	return;
        }
		//获取用户填写的登录用户名
		String username = request.getParameter("username");
		//获取用户填写的登录密码
		String password = request.getParameter("password");
		
		IAdminService service=new AdminService();
		
		Admin admin=service.loginAdmin(username, password);
		
		if(admin==null) 
		{
			request.setAttribute("state", "用户名或密码不正确");
			request.getRequestDispatcher("/ManagementLogin.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("admin", admin);
		request.getRequestDispatcher("/WEB-INF/pages/ManagementProduct.jsp").forward(request, response);
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

		doGet(request, response);
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
