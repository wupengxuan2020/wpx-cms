<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
 <link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/resource/css/index.css" />
	<link rel="stylesheet" type="text/css" href="/resource/jquery/screen.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>

  

</head>
<body>
	<div class="container" style="width: 450px;padding-top: 10px">
	  <span style="color: red">${msg}</span>
		<form id="form1">

			<div class="form-group">
				<label for="username">用户名</label> <input id="username" type="text"
					class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="password">密码</label> <input id="password"
					type="password" class="form-control" name="password">
			</div>
			

			<div class="form-group">
				<button type="submit" class="btn btn-info">登录</button>
				<button type="reset" class="btn btn-warning">重置</button>
				<span id="msg"> </span>
			</div>

		</form>

	</div>
	
	<script type="text/javascript">
	  $(function(){
		  
		  $("#form1").validate({
			  
			  //1 .定义规则
			  rules:{
				 username:{
					 required:true,//用户名不能为空
				 }, 
				 password:{
					 required:true,//密码不能为空
				 }
			  },
			  //2.定义消息提示
				 messages:{
					username:{
						 required:"用户名不能为空",
					} , 
					 password:{
						 required:"密码不能为空",
					 } 
				 },submitHandler:function(flag){
					 //如果校验通过。则执行注册
					 $.post("/passport/login",$("#form1").serialize(),function(result){
						 if(result.code==200){
							// $("#msg").html("<font color='red'>恭喜登录成功</font")
							 location.href="/admin";//进入后台
						 }else{
							 $("#msg").html("<font color='red'>"+result.msg+"</font")
						 }
					 })
				 }  
			  
			  
		  })
		  
		  
		  
	  })
	
	
	</script>
</body>
</html>