<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title></title>
	<script type="text/javascript">
	function getFileList()
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
			//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			xmlhttp=new XMLHttpRequest();
		}
		else
		{
			// IE6, IE5 浏览器执行代码
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				window.location.reload();
		    }
		}
		xmlhttp.open("POST","ListFileServlet", true);
		xmlhttp.send(null);
	}
	
	function rpajax(url,Return_Function){
	    var email = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
	    email.open("POST",url,true);
	    email.onreadystatechange=function()
		{
			if (email.readyState == 4&&email.status == 200)
			{
				respText = email.responseText;
				Return_Function(respText);
			}
		}
		email.send();
	}
    
	window.onload = function(){

	    var fileArea = document.getElementById("chooseFile");
	    
	    fileArea.onmouseover = function(){
	    	var file1 = document.getElementById("file1").value;
	    	var num = file1.lastIndexOf('\\');
	    	var file1Name = file1.substring(num + 1);
	    	file1Name = encodeURIComponent(encodeURIComponent(file1Name));
	    	if(file1Name != ""){
		        rpajax("FileCheckAction?file1Name=" + file1Name, function(data){
		            var fileCheck = document.getElementById("fileCheck");
		            
		            if(data == "no")
		            {
		            	fileCheck.innerHTML = "文件列表中尚无此文件";
		            	fileCheck.style.color = "blue";
		            }
		            else if(data == "exist")
		            {
		            	fileCheck.innerHTML = "文件列表中已经存在此文件 ，点击【上传】即可覆盖";
		            	fileCheck.style.color = "red";
		            }
		        });
	    	}
	    }
	}
	</script>
</head>
<body>
	<div class="people-list">
		<ul class="list-group" id="listgroup">
		<!--参会成员列表-->
		</ul>
	</div>
		
	<ul class="nav nav-pills nav-stacked" id="naveul">
        <li style="margin: 15px;"><a href="#tom" data-toggle="tab">签到</a></li>
        <li style="margin: 15px;"><a href="#alm" data-toggle="tab">笔记</a></li>
        <li style="margin: 15px;"><a href="#container" data-toggle="tab">资料</a></li>
    </ul>
		
	<div class="container" id="container">
		<div class="button1" id="uploadFile">
		
			<form action="${pageContext.request.contextPath}/UploadHandleServlet" enctype="multipart/form-data" method="post">

				<span class="btn btn-success fileinput-button" id="chooseFile">
					<span>选择文件</span>
			        <input type="file" name="file1" id="file1"><br/>
				</span>
				
				<span id="fileCheck" class="check">检验上传文件是否已经存在</span><br/>
				
				<span class="btn btn-success fileinput-button">
					<span>上传</span>
					<input type="submit" value="上传">
				</span>
				
     		</form>
		</div>
		<button onclick="getFileList()">刷新文件列表</button>
		<div class="loadlist" id="loadlist">
		
			<!-- 遍历Map集合 -->
	        <c:forEach var="me" items="${fileNameMap}">
	            <c:url value="/DownloadServlet" var="downurl">
		            <c:param name="filename" value="${me.key}">
		            </c:param>
	        	</c:url>
	        	<div>${me.value}</div>
	        	<a href="${downurl}">下载</a>
	        	<br/>
	    	</c:forEach>
		
		</div>
		
	</div>
		
</body>
</html>