<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>

<div class="main">
	<div class="post">





		<c:forEach items="${postList}" var="item">
			<table cellspacing="10" class="post_table">
				<tr>

					<td width="15%"><a
						href="/SpringSecurity/profile/<c:out value="${item.authorID }" />"><c:out
								value="${item.authorName}" /></a><br> <img width="50px"
						src="resources/avatars/${item.authorAvatarURL}"> <br>Posted:<br>
						<p>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
								value="${item.createdDate}" />
						</p>

				    	<c:if test="${item.totalCount == 0}">
                            <div class="points">${item.totalCount}</div>
                        </c:if> <c:if test="${item.totalCount > 0}">
                            <div class="points plus">+${item.totalCount}</div>
                        </c:if> <c:if test="${item.totalCount < 0}">
                            <div class="points minus">${item.totalCount}</div>
                        </c:if>
                        <div class="iconvote">
                            <a href="${contextPath }/post/${item.id}/vote/plus"><img src="${contextPath }/resources/images/plus.png"></a></img> 
                            <a href="${contextPath }/post/${item.id}/vote/minus"><img src="${contextPath }/resources/images/minus.png"></a></img>
                        </div>
                        <br></td>
					<td><a href="${contextPath}/post/${item.id}">#<c:out
								value="${item.id}" /></a>


						<hr class="specialhr"> <c:out value="${item.message}"
							escapeXml="false" /></td>
				</tr>
			</table>
			<p></p>
			<div style="position: relative; left: 15%;">
				<a href="${contextPath}/post/${item.id}/addComment"
					class="btn btn-primary btn-lg raised" role="button">Add Comment</a>
				<a href="#" class="btn btn-primary btn-lg raised" role="button">Report
					this post</a>
			</div>
			<hr>





		</c:forEach>


	</div>
</div>
</body>
</html>