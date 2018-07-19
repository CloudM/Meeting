$(document).ready(function(){

	$("#change").click(function(){
		$("#f-name").val($("#m-name").text());
		$("#f-org").val($("#m-org").text());
		$("#f-place").val($("#m-place").text());
		$("#f-guest").val($("#m-guest").text());
		$("#f-time").val($("#m-time").text());
		$("#f-longtext1").val($("#longtext1").text());
		$("#f-longtext2").val($("#longtext2").text());
	});
});