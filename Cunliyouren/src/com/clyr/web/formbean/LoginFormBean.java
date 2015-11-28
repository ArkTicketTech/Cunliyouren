package com.clyr.web.formbean;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * ��װ���û�ע���bean����������ManagementLogin.jsp�еı��������ֵ
 * LoginFormBean�е�������ManagementLogin.jsp�еı��������nameһһ��Ӧ
 * LoginFormBean��ְ����˸������ManagementLogin.jsp�еı��������ֵ֮�⻹������У����������ֵ�ĺϷ���
 *
 */
public class LoginFormBean {

    //LoginFormBean�е�������ManagementLogin.jsp�еı��������nameһһ��Ӧ
    //<input type="text" name="username"/>
    private String username;
    //<input type="password" name="password"/>
    private String password;

    
    /**
     * �洢У�鲻ͨ��ʱ���û��Ĵ�����ʾ��Ϣ
     */
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    /*
     * validate��������У���������
     * ��������У�����
     *         private String userName; �û�������Ϊ�գ�����Ҫ��3-8����ĸ abcdABcd 
     *         private String userPwd; ���벻��Ϊ�գ�����Ҫ��3-8������
     */
    public boolean validate() {

        boolean isOk = true;
        

        if (this.username == null || this.username.trim().equals("")) {
            isOk = false;
            errors.put("userName", "�û�������Ϊ�գ���");
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
