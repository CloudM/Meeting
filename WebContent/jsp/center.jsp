<%@ page language="java" import="com.entity.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   
   <script type="text/javascript">
	    function logout()
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
	    		if (xmlhttp.readyState==4)
	    	    {
	    			window.open("index.jsp","_self").close();
	    	    }
	    	}
	    	xmlhttp.open("POST","LogoutServlet", true);
	    	xmlhttp.send();
	    }
    </script>     
   
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



    <div class="container" id="container1">

      <div class="user-info clearfix">
        <div class="user-pic" data-is-fans="" data-is-follows="">
          <div class="user-pic-bg">
            <img class="img" src="../images/touxiang.jpg" alt="">
          </div><!--user-pic-big end-->           
        </div>

        <div class="user-info-right">
          <h3 class="user-name clearfix">
            <span>${User.uname}</span>
        </h3>
        <!--25-->
        <p class="about-info">
        <span>${User.sex}</span>
        <span>${User.city}</span>
        <span>${User.job}</span>
          </p>
        </div>


      </div>    

    </div>

    <div class="container">
      <div class="row">
        <div class="col-xs-2">
         <div class="nav1">
        <div class="nav-top">
            <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)"><img src="./images/mini.png" ></div>
        </div>

        <ul>
           <li class="nav-item">
            <a href="center.html"><i class="fa fa-user-circle fa-lg"></i><span>个人信息</span></a>
          </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-calendar fa-lg"></i><span>我参加的会议</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="center-attend-wait.html"><span>待审核</span></a></li>
                    <li><a href="center-attend-to.html"><span>待参加会议</span></a></li>
                    <li><a href="center-attend-have.html"><span>已参加会议</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-gg-circle fa-lg"></i><span>我发布的会议</span><i class="my-icon nav-more"></i></a>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-org-script.jsp"><span>草稿箱</span></a></li>
                    <li><a href="center-org-have.html"><span>已发布会议</span></a></li>
                    <li><a href="center-org-fini.html"><span>已完成会议</span></a></li>
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

                    <form class="form-horizontal" action="${pageContext.request.contextPath}/ResetUserServlet" method="post">
                <div class="form-group">
                    <label class="reginfo">用户名</label>
                    <input name="userName" type="email" class="form-control1" id="inputEmail3" value=${User.uname}>
                    <i class="fa fa-user"></i>
                </div>
                <%  
                	User user = (User)request.getSession().getAttribute("User");
                    String year = null;
                    String month = null;
                    String date = null;
	                if(user.getBirthday() != null){
	                	String[] birthday = user.getBirthday().split(" ");
	                	if(birthday.length == 3) {
	                    	year = birthday[0];
	                    	month = birthday[1];
	                    	date = birthday[2];
	                    }
	                }
                	request.getSession().setAttribute("year", year);
                	request.getSession().setAttribute("month", month);
                	request.getSession().setAttribute("date", date);
                %>
                <div class="form-group">
   
                <label class="reginfo">生日</label>
			        <div class="group birth">
			        <div class="txt">
			            <div class="year sel">
			                <input name="year" type="text" placeholder="请选择年" readOnly data-id='1' value=${year}>
			                <ul>
			                </ul>
			            </div>
			            <div class="mon sel">
			                <input name="month" type="text" placeholder="请选择月" readOnly data-id='1' value=${month}>
			                <ul>
			                </ul>
			            </div>
			            <div class="date sel">
			                <input name="date" type="text" placeholder="请选择日" readOnly data-id='1' value=${date}>
			                <ul>
			                </ul>
			            </div>
			        </div>
			        <p></p>
			    </div>
                     </div>
                
                
                <div class="form-group">
                    <label class="reginfo">密码</label>
                    <input name="upwd" type="text" class="form-control1" id="inputEmail3" value=${User.upwd}>
                    <i class="fa fa-user"></i>
                </div>
                
                <div class="form-group">
                    <label class="reginfo">性别</label>
                    <input name="sex" type="text" class="form-control1" id="inputEmail3" value=${User.sex}>
                    <i class="fa fa-user"></i>
                </div>
                
                <div class="form-group">
                    <label class="reginfo">电话号码</label>
                    <input name="phoneNumber" type="text" class="form-control1" id="inputEmail3" value=${User.phoneNumber}>
                    <i class="fa fa-user"></i>
                </div>
                
                <div class="form-group">
                    <label class="reginfo">职位</label>
                    <input name="job" type="text" class="form-control1" id="inputEmail3" value=${User.job}>
                    <i class="fa fa-user"></i>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">城市</label>
                    <input name="city" type="text" class="form-control1" id="inputPassword3" value=${User.city}>
                    <i class="fa fa-lock"></i>
                </div>
                    
                <div class="form-group">
                    <label class="reginfo">爱好</label>
                    <input name="hobby" type="text" class="form-control1" id="inputEmail3" value=${User.hobby}>
                    <i class="fa fa-user"></i>
                </div>
                
                <div class="form-group">
                    <label class="reginfo">座右铭</label>
                    <input name="Motto" type="text" class="form-control1" id="inputEmail3" value=${User.motto}>
                    <i class="fa fa-user"></i>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit"  class="btn btn-primary">提交</button>
                </div>
            </form>
              </div><!-- /.modal-content -->
            </div><!-- /.modal -->
          </div>

        </div>
        <div class="line"></div>

        <div class="info-wapper">
          <div class="info-box clearfix">
            <label class="pull-left">用户名</label>
            <div class="pull-left">${User.uname}</div>
          </div>

          <div class="info-box clearfix">
            <label class="pull-left">邮箱</label>
            <div class="pull-left">${User.UEmail}</div>
          </div>

          <div class="info-box clearfix">
            <label class="pull-left">生日</label>
            <div class="pull-left">1998.5.19</div>
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

<script type="text/javascript" src="./js/birth.js"></script>

<script type="text/javascript" src="./js/nav.js"></script>
</body>
</html>