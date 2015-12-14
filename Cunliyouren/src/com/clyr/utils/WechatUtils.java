package com.clyr.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.clyr.domain.AccessToken;
import com.clyr.domain.U_AccessToken;
import com.clyr.service.impl.AccessTokenService;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class WechatUtils {
	private static String APPID;
	private static String APPSECRET;
	private static String CODE_URL;
	private static String U_ACCESS_TOKEN_URL;
	private static String ACCESS_TOKEN_URL;
	private static String REDIRECT_URI_BASE;
	private static String REDIRECT_URI_ALL;
	private static String GET_USER_INFO_URL;
	private static String VALIDATE_URL;
	private static String TICKET_URL;
	private static String REDIRECT_URI_BASE_SENDED;
	private static String REDIRECT_URI_BASE_RECEIVED;
	private static String REDIRECT_URI_BASE_MYSHOP;
	private static String REDIRECT_URI_BASE_PRODETAIL;
	private static String REDIRECT_URI_BASE_PC;
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
		ACCESS_TOKEN_URL=pro.getProperty("ACCESS_TOKEN_URL");
		REDIRECT_URI_ALL=pro.getProperty("REDIRECT_URI_ALL");
		GET_USER_INFO_URL=pro.getProperty("GET_USER_INFO_URL");
		VALIDATE_URL=pro.getProperty("VALIDATE_URL");
		TICKET_URL=pro.getProperty("TICKET_URL");
		REDIRECT_URI_BASE=pro.getProperty("REDIRECT_URI_BASE_MAIN");
		REDIRECT_URI_BASE_SENDED=pro.getProperty("REDIRECT_URI_BASE_SENDED");
		REDIRECT_URI_BASE_RECEIVED=pro.getProperty("REDIRECT_URI_BASE_RECEIVED");
		REDIRECT_URI_BASE_MYSHOP=pro.getProperty("REDIRECT_URI_BASE_MYSHOP");
		REDIRECT_URI_BASE_PRODETAIL=pro.getProperty("REDIRECT_URI_BASE_PRODETAIL");
		REDIRECT_URI_BASE_PC=pro.getProperty("REDIRECT_URI_BASE_PC");
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
	public static String getBaseUrl(String redi, String pId){
		String url="";
		if(redi.equals("Main"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE).replace("SCOPE", "snsapi_base");
		else if(redi.equals("SendedOrder"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE_SENDED).replace("SCOPE", "snsapi_base");
		else if(redi.equals("ReceivedOrder"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE_RECEIVED).replace("SCOPE", "snsapi_base");
		else if(redi.equals("MyShop"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE_MYSHOP).replace("SCOPE", "snsapi_base");
		else if(redi.equals("PersonalCenter"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE_PC).replace("SCOPE", "snsapi_base");
		else if(redi.equals("ProDetail"))
			url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_BASE_PRODETAIL+"?pId="+pId).replace("SCOPE", "snsapi_base");
		return url;
	}
	
	/**
	 * 获取全域code
	 * @return
	 */
	public static String getALLUrl(String state){
		String url=CODE_URL.replace("APPID", APPID).replace("REDIRECT_URI",REDIRECT_URI_ALL).replace("SCOPE", "snsapi_base,snsapi_userinfo");
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
	
	/**
	 * 获取企业accesstoken
	 * @return
	 */
	public static String getAccessToken(){
		AccessTokenService service = new AccessTokenService();
		String accessToken=service.get();
		if(accessToken.equals(""))
		{
			String url=ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
			JSONObject jsonObjectAT=doGetStr(url);
			if(jsonObjectAT!=null)
			{
				accessToken=jsonObjectAT.getString("access_token");
				service.input(accessToken);
			}
		}
		else if(accessToken.equals("refresh"))
		{
			String url=ACCESS_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
			JSONObject jsonObjectAT=doGetStr(url);
			if(jsonObjectAT!=null)
			{
				accessToken=jsonObjectAT.getString("access_token");
				service.update(accessToken);
			}
		}
		return accessToken;
	}
	
	public static String getTicket(){
		String url=TICKET_URL.replace("ACCESS_TOKEN",getAccessToken());
		JSONObject jsonObjectAT=doGetStr(url);
		String ticket="";
		if(jsonObjectAT!=null)
		{
			ticket=jsonObjectAT.getString("ticket");
		}
		return ticket;
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
	
	/**
	   * 获取媒体文件
	   * @param accessToken 接口访问凭证
	   * @param media_id 媒体文件id
	   * @param savePath 文件在服务器上的存储路径
	   * */
	  public static String downloadMedia( String mediaId, String savePath) {
	    String filePath = null;
	    // 拼接请求地址
	    String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	    requestUrl = requestUrl.replace("ACCESS_TOKEN", getAccessToken()).replace("MEDIA_ID", mediaId);
	    System.out.println(requestUrl);
	    try {
	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");

	      if (!savePath.endsWith("/")) {
	        savePath += "/";
	      }
	      // 根据内容类型获取扩展名
 	     // String fileExt = WechatUtils.getFileEndWitsh(conn.getHeaderField("Content-Type"));
	      // 将mediaId作为文件名
	      filePath = savePath + mediaId+ ".jpeg";

	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	      String info = String.format("下载媒体文件成功，filePath=" + filePath);
	      System.out.println(info);
	    } catch (Exception e) {
	      filePath = null;
	      String error = String.format("下载媒体文件失败：%s", e);
	      System.out.println(error);
	    }
	    return filePath;
	  }
	  
	  public static String getFileEndWitsh(String ct){
		  String result="";
		  if(ct.equals("image/tiff"))
			  result=".tif";
		  if(ct.equals("image/fax"))
			  result=".fax";
		  if(ct.equals("image/gif"))
			  result=".gif";
		  if(ct.equals("image/x-icon"))
			  result=".ico";
		  if(ct.equals("image/jpeg"))
			  result=".jpg";
		  if(ct.equals("image/pnetvue"))
			  result=".net";
		  if(ct.equals("image/png"))
			  result=".png";
		  if(ct.equals("image/vnd.rn-realpix"))
			  result=".rp";
		  if(ct.equals("image/vnd.wap.wbmp"))
			  result=".wbmp";
		  return result;
	  }
	
//	public static void main(String args[])
//	{
//		AccessToken token=WechatUtils.getUAccessToken();
//		System.out.println(token.getAccess_token());
//		System.out.println(token.getExpires_in());
//	}
}
