<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManagementLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <style type="text/css">  
body{  
 color : #000 ;  
 font-size : 12px ;  
  
 margin : 0px auto ;  
 }  
  
</style>  
  

</head>  
<body>  
<form action="AdminLoginServlet" method="post" name="form1">  
      
      
<table border="1" cellspacing="1" cellpadding="1"  bordercolor="silver" align="center">  
   <tr>  
      <td colspan="2" align="center" bgcolor="#e8e8e8">用户登陆</td>  
   </tr>  
   <tr>  
      <td>用户名：</td>  
      <td style="color:#FF0000"><input type="text" name="username" value="${formbean.userName}">${formbean.errors.userName}</td>  
   </tr>  
   <tr>  
      <td>密码：</td>  
      <td  style="color:#FF0000"><input type="password" name="password" value="${formbean.userPwd}"> ${formbean.errors.userPwd} </td>  
   </tr>  
   <tr>  
      <td></td>  
      <td style="color:#FF0000"><input type="submit" name="submit" value="登录" style="width: 137px; "/>${state}</td>  
   </tr>  
</table>  

  
</form>  
</body>  
</html>
