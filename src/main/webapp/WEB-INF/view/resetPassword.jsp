<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<p>重置密码：
		<form action="resetPassword" onsubmit="return check()">
			<p>
				新密码：<input type="password" name="password" id="password">
			<div class="one"></div>
			<p>
				确认密码：<input type="password" name="newpassword" id="newpassword">
				<div class="two"></div>
			<p>
				<button type="submit"  title="提交">提交</button>
		</form>
	</div>
	<script type="text/javascript">
		function check(){
			var password=$("#password").val();
			var newpassword=$("#newpassword").val();
			if(password==""){
				alert("密码不能为空!");
				return false;
			}else if(newpassword==""){
				alert("确认密码不能为空!");
				return false;
			}else if(password!=newpassword){
				alert("密码和确认密码必须一致!");
				return false;
			}else{
				alert('密码重置成功!请登录');
				return true;
			}
		}
	</script>

</body>
</html>