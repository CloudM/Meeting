$(document).ready(function(){

	$("#apply").click(function(){

		var text_cdn = $("#text_cdn").val();
		
		$(".nameinfo").append("<span class=\"name\">"+text_cdn+"</span>");

		var text_cdtitle = $("#text_cdtitle").val();
	
		$(".companyinfo").append("<span class=\"glyphicon glyphicon-user\" style=\"color: #FFFFF0\"></span>&nbsp;<span class=\"company1\">"+text_cdtitle+"</span>");

		var text_cdorg = $("#text_cdorg").val();
		
		$(".companyinfo").append("<span class=\"company2\">"+text_cdorg+"</span>");

		var text_cdtel = $("#text_cdtel").val();
		
		$(".contactinfo").append("<span class=\"glyphicon glyphicon-phone contact1\" style=\"color: #FFFFF0\"></span>&nbsp;手机号：<span class=\"phonenum\">"+text_cdtel+"</span>");

		var text_cdtel1 = $("#text_cdtel1").val();
		
		$(".contactinfo").append("<span class=\"glyphicon glyphicon-phone-alt contact2\" style=\"color: #FFFFF0\"></span>&nbsp;工作电话：<span class=\"worknum\">"+text_cdtel1+"</span>");

		var text_cdemail = $("#text_cdemail").val();
		
		$(".emailinfo").append("<span class=\"glyphicon glyphicon-envelope\" style=\"color: #FFFFF0\"></span>&nbsp;邮箱：<span class=\"email\">"+text_cdemail+"</span>");

		var text_cdadr = $("#text_cdadr").val();
		
		$(".addressinfo").append("<span class=\"glyphicon glyphicon-home\" style=\"color: #FFFFF0\"></span>&nbsp;地址：<span class=\"address\">"+text_cdadr+"</span>");
	});

	$('#myModal').on('hide.bs.modal', function () {
		
		$(".nameinfo").empty();

		$(".companyinfo").empty();
				
		$(".companyinfo").empty();
		
		$(".contactinfo").empty();
		
		$(".contactinfo").empty();
		
		$(".emailinfo").empty();
		
		$(".addressinfo").empty();
	})

});