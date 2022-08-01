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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body sty>


	<div class="join_container">
		<div class="login-content">

			<form action="Join.do">
				<h2 class="login_title">EARTH BOX</h2>
				<br>
				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>닉네임</h5>
						<input type="text" class="input" name="user_nick">
					</div>
				</div>

				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>아이디</h5> 
						<input type="text" class="input input-id" name="user_id"> <button class="check-id">중복확인</button>
					</div>
				</div>

				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>비밀번호</h5>
						<input type="password" class="input" name="user_pw">
					</div>
				</div>

				<!-- 
				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<input type="date" class="input" name="user_birthdate">
					</div>
				</div>
				 -->

				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>이메일</h5>
						<input  type="email" class="input" name="user_email">
					</div>
				</div>

				<div class="input-div join-input">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>아파트 설정하기</h5>
						<input type="text" class="input" name="user_addr" readonly="readonly" id="user_addr">
					</div>
				</div>

				<br><br> <input type="submit" class="btn btn-sm login-btn"
					value="가입완료">
			</form>
		</div>
	</div>

	<script type="text/javascript" src="js/main.js"></script>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	// id중복값 찾기
	$(document).ready(findOverla);
	
	function checkId() {
		
		user_id = $('#user_id').val();
		
		$.ajax({
			
			url : 'CheckId.do',
			type : 'post',
			data : {
				
				'user_id' : user_id
				
			},
			
			
		
		
		
		
		})
		
		
		
		
		
		
	}
	
	
	
	// 도로명 주소찾기 
	window.onload = function(){
	    document.getElementById("user_addr").addEventListener("click", function(){ //주소입력칸을 클릭하면
	        //카카오 지도 발생
	        new daum.Postcode({
	            oncomplete: function(data) { //선택시 입력값 세팅
	            		document.getElementById("user_addr").value = data.address; 
	            		console.log(data)
	            }
	        }).open();
	    });
	}
</script>
</body>
</html>
