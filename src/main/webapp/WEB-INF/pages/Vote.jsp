<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="header.jsp" %>
<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script>tinymce.init({selector:'textarea'});</script>

<div class="main">
    <div class="postadd">
    <h2>Vote</h2>
    <c:if test="${errorList == null}"> 
    <div class="alert alert-success" role="alert">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                        <strong>Success.</strong> Your vote has been saved.
                        </div>
    </c:if>
    <c:if test="${errorList != null}"> 
    
        <%@ include file="Error.jsp"%>
    </c:if>
    </div>
    </div>
    
</body>
</html>

