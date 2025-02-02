<%@page import="com.Hotel.vo.MemberVO"%>
<%@page import="com.Hotel.vo.Room_ReservationVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 - 간편결제</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body> 
    <script>
    
    <% request.setCharacterEncoding("utf-8"); %>
    
    var prodNo = <%= request.getParameter("prodNo") %>
    var prodNm = <%= "\"" + request.getParameter("prodNm") + "\"" %>
    var prodPrice = <%= request.getParameter("prodPrice") %>
    console.log(prodNo, prodNm, prodPrice);
    
    <% MemberVO log = (MemberVO) session.getAttribute("loginCode"); 
	    String memname = log.getMem_name();
	    String memAddr = log.getMem_addr1();
	    String memTel = log.getMem_tel();
 	%>

    
    
   
    <% java.util.UUID one = java.util.UUID.randomUUID(); %>
    
    var UID =  <%= "\"" + one.toString() + "\"" %> 
    console.log(UID);
    
    <%
	    request.setCharacterEncoding("utf-8");
	    String typeParam = request.getParameter("type");
	    String amountParam = request.getParameter("amount");
	    String r_res_no = request.getParameter("r_res_no");
	    if (typeParam == null || typeParam.isEmpty()) {
	        typeParam = "기본값"; // 기본값 설정
	    }
	%>
	
	
	 var type = "<%= typeParam %>"; // JSP에서 전달받은 값을 JS 변수로
	 var amount = "<%= amountParam %>";
	 var memname = <%= "\"" + memname + "\"" %>; 
	 var memAddr = <%= "\"" + memAddr + "\"" %>;
	 var memTel = <%= "\"" + memTel + "\"" %>;

	console.log(type); // 디버깅


    
    $(function(){
    	
        var IMP = window.IMP; // 생략가능
        IMP.init('imp03127688'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        //결제 할 때 sunday1284, 1q2w3e4r5T!로 로그인하고 -> 객실 예약에서 1박2일로 설정하고 성인 2명 값만 주고 
        // 조식 언리,레이트 체크인 다 박고 계산한 값입니다.
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid: UID,
            name: type,		// <- 동적으로 받아옴
            amount: amount,			// <- 동적으로 받아옴
            buyer_name: memname,		// <- 동적으로 받아옴
            buyer_tel: memTel, // <- 동적으로 받아옴
            buyer_addr: memAddr,
            buyer_postcode: "01181",
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우ㅁㄴㅇ
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
                location.href='/payresult?r_res_no=<%=r_res_no%>';
                alert('결제가 완료되었습니다.');
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/Main.jsp";
                alert(msg);
            }
        });
        
    });
    </script>
 
</body>
</html>
