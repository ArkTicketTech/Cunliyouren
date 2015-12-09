package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.clyr.domain.Order;
import com.clyr.domain.Product;
import com.clyr.domain.RelationBean;
import com.clyr.domain.User;
import com.clyr.service.IOrderService;
import com.clyr.service.IProductService;
import com.clyr.service.IUserService;
import com.clyr.service.impl.OrderService;
import com.clyr.service.impl.ProductService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.AMapUtils;

public class ProductSearch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductSearch() {
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
		String openId=request.getParameter("openId");
		IUserService userv=new UserService();
		User u=userv.searchByOpenId(openId);
		IProductService service=new ProductService();
		ArrayList<Product> a=new ArrayList<Product>();
		a=service.searchByProductName(request.getParameter("productName"));
		a=service.addConstraint(a, request.getParameter("hometown"), u);
		a=service.addConstraint(a, request.getParameter("school"), u);
		a=service.addConstraint(a, request.getParameter("workAdd"), u);
		a=service.addConstraint(a, request.getParameter("homeAdd"), u);
		JSONArray result=JSONArray.fromObject(a);
		ArrayList<RelationBean> a_r=new ArrayList<RelationBean>();
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<a.size();i++)
		{
			User temp=new User();
			RelationBean rb=new RelationBean();
			temp=userv.searchByUId(a.get(i).getOwnerId());
			rb.setFriendName(temp.getNickName());
			if(temp.getHomeTown().equals(u.getHomeTown()))
				rb.setHometown(1);
			if(temp.getHighSchool().equals(u.getHighSchool()) || 
					temp.getUniversity().equals(u.getUniversity()))
				rb.setSchool(1);
			if(AMapUtils.Distance(temp.getHomeAddressLocation(), u.getHomeAddressLocation())<3000)
				rb.setHomeAdd(1);
			if(AMapUtils.Distance(temp.getWorkingAddressLocation(), u.getWorkingAddressLocation())<3000)
				rb.setWorkAdd(1);
			a_r.add(rb);
		}
		JSONArray relation=JSONArray.fromObject(a_r);
		String r=joinJSONArray(result,relation);
		JSONArray ja=JSONArray.fromObject(r);
		request.setAttribute("result", ja);
		request.setAttribute("openId", openId);
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
	/**
     * 返回两个JsonArray的合并后的字符串
     * @param mData
     * @param array
     * @return
     */
    public String joinJSONArray(JSONArray mData, JSONArray array) {
        StringBuffer buffer = new StringBuffer();
        try {
          int len = mData.size();
          for (int i = 0; i < len; i++) {
            JSONObject obj1 = (JSONObject) mData.get(i);
            JSONObject obj2 = (JSONObject) array.get(i);
            if (i == len - 1)
            {
            	String str=obj2.toString().substring(1);
            	buffer.append(obj1.toString()).deleteCharAt(buffer.length()-1).append(",").append(str);
            }
            else
            {
            	String str=obj2.toString().substring(1);
            	buffer.append(obj1.toString()).deleteCharAt(buffer.length()-1).append(",").append(str).append(",");
            }
          }
          buffer.insert(0, "[").append("]");
          return buffer.toString();
        } catch (Exception e) {
        }
        return null;
      }

}
