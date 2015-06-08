<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="header.jsp" %>
<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script>tinymce.init({selector:'textarea'});</script>

<div class="main">
	<div class="postadd">
	
	<c:if test="${errorList == null}">  
	<h2>Create comment</h2>
    <div class="green">You are commenting <a href="${contextPath }/post/${id }">this post.</a></div>
	<br>
	<form name='postForm' action="<c:url value='/post/${post.id }/addComment' />" method='POST'>
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
               		 	<br><a href="${contextPath }/post/${id }">Check your comment.</a>
               		 	</div>
	</c:if>
	</div>
	</div>
	
</body>
</html>