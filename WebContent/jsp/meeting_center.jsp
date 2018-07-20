<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>个人中心</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
  <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
  <link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css"> 
  <link href="${pageContext.request.contextPath}/css/center.css" rel="stylesheet" type="text/css">   
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font/iconfont.css">
  <link href="${pageContext.request.contextPath}/css/nav.css" rel="stylesheet" type="text/css"> 
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/meeting_center.css">
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  
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




	<div class="body">
		<div class="people_manage">
			<div class="query">
				<h4 class="people_list_head">参会人员列表</h4>
			</div>
			<div class="people">
				<ul class="people_list">
				</ul>
			</div>
		</div>
		
		<div class="chat_container" id="chat_container">
			<p class="meetingname" id="meetingname" name="meetingname">黑坤批斗大会</p>
			<p class="meetinghost" id="meetinghost" name="meetinghost">CloudM</p>
			
		</div>
		
		<button class="btn_flash fade" onclick="getFileList()">刷新文件列表</button>
		<div class="loadlist fade" id="loadlist">
		
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
		
		<div class="other">
			<div class="function">
				<ul class="function_ul" id="function_ul_id">
					<a href="#info" data-toggle="tab"><li class="main" align="center"><h2>主&emsp;页</h2></li></a>
					<a href="#tom" data-toggle="tab"><li class="load" ><h2>文&emsp;件</h2></li></a>
					<a href="#card" data-toggle="tab"><li class="btn_card" ><h2>名&emsp;片</h2></li></a>
					<label class="btn_sign" data-toggle="modal" data-target="#myModal"><li class="btn_sign"><h2>笔&emsp;记</h2></li></label>
				</ul>
			</div>
		</div>
	</div>			
	
				<!--笔记界面-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h1 class="modal-title" id="myModalLabel" align="center">笔&emsp;记</h1>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" align="center">
								<textarea class="textarea" type="text" rows="18" cols="48"></textarea>
							</form>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary">保存</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal -->
			</div>
			<!--文件上传-->
	
	<button onclick="getFileList()">刷新文件列表</button>
		<div class="loadlist" id="loadlist">
		
			
		
		</div>
	
	<div class="modal fade" id="cardpannel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" id="card-instance">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;<tton>
						<h4 class="modal-title" id="myModalLabel">名片详情</h4>
					</div>
					<div class="modal-body">
						<div class="card" id="card-instance">
							<div class="nameinfo">
								<span class="modal_name" id="username"></span>
							</div>
							<div class="companyinfo">
								<span class="glyphicon glyphicon-user" style="color: #FFFFF0"></span>&nbsp;
								<span class="company1"></span>
								<span class="company2"></span>
							</div>
							<div class="contactinfo">
								<span class="glyphicon glyphicon-phone contact1" style="color: #FFFFF0"></span>&nbsp;手机号：
								<span class="phonenum"></span>
							</div>
							<div class="contactinfo">
								<span class="glyphicon glyphicon-phone-alt contact2" style="color: #FFFFF0"></span>&nbsp;工作电话：
								<span class="worknum"></span>
							</div>
							<div class="emailinfo">
								<span class="glyphicon glyphicon-envelope" style="color: #FFFFF0"></span>&nbsp;
									邮箱：
								<span class="email"></span>
							</div>
							<div class="addressinfo">
								<span class="glyphicon glyphicon-home" style="color: #FFFFF0"></span>&nbsp;
									地址：
								<span class="address"></span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-warning" id="cancel" data-dismiss="modal">返回</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
	
	
<footer class="footer">
  <div class="copyright">@CloudM</div>
</footer>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/birth.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>

<script  type="text/javascript">
var map = "${fileNameMap}";
var url = "${downurl}";
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/meeting_center.js"></script>
</body>
</html>