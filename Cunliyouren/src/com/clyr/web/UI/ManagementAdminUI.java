package com.clyr.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clyr.domain.Admin;
import com.clyr.service.IAdminService;
import com.clyr.service.impl.AdminService;

public class ManagementAdminUI extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManagementAdminUI() {
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
		Cookie[] c = request.getCookies();
		String username = null;
		String password = null;
		if (c != null) {
			for (int i = 0; i < c.length; i++) {
				if ("username".equals(c[i].getName())) {
					username = c[i].getValue();
				}
				if ("password".equals(c[i].getName())) {
					password = c[i].getValue();
				}
			}
			if (username != null && password != null) {
				IAdminService service = new AdminService();
				Admin admin = service.loginAdmin(username, password);
				if (admin != null)
					request.getRequestDispatcher(
							"/WEB-INF/pages/ManagementAdmin.jsp").forward(
							request, response);
				else
					request.getRequestDispatcher(
							"/WEB-INF/pages/ManagementLogin.jsp").forward(
							request, response);
			}
		} else
			request.getRequestDispatcher("/WEB-INF/pages/ManagementLogin.jsp")
					.forward(request, response);
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

		doGet(request, response);
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
