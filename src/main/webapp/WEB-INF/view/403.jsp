<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto, 100px;">
		<p>无权限!</p>
	</div>
	<a href="to_main">3秒后自动跳转到主页面....点击直接跳转</a>
	<script type="text/javascript">
		window.setTimeout("location.href='to_main'",3000);
	</script>
</body>
</html>