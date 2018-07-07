<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
                <img class="img" src="./images/touxiang.jpg" alt="">
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
	<div class="model release" id="release model" role="dialog" aria-labelledby="releaseModalLabel" aria-hidden="true">
		<div class="modelr-dialog">
			<div class="modelr-content">
				<div class="modelr-header">
					<button type="button" class="close" data-dismiss="modalr" aria-hidden="true">&times;</button>
                	<h4 class="modal-title" id="releaseModalLabel">请填写会议信息</h4>
				</div>
				
				<div class="modal-body">
					<from class="form-horizontal">
						<div class="form-group">
							<label class="reginfo">会议名称</label>
							<input name="meetingname" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">主办方</label>
							<input name="host" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">会议类型</label>
							<input name="meetingtype" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">出席嘉宾</label>
							<input name="guest" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">会议时间</label>
							<input name="meetingtime" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">会议地点</label>
							<input name="place" type="text" class="form-control" id="inputEmail4">
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">会议介绍</label>
							<textarea name="description" rows="8" cols="180"></textarea>
							<i class="fa fa-user"></i>
						</div>
						
						<div class="form-group">
							<label class="reginfo">备注</label>
							<textarea name="remark" rows="8" cols="180"></textarea>
							<i class="fa fa-user"></i>
						</div>
							
							
						</div>
						</div>
					</from>
				</div>
				
				<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button name="CreateMeeting" type="button" class="btn btn-primary">创建会议</button>
            </div>
			</div>
			
		</div>
	</div>

</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</body>
</html>