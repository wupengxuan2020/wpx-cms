<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 
 <link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>

  

</head>
<body>
<div class="container-fluid">
		<!-- 头 -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #563D7C; height: 60px">
				<img alt="图片失败" src="/resource/images/logo3.png"
					style="height: 55px; padding-top: 4px; padding-left: 2px"> <span
					style="color: white">今日头条-个人中心</span>
			</div>

		</div>
		<div class="row" style="padding-top: 5px">
			<div class="col-md-2">
				<ul class="list-group">
					<li class="list-group-item active"><a href="#" data="/my/articles"><font color="red">我的文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font color="red">发布文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/showCollect"+><font color="red">我的收藏</font></a></li>
					<li class="list-group-item"><a href=""><font color="red">我的评论</font></a></li>
					<li class="list-group-item"><a href=""><font color="red">个人信息</font></a></li>
				</ul>

			</div>
			  <!-- 内容显示区域 -->
			<div class="col-md-10" id="center">
				<div style="display:none ">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				
				</div>
			  	
				
			</div>

		</div>


	</div>


<script type="text/javascript">
	$(function() {
		//
		$("#center").load("/my/articles")
		
		$("li").click(function() {
			
			var url=$(this).children().attr("data");
			
			$("li").removeClass("active");
			$(this).addClass("list-group-item active")
			$("#center").load(url);
			
		})
		
		
		
	})
	
</script>

</body>
</html>