<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>参加会议</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="../css/public.css" rel="stylesheet" type="text/css"> 
    <link href="../css/center.css" rel="stylesheet" type="text/css">   

    <link href="../css/attend.css" rel="stylesheet" type="text/css">   
  
     <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
</head>

<body>

<div class="navbar navbar-default navbar-fixed-top" role="navigation" style="height: 50px;">
    <div class="navbar-header">
        <!-- .navbar-toggle样式用于toggle收缩的内容，即nav-collapse collapse样式所在元素 -->
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
       </button>
       <!-- 确保无论是宽屏还是窄屏，navbar-brand都显示 -->
       <a href="##" class="navbar-brand">云会议</a>

    </div>
  <!-- 屏幕宽度小于768px时，div.navbar-responsive-collapse容器里的内容都会隐藏，显示icon-bar图标，当点击icon-bar图标时，再展开。屏幕大于768px时，默认显示。 -->
    <div class="collapse navbar-collapse navbar-responsive-collapse"style="text-align: center;">
        <ul class="nav navbar-nav" style="display: inline-block;float: none;">
           
        <li  style="width: 100px;"><a href="##">网站首页</a></li>
        <li class="active" style="width: 100px;"><a href="##">所有会议</a></li>
        <li style="width: 100px;"><a href="${pageContext.request.contextPath}/jsp/createandrelease.jsp">创建会议</a></li>
        <li style="width: 100px;"><a href="##">个人中心</a></li>
        <li style="width: 100px;"><a href="##">消息中心</a></li>
        </ul>
        
        <ul class="nav navbar-nav" style="float: right;margin-right: 40px;">
            <li style="width: 80px;">
                <a href="##">
                <button type="button" class="btn btn-primary" style="font-size: 12px;">
                    <span class="glyphicon glyphicon-chevron-right"></span> 退出登陆
                </button>
                </a>
        </ul>
            
    </div>
</div>



<div class="container" id="container2">
    
    <div class="course-top clearfix">
                <a class="top-header" href="/course/list">
                    <img width="239" height="36" alt="免费课程" src="../images/logo1.png">
                </a>

                <div class="course-top-search">
                    <div class="search-area" data-search="top-banner">
                         <input type="text" class="search-input" id="search" placeholder="输入搜索内容">     
                          <span class="glyphicon glyphicon-user" id="searchbtn"></span> 
                    </div>       
                            
                </div>
               
    </div>

</div>

<div class="container">

    <div class="meeting">
        <div class="meeting-list">
            <div class="clearfix">
                <div class="course-card-container">
                        
                </div>
            </div>

        </div>

    </div>  

</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/attend.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/allmeetings.js"></script>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>