function addLi(id,src,name,position){
	var str = 
		"<a href=\"https://123.sogou.com/\"><li data-target=\"https://123.sogou.com/\" id=\""+id+"\"data-toggle=\"modal\">"+
			"<div class=\"left_part\">"+
				"<img class=\"image\" src=\""+src+"\">"+
			"</div>"+
			"<div class=\"right_part\">"+
				"<p class=\"name\">"+name+"</p>"+
				"<p class=\"position\">"+position+"</p>"+
			"</div>"+
		"</li></a>";
	$(".people_list").append(str);
}
function addDiv(){
	$(".chat_container").empty();
	var str = "<div class=\"file\" id=\"file\">"+
	"<form action=\"../UploadHandleServlet\" enctype=\"multipart/form-data\" method=\"post\">"+
	"<span class=\"btn_file_choose\ id=\"chooseFile\">"+
		"<input type=\"file\" name=\"file\" id=\"file1\">"+
	"</span>"+
	
	"<span id=\"fileCheck\" class=\"check\">"+"检验上传文件是否已经存在"+"</span>"+
	
	"<span class=\"btn_file_upload\">"+
		"<input type=\"submit\" value=\"up\">"+
	"</span>"+
	"</form>"+
"</div>"+

"</div>"+
"<button onclick=\"getFileList()\">"+"刷新文件列表"+"</button>"+
"<div class=\"loadlist\" id=\"loadlist\">"+

	"<!-- 遍历Map集合 -->"+
    "<c:forEach var=\"me\" items=\""+map+"\">"+
        "<c:url value=\"/DownloadServlet\">"+
            "<c:param name=\"filename\" value=\"${me.key}\">"+
            "</c:param>"+
    	"</c:url>"+
    	"<div><c:out value=\"${me.value}\"></div>"+
    	"<a href=\""+url+"\">"+"下载"+"</a>"+
    	"<br/>"+
	"</c:forEach>"+
"</div>";
	$(".chat_container").append(str);
}



function fileAdd(src,name,time,size,uploader){
	var str = 
		
		"<li class=\"file_block\">"+
				"<img class=\"file_type\" src=\""+src+"\">"+
				"<div class=\"file_name\">"+name+"</div>"+
				"<div class=\"file_upload_time\">"+time+"</div>"+
				"<div class=\"file_size\">"+size+"</div>"+
				"<div class=\"file_uploader\">"+uploader+"</div>"+
				"<a href=\"${downurl}\"><img class=\"download\" src=\"../images/download_new.jpg\"></a>"+
			"</li>";
	$(".file_list").append(str);
}



function addMain(){
	$(".chat_container").empty();
	var str = "<p class=\"meetingname\" id=\"meetingname\" name=\"meetingname\">黑坤批斗大会</p>"+
			"<p class=\"meetinghost\" id=\"meetinghost\" name=\"meetinghost\">CloudM</p>";
	$(".chat_container").append(str);
}
function addShare(result){
	var str = "<div class=\"share_card\">"+
		"<p>名片墙</p>"+
		"<button class=\"btn_share\" type=\"\" value=\""+result+"\" id=\"share_cancle\">"+result+"</button>"+
		"</div>";
	$(".chat_container").append(str);
}
function addCard(id,value,classname,name,position,company,phoneNum,email,address){
	
	var str = ""+
	"<div class=\"card_front\" value=\""+value+"\">"+
	"	<div class=\"nameinfo_front\" data-toggle=\"modal\" data-target=\"#cardpannel\">"+
	"		<span class=\"username_front\" id=\"name_simple\">"+name+"</span>"+
	"	</div>		"+		
	"	<div class=\"companyinfo_front\" data-toggle=\"modal\" data-target=\"#cardpannel\">"+
	"		<span class=\"glyphicon glyphicon-user\" style=\"color: #FFFFF0\"></span>&nbsp;"+
	"		<span class=\"company1_front\">"+position+"</span><br>"+
	"		<span class=\"company2_front\">"+company+"</span>"+ 
	"	</div>"+
	"	<div class=\"card-footer\">"+
	"		<button type=\"button\" class=\"btn_collect\" id=\""+id+"\" data-dismiss=\"modal\">收藏</button>"+
	"	</div>"+
	"</div>";

	$("."+classname).append(str);
}
function card(){
	var r = confirm("是否收藏名片？");
	if(r==true){
		
	}else{
		
	}
}

