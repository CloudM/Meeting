
function addLi(id, name, mail, phone, picture, age, sex, introduction, 
		position, company, hobby){
	var str = "<li data-toggle=\"modal\" data-target=\"#cardpannel\">"+  
        "<div class=\"leftpart\">"+
          "<span class=\"time-info\">"+picture+"</span>"+
        "</div>"+
        "<div class=\"rightpart\">"+
          "<span class=\"name-info\">"+name+"</span>"+  
          "<p>"+
           "<span class=\"glyphicon glyphicon-user\"></span><br>"+
           "<span class=\"mail-info\">"+mail+"</span>"+
           "<br>"+
           "<span class=\"phone-info\">"+phone+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+age+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+sex+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+introduction+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+position+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+company+"</span>"+
		   "<br>"+
           "<span class=\"phone-info\">"+hobby+"</span>"+
          "</p>  "+
       "</div>"+
	"</li>";
	
	$(".card-list").append(str);

}

function addValue(num,list){
	var id = new Array();
	var name = new Array();
	var mail = new Array();
	var phone = new Array();
	var picture = new Array();
	var age = new Array();
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
		age[i] = list[i][5];
		sex[i] = list[i][6];
		introduction[i] = list[i][7];
		position[i] = list[i][8];
		company[i] = list[i][9];
		hobby[i] = list[i][10];
	}
	
	for(var i=0;i<num;i++){
		addLi(id[i], name[i], mail[i], phone[i], picture[i], age[i], sex[i],
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
        		list[i][5] = cardlist_json[i].age;
        		list[i][6] = cardlist_json[i].sex;
        		list[i][7] = cardlist_json[i].introduction;
        		list[i][8] = cardlist_json[i].position;
        		list[i][9] = cardlist_json[i].company;
        		list[i][10] = cardlist_json[i].hobby;
        	}
        	addValue(row,list);
        	//添加到模态框
        	$("li").click(function(){	
    			$(".name").append($(this).children().eq(1).children().eq(0).html());
    			$(".mail").append($(this).children().eq(1).children().eq(1).childre().eq(1).html());
    			$(".phone").append($(this).children().eq(1).children().eq(1).childre().eq(2).html());
    			$(".picture").append($(this).children().eq(0).children().html());
    			$(".age").append($(this).children().eq(1).children().eq(1).childre().eq(3).html());
    			$(".sex").append($(this).children().eq(1).children().eq(1).childre().eq(4).html());
    			$(".introduction").append($(this).children().eq(1).children().eq(1).childre().eq(5).html());
    			$(".position").append($(this).children().eq(1).children().eq(1).childre().eq(6).html());
    			$(".company").append($(this).children().eq(1).children().eq(1).childre().eq(7).html());
    			$(".hobby").append($(this).children().eq(1).children().eq(1).childre().eq(8).html());
        	});
        	//模态框不显示时删除数据
        	$("#cardpannel").on('hide.bs.modal', function () {
        		$(".card").empty();
        	})
                
                console.log("c");
        });
  //  });
});