function addLi(id,src,title,time,type){
	var meetlist = document.getElementById("tomlist");
	var li = document.createElement("li");
	li.setAttribute("id",id);
	meetlist.appendChild(li);
	
	var newli = document.getElementById(id);
	var img = document.createElement("img");
	img.src = src;
	var h3 = document.createElement("h3");
	h3.innerHTML=title;
	var p2 = document.createElement("p");
	p.innerHTML=time; 
	var p1 = document.createElement("p");
	p.innerHTML=type; 
	var a = document.createElement("a");
	a.src = src;
	
	newli.appendChild(img);
	newli.appendChild(h3);
	newli.appendChild(p1);
	newli.appendChild(p2);
}

window.onload = function(){

	var Mlist="<%=Mlist%>";
	var num="<%=count%>";
	var src = "../images/logo1.png";

	var id = new Array();
	for(var i = 0; i<num; i++){
		id[i] = Mlist.get(i).getMid;
	}
	
	var name = new Array();
	for(var i = 0; i<num; i++){
		name[i] = Mlist.get(i).getMname;
	}
	
	var type = new Array();
	for(var i = 0; i<num; i++){
		type[i] = Mlist.get(i).getTypeid;
	}
	
	var time = new Array();
	for(var i = 0; i<num; i++){
		time[i] = Mlist.get(i).getStartTime;
	}
	
	for(var i=0;i<num;i++){
		addLi(id[i],src,name[i],time[i],type[i]);
	}
	
}