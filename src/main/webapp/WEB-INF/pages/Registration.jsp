<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%> 
  <%@ include file="header.jsp" %>

    <div align="center">
    	<br><br>
        <form:form action="/SpringSecurity/register/" method="post" commandName="userForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Register</h2></td>
                </tr>
                <c:if test="${success == null}"> 
	                <tr>
	                	<c:if test="${error != null}"> 
	                	<td colspan="2" >
	                	<div class="alert alert-danger" role="alert">
               		 	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
               		 	<strong>Error! </strong>Please check following items:<br>
               		 	<ul>
	                	<c:forEach items="${error}" var="item">
	   					<li>${item}</li>
						</c:forEach>
						</ul>
	                	</div>
	                	</c:if>
	                	
	                	</td>
	                </tr>
	                <tr>
	                    <td>Login:</td>
	                    <td><form:input path="login" /></td>
	                </tr>
	                <tr>
	                    <td>Password:</td>
	                    <td><form:password path="password" /></td>
	                </tr>
	                <tr>
	                    <td>E-mail:</td>
	                    <td><form:input path="email" /></td>
	                </tr>
		              <tr>
	                    <td>Visible name:</td>
	                    <td><form:input path="visibleName" /></td>
	                </tr>
	                <tr>
	       
	                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
	                </tr>
                </c:if>
                <c:if test="${success != null}">
                <tr>
               		 	<td colspan="2" align="center">
               		 	<div class="alert alert-success" role="alert">
               		 	<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
               		 	<strong>Register success.</strong> Please check email and confirm your registration!
               		 	</div>
               		 		
                		</td>
                </tr> </c:if>
            </table>
            <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
        </form:form>
    </div>
</body>
</html>