function rpajax(url,Return_Function){
    var email = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
    email.open("POST",url,true);
    email.onreadystatechange=function()
	{
		if (email.readyState==4 && email.status==200)
		{
			respText=email.responseText;
			Return_Function(respText);
		}
	}
	email.send();
}


function sendSecCode()
{
	var Email = document.getElementById("inputEmail2").value;
	var UserName = document.getElementById("inputUserName2").value;
	var Password = document.getElementById("inputPassword2").value;
	var CPassword = document.getElementById("inputPassword3").value;
	if(Email == ""){
		alert("请输入邮箱！");
		return;
	}
	if(UserName == ""){
		alert("请输入用户名！");
		return;
	}
	if(Password == ""){
		alert("请输入密码！");
		return;
	}
	if(Password != CPassword){
		alert("两次输入的密码不一致！");
		return;
	}
	var str = "&Email=" + Email + "&UserName=" + UserName + "&Password=" + Password;
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
    		alert("验证码已发送，请及时输入");
	    }
	}
	xmlhttp.open("POST","LoginAndRegister?mthod=register1" + str, true);
	xmlhttp.send(null);
}