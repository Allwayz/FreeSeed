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
		<script>
			function userDetailClick(dataInput) {
				$.ajax({
					type: "GET",
					url: "checkUserDtl/"+$(dataInput).html(),
					dataType: "json",
					success: function (data) {
						confirm(
							"Role: "+data.roleDesc+"\n"+
							"First Name: "+data.fristName+"\n" +
							"Last Name: "+data.lastName+"\n" +
							"Email: "+data.user_email+"\n" +
							"Password: "+data.user_password+"\n" +
							"Birthday: "+data.birthday+"\n" +
							"Telephone: "+data.telephone+"\n" +
							"================================="+"\n" +
							"Location: "+data.cityName+" · "+data.provinceName+" · "+data.nationalName
						)
					},
					timeout:2000,
					sync: true
				})
			};

			function userDetailClickById(dataInput) {
				$.ajax({
					type: "GET",
					url: "checkUserDtlById/"+dataInput,
					dataType: "json",
					success: function (data) {
						confirm(
								"Role: "+data.roleDesc+"\n"+
								"First Name: "+data.fristName+"\n" +
								"Last Name: "+data.lastName+"\n" +
								"Email: "+data.user_email+"\n" +
								"Password: "+data.user_password+"\n" +
								"Birthday: "+data.birthday+"\n" +
								"Telephone: "+data.telephone+"\n" +
								"================================="+"\n" +
								"Location: "+data.cityName+" · "+data.provinceName+" · "+data.nationalName
						)
					},
					timeout:2000,
					sync: true
				})
			};

			function addMajorDtl(input) {
				var r = confirm("Confirm to add a Major Dtl")
				//TODO: can not run here
				if(r==true){
					// $.ajax({
					//     url: "addMajorDtl?year="+year+"&semester="+semester+"&classroom=1&majorId="+majorId,
					//     dataType: "json",
					//     success: function (data) {
					//         alert(data)
					//     }
					// })
					alert(input.val())
					//document.write("You pressed OK!")
				}

			};

			function addMajor(majorDepartment,MajorName) {
				$.ajax({
					    url: "addMajor?majorDepartment="+$(majorDepartment).val()+"&majorName="+$(MajorName).val(),
					    dataType: "json",
					    success: function (data) {
					        location.reload();
					    }
				})
				location.reload();
			}
		</script>
		<script>
			function turn_gray(id,majorId) {
				document.getElementById("netghost").style.display = "block";
				document.getElementById("netghost").style.width = document.body.clientWidth;
				document.getElementById("netghost").style.height = document.body.clientHeight;
				document.getElementById(id).style.display = "block";
				document.getElementById(id).style.top = document.documentElement.scrollTop + document.body.scrollTop + 100;
				document.getElementById(id).style.left = (document.body.clientWidth - document.getElementById(id).clientWidth) / 2;
			}
			function turn_back(id) {
				document.getElementById(id).style.display = "none";
				document.getElementById("netghost").style.display = "none";
			}

			function deleteUser(userId) {
				var r = confirm("Are you confirm to disable this account?")
				if(r){
					$.ajax({
						url: "deleteUser/"+userId,
						method: "delete",
						dataType: "json",
						success: function (data) {
							location.reload();
						}
					})
				}

			}
		</script>

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

			.fw
			{
				position: absolute;
				z-index: 2002;
				width: 550px;
				height: 600px;
				background-color:#fff;
				display: none;
				border: 2px solid #000;
			}

			.fw a
			{
				font-size: 24px;
				float: right;
				padding-right: 10px;
				text-decoration: none;
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
					<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
						<h2 id="tableName">${requestScope.message}</h2>
						<div class="btn-toolbar mb-2 mb-md-0">
							<div class="btn-group mr-2">
								<button class="btn btn-sm btn-outline-secondary" onclick="location.reload()">
									<img src="https://img.icons8.com/officel/16/000000/available-updates.png" width="30"/>
									Refresh
								</button>
							</div>
						</div>
					</div>
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
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tableMap}" var="node">
										<tr>
											<td>${node.userId}</td>
											<td><span style="cursor:pointer" onclick="userDetailClick(this)">${node.userEmail}</span></td>
											<td>${node.updateTime}</td>
											<td>
												<c:choose>
													<c:when test="${node.roleId == 1}">
													Admin
													</c:when>
													<c:when test="${node.roleId == 2}">
														Teacher
													</c:when>
													<c:when test="${node.roleId == 3}">
														Student
													</c:when>
												</c:choose>
											</td>
											<c:choose>
												<c:when test="${node.roleId == 1}">
													<td><button class="btn btn-warning" onclick="deleteUser(${node.userId})" disabled>Disable User</button></td>
												</c:when>
												<c:otherwise>
													<td><button class="btn btn-warning" onclick="deleteUser(${node.userId})">Disable User</button></td>
												</c:otherwise>
											</c:choose>
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
									<th style="width: 300px">Add Major Detail</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${tableMap}" var="node">
									<tr>
										<td><span id="majorId">${node.majorId}</span></td>
										<td><span style="cursor:pointer" onclick="majorDetailClick(this)">${node.majorName}</span></td>
										<td>${node.majorCode}</td>
										<td>${node.majorStatus}</td>
										<td>${node.updateTime}</td>
										<td>
											<div class="input-group" style="width: 300px">
												<div>
														<button class="btn btn-default btn-success" onclick="turn_gray('fw_01',${node.majorId})">
															Add a major detail
														</button>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<span onclick="turn_gray('fw_02')">
											<img src="https://img.icons8.com/officel/80/000000/add-database.png" width="20">
											Add new Row
										</span>
									</td>
								</tr>
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
										<td>${node.enrollmentId}</td>
										<td><span style="cursor:pointer" onclick="userDetailClickById(${node.userId})">${node.userId}</span></td>
										<td>${node.majorDtlId}</td>
										<td>${node.createTime}</td>
									</tr>
								</c:forEach>
								</tbody>
							</c:when>
							</c:choose>
						</table>
					</div>
					<div id="netghost"></div>
					<!-------MajorDtl浮层---------->
					<div id="fw_01" class="fw">
						<div class="input-group back" style="width: 500px">
							<a href="javascript: turn_back('fw_01')">×</a>
							<select class="custom-select" id="yearSelect">
								<option selected>Choose...</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2024">2024</option>
							</select>
							<select class="custom-select" id="semesterSelect">
								<option selected>Choose...</option>
								<option value="SS">SS</option>
								<option value="FW">FW</option>
							</select>
							majorId: <span id="major_id">2</span>
							<div>
								<button class="btn btn-default btn-success">
<%--									TODO: 无法传递参数--%>
									<span onclick="addMajorDtl(this.$('#majorId'))">Confirm</span>
								</button>
							</div>
						</div>
					</div>
					<!-------Major浮层------------->
					<div id="fw_02" class="fw">
							Major Name: <input type="text" id="majorName" name="majorName">
						Major Department: <select id="majorDepartmentList" >
								<option selected>Choose...</option>
								<option>Philosophy</option>
								<option>Economics</option>
								<option>Law</option>
								<option>Education</option>
								<option>Literature</option>
								<option>History</option>
								<option>Science</option>
								<option>Engineering</option>
								<option>Agriculture</option>
								<option>Medicine</option>
								<option>Military</option>
								<option>Management</option>
								<option>Art</option>
							</select>
						<button onclick="addMajor($('#majorDepartmentList'),$('#majorName'))">Commit</button>
						<a href="javascript: turn_back('fw_02')">Cancel</a>
					</div>
				</main>
			</div>
		</div>


		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script type="text/javascript" src="asserts/js/jquery-3.4.1.js"></script>
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