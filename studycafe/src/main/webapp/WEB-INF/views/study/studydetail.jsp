<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/studydetail.css">
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
					<label for="studyTitle">제목</label>
					<input type="text" id="studyTitle" name="studyTitle" value="${studyEntity.studyTitle}" readonly="readonly"></p>
				<p>
					<label for="studyWriter">작성자</label>
					<input type="text" id="studyWriter" name="studyWriter" value="${studyEntity.studyWriter}" readonly="readonly"></p>
				<p>
					<label for="dateTime">작성날짜</label>
					<input type="text" id="dateTime" name="dateTime" value="${studyEntity.dateTime}" readonly="readonly"></p>
				<div>
					<label for="studyContent">내용</label>
					<textarea id="studyContent" name="studyContent" readonly="readonly">${studyEntity.studyContent}</textarea></div>
				<p>
					<label for="dateTime">지번 주소</label>
					<input type="text" id="address_name" name="address_name" readonly="readonly"></p>
				<!-- 도로명 주소 출력 -->
				<div id="road_address"></div>
				
				<div class="map_wrap" align="center">
					<div id="map"
						style="width: 100%; height: 500px; position: relative; overflow: hidden;"></div>
					<input type="hidden" id="lat" value="${studyEntity.latitude}">
					<input type="hidden" id="lng" value="${studyEntity.longitude}">
				</div>
				<button class="btn btn-dark" id="listBtn" type="button" onclick="window.history.back();">목록</button>
				<button class="btn btn-dark" id="modifyBtn" type="button" onclick="location.href='/studymodify/${studyEntity.studyNum}'">수정</button>
				<button class="btn btn-dark" id="deleteBtn" type="button" onclick="studyDelete(${studyEntity.studyNum})">삭제</button>
			</form>
		</div>
	</div>
 	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=59e92bd7943f48f31ff73b322a4e5603&libraries=services,clusterer,drawing"></script>
	<script src="/js/studydetail.js"></script>
	<jsp:include page="/WEB-INF/views/pageingredient/footer.jsp"></jsp:include>
</body>
</html>