<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript" src="js/validate-1.14.0.min.js"></script>
<style type="text/css">
h1 {
	font-size: 45px;
	font-weight: 500;
	letter-spacing: 4px;
	margin: 60px 577px;
	color: #41413B;
}

.main {
	width: 50%;
	margin: 0 auto;
	padding: 40px;
	background-color: rgba(10, 10, 10, 0.77);
	border: 2px ridge rgba(238, 238, 238, 0.13);
	border-radius: 5px;
	-moz-box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
	-webkit-box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
	box-shadow: 0 -5px 10px 1px rgba(16, 16, 16, 0.57);
	border-bottom: none;
	border-bottom-left-radius: initial;
	border-bottom-right-radius: initial;
}
</style>


</head>
<body style="background-image: url(images/4.jpg)">
	<h1>三峡阳菊</h1>
	<div class="main">
		<p>短信验证方式：
		<form action="checkCode">
			<p>
				用户名：<input type="text" name="username" id="username">
			<div class="one"></div>
			<p>
				手机号：<input type="phone" name="phone" id="phone">
				<div class="two"></div>
			<p>
				验证码：<input type="text" name="code">
				<button id="validateCode" type="button" onclick="sendCode(this);"
					title="获取验证码">获取验证码</button>
			<p>
				<button type="submit"  title="提交">提交</button>
		</form>
	</div>
	<script type="text/javascript">
		//验证用户名是否存在
		$("#username").blur(function() {
			var username = $("#username").val();
			var content = {
				username : username
			};
			var opt = {
				cache : false,
				url : "checkUsername",
				dataType : "text",
				data : content,
				success : function(data) {
					if (data == "OK") {
						$(".two").html("");
						$(".one").html("用户名正确");
						$(".one").css("color", "green");
					} else {
						$(".two").html("");
						$(".one").html("用户名不存在");
						$(".one").css("color", "red");
					}
				}

			}
			if (username != "") {
				$.ajax(opt);
			} else {
				$(".two").html("");
				$(".one").html("用户名不能为空");
				$(".one").css("color", "red");
			}

		})
		//验证手机号是否与用户名匹配
		$("#phone").blur(function() {
			var phone = $("#phone").val();
			var username=$("#username").val();
			var content = {
					phone : phone,
					username:username
			};
			var opt = {
				cache : false,
				url : "checkPhone",
				dataType : "text",
				data : content,
				success : function(data) {
					if (data == "OK") {
						$(".one").html("");
						$(".two").html("手机号正确");
						$(".two").css("color", "green");
					} else {
						$(".one").html("");
						$(".two").html("手机号不匹配");
						$(".two").css("color", "red");
					}
				}

			}
			if (phone != "") {
				$.ajax(opt);
			} else {
				$(".one").html("");
				$(".two").html("手机号不能为空");
				$(".two").css("color", "red");
			}

		})
		function sendCode(obj) {
			var phone = document.getElementById("phone");
			var value = phone.value.trim();
			if (value && value.length == 11) {
				$.ajax({
					cache : false,
					url : "sendCode",
					data : {
						phone : value
					}
				});
			} else {
				alert("请输入正确的手机号码");
				phone.focus();
			}
		}
	</script>

</body>
</html>