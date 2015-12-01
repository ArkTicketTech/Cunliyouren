package com.clyr.web.formbean;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class LoginFormBean {

    //<input type="text" name="username"/>
    private String username;
    //<input type="password" name="password"/>
    private String password;

    
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public boolean validate() {

        boolean isOk = true;
        

        if (this.username == null || this.username.trim().equals("")) {
            isOk = false;
            errors.put("userName", "�û�����Ϊ�գ���");
        } 

        if (this.password == null || this.password.trim().equals("")) {
            isOk = false;
            errors.put("userPwd", "���벻��Ϊ�գ���");
        } 

        return isOk;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
