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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>


<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand ps-3" href="${pageContext.request.contextPath }/admin/AdminMain.ad">ADMIN</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
	</nav>

	<!-- adminDAO 변수 받아오기 -->
	<c:set var="adminList" value="${requestScope.adminList }" />
	<c:set var="adminExitList" value="${requestScope.adminExitList }" />


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
					<h1 class="mt-4">전체 회원</h1>
					<br>
					<div>
						<strong>총 내역 : ${totalCnt} 개</strong>
					</div>

					<div class="card mb-4">
						<div class="card-body">
							<form
								action="${pageContext.request.contextPath }/admin/AdminMemberUpdateOk.ad"
								name="updateform" method="post">
								<table id="datatablesSimple">
									<thead>
										<tr>
											<th>고객명</th>
											<th>전화번호</th>
											<th>이메일</th>
											<th>아이디</th>
											<th>비밀번호</th>
											<th>회원 번호</th>
										</tr>
									</thead>
									<tbody>

										<c:choose>
											<%-- 회원이 있는경우 --%>
											<c:when
												test="${adminList != null and fn:length(adminList) > 0 }">
												<c:forEach var="admin" items="${adminList }">
													<tr>

														<td><input type="text" class="edit"
															name="name${admin.u_id }" value="${admin.u_name }"
															readonly="readonly"></td>
														<td><input type="text" class="edit"
															name="phone${admin.u_id }" value="${admin.u_phone }"
															readonly="readonly"></td>
														<td><input type="text" class="edit"
															name="email${admin.u_id }" value="${admin.u_email }"
															readonly="readonly"></td>
														<td><input type="text" class="edit"
															name="id${admin.u_id }" value="${admin.u_id }"
															readonly="readonly"></td>
														<td><input type="text" class="edit"
															name="password${admin.u_id }"
															value="${admin.u_password }" readonly="readonly"></td>
														<td><input style="" type="text" class="edit"
															name="status${admin.u_id }" value="${admin.u_status }"
															readonly="readonly"></td>

														<%-- 	 아이디,이름 검색 --%>

														<td style="display: none">${admin.u_id }</td>
														<td style="display: none">${admin.u_name }</td>

														<td><a
															href="javascript:updateMemberOk('${admin.u_id }');">
																[변경]</a> <br> <a
															href="javascript:updateReadonly('${admin.u_id }');">[변경하기]</a>
															<br> <a
															href="javascript:deleteMemberOk('${admin.u_id }');">[삭제]</a>
														</td>
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
							</form>
						</div>
					</div>
					<br>
					<h1 class="mt-4">탈퇴 회원</h1>
					<div class="card mb-4">
	
						<div class="card-body">
							<table id="datatablesSimple2">
								<thead>
									<tr>

										<th>고객명</th>
										<th>아이디</th>
									</tr>
								</thead>

								<tbody>

									<c:choose>
										<c:when
											test="${adminExitList != null and fn:length(adminExitList) > 0 }">
											<c:forEach var="exitList" items="${adminExitList }">
												<tr>
													<td>${exitList.u_name}</td>
													<td>${exitList.u_id}</td>
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
<script>
function updateMemberOk(u_id) {	
	let pw = prompt("비밀번호를 입력해주세요!");
	if (pw == 1234) {
		alert("변경이 완료되었습니다.")
		document.updateform.action = 
			"${pageContext.request.contextPath }/admin/AdminMemberUpdateOk.ad?u_id=" + u_id;
		document.updateform.submit();
	} else {	
		alert("비밀번호를 확인해 주세요!");
	}
}
function updateReadonly(u_id) { 
	alert("정보를 변경합니다");
	$('.edit').attr("readonly", false);
}
function deleteMemberOk(u_id) {	
	alert(u_id);
	let pw = prompt("비밀번호를 입력해주세요!");
	if (pw == 1234) {
		document.updateform.action = 
			"${pageContext.request.contextPath }/admin/AdminMemberDeleteCheck.ad?u_id="+u_id;
		document.updateform.submit();
	} else {	
		alert("비밀번호를 확인해 주세요!");
	}
}
</script>