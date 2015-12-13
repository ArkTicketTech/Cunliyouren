package com.clyr.service.impl;

import java.sql.Timestamp;

import com.clyr.dao.impl.AccessTokenDao;
import com.clyr.domain.AccessToken;

public class AccessTokenService {
	private AccessTokenDao atDao=new AccessTokenDao();
	public String get()
	{
		AccessToken at=atDao.select();
		if(at==null)
		{
			return "";
		}
		else
		{
			long tn=new Timestamp(System.currentTimeMillis()).getTime(); 
			long tc=at.getCreateTime().getTime();
			if((tn-tc)>=7200000)
			{
				return "refresh";
			}
		}
		return at.getAccessToken();
	}
	public void input(String token)
	{
		atDao.add(token);
	}
	public void update(String token)
	{
		atDao.update(token);
	}
}
