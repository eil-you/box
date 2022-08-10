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
		<div class="navbar__logo add-header">
			<h4 style="display: inline-block;">마이페이지</h4>
		</div>
	</nav>

	<!-- ================ trending product section start ================= -->
	<section class="section-margin calc-60px">
		<div class="container container-pd container-my">

			<div class="profile">
				<img class="mypage-img" src="/img/icon/profile-img.png">
				<div>
					<p class="my-nick">${user_id}</p>
					<p class="my-apt">${apt_name}</p>
				</div>
				<div>
					<img class="back" src="/img/icon/bk.png">
				</div>
			</div>

			<div class="mypage-menu-sec">
				<div class="mypage-sec" onclick="location.href='proList.do?user_id=${user_id}'">
					<div class="icon-bgc">
						<img src="/img/icon/sell.png">
					</div>
					<p>판매내역</p>
				</div>

				<div class="mypage-sec" onclick="location.href='goodsBuyList.do?user_id=${user_id}'">
					<div class="icon-bgc">
						<img src="img/icon/cart.png">
					</div>
					<p>구매내역</p>
				</div>

				<div class="mypage-sec" onclick="zzimList()">
					<div class="icon-bgc">
						<img src="/img/icon/wish-cart.png">
					</div>
					<p>찜목록</p>
				</div>
			</div>
		</div>

		<div class="mypage-div"></div>





	</section>
	<!-- ================ trending product section end ================= -->

<!--  footer start -->
	<div class="foot-bar">
		<div class="foot-div"
			onclick="location.href='index.do?user_addr=${user_addr}'">
			<div>
				<img alt="" src="/img/icon/home-gr.png">
			</div>
		</div>

		<div class="foot-div" onclick="location.href='viewBoard.do'">
			<div>
				<img alt="" src="/img/icon/message-gr.png">
			</div>
		</div>

		<div class="foot-div" onclick="location.href='viewGoodsForm.do'">
			<img alt="" src="/img/icon/plus-gr.png">
		</div>

		<div class="foot-div">
			<img alt="" src="/img/icon/map-gr.png">
		</div>
		<div class="foot-div"
			onclick="location.href='viewMypage.do?user_id=${user_id}&user_addr=${user_addr}'">
			<img alt="" src="/img/icon/me-full.png">
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
		function goodsContent() {

			$('')

		}

		function viewGoodsContent(g_seq,apt_name){
            console.log(g_seq)
            console.log(apt_name)
			
            var f = document.createElement("form");
            var obj1 = document.createElement('input');
            obj1.setAttribute('type','hidden')
            obj1.setAttribute('name','g_seq')
            obj1.setAttribute('value', g_seq )
            f.appendChild(obj1);
            
            obj2 = document.createElement('input');
            obj2.setAttribute('type','hidden')
            obj2.setAttribute('name','apt_name')
            obj2.setAttribute('value', apt_name )
            console.log(obj2)
            f.appendChild(obj2);
            
            f.setAttribute('method','post');
            f.setAttribute('action','goodsInfo.do')
            document.body.appendChild(f);
		    f.submit();
			}
		
		
		
		
	</script>



</body>

</html>