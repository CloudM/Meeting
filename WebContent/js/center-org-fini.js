$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("ended.do",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});