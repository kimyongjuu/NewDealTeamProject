<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${teamPost.teamBoardTitle }</title>
<link rel="stylesheet" type="text/css" href="/css/detailview.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/pageingredient/header.jsp"></jsp:include>

	<div class="main-wrap">
		<div class="index-ingredient">
			<form method="post" enctype="multipart/form-data">
				<p>
					<label for="team-title">제목</label>
					<input type="text" id="team-title" name="teamBoardTitle" value="${teamPost.teamBoardTitle }" readonly="readonly">
				</p>

				<p>
					<label for="team-head">작성자(팀장)</label>
					<input type="text" id="team-head" name="teamBoardWriter" value="${teamPost.teamBoardWriter }" readonly="readonly">
				</p>
				
				<p>
					<label for="team-head">작성날짜</label>
					<input type="text" id="team-head" name="teamBoardWriter"
					value=${teamPost.createDate } readonly="readonly">
				</p>

				<div>
					<label for="content">내용</label>
					<textarea id="content" name="teamBoardContent" readonly="readonly">
						${teamPost.teamBoardContent }
					</textarea>
				</div>
			</form>

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/pageingredient/footer.jsp"></jsp:include>
	<script src="/js/detailview.js"></script>
</body>
</html>