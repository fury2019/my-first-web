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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>ADMIN</title>

<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />

<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>


<body class="sb-nav-fixed">

	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand ps-3" href="${pageContext.request.contextPath }/admin/AdminMain.ad">ADMIN</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
	</nav>



	<div id="layoutSidenav">

		<div id="layoutSidenav_nav">
			<div id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<hr>

							<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
								data-bs-target="#collapsePages" aria-expanded="false"
								aria-controls="collapsePages">
								<div class="sb-nav-link-icon">
									<i class="fas fa-book-open"></i>
								</div> 관리 테이블
								<div class="sb-sidenav-collapse-arrow">
									<i class="fas fa-angle-down"></i>
								</div>
							</a>

							<div class="collapse" id="collapsePages"
								aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
								<nav class="sb-sidenav-menu-nested nav accordion"
									id="sidenavAccordionPages">
									<a class="nav-link collapsed"
										href="${pageContext.request.contextPath }/admin/AdminMemberList.ad">
										회원정보 </a> 
									<a class="nav-link collapsed"
										href="${pageContext.request.contextPath }/admin/AdminSalesList.ad">
										매출정보 </a> 
									<a class="nav-link collapsed"
										href="${pageContext.request.contextPath }/admin/AdminRoomList.ad">
										객실정보 </a>
									<a class="nav-link collapsed" href="/admin/room_add.jsp">
										객실등록
									</a>
								</nav>
							</div>
							<a class="nav-link"
								href="${pageContext.request.contextPath }/admin/AdminReservationList.ad">
								<div class="sb-nav-link-icon">
									<i class="fas fa-bars"></i>
								</div> 예약 내역
							</a> <a class="nav-link" href="../login/index.jsp">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> 메인 홈페이지
							</a>
							<hr>
						
						</div>
					</div>

				</nav>
			</div>
		</div>


		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">객실정보</h1>
					<br>

					<div>
						<strong>총 내역 : ${totalCnt} 개</strong>
					</div>

					<div class="card mb-4">

						<div class="card-body">
							<table id="datatablesSimple">
								<thead>

									<tr>
										<th>객실 아이디</th>
										<th>객실 종류</th>
										<th>수용 인원</th>
										<th>가격</th>
									</tr>
								</thead>


								<tbody>

									<c:choose>
										<c:when
											test="${roomList != null and fn:length(roomList) > 0 }">
											<c:forEach var="room" items="${roomList }">
												<tr>
													<td>${room.r_id}</td>
													<td>${room.r_type}</td>
													<td>${room.r_capacity}</td>
													<td>${room.r_price}</td>
													<td class="text-center"><a
														href="${pageContext.request.contextPath }/admin/AdminRoomView.ad?r_id=${room.r_id }">
															상세보기</a></td>
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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<%--  <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
         --%>

	<script src="js/simple-datatables.js" crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="js/chart-area-demo2.js"></script>
	<script src="js/datatables-simple-demo2.js"></script>
</body>
