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
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>



</head>
<body>
	<c:forEach items="${info.list }" var="article">
		<div class="media">
			<img alt="..." class="mr rounded" src="/pic/${article.picture }"
				style="width: 60px; height: 60px;">
			<div class="media-body">
				<h5 class="mt-0">${article.title }</h5>

				<div style="float: right; padding-top: 60px">
					<!-- <button type="button" class="btn btn-link">详情</button> -->
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-link" data-toggle="modal"
						data-target="#exampleModalLong" onclick="articleDetail(${article.id})">详情</button>
				</div>
			</div>

		</div>
		<hr />
	</c:forEach>

	<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h5 class="modal-title" id="exampleModalLongTitle"><span id="title"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="content">
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
<script type="text/javascript">

function articleDetail(id){
	 //查询单个文章，没模态框赋值
	$.get("/my/articleDetail",{id:id},function(article){
		$("#title").append(article.title);
		$("#content").append(article.content);
		
	})
}

	function goPage(page) {
		$("#center").load("/my/articles?page="+page)
			
	}

</script>


</html>