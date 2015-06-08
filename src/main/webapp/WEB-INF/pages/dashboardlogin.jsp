<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${contextPath}/resources/css/main.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${contextPath}/resources/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="main">
		<center>
			<div class="logo">
				<img src="${contextPath}/resources/images/logo.png">
			</div>
			<div class="post">

				<form name='loginForm' action="<c:url value='/login' />"
					method='POST' class='form-signin'>
					<h2 class="form-signin-heading">Sign in</h2>
					<c:if test="${not empty error}">
						<div class="alert alert-danger" role="alert">
							<strong>Warning! </strong><br> ${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="alert alert-info" role="alert">
							<strong>Info!</strong><br>${msg}</div>
					</c:if>
					<label for="inputEmail" class="sr-only">Logins</label> <input
						type="text" id="input" class="form-control" name='username'
						placeholder="Login" required autofocus> <label
						for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="inputPassword" class="form-control"
						placeholder="Password" name='password' required>
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember me
						</label> <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form>
			</div>
		</center>
	</div>
	<!-- /container -->
</body>
</html>
