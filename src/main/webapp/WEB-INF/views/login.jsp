<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Animated Login Form</title>
	<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자 정의 -->
	<link href="css/other.css" rel="stylesheet">

</head>
<body>

	<div class="container">

		<div class="login-content">
			<form action="main.do">
				<img src="img/logo/earthbox_logo.png">
				<h2 class="login_title">EARTH BOX</h2><br>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>아이디</h5>
           		   		<input type="text" class="input" name="id">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>비밀번호</h5>
           		    	<input type="password" class="input" name="pw">
            	   </div>
            	</div>
            	<br>
            	<p><a class ="join_link" href="#">회원가입</a><p>
            	<br>
            	<input type="submit" class="btn btn-sm login-btn" value="로그인" >
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
