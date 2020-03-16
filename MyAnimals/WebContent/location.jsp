<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<body>
	<%@ include file="./getAnimalData.jsp"%>
	<input type="button" value="지역" id="selectLocationButton">
	<input type="button" value="종" id="selectKindButton">
	<input type="button" value="상태" id="selectStateButton" onclick="getData('state')">
	<br>
	<script type="text/javascript">
		$("#selectLocationButton").click(function () {
			$("#area").css("display", "");
			$("#animalKind").css("display", "none");
		})
		$("#selectKindButton").click(function () {
			$("#animalKind").css("display", "");
			$("#area").css("display", "none");
		})
		$('#selectStateButton').click(function () {
			$("#animalKind").css("display", "none");
			$("#area").css("display", "none");
		})
	</script>
	<%@ include file="./searchSelect.jsp"%>


	<canvas id="myChart" style="width: 1000px; height: 500px;"></canvas>
	<script type="text/javascript">

		$('document').ready(function () {
			var name = new Array();
			var value = new Array();
			var index = 0;
			$.ajax({
				url: "location.do",
				type: "POST",
				dataType: "json",
				data: {
					'sido': '전국'
				},
				success: function (data) {
					$.each(data, function (key, val) {
						name[index] = key;
						value[index] = val;
						index++;
					});
					$('#myChart').replaceWith('<canvas id="myChart" style="width: 1000px; height: 500px;"></canvas>');
					var ctx = document.getElementById("myChart").getContext('2d');
					var myChart = new Chart(ctx, {
						type: 'doughnut',
						data: {
							labels: name,
							datasets: [{
								label: $('#sido').val(),
								data: value,
								backgroundColor: [
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 99, 132, 0.2)',],
								borderColor: [
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255,99,132,1)',],
								borderWidth: 1
								
							}]
						},
						options: {
							responsive: false,
							maintainAspectRatio: false, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
							scales: {
								yAxes: [{
									ticks: {
										beginAtZero: true
									}
								}]
							}
						}
					});
				},
				error: function (request, status, error) {
				}
			});
		})
	</script>
	
	
</body>
</body>

</html>