// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
	type: 'bar',
	data: {
		labels: ['5월','6월','7월', '8월', '9월', '10월', '11월', '12월'],
		datasets: [{
			label: "Revenue",
			backgroundColor: [
				'rgba(255, 99, 132, 0.5)',
				'rgba(54, 162, 235, 0.5)',
				'rgba(255, 206, 86, 0.5)',
				'rgba(75, 192, 192, 0.5)',
				'rgba(153, 102, 255, 0.5)',
				'rgba(200, 133, 200, 0.5)',
				'rgba(255, 159, 64, 0.5)'],
		borderColor: [
				'rgb(255, 99, 132,1.5)',
                'rgba(54, 162, 235, 1.5)',
                'rgba(255, 206, 86, 1.5)',
                'rgba(75, 192, 192, 1.5)',
                'rgba(153, 102, 255, 1.5)',
                'rgba(200, 133, 200, 1.5)',
                'rgba(255, 159, 1, 1.5)'],
		data: [Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50),
					Math.floor(Math.random() * 400+50)],
	}],
},
	options: {
	scales: {
		xAxes: [{
			time: {
				unit: 'month'
			},
			gridLines: {
				display: false
			},
			ticks: {
				maxTicksLimit:10
			}
		}],
		yAxes: [{
			ticks: {
				min: 0,
				max: 500,
				maxTicksLimit: 10
			},
			gridLines: {
				display: true
			}
		}],
	},
	legend: {
		display: false
	}
}
});
