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
		//���ͻ����ύ�ı����ݷ�װ��LoginFormBean������
        LoginFormBean formbean = WebUtils.request2Bean(request,LoginFormBean.class);
        //У���û�ע����д�ı�����
        if (formbean.validate() == false) {//���У��ʧ��
        	request.setAttribute("formbean", formbean);
        	request.getRequestDispatcher("/ManagementLogin.jsp").forward(request, response);
        	return;
        }
		//��ȡ�û���д�ĵ�¼�û���
		String username = request.getParameter("username");
		//��ȡ�û���д�ĵ�¼����
		String password = request.getParameter("password");
		
		IAdminService service=new AdminService();
		
		Admin admin=service.loginAdmin(username, password);
		
		if(admin==null) 
		{
			request.setAttribute("state", "�û��������벻��ȷ");
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
