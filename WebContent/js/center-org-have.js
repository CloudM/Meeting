$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("released.do",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});