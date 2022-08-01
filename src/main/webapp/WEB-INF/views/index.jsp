<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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



<title>BRANDY</title>
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
			<i class="fab fa-accusoft"></i> <a class="menu_bar">☰</a>
			<div class="dropdown">
				<a class="menu_drop" href="">A 아파트 ▼</a>
				<div class="dropdown-content">
					<a style="color: black !important;" href="">아파트 설정하기</a>
				</div>
			</div>
		</div>
		<!-- 
		<ul class="navbar__menu">
			<li><a href="login.do">로그인</a></li>
			<li><a href="">Gallery</a></li>
			<li><a href="">Wedding</a></li>
			<li><a href="">FAQ</a></li>
			<li><a href="">Booking</a></li>
		</ul>
 -->
	</nav>

	<!-- ================ trending product section start ================= -->
	<section class="section-margin calc-60px">
		<div class="container container-pd">
			<div class="row list_layout">
				<!--리스트 출력 시작 시작 -->

				<%
				for (int i = 0; i < 6; i++) {
				%>
				<div class="card-product__img">
					<img class="card-img" src="img/product/product<%=i + 1%>.png">
					<div class="card-body">
						<h4>상품이름</h4>
						<br>
						<p>상품 위치</p>
						<p>\120,000</p>
					</div>
				</div>
				<%
				}
				%>
				<!-- 끝 -->
			</div>
		</div>
	</section>
	<!-- ================ trending product section end ================= -->

	<div class="foot-bar">
		
		<div class="foot-div" onclick="location.href='#'">
			<svg aria-label="홈" class="_8-yf5 " color="white" fill="#262626"
			height="24" role="img" viewBox="0 0 24 24" width="24">
			<path
				d="M9.005 16.545a2.997 2.997 0 012.997-2.997h0A2.997 2.997 0 0115 16.545V22h7V11.543L12 2 2 11.543V22h7.005z"
				fill="none" stroke="currentColor" stroke-linejoin="round"
				stroke-width="2"></path></svg>
		</div>
		<div class="foot-div">
		<?xml version="1.0" ?><!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg id="Capa_1" style="enable-background:new 0 0 60 60;" version="1.1" viewBox="10 10 150 150" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M54.07,1H15.93C12.66,1,10,3.66,10,6.93V15H5.93C2.66,15,0,17.66,0,20.929V42.07C0,45.34,2.66,48,5.93,48H12v10  c0,0.413,0.254,0.784,0.64,0.933C12.757,58.978,12.879,59,13,59c0.276,0,0.547-0.115,0.74-0.327L23.442,48H44.07  c3.27,0,5.93-2.66,5.93-5.929V34h4.07c3.27,0,5.93-2.66,5.93-5.93V6.93C60,3.66,57.34,1,54.07,1z M48,42.071  C48,44.237,46.237,46,44.07,46H23c-0.282,0-0.551,0.119-0.74,0.327L14,55.414V47c0-0.552-0.447-1-1-1H5.93  C3.763,46,2,44.237,2,42.07V20.929C2,18.763,3.763,17,5.93,17H11h33.07c2.167,0,3.93,1.763,3.93,3.93V33V42.071z M58,28.07  c0,2.167-1.763,3.93-3.93,3.93H50V20.93c0-3.27-2.66-5.93-5.93-5.93H12V6.93C12,4.763,13.763,3,15.93,3H54.07  C56.237,3,58,4.763,58,6.93V28.07z"/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/><g/></svg>
		</div>
		<div class="foot-div">
			<p>등록하기</p>
		</div>
		<div class="foot-div">
			<p>위치</p>
		</div>
		<div class="foot-div">
			<p>내정보</p>
		</div>
	</div>

	<!-- =========================
     SCRIPTS 
============================== -->


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/wow.js"></script>
	<script src="js/script.js"></script>
	<!-- 쇼핑몰 js <script src="js/shopmain.js"></script> -->




</body>

</html>