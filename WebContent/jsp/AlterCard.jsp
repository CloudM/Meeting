<%@ page language="java" import="com.entity.Card" import="com.entity.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改名片</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
	<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css">   
	<link href="${pageContext.request.contextPath}/css/createcard.css" rel="stylesheet" type="text/css">  
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
        <li style="width: 100px;"><a href="${pageContext.request.contextPath}/jsp/attend.jsp">所有会议</a></li>
        <li style="width: 100px;"><a href="${pageContext.request.contextPath}/jsp/createandrelease.jsp">创建会议</a></li>
        <li style="width: 100px;"><a href="${pageContext.request.contextPath}/jsp/center.jsp">个人中心</a></li>
        <li style="width: 100px;"><a href="##">消息中心</a></li>
			</ul>

			<ul class="nav navbar-nav" style="float: right;margin-right: 10px;">
				<li style="width: 80px;">
					<a href="##">
						<button type="button" class="btn btn-primary" style="font-size: 12px;">
							<span class="glyphicon glyphicon-user"></span> 登陆
						</button>
					</a>
					<li style="width: 80px;">
						<a href="##">
							<button type="button" class="btn btn-primary" style="font-size: 12px;">
								<span class="glyphicon glyphicon-eye-open"></span> 注册
							</button>
						</a>
					</li>
				</ul>

			</div>
		</div>



		<div class="container">
			<div class="row">


				<div class="qrcode-form">


					<textarea name="head_info" class="hide" id="head_info"></textarea>
					<textarea name="weixin_info" class="hide" id="weixin_info"></textarea>


<%  
                	
					Card card = (Card)request.getSession().getAttribute("mycard");
					request.getSession().setAttribute("name", card.getC_username());
					request.getSession().setAttribute("company", card.getC_company());
					request.getSession().setAttribute("position", card.getC_position());
					request.getSession().setAttribute("phone", card.getC_phone());
					request.getSession().setAttribute("email", card.getC_mail());
					request.getSession().setAttribute("introduction", card.getC_introduction());
					/* request.getSession().setAttribute("officephone", card.getC_officephone()); */
					request.getSession().setAttribute("picture", card.getC_picture());
					request.getSession().setAttribute("address",card.getC_address());
					
%> 
					<form class="form-horizontal" action="${pageContext.request.contextPath}/CardAction?method=AlterCard" method="post">
					<div id="qrcode-card">
						<div class="form-tit">修改电子名片
							</div>
							<hr>
						
						

						
						<div class="form-row">
							<span class="row-th" id="lnag_cdn">姓名</span>
							<input class="form-qrtext-mini" id="text_cdn" type="text" placeholder="输入姓名" name="username" value="${name}">
							
						</div>


						<div class="form-row">
							<span class="row-th" id="lnag_cdorg">公司名称</span>
							<input class="form-qrtext-mini" id="text_cdorg" type="text" placeholder="输入公司名称" value="${company}" name="company">
							<span class="row-th" id="lnag_cdtitle">职位</span>
							<input class="form-qrtext-mini" id="text_cdtitle" type="text" placeholder="输入职称" value="${position}" name="position">
							
							</div>

							<div class="form-row">
								<span class="row-th" id="lnag_cdtel">手机</span>
								<input class="form-qrtext-mini" id="text_cdtel" type="text" placeholder="输入手机" value="${phone}" name="phone">
								<span class="row-th" id="lnag_cdtel1">工作电话</span>
								<input class="form-qrtext-mini" id="text_cdtel1" type="text" placeholder="输入工作电话" value="${officephone}" name="officephone">
							</div>


							<div class="form-row">
								<span class="row-th" id="lnag_cdemail">邮箱</span>
								<input class="form-qrtext-small" id="text_cdemail" type="text" placeholder="输入邮箱地址" value="${email}" name="email">

							</div>

							<div class="form-row">
								<span class="row-th" id="lnag_cdadr">工作地址</span>
								<input class="form-qrtext-small" id="text_cdadr" type="text" placeholder="输入工作地址" value="${address}" name="address">
							</div>

						<div class="form-row">
							<span class="row-th" id="lnag_cdnote">备注</span>
							<input class="form-qrtext-small" id="text_cdnote" type="text" placeholder="输入备注" value="${introduction}" name="introduction">
						</div>
						
					</div>

					<hr>
					
					

					<button type="button" class="btn btn-info" id="apply" data-toggle="modal" data-target="#myModal">预览</button>

					<button type="submit" class="btn btn-success" style="float: right;">提交</button>
					<!-- 表示应谨慎采取的动作 -->
					</form>
				</div>
			</div>
		</div>



		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">名片预览</h4>
					</div>
					<div class="modal-body">

						<div class="card">

							<div class="nameinfo">
								<!-- <span class="name">小明</span> -->
							</div>

							<div class="companyinfo">
								 <!-- <span class="glyphicon glyphicon-user" style="color: #FFFFF0"></span>&nbsp;
								 <span class="company1">总经理</span>
								<span class="company2">xxxxxx公司</span> -->
							</div>

							<div class="contactinfo">
								 <!-- <span class="glyphicon glyphicon-phone contact1" style="color: #FFFFF0"></span>&nbsp;手机号：
								 <span class="phonenum">18123423356</span>
								
								<span class="glyphicon glyphicon-phone-alt contact2" style="color: #FFFFF0"></span>&nbsp;工作电话：
								<span class="worknum">0748-23244</span> -->
							</div>

							<div class="emailinfo">
								
							<!-- 	<span class="glyphicon glyphicon-envelope" style="color: #FFFFF0"></span>&nbsp;
								邮箱
								<span class="email">875503176@qq.com</span> -->
							</div>

							<div class="addressinfo">
								<!-- <span class="glyphicon glyphicon-home" style="color: #FFFFF0"></span>&nbsp;
								地址
								<span class="address">湖北省武汉市武汉大学信息学部</span> -->
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

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/createcard.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/logout.js"></script>
	</body>
	</html>