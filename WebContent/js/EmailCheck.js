window.onload=function(){
	
    var txtEmail= document.getElementById("inputEmail2");
    //onblur：焦点离开触发onblur事件
    txtEmail.onblur = function(){
        //var email = txtEmail.value;
        var email = this.value;
        console.log("执行onblur");
        rpajax("EmailCheckAction?email=" + email, function(data){
            var msg = document.getElementById("msg");
          
            console.log("发送请求");
            var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
            if(!myReg.test(email))
            {
            	msg.innerHTML = "邮箱格式错误 ";
                msg.style.color = "red";
            }
            else if(data == "error")
            {
                msg.innerHTML = "邮箱已注册 ";
                msg.style.color = "red";
            }
            else if(data == "secCode")
            {
            	msg.innerHTML = "您需要输入您收到的验证码";
            	msg.style.color = "blue";
            }
            else{
            	msg.innerHTML = "";
            }
        });
    }
}