<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<!-- nav bar -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nav bar</title>
<link rel="stylesheet" href="style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/b17d4fa9e7.js"
	crossorigin="anonymous"></script>
<script src="main.js" defer></script>
<!-- nav bar end -->

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Aroma Shop - Home</title>
<link rel="icon" href="img/Fevicon.png" type="image/png">
<link rel="stylesheet" href="vendors/bootstrap/bootstrap.min2.css">
<link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
<link rel="stylesheet" href="vendors/nice-select/nice-select.css">
<link rel="stylesheet"
	href="vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">



<title>Earthbox</title>
<!-- Google Font -->
<link
	href='http://fonts.googleapis.com/css?family=Dosis:300,400,500,600,700,800'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!-- Preloader -->
<link rel="stylesheet" href="css/preloader.css" type="text/css"
	media="screen, print" />
<!-- Icon Font-->
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.default.css">
<!-- Animate CSS-->
<link rel="stylesheet" href="css/animate.css">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Style -->
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="css/shopstyle.css">
<!-- Responsive CSS -->
<link href="css/responsive.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="js/lte-ie7.js"></script>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- 사용자 정의 -->
<link href="css/other.css" rel="stylesheet">
</head>


<body>

	<!-- Preloader -->
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>

	<nav class="navbar">
		<div class="navbar__logo">
			<div class="dropdown">
				<a class="menu_drop" href="">☰</a>
				<div class="dropdown-content">
					<a style="color: black !important;" href="">아파트 설정하기</a>
				</div>
				<span class="apt_name">${apt_name}</span>
			</div>
		</div>
	</nav>



	<!-- ================ trending product section start ================= -->
	<section class="section-margin calc-60px">
		<div class=" container-pd community-sec">
			<div class=" list_layout">
				<!--리스트 출력 시작 시작 -->
				<div class="cate-select">
					<div class="choose-cate">
						<c:forEach items="${cCategory}" var="vo" step="1">
							<button type = "button" class="btn btn-sm c-cate"
								onclick="choiceCategory(${vo.c_category_seq})">${vo.c_category_seq}</button>
						</c:forEach>
					</div>
				</div>

				<c:forEach items="${boardList}" var="vo" step="1">
					<!-- 반목분 시작 -->
					<div class="board-sec">
						<span class="cate">${vo.c_category_name}</span> <br>
						<div class="board-text">${vo.article_content}</div>

						<c:choose>
							<c:when test="${vo.article_file == null}">
							</c:when>

							<c:otherwise>
								<img class="board-img" src="/file/${vo.article_file}">
							</c:otherwise>

						</c:choose>

						<div class="board-foot">
							<p class="board-nick">${vo.user_id}</p>
							<p class="sysdate">${vo.article_date}</p>
						</div>
						<div class="section-line"></div>
						<div class="like">
							<div class="reac-div reaction">
								<img class="reac" src="/img/icon/gonggam.png"> <span>공감하기</span>
								<input type="hidden" value="${vo.article_seq}" id="article_seq">
								<span id="cnt">${vo.c_like}</span>
							</div>

							<div class="reac-div" onclick="location.href='boardInfo.do'">
								<img class="reac" src="/img/icon/datggle.png"> <span>댓글달기</span>
							</div>
						</div>

						<div class="seper-line"></div>
					</div>
					<!-- 반목분 종료 -->
				</c:forEach>



				<img class="write-board" onclick="location.href='viewBoardForm.do'"
					src="/img/icon/pen.png">

			</div>
		</div>
	</section>
	<!-- ================ trending product section end ================= -->

	<!--  footer start -->
	<div class="foot-bar">
		<div class="foot-div" onclick="location.href='index.do'">
			<div>
				<img alt="" src="/img/icon/home-gr.png">
			</div>
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/message-full.png">
		</div>

		<div class="foot-div" onclick="location.href='viewChallenge.do'">
			<img class=" main-btn" alt="" src="/img/icon/unearth.png">
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/map-gr.png">
		</div>
		<div class="foot-div" onclick="location.href='viewMypage.do'">
			<img alt="" src="/img/icon/me-gr2.png">
		</div>
	</div>
	<!--  footer end -->

	<!-- =========================
     SCRIPTS 
============================== -->

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/wow.js"></script>
	<script src="js/script.js"></script>
	<script type="text/javascript">
		$(document).on('click', '.c-cate', function() {

			console.log("함수실행")
			$(".c-cate").css("background-color", "white")
			$(this).css("background-color", "#599555")

		})

		$(document).on("click", ".reaction", function(article_seq) {

			var img = $(this).children("img").attr("src")
			var cnt = parseInt($(this).children("#cnt").html())
			var status = "";
			var article_seq = $(this).children("#article_seq").val();
			console.log("자식 : " + article_seq)

			if (img == "/img/icon/gonggam.png") {

				$(this).children("img").attr("src", "/img/icon/love-gr.png");
				cnt = cnt + 1
				console.log($(this).children("#cnt").html(cnt))

				$.ajax({

					url : "reaction.do",
					type : "post",
					data : {
						"status" : 1,
						"article_seq" : article_seq,
					},
					success : function () {
						
					console.log("성공")

					},
					
					error : function () {
						console.log("실패")
					}
					

				})

			} else {

				$(this).children("img").attr("src", "/img/icon/gonggam.png");
				cnt = cnt - 1
				console.log($(this).children("#cnt").html(cnt))
				
				$.ajax({

					url : "reaction.do",
					type : "post",
					data : {
						"status" : 0,
						"article_seq" : article_seq,
					},
					success : function () {
						
					console.log("성공")

					},
					
					error : function () {
						console.log("실패")
					}
					

				})

			}

		})

				
		function choiceCategory(c_category_seq) {
			
			
			
			console.log("시퀀스번호" + c_category_seq)
			
			$.ajax({
				
				url : "gcList.do",
				type:"post",
				data : {
					"c_category_seq" : c_category_seq
				},
				success: function (data) {
					console.log(data)
				},
				error : function () {
					console.log("카테고리 실패")
				}
				
			
			})
			
			
		}
		
		
		
		
	</script>


</body>

</html>