
function addLi(id, name, mail, phone, picture, address, sex, introduction, 
		position, company, hobby){
	var str = "<li data-toggle=\"modal\" data-target=\"#cardpannel\">"+  
    "<div class=\"leftpart\">"+
		"<span class=\"name-info\">"+name+"</span>"+  
    "</div>"+
    "<div class=\"rightpart\">"+
      "<span class=\"time-info\" value=\""+picture+"\"></span>"+
      "<p>"+
       "<span class=\"glyphicon glyphicon-user\"></span>"+
       "<span class=\"mail-info\" value=\""+mail+"\"></span>"+
       "<span class=\"phone-info\" value=\""+phone+"\"></span>"+
       "<span class=\"phone-info\" value=\""+address+"\"></span>"+
       "<span class=\"phone-info\" value=\""+sex+"\"></span>"+
       "<span class=\"phone-info\" value=\""+introduction+"\"></span>"+
       "<span class=\"phone-info\">"+position+"</span>&nbsp;&nbsp;"+
       "<span class=\"phone-info\">"+company+"</span>"+
       "<span class=\"phone-info\" value=\""+hobby+"\"></span>"+
      "</p>  "+
   "</div>"+
"</li>"+
   "<button type=\"button\" id=\""+id+"\">"+"取消收藏"+"</button>";

	
	$(".card-list").append(str);
	
	
	
	var rightheight=$(".col-xs-10").outerHeight();
    $(".col-xs-2").css("height",rightheight);

}

function addValue(num,list){
	var id = new Array();
	var name = new Array();
	var mail = new Array();
	var phone = new Array();
	var picture = new Array();
	var address = new Array();
	var sex = new Array();
	var introduction = new Array();
	var position = new Array();
	var company = new Array();
	var hobby = new Array();
	
	for(var i = 0; i<num; i++){
		id[i] = list[i][0];
		name[i] = list[i][1];
		mail[i] = list[i][2];
		phone[i] = list[i][3];
		picture[i] = list[i][4];
		address[i] = list[i][5];
		sex[i] = list[i][6];
		introduction[i] = list[i][7];
		position[i] = list[i][8];
		company[i] = list[i][9];
		hobby[i] = list[i][10];
	}
	
	for(var i=0;i<num;i++){
		addLi(id[i], name[i], mail[i], phone[i], picture[i], address[i], sex[i],
			introduction[i], position[i], company[i], hobby[i]);
	}
}

$(document).ready(function(){
  //  $("#ShowCard").click(function(){
    	console.log("a");
        $.getJSON("../ShowOtherCard",function(cardlist_json){
        	console.log("s");
        	
        	var list = new Array();
        	var row = cardlist_json.length;
        	
        	for(var i = 0; i<row; i++){
        		list[i] = new Array();
        		list[i][0] = cardlist_json[i].cardid;
        		list[i][1] = cardlist_json[i].username;
        		list[i][2] = cardlist_json[i].mail;
        		list[i][3] = cardlist_json[i].phone;
        		list[i][4] = cardlist_json[i].picture;
        		list[i][5] = cardlist_json[i].address;
        		list[i][6] = cardlist_json[i].sex;
        		list[i][7] = cardlist_json[i].introduction;
        		list[i][8] = cardlist_json[i].position;
        		list[i][9] = cardlist_json[i].company;
        		list[i][10] = cardlist_json[i].hobby;
        	}
        	addValue(row,list);
        	//添加到模态框
        	$("li").click(function(){	
    			$(".name").append($(this).children().eq(0).children().eq(0).html());
    			$(".email").append($(this).children().eq(1).children().eq(1).children().eq(1).attr("value"));
    			$(".phonenum").append($(this).children().eq(1).children().eq(1).children().eq(2).attr("value"));
    			$(".picture").append($(this).children().eq(0).children().attr("value"));
    			$(".introduction").append($(this).children().eq(1).children().eq(1).children().eq(5).attr("value"));
    			$(".company1").append($(this).children().eq(1).children().eq(1).children().eq(6).html());
    			$(".company2").append($(this).children().eq(1).children().eq(1).children().eq(7).html());
    	});

        	//模态框不显示时删除数据
        	$("#cardpannel").on('hide.bs.modal', function () {
        		$(".name").empty();
        		$(".email").empty();
        		$(".phonenum").empty();
        		$(".picture").empty();
        		$(".introduction").empty();
        		$(".company1").empty();
        		$(".company2").empty();
        		$(".hobby").empty();
        	});
                
        	for(var i = 0; i<row; i++){
            	
            	document.getElementById(cardlist_json[i].cardid).onclick=function(){
            		$.ajax({url:"../CardAction?method=CancleCollectCard&cardid="+this.id,success:function(result){
            			window.location.href='center-card-other.jsp';
            			console.log("hhhhhh");
           	    }});
            	    console.log(this.id)
            	}

         
            }
         
            
    });

});