function getFileList()
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
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			//window.location.reload();
	    }
	}
	xmlhttp.open("POST","../ListFileServlet", true);
	xmlhttp.send(null);
	console.log("ggggggg");
}

function rpajax(url,Return_Function){
    var email = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
    email.open("POST",url,true);
    email.onreadystatechange=function()
	{
		if (email.readyState == 4&&email.status == 200)
		{
			respText = email.responseText;
			Return_Function(respText);
		}
	}
	email.send();
}

window.onload = function(){
	
	var num_people = 13;
	var num_file = 10;
	var src_people = "../images/people.png";
	var src_file_type = "../images/word.png";
	var id = new Array();
	var name = new Array();
	var position = new Array();
	var file_name = new Array();
	var file_upload_time = new Array();
	var file_size = new Array();
	var file_uploader = new Array();
	for(var i = 0; i<num_people; i++){
		id[i] = "id"+i;
		name[i] = "name"+i;
		position[i] = "position"+i;
		file_name[i] = "file_name"+i;
		file_upload_time[i] = "2018-07-"+i;
		file_size[i] = i+"KB";
		file_uploader[i] = "uploader"+i;
	}
	for(var i = 0; i<num_people; i++){
		addLi(id[i],src_people,name[i],position[i]);
	}
	
	if(num_people>12){
		$(".people").css("overflow-y","scroll");
	}
	
	$(".btn_checkin").click(function (){
		$("#id0").css("background-color","#FFFFFF");
		$("#id0 p").css("color","#000000");
		$("#id0 img").attr("src","../images/people_online.png");
	});
	
	$(".load").click(function (){
		$(".function_ul li").css("background-color","#FFFFFF");
		$(".load").css("background-color","#B0C4DE");
		addDiv();
		getFileList();
		
//		for(var i = 0; i<num_file; i++){
//			fileAdd(src_file_type,file_name[i],file_upload_time[i],file_size[i],file_uploader[i]);
//		}
//		
		$(".btn_flash").attr("class","btn_flash");
		$(".loadlist").attr("class","loadlist");
		
		var fileArea = document.getElementById("file1");
	    
		//console.log(fileArea.value);
	    fileArea.onmouseover = function(){
	    	var file1 = document.getElementById("file1").value;
	    	var num = file1.lastIndexOf('\\');
	    	var file1Name = file1.substring(num + 1);
	    	 console.log("s");
	    	file1Name = encodeURIComponent(encodeURIComponent(file1Name));
	    	if(file1Name != ""){
		        rpajax("../FileCheckAction?file1Name=" + file1Name, function(data){
		            var fileCheck = document.getElementById("fileCheck");
		            if(data == "no")
		            {
		            	fileCheck.innerHTML = "文件列表中尚无此文件";
		            	fileCheck.style.color = "blue";
		            }
		            else if(data == "exist")
		            {
		            	fileCheck.innerHTML = "文件列表中已经存在此文件 ，点击【上传】即可覆盖";
		            	fileCheck.style.color = "red";
		            }
		        });
	    	}
	    }
		
	});
	$(".main").click(function (){
		$(".function_ul li").css("background-color","#FFFFFF");
		$(".main").css("background-color","#B0C4DE");
		addMain();
	});
	$(".btn_sign").click(function (){
		$(".function_ul li").css("background-color","#FFFFFF");
		$(".btn_sign").css("background-color","#B0C4DE");
	});
		//名片墙
	$(".btn_card").click(function(){
		$(".function_ul li").css("background-color","#FFFFFF");
		$(".chat_container").empty();
		$(".btn_card").css("background-color","#B0C4DE");
		
		$.ajax({url:"../ShareCardButton",success:function(result){
			addShare(result);
			console.log(result);
	    }});
		
		
		
		
		var id = new Array();
		var value = new Array;
		var classname = new Array();
		var company = new Array();
		var phoneNum = new Array();
		var email = new Array();
		var address = new Array();
		var sex = new Array();
		var introduction = new Array();
		var position = new Array();
		var company = new Array();
		var hobby = new Array();
		var picture = new Array();
		
		console.log("s");
		$.getJSON("../CardWall",function(cardlist_json){
			var num = cardlist_json.length;
			var row = Math.ceil(num/4);
			var other = num%4;
			if(row>3)
				$(".chat_container").css("overflow-y","scroll");
			console.log(cardlist_json.length);
		for(var i = 0; i<num; i++){
			id[i] = cardlist_json[i].cardid;
			value[i] = i;
			name[i] = cardlist_json[i].username;
			email[i] = cardlist_json[i].mail;
			phoneNum[i] = cardlist_json[i].phone;
			picture[i] = cardlist_json[i].picture;
			address[i] = cardlist_json[i].address;
			sex[i] = cardlist_json[i].sex;
			introduction[i] = cardlist_json[i].introduction;
			position[i] = cardlist_json[i].position;
			company[i] = cardlist_json[i].company;
    		hobby[i] = cardlist_json[i].hobby;
		}
		for(var i = 0; i<row; i++){
			$(".chat_container").append("<div class=\"card_"+i+"\"></div>");
			classname[i] = "card_"+i;
			$(".card_"+i).css("height","28%");
			$(".card_"+i).css("display","flex");
			$(".card_"+i).css("flex-direction","row");
		}
		if(num<=3){
			for(var i = 0; i<num; i++){
				addCard(id[i],value[i],classname[0],name[i],position[i],company[i],phoneNum[i],email[i],address[i]);
			}
		}else{
			for(var i = 0; i<4; i++){
				addCard(id[i],value[i],classname[0],name[i],position[i],company[i],phoneNum[i],email[i],address[i]);
			}
			for(var i = 1; i<row; i++){
				if(i!=row-1||other==0){
					for(var j = 0; j<4; j++){
						var x = 4*i+j;
						addCard(id[x],value[x],classname[i],name[x],position[x],company[x],phoneNum[x],email[x],address[x]);
					}
				}
				else{
					for(var j = 0; j<other; j++){
						var x = 4*i+j;
						addCard(id[x],value[x],classname[i],name[x],position[x],company[x],phoneNum[x],email[x],address[x]);
					}
				}
			}
		}
		
		console.log(num);
		
		for(var i = 0; i<num; i++){
        	
			//document.getElementById(cardlist_json[i].cardid).onload=function(){
			//	if($(this).html()=="收藏"){url:"../CheckCollectedCard?cardid="+cardlist_json[i].cardid
			
			$.getJSON("../CheckCollectedCard?cardid="+cardlist_json[i].cardid,function(cl){
        				console.log("hhhhhh");
        				
        				//alert(cl);
            			if(cl.collect==2){
            				
            		$("#"+cl.cardid).html("已收藏");
        			$("#"+cl.cardid).css("cursor","default");
        			$("#"+cl.cardid).css("background-color","gray");}
            			
			});
			
        	$(".btn_collect").click(function(){
        		if($(this).html()=="收藏"){
        			
        			$.ajax({url:"../CardAction?method=CollectCard&cardid="+this.id,success:function(result){
            			//window.location.href='center-card-other.jsp';
            			//console.log("hhhhhh");
        			}});
        			$(this).html("已收藏");
        			$(this).css("cursor","default");
        			$(this).css("background-color","gray");
        		}
        		
        	    console.log(this.id)
        	});
        }
		
		$(".card_front").click(function(){
			var i = $(this).attr("value");
			$("#username").html(name[i]);
			$(".company1").html(position[i]);
			$(".company2").html(company[i]);
			$(".phonenum").html(phoneNum[i]);
			$(".worknum").html(sex[i]);
			$(".email").html(email[i]);
			$(".address").html(address[i]);
		});

		$(".btn_share").click(function(){
			var share = document.getElementById("share_cancle").value;
			console.log("hhh"+share);
			if(share=="取消分享"){
				$.ajax({url:"../ShareCard?method="+share,success:function(result){
					console.log(00000);
			    }});
			}else{
				$.ajax({url:"../ShareCard?method="+share,success:function(result){
					console.log(00000);
				}});	
			}
		});
		
	});
	});
	
   
}


