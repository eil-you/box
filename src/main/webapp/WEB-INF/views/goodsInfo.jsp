<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<style type="text/css">
</style>

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
				<a class="menu_drop" href="">${apt_name} ▼</a>
				<div class="dropdown-content">
					<a style="color: black !important;" href="">아파트 설정하기</a>
				</div>
			</div>
		</div>
	</nav>
	<!--  <div class="panel-heading">게시판 만들기</div> -->
	<div class="panel-body add-body">
			<div class="form-group">
				<div class="col-sm-10">
<!--  					<h2 type="text">${goodsInfo.g_name}</h2>-->
					<h2 type="text">상품이름</h2>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-10">
					<!--  <h4>\ ${goodsInfo.g_price}</h4> -->
					<h4>\ 5000000</h4>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-10">
					<!--  <img src="${goodsInfo.g_img}"/> -->
					<img src="/img/product/product1.png">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-10">
					<!--  <div>${goodsInfo.g_info}</div> -->
					<div>글내용</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				</div>
			</div>

	</div>


		<div class="foot-bar">
		<div class="foot-div"
			onclick="location.href='index.do?user_addr=${user_addr}'">
			<div>
				<img alt="" src="/img/icon/home.png">
			</div>
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/mesaage.png">
		</div>

		<div class="foot-div" onclick="location.href='viewGoodsForm.do'">
			<img alt="" src="/img/icon/add.png">
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/location.png">
		</div>
		<div class="foot-div">
			<img alt="" src="/img/icon/me.png">
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


	<script type="text/javascript">
	$(document).ready(function(){ 
		  var fileTarget = $('#file'); 
		  fileTarget.on('change', function(){ // 값이 변경되면
		      var cur=$(".filebox input[type='file']").val();
		    $(".upload-name").val(cur);
		  }); 
		}); 		
		
	</script>

</body>

</html>