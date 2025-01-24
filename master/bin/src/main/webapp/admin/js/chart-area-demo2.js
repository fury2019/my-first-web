// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAAreaChart");
var myLineChart = new Chart(ctx, {
	type: 'bar',
     data: {
                labels: ['7월', '8월', '9월', '10월', '11월', '12월'],
                datasets: [{
                    label: '바 그래프',
                    type : 'bar', // 'bar' type, 전체 타입과 같다면 생략가능
                    backgroundColor: 'rgba(75, 192, 192, 1)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    data: [Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100)]
                }, {
                    label: '라인 그래프1',
                    type : 'line',         // 'line' type
                    fill : false,         // 채우기 없음
                    lineTension : 0.2,  // 0이면 꺾은선 그래프, 숫자가 높을수록 둥글해짐
                    pointRadius : 0,    // 각 지점에 포인트 주지 않음
                    backgroundColor: 'rgb(255, 153, 0)',
                    borderColor: 'rgb(255, 153, 0)',
                    data: [Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100),
					Math.floor(Math.random() * 100)]
                }]
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
						maxTicksLimit: 7
					}
				}],
				yAxes: [{
					ticks: {
						min: 0,
						max: 100,
						maxTicksLimit: 10
					},
					gridLines: {
						color: "rgba(0, 0, 0, .125)",
					}
				}],
			},
			legend: {
				display: false
			}
		}
});
