$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("wait.searchApplyMeeting",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});