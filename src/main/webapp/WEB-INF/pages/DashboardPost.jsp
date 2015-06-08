<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="header.jsp" %>
<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script>tinymce.init({selector:'textarea'});</script>

<div class="main">
	<div class="postadd">
	<h2>Create post</h2>
	<c:if test="${errorList == null}"> 
	<form name='postForm' action="<c:url value='/dashboard/add' />" method='POST'>
		<textarea id="message" name="message"></textarea>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<br><input name="submit" type="submit" value="Post it!" />
	</form>
						
	</c:if>
	<c:if test="${(errorList != null) and (success==null)}"> 
		<%@ include file="Error.jsp" %>
		
	</c:if>
	
	<c:if test="${success != null}"> 
	<div class="alert alert-success" role="alert">
               		 	<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
               		 	<strong>Success.</strong> Your message has been posted.
               		 	</div>
	</c:if>
	</div>
	</div>
	
</body>
</html>

