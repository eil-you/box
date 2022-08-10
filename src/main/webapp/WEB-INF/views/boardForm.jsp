<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<form class="form-horizontal" action="boardInsert.do" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit"  class="btn btn-default goods-commit">완료</button>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-10">
					<!-- 상품 카테고리 리스트 출력 시작 -->
					<select class="my-select" name="c_category_seq">
						<option>게시글의 주제를 선택해주세요</option>
					<c:forEach items="${categoryList}" var="vo" step="1">
						<option value = "${vo.c_category_seq}"><c:out value = "${vo.c_category_name}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-10">
					<textarea rows="10" placeholder="아파트 이웃에게 질문하거나 이야기를 해보세요"  class="form-control"
						name="article_content"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<div class="filebox">
						<label for="file">📷</label> <input type="file" name="img2"
							id="file" accept="image/*;capture=camera" > <input
							class="upload-name" value="" readonly>
					</div>
				</div>
			</div>

		</form>

</body>
</html>