<%@include file="dashboard-header.jsp"%>


	<div id="page-wrapper">

		<div class="container-fluid">

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Dashboard <small>Statistics</small>
					</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-dashboard"></i> Dashboard/Statistics
						</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="post">
					<c:if test="${not empty wordList}">
					  <h2>Most Revelant Words</h2>
					  <h4>Last update: ${lastDate }</h4>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                    	<th>ID</th>
                                        <th>Word</th>
                                        <th>Amount</th>
                                        

                                    </tr>
                                </thead>
                                <tbody>
                                   <c:forEach var="word" items="${wordList}">
                                   <tr>
                                   		<td>${word.idStats }</td>
                                   		<td>${word.word }</td>
                                   		<td>${word.amount }</td>
                                   </tr>
                                   </c:forEach>
                                   
               
                                </tbody>
                            </table>
                        </div>
                        </c:if>
					</div>
				</div>
			</div>
			<!-- /.row -->






		</div>
		<!-- /.container-fluid -->
 
	</div>
	<!-- /#page-wrapper -->
<%@include file="dashboard-footer.jsp"%>

