package com.clyr.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.clyr.domain.U_AccessToken;

import net.sf.json.JSONObject;

public class WechatUtils {
	private static String APPID;
	private static String APPSECRET;
	private static String CODE_URL;
	private static String U_ACCESS_TOKEN_URL;
	private static String REDIRECT_URI_BASE;
	private static String REDIRECT_URI_ALL;
	private static String GET_USER_INFO_URL;
	private static String VALIDATE_URL;
	static {
		Properties pro = new Properties();
		try {
			pro.load(WechatUtils.class.getResourceAsStream("Wechat.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		APPID=pro.getProperty("APPID");
		APPSECRET=pro.getProperty("APPSECRET");
		CODE_URL=pro.getProperty("CODE_URL");
		U_ACCESS_TOKEN_URL=pro.getProperty("U_ACCESS_TOKEN_URL");
		REDIRECT_URI_BASE=pro.getProperty("REDIRECT_URI_BASE");
		REDIRECT_URI_ALL=pro.getProperty("REDIRECT_URI_ALL");
		GET_USER_INFO_URL=pro.getProperty("GET_USER_INFO_URL");
		VALIDATE_URL=pro.getProperty("VALIDATE_URL");
	}
	
	public static JSONObject doGetStr(String url)
	{
		DefaultHttpClient httpclient=new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(url);
		JSONObject jsonObject=null;
		HttpResponse response;
		try {
			response = httpclient.execute(httpGet);
			HttpEntity entity= response.getEntity();
			if(entity!=null)
			{
				String result=EntityUtils.toString(entity,"UTF-8");
				jsonObject=JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public static JSONObject doPostStr(String url,String outStr)
	{
		DefaultHttpClient httpclient=new DefaultHttpClient();
		HttpPost httpPost=new HttpPost(url);
		JSONObject jsonObject=null;
		try {
			httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
			HttpResponse response=httpclient.execute(httpPost);
			String result=EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject=JSONObject.fromObject(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	
	/**
	 * 获取静域code
	 * @return
	 */
	public static String getBaseUrl(String state){
		String url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE).replace("SCOPE", "snsapi_base").replace("STATE", state);
		return url;
	}
	
	/**
	 * 获取全域code
	 * @return
	 */
	public static String getALLUrl(String state){
		String url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_ALL).replace("SCOPE", "snsapi_base,snsapi_userinfo").replace("STATE", state);
		return url;
	}
	
	/**
	 * 通过code获取u_accesstoken
	 * @return
	 */
	public static U_AccessToken getUAccessToken(String code){
		U_AccessToken token=new U_AccessToken();
		String url=U_ACCESS_TOKEN_URL.replace("APPID",APPID).replace("SECRET",APPSECRET).replace("CODE",code);
		JSONObject jsonObjectAT=doGetStr(url);
		if(jsonObjectAT!=null)
		{
			token.setAccess_token(jsonObjectAT.getString("access_token"));
			token.setExpires_in(jsonObjectAT.getInt("expires_in"));
			token.setOpenId(jsonObjectAT.getString("openid"));
			token.setRefresh_token(jsonObjectAT.getString("refresh_token"));
			token.setScope(jsonObjectAT.getString("scope"));
		}
		return token;
	}
	
	public static JSONObject getUserInfo(String access_token,String openid){
		String url=GET_USER_INFO_URL.replace("ACCESS_TOKEN", access_token).replace("OPENID",openid);
		JSONObject jsonObject=doGetStr(url);
		return jsonObject;
	}
	
	public static JSONObject validate(String access_token,String openid)
	{
		String url=VALIDATE_URL.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
		JSONObject jsonObjectAT=doGetStr(url);
		return jsonObjectAT;	
	}
	
//	public static void main(String args[])
//	{
//		AccessToken token=WechatUtils.getUAccessToken();
//		System.out.println(token.getAccess_token());
//		System.out.println(token.getExpires_in());
//	}
}
