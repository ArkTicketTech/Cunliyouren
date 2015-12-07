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
    	height: 800px;			
    	background: #a4f;			
    }						
    .maincontent{	
    	float: left;
    	width: 1100px;	
    	height: 800px;						
    	background: #eee;			
    }		
    #nav { 
    	background: #fff;
    	width:450px; 
    	height: 300px; 
    	display: none;
    	border: 1px solid #D4CD49; 
    	position:absolute;
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
			    newRow.insertCell(10).innerHTML="<div class='pro' name='"+item.pid[0]+"'>"+item.pName[0]+"</div>";
			    newRow.insertCell(11).innerHTML="<div class='pro' name='"+item.pid[1]+"'>"+item.pName[1]+"</div>";
			    newRow.insertCell(12).innerHTML="<div class='pro' name='"+item.pid[2]+"'>"+item.pName[2]+"</div>";
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
			$(".pro").mouseover(function(){ 
					productInfo($(this).attr("name")); 
					var X=$(this).offset();
					$("#nav").css("left",X.left-300+"px").css("top",X.top+30+"px").css("display","block");
				});
			$(".pro").mouseout(function(){ $("#nav").css("display","none");});
			function productInfo(pId) { 
				$.ajax({
					type:"POST",
					url:"MProductSearch?pId="+pId,
					dataType: "json",
					success: function(data){ 
						$("#i_proPic1").attr("src",data[0].picture1);
						$("#i_proPic2").attr("src",data[0].picture2);
						$("#i_proPic3").attr("src",data[0].picture3);
						$("#p_proName").html("产品名称："+data[0].productName);
						$("#p_proPrice").html("价格:"+data[0].price+"/"+data[0].unit);
						$("#p_proPlace").html("交易地点:"+data[0].deliveryPoint);
						$("#d_proDisc").html("简介:"+data[0].description);
					}
				});
			};
			
			$("#sortSend").click(function(){checkColumnValue(2)});
			$("#sortReceive").click(function(){checkColumnValue(3)});
			function checkColumnValue(index) {
				var tableObject = $("#mainTable"); 
            	var tbBody = tableObject.children("tbody"); 
           	    var tbBodyTr = tbBody.find("tr"); 
                var trsValue = new Array();
                tbBodyTr.each(function () {
                    var tds = $(this).find('td');
                    trsValue.push($(tds[index]).html() + ".separator" + $(this).html());
                    $(this).html("");
                });
                var len = trsValue.length;
                for (var i = 0; i < len; i++) {
                    for (var j = i + 1; j < len; j++) {
                        value1 = trsValue[i].split(".separator")[0];
                        value2 = trsValue[j].split(".separator")[0];
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
            var tableObject = $("#mainTable"); 
            var currentPage=0;
           	var pageSize=20;
           	tableObject.bind("paging",function(){
           		tableObject.find("tbody tr").hide().slice(currentPage*pageSize,(currentPage+1)*pageSize).show();
           	});	
           	var sumRows=tableObject.find("tbody tr").length;
           	var sumPages=Math.ceil(sumRows/pageSize);
           	var pager=$("<div class='page'></div>");
           	for(var pageIndex=0;pageIndex<sumPages;pageIndex++){
           		$("<span style='cursor:hand;text-decoration:underline'>"+(pageIndex+1)+"</span>").bind("click",{'newPage':pageIndex},function(event){
           			currentPage=event.data["newPage"];
           			tableObject.trigger("paging");
           		}).appendTo(pager);
           		pager.append(" ");
           	}
           	pager.insertAfter(tableObject);
           	tableObject.trigger("paging");
  		});
    </script>
  <body>		
  	<div class="container">	
  		<div id="nav">
  			<img alt="" src="" style="width:150px;height:150px;float:left;" id="i_proPic1">
  			<img alt="" src="" style="width:150px;height:150px;float:left;" id="i_proPic2">
  			<img alt="" src="" style="width:150px;height:150px;float:left;" id="i_proPic3">
  			<div style="width:225px;height:150px;float:left;">
  				<p id="p_proName"  style="float:left;width:225px;height:50px;margin:0;"></p>
  				<p id="p_proPrice" style="float:left;width:225px;height:50px;margin:0;"></p>
  				<p id="p_proPlace" style="float:left;width:225px;height:50px;margin:0;"></p>
  			</div>
  			<div style="width:225px;height:150px;float:left;" id="d_proDisc">
  			</div>
  		</div>		
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
