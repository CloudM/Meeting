<%@ page language="java" import="com.entity.Meeting" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发布会议详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">  
    <link href="../css/public.css" rel="stylesheet" type="text/css"> 
    <link href="../css/center.css" rel="stylesheet" type="text/css">   
    <link href="../css/confirm.css" rel="stylesheet" type="text/css">   

    
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
        <li style="width: 100px;"><a href="##">所有会议</a></li>
        <li style="width: 100px;"><a href="##">创建会议</a></li>
        <li class="active" style="width: 100px;"><a href="##">个人中心</a></li>
        <li style="width: 100px;"><a href="##">消息中心</a></li>
      </ul>

      <ul class="nav navbar-nav" style="float: right;margin-right: 40px;">
        <li style="width: 80px;">
          <a href="##">
            <button type="button" class="btn btn-danger" style="font-size: 12px;">
              <i class="fas fa-sign-out-alt"></i> 退出登陆
            </button>
          </a>
        </ul>

      </div>
    </div>

        <div class="container">

            <div class="row">  

                <div class="col-xs-5">
                    
<div class="course-wrapl">

 <%
					if((Meeting)request.getSession().getAttribute("Meeting")!=null){
					Meeting meeting=(Meeting)request.getSession().getAttribute("Meeting");
					String Name=meeting.getMname();
					String Host=meeting.getHost();
					//int type=meeting.getTypeid();
					String Guest=meeting.getGuest();
					String Time=meeting.getStartTime();
					String Place=meeting.getPlace();
					String Introduction=meeting.getDescribe();
					String Remarks=meeting.getRemarks();
					int typeID=meeting.getTypeid();
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
					
					request.getSession().setAttribute("name", Name);
					request.getSession().setAttribute("host", Host);
					request.getSession().setAttribute("guest", Guest);
					request.getSession().setAttribute("time", Time);
					request.getSession().setAttribute("place", Place);
					request.getSession().setAttribute("introduction", Introduction);
					request.getSession().setAttribute("remarks", Remarks);
					request.getSession().setAttribute("type", type);
					}else{
						request.getSession().setAttribute("name", null);
						request.getSession().setAttribute("host", null);
						request.getSession().setAttribute("guest", null);
						request.getSession().setAttribute("time", null);
						request.getSession().setAttribute("place", null);
						request.getSession().setAttribute("introduction", null);
						request.getSession().setAttribute("remarks", null);
						request.getSession().setAttribute("type", null);
					}
					//request.getSession().setAttribute("name", Name);
					%> 
<div class="info">
    <div class="common-title">
                会议信息
                <a class="pull-right js-edit-info" href="javascript: void(0);" id="change">
                 <label class="reg" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">修改</label>
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
                <form class="form-horizontal" action="${pageContext.request.contextPath}/CreateAndReleaseMeeting?doPost" method="post">

                   <div class="form-group">
                            <label class="reginfo">会议名称</label>
                           <input type="text" class="form-control1" id="f-name" name="name" placeholder="输入会议名">
                        </div>

                        <div class="form-group">
                            <label class="reginfo">主办方</label>
                            <input type="text" class="form-control1" id="f-org" name="host"placeholder="输入主办方">
                        </div>

                        <div class="form-group">
                            <label class="reginfo">会议类型</label>
                            <select name="type" class="form-control">
                                <option value="yantaohui">研讨会</option>
                                <option value="luntan">论坛</option>
                                <option value="zuotanhui">座谈会</option>
                                <option value="taolunhui">专题讨论会</option>
                                <option value="jiangzuo">讲座</option>
                                <option value="bianlunhui">辩论会</option>
                                <option value="else">其他</option>
                            </select>
                        </div>

                      <div class="form-group">
                            <label class="reginfo">出席嘉宾</label>
                            <input type="text" class="form-control1" id="f-guest"  name="guest" placeholder="输入出席嘉宾">
                        </div>

                        <div class="form-group">
                            <label class="reginfo">会议时间</label>
                            <input type="textl" class="form-control1" id="f-time" name="time" placeholder="输入会议时间">
                        </div>

                        <div class="form-group">
                            <label class="reginfo">会议地点</label>
                            <input type="text" class="form-control1" id="f-place" name="place" placeholder="输入会议地点">
                        </div>
        
                        <div class="form-group">
                            <label class="reginfo">会议介绍</label>
                            <textarea rows="5" class="form-control" id="f-longtext1" cols="70" name="introduction"></textarea>
                            <i class="fa fa-user"></i>
                        </div>
                
                        <div class="form-group">
                            <label class="reginfo">备注信息</label>
                            <textarea rows="5" class="form-control" id="f-longtext2" cols="70" name="remarks"></textarea>
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                  <button type="submit" name="create" class="btn btn-primary">提交</button>
                </div>

</form>

                </div>

                
              </div><!-- /.modal-content -->
            </div><!-- /.modal -->
          </div>

        </div>
        <div class="line"></div>

     <div class="info-wapper">
                <div class="info-box clearfix">
                    <label class="pull-left">会议名</label>
                    <div class="pull-left" id="m-name">${name}</div>
                </div>

                <div class="info-box clearfix">
                    <label class="pull-left">主办方</label>
                    <div class="pull-left" id="m-org">${host}</div>
                </div>

                <div class="info-box clearfix">
                    <label class="pull-left">会议类型</label>
                    <div class="pull-left">${type}</div>
                </div>

                <div class="info-box clearfix">
                    <label class="pull-left">出席嘉宾</label>
                    <div class="pull-left" id="m-guest">${guest}</div>
                </div>

                <div class="info-box clearfix">
                    <label class="pull-left">会议时间</label>
                    <div class="pull-left" id="m-time">${time}</div>
                </div>

                <div class="info-box clearfix">
                    <label class="pull-left">会议地点</label>
                    <div class="pull-left" id="m-place">${place}</div>
                </div>

                 <div class="info-box clearfix">
                    <label class="pull-left">会议简介</label>
                    <div class="pull-left" id="longtext1">${introduction}
                    </div>

                <div class="info-box clearfix">
                    <label class="pull-left">备注</label>
                   <div class="pull-left" id="longtext2">${remarks}
                   </div>

            </div>


</div>



</div>


</div>
                </div>
</div>
                 <div class="col-xs-7">
                     
<div class="course-wrap">
    
     <ul class="card-list">  
       <li data-toggle="modal" data-target="#infopannel">  
        <div class="leftpart">
          <span class="name-info">小明</span>  
        </div>
        <div class="rightpart">       
          <p>
           <span class="glyphicon glyphicon-user"></span>&nbsp;
           <span class="company1-info">总经理</span>
         </p>  
        <span class="company2-info">xxxxxx公司</span>
       </div>

       <div class="opebut">
           <button type="button" class="btn btn-success" id="con1">同意申请</button>

            <button type="button" class="btn btn-warning" id="con2">拒绝申请</button>
       </div>

     </li>  


               

<div class="modal fade" id="infopannel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">申请人详情</h4>
          </div>
          <div class="modal-body">



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

          <div class="modal-footer">
            <button type="button" class="btn btn-warning" id="cancel" data-dismiss="modal">返回</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal -->
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

        <script type="text/javascript" src="../js/confirm.js"></script>
</body>
</html>