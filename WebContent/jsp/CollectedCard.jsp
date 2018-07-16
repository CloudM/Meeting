<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>收藏名片</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
  <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
  <link href="../css/public.css" rel="stylesheet" type="text/css"> 
  <link href="../css/createcard.css" rel="stylesheet" type="text/css"> 
  <link href="../css/center.css" rel="stylesheet" type="text/css">   
  <link rel="stylesheet" type="text/css" href="../font/iconfont.css">
  <link href="../css/nav.css" rel="stylesheet" type="text/css"> 
   
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
                    <li><a href="${pageContext.request.contextPath}/jsp/center-org-have.jsp"><span>已发布会议</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/center-org-fini.jsp"><span>已完成会议</span></a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a href="javascript:;"><i class="fa fa-address-card fa-lg"></i><span>名片夹</span><i class="my-icon nav-more"></i></a>
                <ul style="display: block;">
                    <li><a href="center-card-my.html"><span>我的名片</span></a></li>
                    <li class="active"><a href="center-card-other.html"><span>收藏名片</span></a></li>
                </ul>
            </li>


        </ul>
    </div>
        </div>

        <div class="col-xs-10">
        
 <div class="card-area">  
     <ul class="card-list">  
       <li data-toggle="modal" data-target="#cardpannel">  
        <div class="leftpart">
          <span class="time-info">2018.7.12</span>
        </div>
        <div class="rightpart">
          <span class="name-info">小明</span>  
          <p>
           <span class="glyphicon glyphicon-user"></span>&nbsp;
           <span class="company1-info">总经理</span>
           &nbsp;
           <span class="company2-info">xxxxxx公司</span>
         </p>  
       </div>

     </li>  

       <li data-toggle="modal" data-target="#cardpannel">  
        <div class="leftpart">
          <span class="time-info">2018.7.12</span>
        </div>
        <div class="rightpart">
          <span class="name-info">小明</span>  
          <p>
           <span class="glyphicon glyphicon-user"></span>&nbsp;
           <span class="company1-info">总经理</span>
           &nbsp;
           <span class="company2-info">xxxxxx公司</span>
         </p>  
       </div>

     </li>  
       <li data-toggle="modal" data-target="#cardpannel">  
        <div class="leftpart">
          <span class="time-info">2018.7.12</span>
        </div>
        <div class="rightpart">
          <span class="name-info">小明</span>  
          <p>
           <span class="glyphicon glyphicon-user"></span>&nbsp;
           <span class="company1-info">总经理</span>
           &nbsp;
           <span class="company2-info">xxxxxx公司</span>
         </p>  
       </div>

     </li>  
       <li data-toggle="modal" data-target="#cardpannel">  
        <div class="leftpart">
          <span class="time-info">2018.7.12</span>
        </div>
        <div class="rightpart">
          <span class="name-info">小明</span>  
          <p>
           <span class="glyphicon glyphicon-user"></span>&nbsp;
           <span class="company1-info">总经理</span>
           &nbsp;
           <span class="company2-info">xxxxxx公司</span>
         </p>  
       </div>

     </li>  
   </ul>  
 </div>
</div>


<div class="modal fade" id="cardpannel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">名片详情</h4>
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
                
              <!--  <span class="glyphicon glyphicon-envelope" style="color: #FFFFF0"></span>&nbsp;
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

<script type="text/javascript" src="../js/nav.js"></script>
</body>
</html>