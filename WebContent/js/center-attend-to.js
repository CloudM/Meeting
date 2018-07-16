$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("to.searchApplyMeeting",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});