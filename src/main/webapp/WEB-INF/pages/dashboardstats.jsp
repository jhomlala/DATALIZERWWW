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
					<li class="active"><i class="fa fa-dashboard"></i>
						Dashboard/Statistics</li>
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
											<td>${word.id }</td>
											<td>${word.word }</td>
											<td>${word.amount }</td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>






						<script>
						var chart;

						var chartData = [ 
						<c:forEach var="word" items="${wordList}">
							{"word": "${word.word}",
							 "amount" : "${word.amount}"
							},  
						</c:forEach>
						                  
						  ];

						AmCharts
								.ready(function() {
									// SERIAL CHART
									chart = new AmCharts.AmSerialChart();
									chart.dataProvider = chartData;
									chart.categoryField = "word";
									chart.startDuration = 1;

									// AXES
									// category
									var categoryAxis = chart.categoryAxis;
									categoryAxis.labelRotation = 90;
									categoryAxis.gridPosition = "start";

									// value
									// in case you don't want to change default settings of value axis,
									// you don't need to create it, as one value axis is created automatically.

									// GRAPH
									var graph = new AmCharts.AmGraph();
									graph.valueField = "amount";
									graph.balloonText = "[[category]]: <b>[[value]]</b>";
									graph.type = "column";
									graph.lineAlpha = 0;
									graph.fillAlphas = 0.8;
									chart.addGraph(graph);

									// CURSOR
									var chartCursor = new AmCharts.ChartCursor();
									chartCursor.cursorAlpha = 0;
									chartCursor.zoomable = false;
									chartCursor.categoryBalloonEnabled = false;
									chart.addChartCursor(chartCursor);

									chart.creditsPosition = "top-right";

									chart.write("chartdiv");
								});
					</script>

					<h2>Graph</h2>
						<div id="chartdiv" style="width: 100%; height: 400px;"></div>
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

