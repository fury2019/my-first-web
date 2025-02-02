<%@page import="com.Hotel.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>FAQ 새글 등록</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
    /* 전체 페이지 배경 및 글꼴 스타일 */
    body {
        background-color: #faf3e0; /* 은은한 베이지 톤 */
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        color: #5a3e36;
        margin: 0;
        padding: 0;
    }

    /* 메인 컨테이너 스타일 */
    .container {
        max-width: 700px;
        margin: 50px auto;
        background: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        text-align: center;
        transition: all 0.3s ease;
        height: 700px;
    }

    .container:hover {
        transform: scale(1.02);
    }

    /* 제목 스타일 */
    h2 {
        color: #8b4513; /* 고급 브라운 컬러 */
        font-weight: bold;
        margin-bottom: 30px;
    }

    /* 입력 폼 라벨 스타일 */
    label {
        font-weight: bold;
        color: #8b4513;
        margin-bottom: 10px;
    }

    /* 입력 필드 스타일 */
    .form-control {
        border: 1px solid #c2a585;
        border-radius: 6px;
        padding: 12px;
        font-size: 14px;
        transition: box-shadow 0.3s ease, border 0.3s ease;
    }

    .form-control:focus {
        border-color: #8b4513;
        box-shadow: 0 0 8px rgba(139, 69, 19, 0.4);
    }

    /* 버튼 스타일 */
    .btn-primary {
        background-color: #a0522d; /* 새들 브라운 (Saddle Brown) */
        border: none;
        padding: 12px 20px;
        border-radius: 6px;
        font-size: 16px;
        color: #fff; /* 흰색 텍스트 */
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    .btn-primary:hover {
        background-color: #8b4513; /* 다크 브라운 */
        transform: translateY(-3px);
        color: #fff;
    }

    /* 입력 폼 요소 간격 */
    .form-group {
        margin-bottom: 20px;
        text-align: left;
    } 
</style>

</head>

<body>
    <div class="container">
        <h2>FAQ 새글 등록</h2>
        <form action="<%=request.getContextPath()%>/faqInsert" method="post">
            <div class="form-group">
                <label for="faq_title">FAQ 제목</label>
                <input type="text" class="form-control" id="faq_title" name="faq_title" placeholder="FAQ 제목을 입력하세요." required>
            </div>
            <div class="form-group">
                <label for="faq_content">FAQ 내용</label>
                <textarea class="form-control" id="faq_content" name="faq_content" rows="3" placeholder="FAQ 내용을 입력하세요." required></textarea>
            </div>
            <div class="form-group">
                <label for="class_id">게시판 종류</label>
                <select class="form-control" id="class_id" name="class_id" required>
                    <option value="F_Room">객실 관련</option>
                    <option value="F_Fac">편의 시설</option>
                    <option value="F_Shop">E_SHOP 관련</option>
                    <option value="F_Other">기  타</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>
</body>

</html>