<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>MyPage</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/styles.css">
  <link rel="stylesheet" type="text/css" href="/css/MyPage.css">
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
  <script type="text/javascript">
    let chkMenu = null;

    $(function(){
        $(document).on("click", "#menu a", function(event) {
            chkMenu = $(this).attr("id");
        });
    });

    $(function(){
        $(document).on("click", "#pwChk", function(){
            const pw = $("#password").val();
            if(pw.length==0){
                alert("검증할 패스워드를 입력하세요.");
                return;
            }

            $.ajax({
                url : "<%=request.getContextPath()%>/memberUpdatePw",
                type : "post",
                data : {password : pw},
                success : function(res){
                    console.log("res", res);
                    if(res.result=="ok"){
                        if(chkMenu === "update"){
                            loadContent('/memberUpdate');
                        } else if (chkMenu === "delete") {
                            loadContent('/memberDelete');
                        }
                    }else{
                        alert("비밀번호가 틀립니다... 다시 입력하세요...");
                    }
                },
                error : function(xhr){
                    alert("code : " + xhr.code);
                },
                dataType : "json"
            });
        });
    });
  </script>
</head>
<body>
  <div class="layout">
    <div class="content">
      <div class="sidebar" id="menu">
          <ul>
              <li><a href="#" onclick="loadContent('/myPage')">내 정보 조회</a></li>
              <li><a href="#" onclick="loadContent('/memberUpdatePw')" id="update">내 정보 수정</a></li>
              <li>
                  <a href="#" id="res">예약내역</a>
                  <ul id="res-submenu" style="display: none;">
                      <li><a href="#" onclick="loadContent('/hotelRoomResList')"> 객실</a></li>
                      <li><a href="#" onclick="loadContent('/facilitiesResList')"> 다이닝</a></li>
                  </ul>
              </li>
              <li><a href="#" onclick="loadContent('/Goods_CartList.jsp')">장바구니</a></li>
              <li><a href="#" onclick="loadContent('board5.jsp')">주문내역</a></li>
              <li><a href="#" onclick="loadContent('/memberDeletePw')" id="delete">회원 탈퇴</a></li>
          </ul>
      </div>

      <div class="main-content">
          <div id="content-area">
              <h1>마이페이지</h1>
              <p>로딩중...</p>
          </div>
      </div>
    </div>
    <%@include file="/jsp/include/footer.jsp" %>
  </div>
  
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    window.onload = function() {
        loadContent('/myPage');
    };

    $(document).ready(function() {
        $(document).on("click", "#res", function(event) {
            $("#res-submenu").toggle();
        });
    });

    
    function loadContent(page) {
        const contentArea = document.getElementById('content-area');
        fetch(page)
            .then(response => response.text())
            .then(data => {
                contentArea.innerHTML = data;
                if (page === '/memberUpdate') {
                    initializeAddressSearch();
                }
            })
            .catch(error => {
                console.error('Error loading page:', error);
            });
    }

    function initializeAddressSearch() {
        document.getElementById('addrBtn').addEventListener('click', function () {
            new daum.Postcode({
                oncomplete: function (data) {
                    document.getElementById('mem_post').value = data.zonecode;
                    document.getElementById('mem_addr1').value = data.roadAddress;
                }
            }).open();
        });
    }
  </script>
</body>
</html>
