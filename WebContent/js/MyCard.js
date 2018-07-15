$(document).ready(function(){
  //  $("#ShowCard").click(function(){
    	console.log("a");
        $.getJSON("../ShowMyCard",function(cardlist_json){
        	console.log("s");
        	
        	console.log(cardlist_json.length);
                
                console.log("c");
        });
  //  });
});