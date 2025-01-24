<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 - 약관동의</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

/* 헤더 스타일 */
header h1 {
    font-size: 20px;
    color: #3f3f3f;
    font-weight: bold;
    margin-bottom: 15px;
    text-align: center;
}

/* 진행 상태 테이블 */
.progress-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 30px;
    font-family: 'MinSans-Regular', sans-serif;
}

.progress-table td {
    text-align: center;
    font-size: 14px;
    color: #999;
    padding: 10px 0;
    border-bottom: 2px solid #e5e5e5;
}

.progress-table .active {
    color: #3f3f3f;
    font-weight: bold;
    border-bottom: 3px solid #eed787;
}

body {
    font-family: 'MinSans-Regular', sans-serif;
    line-height: 1.6;
    margin: 0;
    padding: 0;
    background-color: #f5f5f5;
    color: #333;
}

.container {
    max-width: 780px;
    margin: 0 auto;
    background: #fff;
    padding: 40px 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    border: 1px solid #ddd;
    font-family: 'MinSans-Regular', sans-serif;
}

h1 {
    font-size: 28px;
    text-align: center;
    margin-bottom: 20px;
    color: #704e26;
}

p {
    text-align: center;
    font-size: 14px;
    margin-bottom: 40px;
    color: #666;
}

.section-title {
    font-size: 16px;
    margin: 20px 0 10px;
    font-weight: bold;
    color: #704e26;
    border-bottom: 2px solid #ddd;
    padding-bottom: 5px;
}

.terms {
    border: 1px solid #ddd;
    padding: 10px;
    max-height: 150px;
    overflow-y: auto;
    background: #f9f9f9;
    margin-bottom: 10px;
    font-size: 13px;
    color: #555;
    line-height: 1.5;
}

.form-group {
    margin-bottom: 30px;
    font-family: 'MinSans-Regular', sans-serif;
}

label {
    display: block;
    margin-bottom: 10px;
    font-size: 14px;
    color: #333;
}

input[type="radio"] {
    margin-right: 8px;
}

.optional {
    color: #888;
    font-size: 12px;
}

.actions {
    text-align: center;
    margin-top: 30px;
}

button {
    background-color: #704e26;
    color: #fff;
    border: none;
    padding: 12px 30px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #5a3c1d;
}

button + button {
    margin-left: 10px;
    background-color: #ddd;
    color: #333;
}

button + button:hover {
    background-color: #bbb;
}

.notice {
    font-size: 12px;
    color: #999;
    text-align: center;
    margin-top: 20px;
}

.notice strong {
    color: #333;
}
</style>
</head>
<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script>
document.addEventListener('DOMContentLoaded', () => {
    const allAgreeRadio = document.querySelector("input[name='agreement_all'][value='agree']");
    const allDisagreeRadio = document.querySelector("input[name='agreement_all'][value='disagree']");
    const nextButton = document.querySelector(".actions button[type='button']");
    const cancelButton = document.querySelector(".actions button:nth-child(2)");

    // 전체 동의/비동의 핸들러
    allAgreeRadio.addEventListener('click', () => toggleAllAgreements('agree'));
    allDisagreeRadio.addEventListener('click', () => toggleAllAgreements('disagree'));

    // '다음' 버튼 클릭 핸들러
    nextButton.addEventListener('click', () => {
        if (validateAgreements()) {
            requestIdentityVerification();
        }
    });

    // '취소' 버튼 클릭 핸들러
    cancelButton.addEventListener('click', () => {
        window.location.href = '/Main.jsp'; 
    });
});

function toggleAllAgreements(value) {
    const radios = document.querySelectorAll("input[type='radio']");
    radios.forEach(radio => {
        if (radio.name !== 'agreement_all') {
            radio.checked = (value === 'agree' && radio.value === 'agree') || (value === 'disagree' && radio.value === 'disagree');
        }
    });
}

function validateAgreements() {
    const requiredAgreements = [
        document.querySelector("input[name='agreement_terms'][value='agree']"),
        document.querySelector("input[name='agreement_privacy'][value='agree']")
    ];

    for (const agreement of requiredAgreements) {
        if (!agreement.checked) {
            alert("필수 항목에 동의해 주세요.");
            return false;
        }
    }

    return true;
}

