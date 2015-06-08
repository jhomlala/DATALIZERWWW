<div class="alert alert-danger" role="alert">
        	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
       	    <strong>Error!</strong><br>
       	    <c:forEach items="${errorList}" var="item">
				<li>${item}</li>				
			</c:forEach>
			<br>
			<a href="${contextPath}">Return to main site.</a>
</div>
