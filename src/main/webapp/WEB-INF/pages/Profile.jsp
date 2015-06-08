<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%> 
  <%@ include file="header.jsp" %>
 
    	<div class="main">
    		<div class="profile">
			 <c:if test="${person != null}"> 
    			<h2>Profile - ${person.visibleName }</h2>
    			<br>
    			<div class="green">
    			<table width="100%">
    			<tr>
	    			<td>
	    				Member since <fmt:formatDate type="date" value="${person.registerDate}" />
	    				<br>
	    				Last seen: <fmt:formatDate type="date" value="${person.lastOnlineDate}" /> 
	    				<br>
	    				Last post: <fmt:formatDate type="date" value="${person.lastPostTime}" /> 
	    			</td>
	    			<td>
	    				<c:if test="${not person.avatarSet}"><img src="${contextPath}/resources/avatars/av_0.jpg"></c:if>
	    				<c:if test="${person.avatarSet}"><img src="${contextPath}/resources/avatars/av_${person.id}.jpg"></c:if>
	    			</td>
    			</tr>
  
    			
    			</table>	
    			</div>
    			<h3>Last 5 posts:</h3> 
    			<div class="green"">
    			<c:forEach items="${personPosts}" var="item">
	   					<li><fmt:formatDate type="both" value="${item.createdDate}" />
	   					<br>${item.message}
	   					
	   					</li>
	   					
						</c:forEach>
    			
    			</div>
    		</div>
    		
    		</c:if>
    		<c:if test="${person == null}"> 
    		
    		
    		<div class="alert alert-danger" role="alert">
        	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
       	    <strong>Error!</strong><br>
       	    There is no user with this ID.
			</div> 
			<a href="../">Return to main site.</a>
    		
    		 
    		</c:if>
    </div>
</body>
</html>