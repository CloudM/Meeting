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

