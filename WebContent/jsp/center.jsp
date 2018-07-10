<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="./css/public.css" rel="stylesheet" type="text/css"> 
    <link href="./css/center.css" rel="stylesheet" type="text/css">   
  
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
    <div class="row">
        <div class="col-xs-2">
            <div class="leftnave">
            <ul class="nav nav-pills nav-stacked" id="naveul">
                <li class="active" style="margin: 15px;"><a href="#info" data-toggle="tab">个人信息</a></li>
                <li style="margin: 15px;"><a href="#tom" data-toggle="tab">待参加会议</a></li>
                 <li style="margin: 15px;"><a href="jsp/createandrelease.jsp">创建会议</a></li>
                <li style="margin: 15px;"><a href="#alm" data-toggle="tab">已参加会议</a></li>
                <li style="margin: 15px;"><a href="#orm" data-toggle="tab">我发布的会议</a></li>
                <li style="margin: 15px;"><a href="#card" data-toggle="tab">名片夹</a></li>
                <li style="margin: 15px;"><a href="#mess" data-toggle="tab">消息中心</a></li>
            </ul>
            </div>
        </div>

        <div class="col-xs-10">
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="info">
                    
                    <div class="common-title">
                        个人信息
                        <a class="pull-right js-edit-info" href="javascript: void(0);"><i class="icon-note">                          
                             <label class="reg" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">编辑</label>
                        </i>
                        </a>

<!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">请输入修改信息</h4>
            </div>
            <div class="modal-body">

            <form class="form-horizontal">
                <div class="form-group">
                    <label class="reginfo">用户名</label>
                    <input type="email" class="form-control1" id="inputEmail3" placeholder="输入用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <label class="reginfo">职位</label>
                    <input type="email" class="form-control1" id="inputEmail3" placeholder="输入职位">
                    <i class="fa fa-user"></i>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">城市</label>
                    <input type="password" class="form-control1" id="inputPassword3" placeholder="输入密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">性别</label>
                    <input type="password" class="form-control1" id="inputPassword3" placeholder="确认密码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
            </form>
        
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
                       
                    </div>
                    <div class="line"></div>

                    <div class="info-wapper">
                        <div class="info-box clearfix">
                            <label class="pull-left">用户名</label>
                            <div class="pull-left">VorSonnenaufgang</div>
                        </div>

                        <div class="info-box clearfix">
                            <label class="pull-left">邮箱</label>
                            <div class="pull-left">875503176@qq.com</div>
                        </div>
                    
                        <div class="info-box clearfix">
                            <label class="pull-left">职位</label>
                            <div class="pull-left">学生</div>
                        </div>
                    
                        <div class="info-box clearfix">
                            <label class="pull-left">城市</label>
                            <div class="pull-left">武汉</div>
                        </div>

                        <div class="info-box clearfix">
                            <label class="pull-left">性别</label>
                            <div class="pull-left">男</div>
                        </div>
            
                        <div class="info-box clearfix">
                            <label class="pull-left">个性签名</label>
                            <div class="pull-left">Carpe diem.</div>
                        </div>
                    
                    </div>

                </div>
                
                <div class="tab-pane fade" id="tom">
                    <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
                    TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
                </div>
                
                <div class="tab-pane fade" id="alm">
                    <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
                    TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
                </div>

                <div class="tab-pane fade" id="orm">
                    <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
                    TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
                </div>

                <div class="tab-pane fade" id="card">
                    <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
                    TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
                </div>

                <div class="tab-pane fade" id="mess">
                    <p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和 Apple
                    TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS 是苹果的移动版本。</p>
                </div>

            </div>

<script>
    $(function () {
        $('#myTab li:eq(1) a').tab('show');
    });
</script>

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

</body>
</html>