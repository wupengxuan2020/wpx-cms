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
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">

	/* var id='${sessionScope.user.id }';
	$.post("/showCollect",{id=id},function(flag){
		
	}) */
	
</script>
  

</head>
<body>
	<form action="/showCollect">
	<c:forEach items="${list }" var="show">
		<div class="media">
			<div class="media-body">
				<h5 class="mt-0">${show.text }</h5>

				<div style="float: right; padding-top: 60px">
				</div>
			</div>

		</div>
		<hr />
	</c:forEach>
</form>
</body>
</html>