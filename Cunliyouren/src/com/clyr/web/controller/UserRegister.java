package com.clyr.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.clyr.domain.U_AccessToken;
import com.clyr.domain.User;
import com.clyr.service.IUserService;
import com.clyr.service.impl.UserService;
import com.clyr.utils.AMapUtils;

public class UserRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserRegister() {
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
		String err="本项必填";	
		if((request.getParameter("homeAddressCity").equals("") || 
				request.getParameter("homeAddressRoad").equals("") ||
				request.getParameter("homeAddressNum").equals("")) &&
				!(request.getParameter("homeAddressCity")+ request.getParameter("homeAddressRoad")+request.getParameter("homeAddressNum")).equals(""))
		{
			err="请完整填写目前常住地点";
			request.setAttribute("accessToken", request.getParameter("accessToken"));
			HashMap<String, String> m=new HashMap<String, String>();
			m.put("nickname", request.getParameter("nickName"));
			m.put("openid", request.getParameter("openId"));
			m.put("headimgurl", request.getParameter("headImgUrl"));
			JSONObject j=JSONObject.fromObject(m);
			request.setAttribute("userInfo",j );
			request.setAttribute("err", err);
			request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
		}
		else if((request.getParameter("workingAddressCity").equals("") || 
	    		request.getParameter("workingAddressRoad").equals("") ||
	    		request.getParameter("workingAddressNum").equals("")) &&
	    		!(request.getParameter("workingAddressCity")+ 
	    		request.getParameter("workingAddressRoad")+
	    		request.getParameter("workingAddressNum")).equals(""))
	    {
			err="请完整填写目前工作地点";
	    	HashMap<String, String> m=new HashMap<String, String>();
			m.put("nickname", request.getParameter("nickName"));
			m.put("openid", request.getParameter("openId"));
			m.put("headimgurl", request.getParameter("headImgUrl"));
			JSONObject j=JSONObject.fromObject(m);
			request.setAttribute("userInfo",j );
	    	request.setAttribute("err", err);
	    	request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
	    }
		else if((request.getParameter("province").equals("") || 
	    		request.getParameter("city").equals("") ||
	    		request.getParameter("country").equals("")) &&
	    		!(request.getParameter("province")+ 
	    		request.getParameter("city")+
	    		request.getParameter("country")).equals(""))
	    {
			err="请完整填写您的家乡";
	    	HashMap<String, String> m=new HashMap<String, String>();
			m.put("nickname", request.getParameter("nickName"));
			m.put("openid", request.getParameter("openId"));
			m.put("headimgurl", request.getParameter("headImgUrl"));
			JSONObject j=JSONObject.fromObject(m);
			request.setAttribute("userInfo",j );
	    	request.setAttribute("err", err);
	    	request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
	    }
		else if(request.getParameter("telNum").equals(""))
	    {
			err="请填写您的手机号码";
	    	HashMap<String, String> m=new HashMap<String, String>();
			m.put("nickname", request.getParameter("nickName"));
			m.put("openid", request.getParameter("openId"));
			m.put("headimgurl", request.getParameter("headImgUrl"));
			JSONObject j=JSONObject.fromObject(m);
			request.setAttribute("userInfo",j );
	    	request.setAttribute("err", err);
	    	request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
	    }
		else{
			User u=new User();
			u.setAccessToken(request.getParameter("accessToken"));
			u.setOpenId(request.getParameter("openId"));
			u.setNickName(request.getParameter("nickName"));
			u.setTelNum(request.getParameter("telNum"));
			u.setHeadImgUrl(request.getParameter("headImgUrl"));
			String province=request.getParameter("province");
			if(province==null)
				province="-";
			String city=request.getParameter("city");
			if(city==null)
				city="-";
			String country=request.getParameter("country");
			if(country==null)
				country="-";
			u.setHomeTown(province+" "+city+" "+country);
			u.setHighSchool(request.getParameter("highSchool"));
			u.setUniversity(request.getParameter("university"));
			String key1=request.getParameter("homeAddressCity")+" "+request.getParameter("homeAddressRoad")+"路 "+request.getParameter("homeAddressNum");
			String homeAddressCity=request.getParameter("homeAddressCity");
			if(homeAddressCity.equals(""))
				homeAddressCity="-";
			String homeAddressRoad=request.getParameter("homeAddressRoad");
			if(homeAddressRoad.equals(""))
				homeAddressRoad="-";
			String homeAddressNum=request.getParameter("homeAddressNum");
			if(homeAddressNum.equals(""))
				homeAddressNum="-";
			u.setHomeAddress(homeAddressCity+" "+homeAddressRoad+" "+homeAddressNum);
			String key2=request.getParameter("workingAddressCity")+" "+request.getParameter("workingAddressRoad")+"路 "+request.getParameter("workingAddressNum");
			String workingAddressCity=request.getParameter("workingAddressCity");
			if(workingAddressCity.equals(""))
				workingAddressCity="-";
			String workingAddressRoad=request.getParameter("workingAddressRoad");
			if(workingAddressRoad.equals(""))
				workingAddressRoad="-";
			String workingAddressNum=request.getParameter("workingAddressNum");
			if(workingAddressNum.equals(""))
				workingAddressNum="-";
			u.setWorkingAddress(workingAddressCity+" "+workingAddressRoad+" "+workingAddressNum);
			JSONObject jhaDD=AMapUtils.getPosition(key1);
			JSONObject jwaDD=AMapUtils.getPosition(key2);
			if(jhaDD.getString("info").equals("OK"))
				if(!jhaDD.getString("count").equals("0"))
					u.setHomeAddressLocation(jhaDD.getJSONArray("pois").getJSONObject(0).getString("location"));
			if(jwaDD.getString("info").equals("OK"))
				if(!jwaDD.getString("count").equals("0"))
					u.setWorkingAddressLocation(jwaDD.getJSONArray("pois").getJSONObject(0).getString("location"));
			IUserService service=new UserService();
			service.register(u);
			request.setAttribute("openId", u.getOpenId());
			request.getRequestDispatcher("/WEB-INF/pages/Main.jsp").forward(request, response);
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
