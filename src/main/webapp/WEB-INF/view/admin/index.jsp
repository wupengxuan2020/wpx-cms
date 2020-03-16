<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/popper.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container-fluid">
		<!-- 头 -->
		<div class="row" style="background-color: #009FD9; height: 55px">
			<div class="col-md-12">
				<img alt="" src="/resource/images/logo3.png" width="55px"
					height="55px"> <font color="white">今日头条-管理员中心</font>


				<div class="btn-group dropleft" style="float: right">
					<button type="button" class="btn btn-link dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<font color="white" size="2px">登录信息</font>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">${sessionScope.admin.username }</a>
						<a class="dropdown-item" href="/passport/logout">注销</a>
					</div>
				</div>
				
				

			</div>
		</div>
		<!--  -->
		<div class="row" style="padding-top: 10px; height: 550px">
			<!-- 左侧菜单 -->
			<div class="col-md-2 rounded"
				style="background-color: #ccc; text-align: center; margin-left: 10px; padding-top: 10px">

				<nav class="nav flex-column"> <a
					class="list-group-item active" href="#" data="/admin/articles">文章审核</a>
				<a class="list-group-item" href="#" data="/admin/users">用户管理</a> <a
					class="list-group-item" href="#">栏目管理</a> <a
					class="list-group-item" href="#">分类管理</a> <a
					class="list-group-item" href="#">系统设置</a> </nav>

			</div>
			<!-- 右侧具体内容 -->
			<div class="col-md-9" id="center"></div>

		</div>


	</div>

	<script type="text/javascript">

//点击样式的切换
 //为 li 添加点击事件
$(function(){
	$("#center").load("/admin/articles");
	
	$("a").click(function(){
		var url = $(this).attr("data");
	    $("a").removeClass("active");
		 $(this).addClass("list-group-item active")
		$("#center").load(url);
	})
	
})


</script>

</body>
</html>