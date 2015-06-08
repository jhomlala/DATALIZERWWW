<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%> 
  <%@ include file="header.jsp" %>
 
        <div class="main">
            <div class="post">
        <h1>Avatar upload</h1>
 		<c:if test="${errorList != null}">
 			<c:forEach items="${errorList}" var="item">
	   					<li>${item}</li>
	   					</c:forEach>
 		</c:if>
 		 
        <form:form method="post" action="/SpringSecurity/dashboard/upload?${_csrf.parameterName}=${_csrf.token}"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p>Select files to upload. Press Add button to add more file
                inputs.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="crunchifyFiles" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
            <input id="addFile" type="button" value="Add File" />

        </form:form>
 
        </div>
    </div>
</body>
</html>