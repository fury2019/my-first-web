   <%@page import="java.util.ArrayList"%>
   <%@page import="java.util.List"%>
   <%@page import="java.util.stream.Collectors"%> <!-- Collectors 임포트 추가 -->
   <%@page import="com.Hotel.vo.Goods_CartVO"%>
   <%@page import="com.Hotel.vo.MemberVO"%>
   <%@page import="com.Hotel.vo.CouponVO"%>
   <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
   <%
       MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
       if (loggedInMember == null) {
           response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
           return;
       }
   
       int memberPoints = loggedInMember.getMem_point();
   
       List<Goods_CartVO> goods_CartList = (List<Goods_CartVO>) session.getAttribute("Goods_CartList");
       if (goods_CartList == null) {
           goods_CartList = new ArrayList<>();
       }
   
       int payId = (int) (System.currentTimeMillis() / 1000);
       int totalPrice = goods_CartList.stream().mapToInt(item -> item.getGoods_price() * item.getGoods_amt()).sum();
       int earnPoints = (int) (totalPrice * 0.05);
   
       List<CouponVO> couponList = (List<CouponVO>) session.getAttribute("CouponList");
   %>
   
   <!DOCTYPE html>
   <html lang="ko">
   <head>
       <meta charset="UTF-8">
       <title>결제 정보 입력</title>
       <style>
           body {
               font-family: Arial, sans-serif;
               margin: 20px;
           }
           h2 {
               text-align: center;
           }
           form {
               max-width: 600px;
               margin: auto;
           }
           label {
               display: block;
               margin: 10px 0 5px;
           }
           input[type="text"], input[type="number"] {
               width: 100%;
               padding: 8px;
               margin-bottom: 10px;
               border: 1px solid #ccc;
               border-radius: 4px;
           }
           input[type="submit"] {
               background-color: #28a745;
               color: white;
               padding: 10px;
               border: none;
               border-radius: 4px;
               cursor: pointer;
           }
           input[type="submit"]:hover {
               background-color: #218838;
           }
           table {
               width: 100%;
               border-collapse: collapse;
               margin-top: 20px;
           }
           th, td {
               border: 1px solid #ddd;
               padding: 8px;
               text-align: center;
           }
           th {
               background-color: #f2f2f2;
           }
       </style>
   </head>
   <body>
       <h2>주문 상세 내역</h2>
       <table>
           <thead>
               <tr>
                   <th>상품명</th>
                   <th>수량</th>
                   <th>가격</th>
                   <th>합계</th>
               </tr>
           </thead>
           <tbody>
               <%
                   if (!goods_CartList.isEmpty()) {
                       for (Goods_CartVO cartItem : goods_CartList) {
               %>
                   <tr>
    <td><%= cartItem.getGoods_name() %>, 
        <input type="hidden" name="goods_id" value="<%= cartItem.getGoods_id() %>">
        <%= cartItem.getGoods_id() %>
    </td>
    <td><%= cartItem.getGoods_amt() %></td>
    <td><%= cartItem.getGoods_price() %>원</td>
    <td><%= cartItem.getGoods_price() * cartItem.getGoods_amt() %>원</td>
</tr>
               <%
                       }
               %>
                   <tr>
                       <td colspan="3" class="total-price">총 결제 금액:</td>
                       <td class="total-price">
                           <%= totalPrice %>원
                       </td>
                   </tr>
               <%
                   } else {
               %>
                   <tr>
                       <td colspan="4">장바구니에 상품이 없습니다.</td>
                   </tr>
               <%
                   }
               %>
           </tbody>
       </table>
   
       <h2>결제 정보 입력</h2>
<form action="<%= request.getContextPath() %>/goods_PaymentInsert" method="post">
    <input type="hidden" name="payId" value="<%= payId %>">
    <input type="hidden" name="cartNo" value="<%= goods_CartList.isEmpty() ? null : goods_CartList.get(0).getCart_no() %>"> <!-- cartNo 설정 -->
    <input type="hidden" name="goodsIdList" value="<%= goods_CartList.stream().map(Goods_CartVO::getGoods_id).collect(Collectors.joining(",")) %>">
    <input type="hidden" name="pPrice" value="<%= totalPrice %>">
    
    <p>회원 보유 포인트: <%= memberPoints %> 포인트</p>
    
    <label for="pUsePoint">포인트 사용 (최대 <%= memberPoints %> 포인트 사용 가능):</label>
    <input type="number" id="pUsePoint" name="pUsePoint" min="0" max="<%= memberPoints %>" value="0" required>

    <label for="couponNo">쿠폰 선택:</label>
    <%
        if (couponList != null && !couponList.isEmpty()) {
            for (CouponVO coupon : couponList) {
    %>
        <div>
            <input type="radio" id="coupon_<%= coupon.getCoupon_no() %>" name="couponNo" value="<%= coupon.getCoupon_no() %>">
            <label for="coupon_<%= coupon.getCoupon_no() %>"><%= coupon.getCoupon_name() %> - <%= coupon.getCoupon_percent() %>% 할인</label>
        </div>
    <%
            }
        } else {
    %>
        <p>보유한 쿠폰이 없습니다.</p>
    <%
        }
    %>

    <label for="pEarnPoint">적립 포인트:</label>
    <input type="text" id="pEarnPoint" name="pEarnPoint" value="<%= earnPoints %>" readonly>

    <label for="pTotPrice">총 결제 금액:</label>
    <input type="text" id="pTotPrice" name="pTotPrice" value="<%= totalPrice %>" readonly>

    <input type="submit" value="결제하기">
</form>

   </body>
   </html>
