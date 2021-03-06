<%@ page language="java" import="com.entity.Meeting" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人中心</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="./css/public.css" rel="stylesheet" type="text/css">
<link href="./css/center.css" rel="stylesheet" type="text/css">
<link href="./css/release.css" rel="stylesheet" type="text/css">
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
			<li class="active" style="width: 100px;"><a href="##">网站首页</a></li>
			<li style="width: 100px;"><a href="##">功能1</a></li>
			<li style="width: 100px;"><a href="##">功能2</a></li>
			<li style="width: 100px;"><a href="##">功能3</a></li>
			<li style="width: 100px;"><a href="##">功能4</a></li>
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
				<img class="img" src="images/touxiang.jpg" alt="">
			</div>
			<!--user-pic-big end-->
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
<div class="container2" id="container2">
	<div class="container">
		<div class="model release" id="release model" role="dialog" aria-labelledby="releaseModalLabel" aria-hidden="true">
			<div class="modelr-dialog">
				<div class="modelr-content">
					<div class="modelr-header">
						<button type="button" class="close" onclick="history.go(-1);"><font color="#DC143C"><h1>&times;</h1></font></button>
						<h2 class="modal-title" id="releaseModalLabel" align="center">请填写会议信息</h2>
					</div>
					<hr>
					<!--[if IE]>
					<br>
					<![endif]-->
					
					<%
					if((Meeting)request.getSession().getAttribute("Meeting")!=null){
					Meeting meeting=(Meeting)request.getSession().getAttribute("Meeting");
					String Name=meeting.getMname();
					String Host=meeting.getHost();
					int type=meeting.getTypeid();
					String Guest=meeting.getGuest();
					String Time=meeting.getStartTime();
					String Place=meeting.getPlace();
					String Introduction=meeting.getDescribe();
					String Remarks=meeting.getRemarks();
					System.out.println(Introduction);
					request.getSession().setAttribute("name", Name);
					request.getSession().setAttribute("host", Host);
					request.getSession().setAttribute("guest", Guest);
					request.getSession().setAttribute("time", Time);
					request.getSession().setAttribute("place", Place);
					request.getSession().setAttribute("introduction", Introduction);
					request.getSession().setAttribute("remarks", Remarks);
					}else{
						request.getSession().setAttribute("name", null);
						request.getSession().setAttribute("host", null);
						request.getSession().setAttribute("guest", null);
						request.getSession().setAttribute("time", null);
						request.getSession().setAttribute("place", null);
						request.getSession().setAttribute("introduction", null);
						request.getSession().setAttribute("remarks", null);
					}
					//request.getSession().setAttribute("name", Name);
					%>
					
					<div class="modal-body">
						<form class="form-inline" role="form" action="${pageContext.request.contextPath}/CreateAndReleaseMeeting?doPost" method="Post">
						<div class="form-group">
							<label class="reginfor">会议名称</label>
							<input type="text" class="form-control" id="inputtext" name="name" value=${name}>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor"> 主&nbsp;&nbsp;办&nbsp;&nbsp;方  </label>
							<input type="text" class="form-control" id="inputtext1" name="host" value=${host}>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">会议类型</label>
							<select name="type" class="form-control">
								<option value="yantaohui">研讨会</option>
								<option value="luntan">论坛</option>
								<option value="zuotanhui">座谈会</option>
								<option value="taolunhui">专题讨论会</option>
								<option value="jiangzuo">讲座</option>
								<option value="bianlunhui">辩论会</option>
								<option value="else">其他</option>
							</select>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">出席嘉宾</label>
							<input type="text" class="form-control" id="inputtext" name="guest" value=${guest}>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">会议时间</label>
							<input type="text" class="form-control" id="inputtext" name="time" value=${time}>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">会议地点</label>
							<input type="text" class="form-control" id="inputtext" name="place" value=${place}>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">会议介绍</label>
							<textarea rows="5" class="form-control" cols="70" name="introduction"> ${introduction}</textarea>
							<i class="fa fa-user"></i>
						</div>
						<br>
						<br>
						<div class="form-group">
							<label class="reginfor">备注信息</label>
							<textarea rows="5" class="form-control" cols="70" name="remarks">${remarks}</textarea>
							<i class="fa fa-user"></i>
						</div>
						<div class="modal-footer">
						
				<input type="submit"  name="create"   value="保存会议">
				<input type="submit"  name="release"   value="发布会议">
                <input type="submit"  name="delete"   value="删除会议">
				
                </div>
						</form>
					</div>
				</div>
				
					
				</div>
				
				
            
			</div>
			
		</div>
	</div>

</div>
</body>
</html>

</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>