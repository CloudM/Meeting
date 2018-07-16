$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("all.do",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});