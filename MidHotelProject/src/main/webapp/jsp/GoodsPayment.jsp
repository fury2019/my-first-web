<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Hotel.vo.Goods_PaymentVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>결제 진행</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
<%
    Goods_PaymentVO payment = (Goods_PaymentVO) request.getAttribute("payment");
    if (payment == null) {
%>
    <p>결제 정보를 불러오는 데 실패했습니다. 다시 시도해 주세요.</p>
    <a href="<%= request.getContextPath() %>/Main.jsp">홈으로 돌아가기</a>
<%
    } else {
%>
    <script>
        var payment = {
            pay_id: "<%= payment.getPayId() %>",
            cart_no: "<%= payment.getCart_no() %>",
            goods_id: "<%= payment.getGoods_id() %>",  // 여기서 goods_id를 가져옵니다
            p_use_point: <%= payment.getP_use_point() %>,
            coupon_no: "<%= payment.getCoupon_no() %>",
            p_earn_point: <%= payment.getP_earn_point() %>,
            p_tot_price: <%= payment.getP_tot_price() %>,
            p_price: <%= payment.getP_price() %>,
            p_date: "<%= payment.getP_date() %>"
        };

        console.log(payment);

        var IMP = window.IMP; // 생략 가능
        IMP.init('imp03127688'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용

        IMP.request_pay({
            pg: 'kakaopay',
            pay_method: 'card',
            merchant_uid: payment.cart_no, // 장바구니 번호
            name: "E-SHOP 결제",
            amount: payment.p_tot_price, // 총 결제 금액
            buyer_name: "홍길동",
            buyer_tel: "010-4242-4242",
            buyer_addr: "서울특별시 강남구 신사동",
            buyer_postcode: "01181",
        }, function(rsp) {
            if (rsp.success) {
                // 결제 성공 시 서버에 imp_uid 전송
                jQuery.ajax({
                    url: "/paymentComplete", // 결제 확인을 위한 서블릿 경로
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid: rsp.imp_uid,
                        merchant_uid: rsp.merchant_uid
                    }
                }).done(function(data) {
                    alert('결제가 완료되었습니다.');
                    location.href='<%=request.getContextPath()%>/E-Shop.jsp';
                });
            } else {
                alert('결제에 실패하였습니다. 에러내용: ' + rsp.error_msg);
                location.href='<%=request.getContextPath()%>/jsp/Goods_Payment.jsp';
            }
        });
    </script>
<%
    }
%>
</body>
</html>
