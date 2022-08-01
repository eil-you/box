<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Animated Login Form</title>
<link rel="stylesheet" type="text/css" href="css/loginstyle.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 사용자 정의 -->
<link href="css/other.css" rel="stylesheet">

</head>
<body>


	<div class="join_container">
		<div class="login-content">
			
			<form action="main.do">
				<h2 class="login_title">EARTH BOX</h2>
				<br>

				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>이름</h5>
						<input type="text" class="input" name="user_nm">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>닉네임</h5>
						<input type="text" class="input" name="user_nick">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>아이디</h5>
						<input type="text" class="input" name="user_id">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>비밀번호</h5>
						<input type="password" class="input" name="user_pw">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<input type="date" class="input" name="user_birthdate">
					</div>
				</div>

				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>이메일</h5>
						<input type="email" class="input" name="user_email">
					</div>
				</div>

				<br> <br> <input type="submit"
					class="btn btn-sm login-btn" value="가입완료">
			</form>
		</div>
	</div>


	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
