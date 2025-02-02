<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.Hotel.vo.Goods_CartVO"%>
<%@page import="com.Hotel.vo.MemberVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 세션에서 로그인 정보를 가져오기 --%>
<%
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loginCode");
    if (loggedInMember == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
        return;
    }

    // goods_CartList를 가져오기
    List<Goods_CartVO> goods_CartList = (List<Goods_CartVO>) session.getAttribute("Goods_CartList");
    if (goods_CartList == null) {
        goods_CartList = new ArrayList<>(); // 기본값으로 빈 리스트 설정
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">
    <script>
        function updatePrice(price, quantityInput, totalPriceCell) {
            const quantity = parseInt(quantityInput.value) || 0; // 수량
            const totalPrice = price * quantity; // 총 가격 계산
            totalPriceCell.textContent = totalPrice.toLocaleString() + '원'; // 총 가격 표시
            updateTotalCartPrice(); // 전체 장바구니 가격 업데이트
        }

        function updateTotalCartPrice() {
            const totalCells = document.querySelectorAll('.total-price');
            const checkboxes = document.querySelectorAll('.item-checkbox');
            let totalCartPrice = 0;
            checkboxes.forEach((checkbox, index) => {
                if (checkbox.checked) {
                    const priceText = totalCells[index].textContent.replace('원', '').replace(/,/g, '');
                    totalCartPrice += parseInt(priceText) || 0;
                }
            });
            document.getElementById('totalCartPrice').textContent = totalCartPrice.toLocaleString() + '원';
        }

        function toggleAllCheckboxes(selectAllCheckbox) {
            const checkboxes = document.querySelectorAll('.item-checkbox');
            checkboxes.forEach(checkbox => {
                checkbox.checked = selectAllCheckbox.checked;
            });
            updateTotalCartPrice(); // 전체 가격 업데이트
        }
    </script>
    <style>
    
      	@font-face {
    		font-family: 'MinSans-Regular';
    		src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    		font-weight: normal;
    		font-style: normal;
		}
        
        .table {
        	font-family: 'MinSans-Regular', sans-serif;
        }
        .btngo, .btnback {
        
        	background-color: #B09F7A;
        	color: white;
        	border: none;
      		border-radius: 4px;
      		padding: 10px;
        }
        .btngo:hover {
        	background-color: #948668;
        }
        
        .item-checkbox {
        	background-color: #B09F7A;
        	color: white;
        }
        
        .item-checkbox:hover {
        	background-color: #948668;
        }
    </style>
</head>

<body>

    <h1>장바구니 목록</h1>
    <table class="table">
        <thead>
            <tr>
                <th><input type="checkbox" class="item-checkbox" onclick="toggleAllCheckboxes(this)" checked> 전체 선택</th> <!-- 전체 선택 체크박스 -->
                <th>상품명</th>
                <th>수량</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
        </thead>
      <tbody>
    <%
        if (!goods_CartList.isEmpty()) {
            for (Goods_CartVO cartItem : goods_CartList) {
    %>
        <tr>
            <td><input type="checkbox" class="item-checkbox" onclick="updateTotalCartPrice()" checked></td> <!-- 각 아이템 체크박스 -->
            <td><%= cartItem.getGoods_name() %></td> <!-- 상품명 -->
            <td>
                <input type="number" min="1" value="<%= cartItem.getGoods_amt() %>" 
                       style="background-color: #f0f0f0; border: none; width: 50px;" readonly>
            </td>
            <td>
                <span class="total-price">
                    <%= cartItem.getGoods_price() * cartItem.getGoods_amt() %>원
                </span>
            </td>
            <td>
                <form action="<%= request.getContextPath() + "/goods_CartDelete" %>" method="post">
                    <input type="hidden" name="cart_no" value="<%= cartItem.getCart_no() %>"> <!-- cart_no 추가 -->
                    <button type="submit" class="btn btn-danger">삭제</button>
                </form>
            </td>
            <td>
                <input type="hidden" name="goodsId" value="<%= cartItem.getGoods_id() %>"> <!-- 각 상품의 goods_id 추가 -->
            </td>
        </tr>
    <%
            }
        } else {
    %>
        <tr>
            <td colspan="5">장바구니에 상품이 없습니다.</td>
        </tr>
    <%
        }
    %>
</tbody>
    </table>

    <h2>총 가격: <span id="totalCartPrice">
        <%
            int totalCartPrice = 0;
            for (Goods_CartVO cartItem : goods_CartList) {
                totalCartPrice += cartItem.getGoods_price() * cartItem.getGoods_amt();
            }
            out.print(totalCartPrice);
        %>원
    </span></h2>

    <form action="<%= request.getContextPath() + "/jsp/Goods_Payment.jsp" %>" method="post">
    <input type="hidden" name="goodsIdList" value="<%= goods_CartList.stream().map(Goods_CartVO::getGoods_id).collect(Collectors.joining(",")) %>"> <!-- 모든 goods_id를 포함 -->
    <button type="submit" class="btngo">구매하기</button>
</form>
	<button type="submit" class="btnback" onclick="goBack()">이전으로</button>
<script>
function goBack() {
    window.history.back(); // 이전 페이지로 이동
}
</script>
</body>
</html>