async function requestIdentityVerification() {
    // PortOne 본인인증 초기화
    IMP.init("imp03127688"); // PortOne에서 발급받은 가맹점 식별코드

    IMP.certification(
        {
            channelKey: "channel-key-7a436243-e988-475a-82a2-5999a06784e1", // 인증 채널 키
        },
        function (rsp) {
            if (rsp.success) {
                // 성공 시 서블릿으로 데이터 전송
                sendCertificationDataToServer(rsp.imp_uid);
            } else {
                // 실패 처리
                alert("본인 인증 실패: " + rsp.error_msg);
            }
        }
    );
}

function sendCertificationDataToServer(imp_uid) {
    // AJAX를 통해 서블릿으로 본인인증 데이터 전송
    $.ajax({
        url: "<%=request.getContextPath() %>/Cuscheck.do", // 서블릿 경로
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({ imp_uid: imp_uid }), // imp_uid 전달
        success: function (response) {
            // 응답 데이터로 join.jsp 이동
            const params = new URLSearchParams({
                name: response.name,
                birth: response.birth,
                phone: response.phone,
                gender: response.gender,
            });
            alert("본인 인증 성공! 회원 정보 입력 페이지로 이동합니다.");
            window.location.href = '/jsp/join.jsp?' + params.toString();
        },
        error: function (xhr) {
            alert("서버 오류 발생: " + xhr.statusText);
        },
        dataType: "json",
    });
}
    </script>
</head>
<body>
<br>
 <header>
     <h1>회원 정보 입력</h1>
 </header>
    <div class="container">
     <table class="progress-table">
     <tr>
        <td class="active">약관동의</td>
        <td>회원정보 입력</td>
        <td>가입완료</td>
    </tr>
    </table>
        <h1>DDIT 호텔에 오신 것을 환영합니다.</h1>
        <p>* 약관 및 개인정보 수집•이용 사항을 확인하시고 동의여부에 체크해주시기 바랍니다.</p>

        <div class="form-group">
            <h2 class="section-title">약관동의</h2>
            <label>
                <input type="radio" name="agreement_all" value="agree">
                전체 동의
            </label>
            <label>
                <input type="radio" name="agreement_all" value="disagree">
                동의하지 않음
            </label>
        </div>

        <div class="form-group">
            <h2 class="section-title">DDIT 호텔 이용약관에 대한 동의 (필수)</h2>
            <div class="terms">
                <p>제1조 회원규정 일반...</p>
            </div>
            <label>
                <input type="radio" name="agreement_terms" value="agree">
                동의함
            </label>
            <label>
                <input type="radio" name="agreement_terms" value="disagree">
                동의하지 않음
            </label>
        </div>

        <div class="form-group">
            <h2 class="section-title">개인정보 수집, 이용에 대한 동의 (필수)</h2>
            <div class="terms">
                <p>수집 이용 항목: 성명, 생년월일...</p>
                <!-- 개인정보 수집 내용 -->
            </div>
            <label>
                <input type="radio" name="agreement_privacy" value="agree">
                동의함
            </label>
            <label>
                <input type="radio" name="agreement_privacy" value="disagree">
                동의하지 않음
            </label>
        </div>

        <div class="form-group">
            <h2 class="section-title">개인정보 마케팅 활용 동의 (선택)</h2>
            <div class="terms">
                <p>마케팅 활용 항목: 성명, 이메일...</p>
                <!-- 마케팅 내용 -->
            </div>
            <label>
                <input type="radio" name="agreement_marketing" value="agree">
                동의함
            </label>
            <label>
                <input type="radio" name="agreement_marketing" value="disagree">
                동의하지 않음
            </label>
        </div>

        <div class="actions">
            <button type="button">다음</button>
            <button type="button">취소</button>
        </div>

        <div class="notice">
            <p>※ 필수 항목을 선택하지 않을 경우, 가입이 제한될 수 있습니다.</p>
        </div>
    </div>
        
<%@include file="/jsp/include/footer.jsp" %>
</body>
</html>