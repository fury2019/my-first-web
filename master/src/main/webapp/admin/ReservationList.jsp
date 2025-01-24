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
</head>

<body class="sb-nav-fixed">

	<c:set var="adminReserveList" value="${requestScope.adminReserveList }" />

	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="${pageContext.request.contextPath }/admin/AdminMain.ad">ADMIN</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
	</nav>

	<div id="layoutSidenav">
		<!------------------------ 사이드바---------------------------->
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
								</div> 정보 관리
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
		<!-- ------------------------------------------------------------------ -->


		<div id="layoutSidenav_content">

			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">예약 회원</h1>
					<br>
					<div>
						<strong>총 내역 : ${totalCnt} 개</strong>
					</div>

					<div class="card mb-4">

					<form action="${pageContext.request.contextPath }/admin/AdminReservationCancel.ad" name="reedit" method="POST">
						<div class="card-body">
							<table id="datatablesSimple">
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
										<th>총 금액</th>										<th>예약일</th>
										<th>취소</th>

									</tr>

								</thead>

								<tbody>
									<c:choose>
											<%-- 회원이 있는경우 --%>
											<c:when
												test="${adminReserveList != null and fn:length(adminReserveList) > 0 }">
												<c:forEach var="reservation" items="${adminReserveList }">
													<tr style="height: 40px;">
															<td name="res_number">${reservation.res_number }</td>
															<td name="u_id">${reservation.u_id }</td>
															<td>${reservation.res_adults }</td>
															<td>${reservation.res_kids }</td>
															<td name="res_checkin">${reservation.res_checkin }</td>
															<td name="res_checkout">${reservation.res_checkout }</td>
															<td name="res_rtype">${reservation.res_rtype }</td>
															<td name="res_price">${reservation.res_price }</td>
															<td >${reservation.totalamount }</td>
															<td>${reservation.res_time}</td>
															<td><a href="javascript:edit('${reservation.res_number }','${reservation.u_id}' ,'${reservation.res_checkin }','${reservation.res_checkout }','${reservation.res_rtype }','${reservation.res_price }')" >
															예약취소</a></td>
													</tr>
												</c:forEach>
											</c:when>
	
											<%-- 회원이 없는경우 --%>
											<c:otherwise>
												<tr>
													<td>등록된 게시물이 없습니다.</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
							</div>
						</form>
					</div>
				</div>
			</main>

			
		</div>
	</div>

	<br>
<script>
    function edit(resnum, id,checkin, checkout, rtype, rprice){
        let num = resnum;
        let pw = prompt("비밀번호를 입력해주세요!");
        if(pw == 1234){
            alert("변경이 완료되었습니다.")
            document.reedit.action = "${pageContext.request.contextPath }/admin/AdminReservationCancel.ad?res_number="+resnum+"&u_id="+id+"&res_checkin="+checkin+"&res_checkout="+checkout+"&res_rtype="+rtype+"&res_price="+rprice;
            document.reedit.submit();
        }else{
            alert("비밀번호를 확인해 주세요!");
        }
    }
</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>



	<script src="js/simple-datatables.js" crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="js/chart-area-demo2.js"></script>
	<script src="js/datatables-simple-demo2.js"></script>

	<script src="../js/jquery.min.js"></script>

	<script src="../js/popper.min.js"></script>

	<script src="../js/bootstrap.min.js"></script>

	<script src="../js/roberto.bundle.js"></script>

	<script src="../js/default-assets/active.js"></script>

</body>

</html>