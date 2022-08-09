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


</head>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>

	<!--  <nav class="navbar">
		<div class="navbar__logo">
			<i class="fab fa-accusoft"></i> <a class="menu_bar">☰</a>
			<div class="dropdown">
				<a class="menu_drop" href="">${apt_name} ▼</a>
				<div class="dropdown-content">
					<a style="color: black !important;" href="">아파트 설정하기</a>
				</div>
			</div>
		</div>
	</nav> -->

	<div class="col-sm-10 detail-img-div">
		<img class="goback" src="/img/icon/goback.png"
			onclick="location.href='index.do'"/ > <img class="detail-img"
			src="file/${goodsInfo.g_img}" />
		<div>
			<img class="back" src="/img/icon/bk.png">
		</div>
	</div>


	<div class="seller-info-sec">
		<img class="seller-img" src="/img/icon/profile-img.png">
		<div class="seller-info">
			<p class="seller-nick">${goodsInfo.seller_nick}</p>
			<p class="seller-apt">${apt_name}</p>
		</div>
		<div class="zzim-sec">
			<p id="g_price">${goodsInfo.g_price }</p>
			<img class="item-zzim" id="zzim" src="/img/icon/star-empty.png">
		</div>
	</div>
	<div class="goods-line"></div>
	<div class="panel-body info-body">
		<div class="form-group">
			<div class="col-sm-10">
				<h4 class="info-g-name">${goodsInfo.g_name}</h4>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-10">
				<div>${fn:replace(goodsInfo.g_info, newLine, "<br/>")}</div>

			</div>
		</div>



	</div>






	<div class="foot-bar">
		<div class="foot-div"
			onclick="location.href='index.do?user_addr=${user_addr}'">
			<div>
				<img alt="" src="/img/icon/home-gr.png">
			</div>
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/message-gr.png">
		</div>

		<div class="foot-div" onclick="location.href='viewGoodsForm.do'">
			<img alt="" src="/img/icon/plus-gr.png">
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/map-gr.png">
		</div>
		<div class="foot-div">
			<img alt="" src="/img/icon/me-gr.png">
		</div>
	</div>

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
		$(document).ready(changemoney)

		function changemoney() {

			console.log($("#g_price").text())
			var price = $("#g_price").text().toLocaleString('ko-KR');

			console.log(price)

			var cPrice = price.toString().replace(
					/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
			console.log(cPrice)

			$("#g_price").text(cPrice + "원");
		}

		// 찜목록 클릭 

		$(document).on('click', '#zzim', function() {

			console.log("zzim")
			document.getElementById("zzim").src="/img/icon/star-full.png";
			$(this).removeAttr('id', 'zzim')
			$(this).attr('id', 'nozzim')

		})

		$(document).on('click', '#nozzim', function() {

			console.log("찜취소")

			document.getElementById("nozzim").src="/img/icon/star-empty.png";
			$(this).removeAttr('id', 'nozzim')
			$(this).attr('id', 'zzim')

			// $('#dislike').remove();
			// $('body').prepend('<button id = "like">좋아요</button>')
			// $('span').text('0')

		})
	</script>

</body>

</html>