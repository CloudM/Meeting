function clickapply(){

    var form=document.forms[0];
    console.log("enter js");
    form.action="${pageContext.request.contextPath}/ApplyAndCancelMeeting";
    console.log("jump to servlet");
    form.submit();
}