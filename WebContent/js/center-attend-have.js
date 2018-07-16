$(document).ready(function(){
	
    //$("#released").click(function(){
    	console.log("a");
        $.getJSON("have.searchApplyMeeting",function(Mlist){
        	
        	addMeeting(Mlist);
        		
        });
    //});
   
});