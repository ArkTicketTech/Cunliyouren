package com.clyr.utils;

import java.io.IOException;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.clyr.domain.U_AccessToken;

public class AMapUtils {
	private static String key;
	private static String KEYWORDS_SEARCH_URL;
	static {
		Properties pro = new Properties();
		try {
			pro.load(WechatUtils.class.getResourceAsStream("AMap.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		key=pro.getProperty("key");
		KEYWORDS_SEARCH_URL=pro.getProperty("KEYWORDS_SEARCH_URL");
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
	
	/**
	 * 获取地理位置
	 * 返回{"pois":["0":{"location":lat,lat}]}
	 * @return
	 */
	public static JSONObject getPosition(String keyWords){
		String url=KEYWORDS_SEARCH_URL.replace("ADDRESS", keyWords).replace("KEY",key);
	    url = url.replaceAll(" ", "%20");
		JSONObject jsonObject=doGetStr(url);
		return jsonObject;
	}
	
	/**
	 * 计算地球上任意两点(经纬度)距离
	 * @param long1 第一点经度
	 * @param lat1 第一点纬度
	 * @param long2 第二点经度
	 * @param lat2 第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double Distance(double long1, double lat1, double long2,
			double lat2) {
		double a, b, R;
		R = 6378137;
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}
	
	public static double Distance(String str1 ,String str2)
	{
		if(str1.equals("") || str2.equals(""))
		{
			return 4000;
		}
		String a[]=str1.split(",");
		String b[]=str2.split(",");
		double long1=Double.valueOf(a[0]);
		double lat1=Double.valueOf(a[1]);
		double long2=Double.valueOf(b[0]);
		double lat2=Double.valueOf(b[1]);
		return Distance(long1,lat1,long2,lat2);
	}
	
//	public static void main(String args[]){
//		System.out.print(AMapUtils.getPosition("上海江浦666").getJSONArray("pois").getJSONObject(0).getString("location"));
//	}
}
