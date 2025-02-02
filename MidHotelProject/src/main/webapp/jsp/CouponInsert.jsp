<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Coupon Insert</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            text-align: center;
            transition: all 0.3s ease;
            height: 750px;
        }

        .container:hover {
            transform: scale(1.02);
        }

        /* 제목 스타일 */
        h2 {
            color: #8b4513; /* 고급 브라운 컬러 */
            font-family: 'Playfair Display', serif;
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
        <h2>쿠폰 생성</h2>
        <form action="<%=request.getContextPath()%>/insertCoupon" method="post">
            <div class="form-group">
                <label for="coupon_name">쿠폰 이름</label>
                <input type="text" class="form-control" id="coupon_name" name="coupon_name" placeholder="예: 여름 특별 할인 쿠폰" required>
            </div>
            <div class="form-group">
                <label for="coupon_comment">쿠폰 설명</label>
                <textarea class="form-control" id="coupon_comment" name="coupon_comment" rows="3" placeholder="쿠폰에 대한 설명을 입력하세요." required></textarea>
            </div>
            <div class="form-group">
                <label for="coupon_percent">할인율(%)</label>
                <input type="number" class="form-control" id="coupon_percent" name="coupon_percent" placeholder="예: 10" min="1" max="100" required>
            </div>
            <div class="form-group">
                <label for="mem_id">회원 ID</label>
                <input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="회원 ID를 입력하세요." required>
            </div>
            <button type="submit" class="btn btn-primary">쿠폰 생성</button>
        </form>
    </div>
</body>
</html>
