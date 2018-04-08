<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="to_main"><strong>三峡阳菊</strong></a>
				<div id="sideNav" href="#">
					<i class="fa fa-caret-right"></i>
				</div>
			</div>
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-messages">
						<li><a href="#">
								<div>
									<strong>何青茂</strong> <span class="pull-right text-muted">
										<em>今天</em>
									</span>
								</div>
								<div>吃鸡小能手</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>吴军</strong> <span class="pull-right text-muted">
										<em>昨天</em>
									</span>
								</div>
								<div>吃鸡小菜鸡</div>
						</a></li>
						<li class="divider"></li>
						<li><a href="#">
								<div>
									<strong>杨涛</strong> <span class="pull-right text-muted">
										<em>昨天</em>
									</span>
								</div>
								<div>吃鸡大神</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>查看所有信息</strong>
								<i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>
					
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" aria-expanded="false"> <i
						class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i>用户信息</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a></li>
						<li class="divider"></li>
						<li><c:url value="/logout" var="logoutUrl"/><a href="${logoutUrl }"><i class="fa fa-sign-out fa-fw"></i>退出</a></li>
					</ul></li>
			</ul>
		</nav>
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a class="active-menu" href="to_main"><i
							class="fa fa-dashboard"></i>首页</a></li>
					<li><a href="company-introduction.jsp"><i
							class="fa fa-desktop"></i>公司介绍</a></li>
					<!-- <li><a href="chart.html"><i class="fa fa-bar-chart-o"></i>权限管理</a>
					</li> -->
					<li><a href="employee-manage.jsp"><i class="fa fa-qrcode"></i>员工信息管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">收购信息</a></li>
							<li><a href="#">杀青信息</a></li>
							<li><a href="#">烘干信息</a></li>
							<li><a href="#">筛选信息</a></li>
							<li><a href="#">包装信息</a></li>
							<li><a href="#">成品信息</a></li>
						</ul></li>
					<li><a href="farm-manage.jsp"><i class="fa fa-table"></i>田间信息管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">收购信息</a></li>
							<li><a href="#">杀青信息</a></li>
							<li><a href="#">烘干信息</a></li>
							<li><a href="#">筛选信息</a></li>
							<li><a href="#">包装信息</a></li>
							<li><a href="#">成品信息</a></li>
						</ul></li>
					<li><a href="batch-manage.html"><i class="fa fa-edit"></i>批次信息管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="#">收购信息</a></li>
							<li><a href="#">杀青信息</a></li>
							<li><a href="#">烘干信息</a></li>
							<li><a href="#">筛选信息</a></li>
							<li><a href="#">包装信息</a></li>
							<li><a href="#">成品信息</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-sitemap"></i>加工信息管理<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="handing_purchase_check">收购信息</a></li>
							<li><a href="handing_wrap_check">杀青信息</a></li>
							<li><a href="handing_drying_check">烘干信息</a></li>
							<li><a href="handing_dressing_check">筛选信息</a></li>
							<li><a href="handing_packing_check">包装信息</a></li>
							<li><a href="handing_product_check">成品信息</a> <!-- <span class="fa arrow"></span>
								<ul class="nav nav-third-level">
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>
									<li><a href="#">Third Level Link</a></li>
								</ul> --></li>
						</ul></li>
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">
					首页 <small>欢迎</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">首页</a></li>
					<li class="active">Data</li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="panel-default">
							<!--  <div class="panel-heading">
                               轮播图
                           </div> -->
							<div class="panel-body">
								<div class="carousel slide" data-ride="carousel" id="lunbo">
									<ol class="carousel-indicators">
										<li data-target="#lunbo" data-slide-to="0" class="active"></li>
										<li data-target="#lunbo" data-slide-to="1" class="active"></li>
										<li data-target="#lunbo" data-slide-to="2" class="active"></li>
										<li data-target="#lunbo" data-slide-to="3" class="active"></li>
									</ol>
									<div class="carousel-inner" role="listbox">
										<div class="item active">
											<img src="images/1.jpg">
										</div>
										<div class="item">
											<img src="images/2.jpg">
										</div>
										<div class="item">
											<img src="images/3.jpg">
										</div>
										<div class="item">
											<img src="images/5.jpg">
										</div>
									</div>
									<a href="#lunbo" class="left carousel-control"
										rel="external nofollow" rol="button" data-slide="prev"> <span
										class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
										<span class="sr-only">上一张</span>
									</a> <a class="right carousel-control" href="#lunbo"
										rel="external nofollow" role="button" data-slide="next"> <span
										class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
										<span class="sr-only">下一张</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<footer>
					<p>
						Copyright &copy; 2016.Company name All rights reserved.More
						Templates <a href="http://www.cssmoban.com/" target="_blank"
							title="模板之家">模板之家</a> - Collect from <a
							href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
					</p>
				</footer>
			</div>
		</div>
	</div>
	<script src="assets/js/jquery-1.10.2.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/morris/raphael-2.1.0.min.js"></script>
	<script src="assets/js/morris/morris.js"></script>
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	<script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	<script src="assets/js/custom-scripts.js"></script>
	<script>
		
	</script>
</body>
</html>