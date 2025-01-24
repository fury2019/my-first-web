<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>ADMIN</title>
    
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
    
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    
</head>

<body class="sb-nav-fixed">

	<c:set var="adminList" value="${requestScope.adminList }" />
	<c:set var="adminReserveList" value="${requestScope.adminReserveList }" />
	<c:set var="RtotalCnt" value="${requestScope.RtotalCnt }" />


    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-3" href="${pageContext.request.contextPath }/admin/AdminMain.ad">ADMIN</a>
        <!-- Sidebar Toggle-->
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                class="fas fa-bars"></i></button>
        <!-- Navbar Search-->

    </nav>

    <div id="layoutSidenav">
        <!------------------------ 사이드바---------------------------->
        <div id="layoutSidenav_nav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <hr>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                정보 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>

                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                                data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link " href="${pageContext.request.contextPath }/admin/AdminMemberList.ad">
                                        회원정보	
                                    </a>

                                    <a class="nav-link collapsed" href="${pageContext.request.contextPath }/admin/AdminSalesList.ad">
                                        매출정보
                                    </a>
                                    <a class="nav-link collapsed" href="${pageContext.request.contextPath }/admin/AdminRoomList.ad">
										객실정보
									
									</a>
									<a class="nav-link collapsed" href="/admin/room_add.jsp">
										객실등록
									</a>
                                </nav>
                            </div>
                            <a class="nav-link" href="${pageContext.request.contextPath }/admin/AdminReservationList.ad">
                                <div class="sb-nav-link-icon"><i class="fas fa-bars"></i></div>
                                예약 목록
                            </a>
                            <a class="nav-link" href="../login/index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                메인 홈페이지
                            </a>
                            <hr>
                        </div>
                    </div>

                </nav>
            </div>
        </div>
        <!------------------------ 사이드바끝 --------------------------->

        <div id="layoutSidenav_content">
            <main>	
                <div class="container-fluid px-4">
                    <h1 class="mt-4">ADMIN</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active"></li>
                    </ol>
                    
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-chart-area me-1"></i>
                                    매출 내역
                                </div>
                                <div class="card-body">
                               	 	<canvas id="myAAreaChart" width="100%" height="40"></canvas>
                                </div>
                            </div>
            	            </div>
                        
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-chart-bar me-1"></i>
                                    예약 내역
                                </div>
                                <div class="card-body">
                              	 	<canvas id="myBarChart" width="100%" height="40"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    

                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            회원내역	
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                    
                                        <th>고객명</th>
                                        <th>아이디</th>
                                        <th>비밀번호</th>
                                        <th>이메일</th>
                                        <th>전화번호</th>
                                    </tr>
                                </thead>
                               
                                <tbody>

									<c:choose>
										<c:when
											test="${adminList != null and fn:length(adminList) > 0 }">
											<c:forEach var="admin" items="${adminList }">
												<tr>
													<td>${admin.u_name}</td>
													<td>${admin.u_id}</td>
													<td>${admin.u_password}</td>
													<td>${admin.u_email}</td>
													<td>${admin.u_phone}</td>
												</tr>
											</c:forEach>
										</c:when>

										<c:otherwise>
										
											<tr>
												<td>등록된 게시물이 없습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i>
                            예약내역
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple2">
                               <thead>

									<tr>
										<th>예약번호</th>
										<th>아이디</th>
										<th>성인</th>
										<th>어린이</th>
										<th>체크인</th>
										<th>체크아웃</th>
										<th>객실</th>
										<th>1박 금액</th>
										<th>총 금액</th>
										<th>예약일</th>
									</tr>
								</thead>


								<tbody>

									<c:choose>
										<c:when
											test="${adminReserveList != null and fn:length(adminReserveList) > 0 }">
											<c:forEach var="reserve" items="${adminReserveList }">
												<tr>
													<td>${reserve.res_number}</td>
													<td>${reserve.u_id}</td>
													<td>${reserve.res_adults}</td>
													<td>${reserve.res_kids}</td>
													<td>${reserve.res_checkin}</td>
													<td>${reserve.res_checkout}</td>
													<td>${reserve.res_rtype}</td>
													<td>${reserve.res_price}</td>
													<td>${reserve.totalamount}</td>
													<td>${reserve.res_time}</td>
												</tr>
											</c:forEach>
										</c:when>

										<c:otherwise>
											<tr>
											
												<td>등록된 게시물이 없습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
            
        </div>
    </div>

    <br>


    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<!--     <script src="js/chart-area-demo.js"></script> -->
<!--     <script src="js/chart-area-demo2.js"></script> -->
<!--     <script src="js/chart-bar-demo.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/simple-datatables.js" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
    <script src="js/datatables-simple-demo2.js"></script>
</body>
<script type="text/javascript">


var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx,
		{

			type : 'bar',
			data : {
				labels : [ '9월', '10월', '11월', '12월' ],
				datasets : [ {
					label : "예약 수",
					backgroundColor : [ 
							'rgba(255, 99, 132, 0.5)',
							'rgba(54, 162, 235, 0.5)',
							'rgba(255, 206, 86, 0.5)',
							'rgba(75, 192, 192, 0.5)',
 ],
					borderColor : [ 
							'rgba(255, 99, 132,1.5)',
							'rgba(54, 162, 235, 1.5)',
							'rgba(255, 206, 86, 1.5)',
							'rgba(75, 192, 192, 1.5)',
],
					data : ["${ReCnt9}",  "${ReCnt10}", "${ReCnt11}","${ReCnt12}" ],
				} ],
			},
			options : {
				scales : {
					xAxes : [ {
						time : {
							unit : 'month'
						},
						gridLines : {
							display : false
						},
						ticks : {
							maxTicksLimit : 10
						}
					} ],
					yAxes : [ {
						ticks : {
							min : 0,
							max : 20,
							maxTicksLimit : 10
						},
						gridLines : {
							display : true
						}
					} ],
				},
				legend : {
					display : false
				}
			}
		});


var ctx = document.getElementById("myAAreaChart");
var myLineChart = new Chart(ctx, {
	type : 'bar',
	data : {
		labels : [ '9월', '10월', '11월', '12월' ],
		datasets : [
				{
					label : '바 그래프',
					type : 'bar', // 'bar' type, 전체 타입과 같다면 생략가능
					backgroundColor : [ 
							'rgba(75, 192, 192, 0.5)',
							'rgba(153, 102, 255, 0.5)',
							'rgba(200, 133, 200, 0.5)',
							'rgba(255, 159, 64, 0.5)' ],
					borderColor : [ 
							'rgba(75, 192, 192, 1.5)',
							'rgba(153, 102, 255, 1.5)',
							'rgba(200, 133, 200, 1.5)',
							'rgba(255, 159, 1, 1.5)' ],
					data : ["${ReSales9}", "${ReSales10}", "${ReSales11}","${ReSales12}" ]
				}, ]
	},
	options : {
		scales : {
			xAxes : [ {
				time : {
					unit : 'month'
				},
				gridLines : {
					display : false
				},
				ticks : {
					maxTicksLimit : 7
				}
			} ],
			yAxes : [ {
				ticks : {
					min : 0,
					max : 5000000,
					maxTicksLimit : 10
				},
				gridLines : {
					display : true
				}
			} ],
		},
		legend : {
			display : false
		}
	}
});



</script>



</html>