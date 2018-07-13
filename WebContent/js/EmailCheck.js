window.onload=function(){
	
    var txtEmail= document.getElementById("inputEmail2");
    //onblur：焦点离开触发onblur事件
    txtEmail.onblur = function(){
       // var email = txtEmail.value;
        var email = this.value;
        console.log("执行onblur");
        rpajax("EmailCheckAction?email="+email,function(data){
            var msg = document.getElementById("msg");
          
            console.log("发送请求");
            if(data=="ok")
            {
                msg.innerHTML = "邮箱可用";
                msg.style.color = "green";
            }
            else if(data=="error")
            {
                msg.innerHTML = "邮箱已注册 ";
                msg.style.color = "red";
            }
        });
    }
}