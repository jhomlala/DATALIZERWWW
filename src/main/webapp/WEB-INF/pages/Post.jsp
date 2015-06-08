<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="header.jsp"%>

<div class="main">

	<c:if test="${errorList == null}">
		<div class="post">
			<table cellspacing="10" class="post_table">
				<tr>

					<td width="15%"><a
						href="/SpringSecurity/profile/<c:out value="${post.authorID }" />"><c:out
								value="${post.authorName}" /></a><br> <img width="50px"
						src="${contextPath }/resources/avatars/${post.authorAvatarURL}">
						<br>Posted:<br>
						<p>${post.createdDate }</p> <c:if test="${post.totalCount == 0}">
							<div class="points">${post.totalCount}</div>
						</c:if> <c:if test="${post.totalCount > 0}">
							<div class="points plus">+${post.totalCount}</div>
						</c:if> <c:if test="${post.totalCount < 0}">
							<div class="points minus">${post.totalCount}</div>
						</c:if>
						<div class="iconvote">
							<img src="${contextPath }/resources/images/plus.png"></img> <img
								src="${contextPath }/resources/images/minus.png"></img>
						</div>
						<br>

						</td>
					<td><a href="${contextPath}/post/${post.id}">#<c:out
								value="${post.id}" /></a>


						<hr class="specialhr"> <c:out value="${post.message}"
							escapeXml="false" /></td>
				</tr>
			</table>
			<br>
			<div style="position: relative; left: 15%;">
				<a href="${contextPath}/post/${post.id}/addComment"
					class="btn btn-primary btn-lg raised" role="button">Add Comment</a>
				<a href="#" class="btn btn-primary btn-lg raised" role="button">Report
					this post</a>
			</div>
			<hr class="hrspecial">
			<h4>Comments:</h4>
			<div class="comments">
				<c:if test="${fn:length(post.commentList) <= 0}">
                 There is no comments to show. 
            </c:if>

				<table cellspacing="10" class="post_table">
					<c:forEach items="${post.commentList}" var="item">

						<td width="15%"><a
							href="/SpringSecurity/profile/<c:out value="${item.authorID }" />"><c:out
									value="${item.authorName}" /></a><br> <img width="50px"
							src="${contextPath }/resources/avatars/${item.authorAvatarURL}">
							<br>Posted:<br>
							<p>${item.createdDate }</p>
                            
                            <c:if test="${item.totalCount == 0}">
                            <div class="points">${item.totalCount}</div> 
                            </c:if>
                            <c:if test="${item.totalCount > 0}">
							<div class="points plus">+${item.totalCount}</div> 
							</c:if>
							<c:if test="${item.totalCount < 0}">
                             <div class="points minus">${item.totalCount}</div> 
                            </c:if>
							<div class= "iconvote">
							<img src="${contextPath }/resources/images/plus.png" ></img> 
							<img src="${contextPath }/resources/images/minus.png"></img> 
							</div><br>
						</td>
						<td>#<c:out value="${item.id}" />

 
							<hr class="specialhr"> <c:out value="${item.message}"
								escapeXml="false" />
						</td>
						</tr>

					</c:forEach>


				</table>

			</div>
	</c:if>
</div>


<c:if test="${errorList != null}">
	<%@ include file="Error.jsp"%>
</c:if>

</div>
</body>
</html>