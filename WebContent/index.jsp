<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <link href="css/public.css" rel="stylesheet" type="text/css">   
    <link href="css/login.css" rel="stylesheet" type="text/css">  
     <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
    <script type="text/javascript" src="js/Ajax.js"></script>
    <script type="text/javascript" src="js/EmailCheck.js"></script>
    
</head>

	<body>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <!-- .navbar-toggle样式用于toggle收缩的内容，即nav-collapse collapse样式所在元素 -->
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
       </button>
       <!-- 确保无论是宽屏还是窄屏，navbar-brand都显示 -->
    </div>
  <!-- 屏幕宽度小于768px时，div.navbar-responsive-collapse容器里的内容都会隐藏，显示icon-bar图标，当点击icon-bar图标时，再展开。屏幕大于768px时，默认显示。 -->
    <div class="collapse navbar-collapse navbar-responsive-collapse"style="text-align: center;">
        <ul class="nav navbar-nav" style="display: inline-block;float: none;">
            <a href="##" class="navbar-brand">云会议</a>
            <li class="active" style="width: 100px;"><a href="##">网站首页</a></li>
            <li style="width: 100px;"><a href="##">功能1</a></li>
            <li style="width: 100px;"><a href="##">功能2</a></li>
            <li style="width: 100px;"><a href="##">功能3</a></li>
            <li style="width: 100px;"><a href="##">功能4</a></li>
        </ul>
    </div>
</div>



<canvas id="canvas"></canvas>

<div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginAndRegister?mthod=login" method="post">
                    <span class="heading">用户登录</span>
                    
                    <div class="form-group">
                        <input name="email" class="form-control" id="inputEmail1" placeholder="用户名或电子邮件">
                        <i class="fa fa-user"></i>
                    </div>
                    
                    <div class="form-group help">
                        <input name="password" class="form-control" id="inputPassword1" placeholder="密　码">
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-question-circle"></a>
                    </div>
                    
                    <div class="form-group">                   
                        <div class="main-checkbox">
                            <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                        </div>                 
                        <span class="text">Remember me</span>
                        <div class="forget">忘记密码</div>
                        <button type="submit" class="btn btn-default">登录</button>
                        
                    </div>

                    <span class="remind">                      
                        <div class="rem">没有账号? 
                            <label class="reg" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">注册</label>
                        </div>
                    </span>

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
                <h4 class="modal-title" id="myModalLabel">请输入注册信息</h4>
            </div>
            <div class="modal-body">

            <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginAndRegister?mthod=register2" method="post">
                <div class="form-group">
                    <label class="reginfo">注册邮箱</label>
                    <input type="email" name="email" class="form-control1" id="inputEmail2" placeholder="输入邮箱地址">
                    <i class="fa fa-user"></i>
                </div>
                <span id="msg" class="check">注册邮箱检验</span>
                
                <div class="form-group">
                    <label class="reginfo">用户名</label>
                    <input type="text" name="userName" class="form-control1" id="inputUserName2" placeholder="输入用户名">
                    <i class="fa fa-user"></i>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">密码</label>
                    <input type="password" name="password" class="form-control1" id="inputPassword2" placeholder="输入密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">确认密码</label>
                    <input type="password" class="form-control1" id="inputPassword3" placeholder="确认密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <label class="reginfo">验证码</label>
                    <input type="text" name="secCode" class="form-control1" id="inputPassword4" placeholder="输入验证码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                    <button type="button" onclick="sendSecCode()">发送验证码</button>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="submit" class="btn btn-primary">提交</button>
	            </div>
            </form>
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

<script src="js/index.js"></script>
</body>
</html>