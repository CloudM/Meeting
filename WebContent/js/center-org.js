
//document.write("<script src='manageMlist.js'></script>");
$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("created.do",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});