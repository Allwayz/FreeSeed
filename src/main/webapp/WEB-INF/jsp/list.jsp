<!DOCTYPE html>
<!-- saved from url=(0052)http://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>List</title>
		<!-- Bootstrap core CSS -->
		<link href="asserts/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="asserts/css/dashboard.css" rel="stylesheet">
		<script src="asserts/js/jquery-3.4.1.js"></script>

		<script src="asserts/js/listFunction.js"></script>


		<style type="text/css">
			/* Chart.js */
			
			@-webkit-keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			@keyframes chartjs-render-animation {
				from {
					opacity: 0.99
				}
				to {
					opacity: 1
				}
			}
			
			.chartjs-render-monitor {
				-webkit-animation: chartjs-render-animation 0.001s;
				animation: chartjs-render-animation 0.001s;
			}
		</style>

	</head>

	<body style="background-image: url('asserts/img/background.png')">
	<%@ include file="jspTemplates/top.jsp"%>

		<div class="container-fluid">
			<div class="row">
				<%@ include file="jspTemplates/Side.jsp"%>
				<!--TODO get data from database-->
				<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
					<h2 id="tableName">${requestScope.message}</h2>
					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<c:choose>
							<%--用户表--%>
							<c:when test="${requestScope.message == 'user'}">
								<thead>
									<tr>
										<th>#</th>
										<th>${requestScope.message}</th>
										<th>updateTime</th>
										<th>Role</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tableMap}" var="node">
										<tr>
											<td>${node.userId}</td>
											<td><span style="cursor:pointer" onclick="userDetailClick(this)">${node.userEmail}</span></td>
											<td>${node.updateTime}</td>
											<td>${node.roleId}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:when>
							<%--科目表--%>
							<c:when test="${requestScope.message == 'major'}">
								<thead>
								<tr>
									<th>#</th>
									<th>${requestScope.message}</th>
									<th>Major Code</th>
									<th>Status</th>
									<th>updateTime</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${tableMap}" var="node">
									<tr>
										<td>${node.majorId}</td>
										<td><span style="cursor:pointer" onclick="majorDetailClick(this)">${node.majorName}</span></td>
										<td>${node.majorCode}</td>
										<td>${node.majorStatus}</td>
										<td>${node.updateTime}</td>
									</tr>
								</c:forEach>
								</tbody>
							</c:when>
							<%--用户学科--%>
							<c:when test="${requestScope.message == 'enrollment'}">
								<thead>
								<tr>
									<th>#</th>
									<th>Student</th>
									<th>Major Detail</th>
									<th>Create Time</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${tableMap}" var="node">
									<tr>
										<td>${node.userId}</td>
										<td><span style="cursor:pointer" onclick="userDetailClick(this)">${node.userId}</span></td>
										<td>${node.majorDtlId}</td>
										<td>${node.createTime}</td>
									</tr>
								</c:forEach>
								</tbody>
							</c:when>
							</c:choose>
						</table>
					</div>
				</main>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script type="text/javascript" src="asserts/js/jquery-3.2.1.slim.min.js"></script>
		<script type="text/javascript" src="asserts/js/popper.min.js"></script>
		<script type="text/javascript" src="asserts/js/bootstrap.min.js"></script>

		<!-- Icons -->
		<script type="text/javascript" src="asserts/js/feather.min.js"></script>
		<script>
			feather.replace()
		</script>

		<!-- Graphs -->
		<script type="text/javascript" src="asserts/js/Chart.min.js"></script>
		<script>
			var ctx = document.getElementById("myChart");
			var myChart = new Chart(ctx, {
				type: 'line',
				data: {
					labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
					datasets: [{
						data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
						lineTension: 0,
						backgroundColor: 'transparent',
						borderColor: '#007bff',
						borderWidth: 4,
						pointBackgroundColor: '#007bff'
					}]
				},
				options: {
					scales: {
						yAxes: [{
							ticks: {
								beginAtZero: false
							}
						}]
					},
					legend: {
						display: false,
					}
				}
			});
		</script>

	</body>

</html>