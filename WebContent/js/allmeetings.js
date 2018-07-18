function addValue(a_src,classname,src,Mname,time,Pnum,type,host){
	var str = "<div class=\"course-card-body\"><div class=\"course-card-top\">" +
				"<a class=\"course-card\" href=\""+a_src+"\" >" +
					"<img class=\"course-banner lazy\" style=\"display: inline;\" src=\""+src+"\">" +
					"<div class=\"course-label\">" +
						" <label>"+type+"</label>" +
					" </div>" +
				"</a>" +
			"</div>" +
			"<div class=\"course-card-content\">" +
				" <a class=\"course-card\" href=\""+a_src+"\" >" +
					"<h3 class=\"course-card-name\">"+Mname+"</h3>" +
				"</a>" +
				"<div class=\"clearfix course-card-bottom\">" +
					"<div class=\"course-card-info\">" +
						" <span>"+host+"</span><span>" +
						" <span class=\"glyphicon glyphicon-user\"></span>"+Pnum+"</span>" +
					"</div>" +
					"<p class=\"course-card-desc\">"+time+"</p>" +
				"</div>" +
			"</div></div>" ;
	$("."+classname).append(str);
}

function addMeeting(Mlist){
	var num = Mlist.length;
	console.log(num);
	var row = Math.ceil(num/4);
	
	var other = num%4;
	
	var classname = "course-card-container";
	var src = "../images/logo.png";
	var a_src = new Array();
	var Mname = new Array();
	var time = new Array();
	var Pnum = new Array();
	var type = new Array();
	var host=new Array();
	
	
	for(var i = 0; i<num; i++){
		a_src[i] = Mlist[i].Mid+".applyedMeeting";
		Mname[i] = Mlist[i].Mname;
		if(Mlist[i].StartTime!=null){
			time[i] = Mlist[i].StartTime;
		}
		else{
			time[i] ="时间待定";
		}
		
		type[i] = Mlist[i].Typeid;
		Pnum[i] = Mlist[i].count;
		host[i]=Mlist[i].Host;
	}
	
	if(num<=4){
		for(var i = 0; i<num; i++){
			addValue(a_src[i],classname,src,Mname[i],time[i],Pnum[i],type[i],host[i]);
		}
	}else{
		for(var i = 0; i<4; i++){
			addValue(a_src[i],classname,src,Mname[i],time[i],Pnum[i],type[i],host[i]);
		}
		for(var i = 1; i<row; i++){
			$(".meeting-list").append("<div class=\"clearfix_"+i+"\"></div>");
			$(".clearfix_"+i).append("<div class=\"course-card-container\"></div>");
			$(".clearfix_"+i).css("height","274px");
			var classname_new = "clearfix_"+i+" .course-card-container";
			if(i!=row-1||other==0){
				for(var j = 1; j<5; j++){
					var x = 4*i+j;
					addValue(a_src[i],classname_new,src,Mname[x],time[x],Pnum[x],type[x],host[x]);
				}
			}
			else{
				for(var j = 1; j<=other; j++){
					var x = 4*i+j;
					addValue(a_src[i],classname_new,src,Mname[x],time[x],Pnum[x],type[x],host[x])
				}
			}
		}
	}
}
