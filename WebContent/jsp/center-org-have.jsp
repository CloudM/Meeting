<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>已发布会议</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
  <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
  <link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css"> 
  <link href="${pageContext.request.contextPath}/css/center.css" rel="stylesheet" type="text/css">   
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font/iconfont.css">
  <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"> 
   
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

        <li class="active" style="width: 100px;"><a href="##">网站首页</a></li>
        <li style="width: 100px;"><a href="##">所有会议</a></li>
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



    <div class="container" id="container1">

      <div class="user-info clearfix">
        <div class="user-pic" data-is-fans="" data-is-follows="">
          <div class="user-pic-bg">
            <img class="img" src="../images/touxiang.jpg" alt="">
          </div><!--user-pic-big end-->           
        </div>

        <div class="user-info-right">
          <h3 class="user-name clearfix">
            <span>VorSonnenaufgang</span>
          </h3>
          <!--25-->
          <p class="about-info">
            <span>男</span>
            <span>湖北</span>             
            <span>武汉市</span>
            <span>学生</span>
          </p>
        </div>


      </div>    

    </div>

    <div class="container">
      <div class="row">
        <div class="col-xs-2">
         <div class="nav1">
        <div class="nav-top">
            <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><img src="../images/mini.png" ></div>
        </div>

        <ul>
           <li class="nav-item">
            <a href="center.html"><i class="fa fa-user-circle fa-lg"></i><span>个人信息</span></a>
          </li>
           <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-calendar fa-lg"></i><span>我参加的会议</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-attend-wait.jsp"><span>待审核</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-attend-to.jsp"><span>待参加会议</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-attend-have.jsp"><span>已参加会议</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-gg-circle fa-lg"></i><span>我发布的会议</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-org-script.jsp"><span>草稿箱</span></a></li>
                    <li><a href="#"><span>已发布会议</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-org-fini.jsp"><span>已完成会议</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-address-card fa-lg"></i><span>名片夹</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="center-card-my.html"><span>我的名片</span></a></li>
                    <li><a href="center-card-other.html"><span>收藏名片</span></a></li>
                </ul>
            </li>


        </ul>
    </div>
        </div>

        <div class="col-xs-10">
         <div class="meeting">  
     <ul class="meet-list" id="meetlist">  
       <li>  
         <img src="../images/logo1.png" />  
         <h3>Headline</h3>  
         <p>Lorem ipsum dolor sit amet...</p>  
       </li>  

  
     </ul>  
   </div> 
</div>



</div>
</div>

</div>


<footer class="footer">
  <div class="copyright">@CloudM</div>
</footer>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <script type="text/javascript" src="${pageContext.request.contextPath}/js/center-org-have.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/manageMlist.js"></script>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>

</body>
</html>