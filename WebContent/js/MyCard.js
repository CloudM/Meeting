
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
        $.getJSON("../ShowMyCard",function(card_json){
        	console.log("s");
        	if(card_json=="zero"){
        		window.location.href='center-card-other.jsp';
        	}
        	else{
        		$(".name").append(card_json.username);
        		$(".company1").append(card_json.position);
        		$(".company2").append(card_json.company);
        		$(".phonenum").append(card_json.phone);
        		$(".email").append(card_json.email);
        		$(".address").append(card_json.username);
        	}
        	
        	
               console.log("c");
        });
        
        $(".btn-success").click(function(){
        	window.location.href='CreatCard.jsp';
        })
        
        $(".btn-danger").click(function(){
        	window.location.href='center-card-my1.jsp';
        })
        //console.log("c");
});