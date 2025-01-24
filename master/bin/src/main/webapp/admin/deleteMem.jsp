<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="exist" value="${requestScope.exist }" />
 <div class="col-12 col-lg-8">
                    <h2 style="text-align: center;height: 50px;"><span style="background-color: #524b42;color: white;padding: 10px;">회원 탈퇴</span></h2>
                    <div class="post-thumbnail mb-50">
                       
                    		<p style="padding : 50px 20px;text-align:center;">
                    		  정말로 탈퇴하시겠습니까?
                    		  <br>
                    		  탈퇴 후 예약 내역과 회원 정보는 조회 할 수 없습니다.
                    		                  		  
                    		</p>
                       
                           
                            <hr>
							
								
                        </div>
							<div style="text-align: center; line-height: 50px;">
								<div>
									<input type="button" id="change" class="change" onclick="deleteMemberOk('${exist }')" value="탈퇴하기">
								</div>
							</div>
                        </div>
                    </div>
                </div>

</body>
<script>
	
function deleteMemberOk(exist) {	
	let pw = prompt("비밀번호를 입력해주세요!");
	alert(exist);
	if (pw == 1234) {
		if( exist == true){
			alert("예약내역을 확인해주세요.");
			location.href="${pageContext.request.contextPath }/admin/AdminReservationList.ad"
		} else if ( exist == false){
			alert("회원 삭제가 완료되었습니다.")
			location.href="${pageContext.request.contextPath }/admin/AdminMemberDelete.ad"
		}
	} else {	
		alert("비밀번호를 확인해 주세요!");
	}
	
	
}
</script>
</html>