<%@ page language="java" import="com.entity.Meeting" import="com.entity.User" import="com.service.MeetingServiceImpl" import="com.service.MeetingService" import="com.service.UserService" import="com.service.UserServiceImpl" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>会议详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">    
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
    <link href="../css/public.css" rel="stylesheet" type="text/css"> 
    <link href="../css/center.css" rel="stylesheet" type="text/css">   
    <link href="../css/attend.css" rel="stylesheet" type="text/css">   
    <link href="../css/content.css" rel="stylesheet" type="text/css">
  
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

        <li style="width: 100px;"><a href="##">网站首页</a></li>
        <li class="active" style="width: 100px;"><a href="##">所有会议</a></li>
        <li style="width: 100px;"><a href="##">创建会议</a></li>
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


<%
int mid=(int)request.getSession().getAttribute("Meetingid");
Meeting meeting=new Meeting();
User user=new User();
MeetingService service=new MeetingServiceImpl();
UserService ser=new UserServiceImpl();
meeting=service.SFindMeeting(mid);
int userid=meeting.getUserid();
user=ser.SgetUser(userid);

String meetingname=meeting.getMname();
String username=user.getUname();
String job=user.getJob();
String starttime=meeting.getStartTime();
int typeID=meeting.getTypeid();
String place=meeting.getPlace();
String host=meeting.getHost();
String guest=meeting.getGuest();
String describe=meeting.getDescribe();
String remark=meeting.getRemarks();
String type=null;
if(typeID==1){
	type="研讨会";
}else if(typeID==2){
	type="论坛";
}else if(typeID==3){
	type="座谈会";
}else if(typeID==4){
	type="专题讨论会";
}else if(typeID==5){
	type="讲座";
}else if(typeID==6){
	type="辩论会";
}else if(typeID==7){
	type="其他";
}

request.getSession().setAttribute("name", meetingname);
request.getSession().setAttribute("host", host);
request.getSession().setAttribute("guest", guest);
request.getSession().setAttribute("time", starttime);
request.getSession().setAttribute("place", place);
request.getSession().setAttribute("introduction", describe);
request.getSession().setAttribute("remarks", remark);
request.getSession().setAttribute("username", username);
request.getSession().setAttribute("job", job);
request.getSession().setAttribute("type", type);

%>
<div class="container" id="container1">

<div class="course-infos">
    <div class="w pr">
      
        <div class="hd clearfix">
            <h2 class="l">${name}</h2>
                    </div>

        <div class="statics clearfix">
                        <div class="teacher-info l">
            <a href="#" target="_blank">
                <img data-userid="3409088" class="js-usercard-dialog" src="../images/tou.png" width="80" height="80">
            </a>
            <span class="tit">
                <a href="/u/3409088/courses?sort=publish" target="_blank">${username}</a><i class="fab fa-mixcloud"></i>
            </span>
            <span class="job">${job}</span>
                    </div>
                
            <div class="static-item l">
                <span class="meta">时间</span><span class="meta-value">${time}</span>
            </div>
            <div class="static-item l">
                <span class="meta">会议类型</span><span class="meta-value">${type}</span>
            </div>
            <div class="static-item l">
                <span class="meta">已参与人数</span><span class="meta-value js-learn-num">${count}</span>
            </div>
           <!--  <div class="static-item l score-btn">
                <span class="meta">预计人数</span><span class="meta-value">100</span>
                                
            </div> -->
          

        </div>
        
   <form class="form-horizontal" action="../ApplyAndCancelMeeting" method="post">      
  <div class="opebut">
  <button type="submit"class="btn btn-success btn-lg" id="confirm">${buttonname}</button>

</div>
</form>

    </div>
   
</div>

</div>



<div class="container" id="main-container">
    <div class="content">
          
        <div class="course-wrap">
          <h3>简介</h3>
          <p>
            ${introduction}
            </p>
           
        </div>
        <div class="course-wrap">
          <h3>备注</h3>
          <p>
           ${remarks}
              </p>
           
        </div>


<div class="course-wrap">
          <h3>主办方</h3>
         <i class="fab fa-meetup"></i>&nbsp;<span> ${host}</span>
    </div>

    <div class="course-wrap">
          <h3>地点</h3>
         <i class="fas fa-map-marker-alt"></i>&nbsp;<span> ${place}</span>
    </div>

<div class="course-wrap">
          <h3>出场嘉宾</h3>
         <p><i class="far fa-user-circle"></i>&nbsp;<span> ${guest}</span></p>
        <!--  <p><i class="far fa-user-circle"></i>&nbsp;<span>副院长：xxx</span></p>
         <p><i class="far fa-user-circle"></i>&nbsp;<span>专家：xxx</span></p> -->
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/click-to-servlet.js"></script>

</body>
</html>