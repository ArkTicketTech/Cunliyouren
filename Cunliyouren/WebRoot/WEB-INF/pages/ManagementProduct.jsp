<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManagementProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">			
    body{				
    	background: #42413C ;				
    	margin: 0;				
    	padding: 0;				
    	text-align: center;			
    }						
    .container{				
    	width: 1200px;				
    	background: #FFF;				
    	margin: 0 auto;				
    	text-align: left;			
    }						
    .header{				
    	padding: 10px 0;				
    	background: #ADB96E;			
    }						
    .sidebar{				
    	float: left;				
    	width: 100px;	
    	height: 500px;			
    	background: #a4f;			
    }						
    .maincontent{	
    	float: left;
    	width: 1100px;	
    	height: 500px;						
    	background: #eee;			
    }							
    </style>	
    
  </head>	
  <script type="text/javascript" src="<%=basePath  %>JavaScript/jquery.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		var v=${searchResult};
    		$.each(v,function(idx,item){     
  		 		var bodyObj=document.getElementById("mainTBody");
  		 		var rowCount = bodyObj.rows.length;
				var newRow = bodyObj.insertRow(rowCount++); 
			    newRow.insertCell(0).innerHTML=idx;
			    newRow.insertCell(1).innerHTML=item.nickName;
			    newRow.insertCell(2).innerHTML=item.sendOrder;
			    newRow.insertCell(3).innerHTML=item.receiveOrder;
			    newRow.insertCell(4).innerHTML=item.telNum;
			    newRow.insertCell(5).innerHTML=item.homeTown;
			    newRow.insertCell(6).innerHTML=item.highSchool;
			    newRow.insertCell(7).innerHTML=item.university;
			    newRow.insertCell(8).innerHTML=item.homeAddress;
			    newRow.insertCell(9).innerHTML=item.workingAddress;
			    newRow.insertCell(10).innerHTML=item.pName[0];
			    newRow.insertCell(11).innerHTML=item.pName[1];
			    newRow.insertCell(12).innerHTML=item.pName[2];
			    if(item.state==0)
			    {
			    	newRow.insertCell(13).innerHTML="<button id='ope"+idx+"' name='Enable'>恢复</button>";
			    }
			    else if(item.state==1)
			    {
			    	newRow.insertCell(13).innerHTML="<button id='ope"+idx+"' name='Disable'>停用</button>";
			    }
			    $("#ope"+idx).click(function(){
  					$.ajax({
  						url: "MUser"+$("#ope"+idx).attr('name')+"?user="+item.uId,
  						success: function(){window.location.reload(true);}
  						});
  				});
			});
			
			function productInfo(pId) { 
				$.ajax({
					url:"MProductSearch?pId="+pId,
					success: function(){}
				});
			};
			
			$("#sortSend").click(function(){checkColumnValue(2)});
			$("#sortReceive").click(function(){checkColumnValue(3)});
			function checkColumnValue(index) {
				var tableObject = $("#mainTable"); //获取id为tableSort的table对象
            	var tbBody = tableObject.children("tbody"); //获取table对象下的tbody
           	    var tbBodyTr = tbBody.find("tr"); //获取tbody下的tr
                var trsValue = new Array();
                tbBodyTr.each(function () {
                    var tds = $(this).find('td');
                    //获取行号为index列的某一行的单元格内容与该单元格所在行的行内容添加到数组trsValue中
                    trsValue.push($(tds[index]).html() + ".separator" + $(this).html());
                    $(this).html("");
                });
                var len = trsValue.length;
                for (var i = 0; i < len; i++) {
                    for (var j = i + 1; j < len; j++) {
                        //获取每行分割后数组的第二个值,即文本值
                        value1 = trsValue[i].split(".separator")[0];
                        //获取下一行分割后数组的第二个值,即文本值
                        value2 = trsValue[j].split(".separator")[0];
                        //接下来是数字\字符串等的比较
                        value1 = value1 == "" ? 0 : value1;
                        value2 = value2 == "" ? 0 : value2;
                        if (parseInt(value1) > parseInt(value2)) {
                            var temp = trsValue[j];
                            trsValue[j] = trsValue[i];
                            trsValue[i] = temp;
                        };
                    };
                }
                for (var i = 0; i < len; i++) {
                	$("tbody tr:eq(" + i + ")").html(trsValue[i].split(".separator")[1]);
                }; 	
            };			
  		});
    </script>
  <body>		
  	<div class="container">			
  		<div class="header">				
  			<h1>村里有人管理平台</h1>			
  		</div>						
  		<div class="content">				
  			<div class="sidebar">					
  				<p>·用户管理</p>					
  				<p><a href="<%=basePath%>ManagementAdminUI">·系统管理</a></p>									
  			</div>				
  			<div class="maincontent">	
  				<form  style="float:left;width:300px" action="MUserSearch" method="post">
  					<input type="text" name="key">
  					<input type="submit" value="检索">
  				</form>
  				<button id="sortSend" style="float:left">按发出购买请求次数降序排序</button>
  				<button id="sortReceive"style="float:left">按收到购买请求次数降序排序</button>
  				<a href="<%=basePath%>AdminLogout"><button style="float:right">注销</button></a>
  				<table id="mainTable" border="1" width="1100px">
  				<thead>
  					<tr>
  						<th>序号</th>
  						<th>昵称</th>
  						<th>发出购买请求次数</th>
  						<th>收到购买请求次数</th>
  						<th>手机号</th>
  						<th>家乡</th>
  						<th>高中</th>
  						<th>大学</th>
  						<th>家庭地址</th>
  						<th>工作地点</th>
  						<th>产品1</th>
  						<th>产品2</th>
  						<th>产品3</th>
  						<th>操作</th>
  						
  					</tr>
  					</thead>
  					<tbody  id="mainTBody">
  					</tbody>
  				</table>								
  			</div>			
  		</div>				
  </div>	
 </body>
</html>
