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

<link rel="stylesheet" href="css/style.css" type="text/css">
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if ($.cookie("rmbUser") == "true") {
			$("#brand1").attr("checked", true);
			$("#user").val($.cookie("username"));
			$("#pswd").val($.cookie("password"));
		}
	});

	//记住用户名密码  
	function Save() {
		if ($("#brand1").is(":checked")) {
			var str_username = $("#user").val();
			var str_password = $("#pswd").val();
			$.cookie("rmbUser", "true", {
				expires : 7
			}); //存储一个带7天期限的cookie  
			$.cookie("username", str_username, {
				expires : 7
			});
			$.cookie("password", str_password, {
				expires : 7
			});
		} else {
			$.cookie("rmbUser", "false", {
				expire : -1
			});
			$.cookie("username", "", {
				expires : -1
			});
			$.cookie("password", "", {
				expires : -1
			});
		}
	};
</script>
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 








</script>
</head>
<body>
	<h1>三峡阳菊</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<form action="do_login" method="post" id="loginForm">
				<input type="text" Name="username" placeholder="用户名" id="user">
				<input type="password" Name="password" placeholder="密码" id="pswd">

				<ul class="tick w3layouts agileits">
					<li><input type="checkbox" id="brand1" value=""><label
						for="brand1"><span></span> 记住我</label> <font color="red"> <c:if
								test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
								<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"></c:out>
							</c:if>
					</font></li>
				</ul>
				<div class="send-button w3layouts agileits">

					<input type="submit" value="登 录" onclick="Save()"> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<!-- <p id="prompt" style="display: none; color: red;">用户名或密码错误</p> -->
				</div>
			</form>

			<a href="to_forgetPassword">忘记密码?</a>
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="#"> <span
							class="icons w3layouts agileits"></span> <span
							class="text w3layouts agileits">QQ</span></a></li>
					<li class="weixin w3ls"><a href="#"> <span
							class="icons w3layouts"></span> <span
							class="text w3layouts agileits">微信</span></a></li>
					<li class="weibo aits"><a href="#"> <span
							class="icons agileits"></span> <span
							class="text w3layouts agileits">微博</span></a></li>
					<!-- <div class="clear"> </div> -->
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="copyrights">
			Collect from <a href="http://www.cssmoban.com/">企业网站模板</a>
		</div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<form action="#" method="post">
				<input type="text" Name="name" placeholder="用户名"> <input
					type="text" Name="email" placeholder="邮箱"> <input
					type="password" Name="password" placeholder="密码"> <input
					type="text" Name="phonenumber" placeholder="手机号码">
			</form>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="submit" value="免费注册">
				</form>
			</div>
			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	</div>

	<div class="footer w3layouts agileits">
		<p>
			Copyright &copy; More Templates <a href="http://www.cssmoban.com/"
				target="_blank" title="模板之家">模板之家</a> - Collect from <a
				href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
		</p>
	</div>

</body>
</html>