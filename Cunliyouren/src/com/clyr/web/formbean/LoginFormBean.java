package com.clyr.web.formbean;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 封装的用户注册表单bean，用来接收ManagementLogin.jsp中的表单输入项的值
 * LoginFormBean中的属性与ManagementLogin.jsp中的表单输入项的name一一对应
 * LoginFormBean的职责除了负责接收ManagementLogin.jsp中的表单输入项的值之外还担任着校验表单输入项的值的合法性
 *
 */
public class LoginFormBean {

    //LoginFormBean中的属性与ManagementLogin.jsp中的表单输入项的name一一对应
    //<input type="text" name="username"/>
    private String username;
    //<input type="password" name="password"/>
    private String password;

    
    /**
     * 存储校验不通过时给用户的错误提示信息
     */
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    /*
     * validate方法负责校验表单输入项
     * 表单输入项校验规则：
     *         private String userName; 用户名不能为空，并且要是3-8的字母 abcdABcd 
     *         private String userPwd; 密码不能为空，并且要是3-8的数字
     */
    public boolean validate() {

        boolean isOk = true;
        

        if (this.username == null || this.username.trim().equals("")) {
            isOk = false;
            errors.put("userName", "用户名不能为空！！");
        } 

        if (this.password == null || this.password.trim().equals("")) {
            isOk = false;
            errors.put("userPwd", "密码不能为空！！");
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
