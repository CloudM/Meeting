//document.write("<script src='center-org.js'></script>");

function addLi(id,src,href,title,time,type){
	var meetlist = document.getElementById("meetlist");
	var a = document.createElement("a");
	a.setAttribute("href",href);
	meetlist.appendChild(a);
	var li = document.createElement("li");
	li.setAttribute("id",id);
	a.appendChild(li);

	var newli = document.getElementById(id);
	var img = document.createElement("img");
	img.src = src;
	var h3 = document.createElement("h3");
	h3.innerHTML=title;
	var p1 = document.createElement("p");
	p1.innerHTML=time; 
	var p2 = document.createElement("p");
	p2.innerHTML=type; 
	
	
	newli.appendChild(img);
	newli.appendChild(h3);
	newli.appendChild(p1);
	newli.appendChild(p2);
}

function addvalue(num, list){
	//对象中的第一种属性——会议id
	var id = new Array();
	var href = new Array();
	for(var i = 0; i<num; i++){
		id[i] = list[i][0];
		href[i]=id[i]+".applyedMeeting";
	}
	//对象中的第二条属性——会议标题
	var name = new Array();
	for(var i = 0; i<num; i++){
		name[i] = list[i][1];
	}
	//对象中的第三条属性——会议类型
	var type = new Array();
	for(var i = 0; i<num; i++){
		type[i] = list[i][2];
	}
	//对象中的第四条属性——会议开始时间
	var time = new Array();
	for(var i = 0; i<num; i++){
		time[i] = list[i][3];
	}
	

	//添加数据
	var src = "./images/logo.png";
	for(var i=0;i<num;i++){
		addLi(id[i],src,href[i],name[i],time[i],type[i]);
	}
	
}

var addMeeting=function addmeeting(Mlist){
	var jsonLength = 0;
    for (var i in Mlist) {
        jsonLength++;
    }
    console.log(jsonLength);
    addvalue(Mlist);    
    var list = new Array();
	var row = jsonLength;//对象数
	
	//对象中的数据赋值到二维数组
	for(var i = 0; i<row; i++){
		list[i] = new Array();
		list[i][0] = Mlist[i].Mid;
		list[i][1] = Mlist[i].Mname;
		list[i][2] = Mlist[i].Typeid;
		list[i][3] = Mlist[i].StartTime;
	}
	addvalue(row, list);
}