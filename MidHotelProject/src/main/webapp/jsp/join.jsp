<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@include file="/jsp/include/top.jsp" %>
<%@include file="/jsp/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDIT 호텔 - 회원가입</title>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<style>
  @font-face {
    font-family: 'MinSans-Regular';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
} 

  body {
            font-family: 'MinSans-Regular', sans-serif;
        }
        .container {
            width: 600px;
            margin: 50px auto;
            border: 1px solid #ccc;
            padding: 30px;
            font-family: 'MinSans-Regular', sans-serif;
        }
        .form-title {
            text-align: center;
            margin-bottom: 20px;
        }
        .rq {
            color: red;
        }
        table {
            width: 100%;
        }
        td {
            padding: 10px;
        }
        label {
            display: inline-block;
            width: 100px;
        }
        input[type="text"],
        input[type="password"],
        input[type="date"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }
       
#disp {
    margin-left: 10px;
    font-size: 14px;
    color: #888;
    font-family: 'MinSans-Regular', sans-serif;
}
#chk {
    margin-left: 10px;
    font-size: 14px;
    color: #888;
    font-family: 'MinSans-Regular', sans-serif;
}
#joinBtn {
  background-color: #c79d65; /* 배경색 */
  color: white; /* 글자색 */
  border: none; /* 테두리 없애기 */
  padding: 10px 20px; /* 버튼 내부 여백 */
  font-size: 16px; /* 글자 크기 */
  cursor: pointer; /* 마우스 커서 모양 변경 */
  border-radius: 5px; /* 둥근 모서리 */
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3); /* 그림자 효과 */
  transition: all 0.3s ease; /* hover 효과를 위한 transition */
}

#joinBtn:hover {
  background-color: #b08654; /* hover 시 배경색 변경 */
  box-shadow: 3px 3px 8px rgba(0, 0, 0, 0.5); /* hover 시 그림자 효과 강화 */
}

/* 아이디 중복확인 버튼 스타일 */
#idChk {
  background-color: #c79d65; 
  color: white;
  border: none;
  padding: 8px 16px;
  font-size: 14px;
  cursor: pointer;
  border-radius: 5px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
  transition: all 0.3s ease;
}
#idChk:hover {
  background-color: #b08654; 
  box-shadow: 3px 3px 8px rgba(0, 0, 0, 0.5);
}

/* 주소검색 버튼 스타일 */
#addrBtn {
  background-color: #c79d65; 
  color: white;
  border: none;
  padding: 8px 16px;
  font-size: 14px;
  cursor: pointer;
  border-radius: 5px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
  transition: all 0.3s ease;
}
#addrBtn:hover {
  background-color: #b08654; 
  box-shadow: 3px 3px 8px rgba(0, 0, 0, 0.5);
}

/* 화면 반응형 */
@media screen and (max-width: 768px) {
      table {
        width: 90%;
        padding: 15px;
    }

    input[type="text"],
    input[type="password"],
    input[type="date"],
    button {
        font-size: 14px;
        border: 1px solid #c79d65;
    }
}

/* 진행 상태 테이블 */
.progress-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 30px;
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

/* 헤더 스타일 */
header h1 {
    font-size: 20px;
    color: #3f3f3f;
    font-weight: bold;
    margin-bottom: 15px;
    text-align: center;
}

</style>
</head>
<script>
$(document).ready(function() {
    // URL에서 파라미터 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const name = urlParams.get('name');
    const birth = urlParams.get('birth');
    const phone = urlParams.get('phone');
    const gender = urlParams.get('gender');

    // 각 입력 필드에 값 할당
    $("#name").val(name);
    $("#bir").val(birth);
    $("#tel").val(phone);

    if (gender === 'male') {
        $("#male").prop("checked", true);
    } else if (gender === 'female') {
        $("#female").prop("checked", true);
    }
});

function f_valid(event) {
    // 기존 유효성 검사 로직 유지
}
</script>
<body>
 <div class="container">
        <header>
            <h1>회원 정보 입력</h1>
             <table class="progress-table">
                <tr>
                    <td>약관동의</td>
                    <td class="active">회원정보 입력</td>
                    <td>가입완료</td>
                </tr>
            </table>
        </header>
        <form class="form-horizontal" method="post" onsubmit="return f_valid(event)">
            <table>
                <tr>
                    <td><label for="id">아이디<span class="rq">*</span></label></td>
                    <td>
                        <input type="text" id="userId" name="mem_id" placeholder="5~12자 이내 영문 또는 영문/숫자 조합" required pattern="[a-zA-Z][a-zA-Z0-9]{4,11}">
                        <button type="button" class="btn btn-success btn-sm" id="idChk">아이디 중복확인</button>
                        <span id="disp"></span>
                    </td>
                </tr>
                <tr>
                    <td><label for="pw">비밀번호<span class="rq">*</span></label></td>
                    <td><input type="password" id="pw" name="mem_pw" placeholder="8~20자 이내 영문/숫자 조합(특수문자 입력 가능)" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$%\^&amp;\*\(\)_\+\|]).{8,20}"></td>
                </tr>
                <tr>
                    <td><label for="pw_confirm">비밀번호 확인<span class="rq">*</span></label></td>
                    <td><input type="password" id="pw_confirm" name="mem_pw_confirm" placeholder="8~20자 이내 영문/숫자 조합(특수문자 입력 가능)" required pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#\$%\^&amp;\*\(\)_\+\|]).{8,20}">
                	<span id="chk"></span>
                	</td>
                </tr>
                <tr>
                    <td><label for="name">이름<span class="rq">*</span></label></td>
                    <td>
                        <input type="text" id="name" name="mem_name" required pattern="[가-힣]{2,5}">
                    </td>
                </tr>
                <tr>
                    <td><label for="bir">생년월일<span class="rq">*</span></label></td>
                    <td><input type="date" id="bir" name="mem_bir" required></td>
                </tr>
                <tr>
    				<td><label for="gender">성별<span class="rq">*</span></label></td>
    				<td>
        				<input type="radio" id="male" name="mem_gender" value="남자" required> 남성
        				<input type="radio" id="female" name="mem_gender" value="여자" required> 여성
    				</td>
				</tr>
                <tr>
                    <td><label for="tel">휴대전화<span class="rq">*</span></label></td>
                   <td>
    					<input type="tel" id="tel" name="mem_tel" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
  				   </td>
                </tr>
                <tr>
                    <td><label for="post">우편번호<span class="rq">*</span></label></td>
                    <td>
                        <input type="text" id="postAddr" name="mem_post" readonly>
                        <button type="button" id="addrBtn" class="btn btn-info btn-sm">주소검색</button>
                    </td>
                </tr>
                <tr>
                    <td><label for="addr1">자택주소<span class="rq">*</span></label></td>
                    <td><input type="text" id="addr1" name="mem_addr1" readonly></td>
                </tr>
                <tr>
                    <td><label for="addr2">상세주소</label></td>
                    <td><input type="text" id="addr2" name="mem_addr2"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button class="btn btn-default" id="joinBtn">가입 신청</button>
                        <span id="joinspan"></span>
                    </td>
                </tr>
            </table>
        </form>
    </div>

   <!-- 다음주소api -->
   <script
      src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
      //주소 검색 이벤트
      $('#addrBtn').on('click', addr);

      function addr() {
         new daum.Postcode(
               {
                  oncomplete : function(data) {

                     document.getElementById('postAddr').value = data.zonecode; //우편번호
                     // jsp파일은 백틱을 사용한 탬플릿리터럴과 el tag형식이 사용해 충돌될 수 있으므로 백틱 사용시 $앞쪽에 \(백슬래시)를 붙여 쓰자
                     document.getElementById("addr1").value = `\${data.roadAddress}(\${data.jibunAddress})`; //도로명 주소
                     //document.getElementById("sample4_jibunAddress").value = data.jibunAddress; //지번 주소

                  }
               }).open();
      }

      //id중복검사
      $('#idChk').on('click', function() {
         //    $('#id').on('keyup',function(){});

			//id영역의 입력 값 얻기
			const idVal = $('#userId').val();

         //서버위치로 보내주기 - 비동기통신(AJAX) 이용해서 현재 페이지로 응답 받을 예정..
         $.ajax({
            url : 'idChk.jsp', //현재 위치로 요청보내고 다시 응답받을 예정..
            type : 'get',
            //data: "userId=" + idVal,
            data : {
               userId : idVal
            }, //객체 형식으로 정보 전달해도 key=value(url인코딩)형식으로 넘어감
            success : function(rst) {
               console.log(rst);
               //id=disp영역에 결과 출력하기
               if (rst.rst == "ok") {
                  $('#disp').text("사용가능").css('color', 'green');
               } else {
                  $('#disp').text("사용불가").css('color', 'red');
               }
            },
            error : function(xhr) {
               alert(xhr.status);
            },
            dataType : 'json'
         });
      });

      //form내부의 button요소는 전송 기능을 갖는다
      //button이 눌리는순간 form의 action위치로 요청정보를 전달하는데
      //action이 생략되어있을 때는 현재 문서의 url위치로 요청이 전달된다
      //위 과정대로 진행하지 않고 중간 과정을 거치기 위해 함수로 이동하게 만든다
      function f_valid(e) {

         //1.이벤트의 메소드(preventDefault)를 사용해서 현재 함수에 머무르는 방법
         // 1번 방식은 현재 코드구문 실행에 영향을 주지 않음
         //       e.preventDefault(); //submit의 기능 중지...

         //요청정보를 직렬화하여 Join서블릿으로 전달 예정..

         //데이터 직렬화 (= form내부의 입력양식들의 정보를 k=v형태로 엮어 하나의 문자열로 제공)
         const frmData = $('form').serialize();
         console.log(frmData);
         const userId = document.getElementById("userId").value;
         const name = document.getElementById("name").value;

         // localStorage에 저장
         localStorage.setItem("userId", userId);
         localStorage.setItem("name", name);
         
         //AJAX사용해서 요청위치로 응답받기
         //ajax는 응답 부분만 받아 그 부분만 갱신하기때문에 페이지 전체를 다시 그려내는것보다 부하가 적고 빠름
         $.ajax({
            url : '/Join',
            type : 'post',
            data : frmData,
            success : function(rst) {
               if (rst)
                  window.location.href = "/jsp/joinSuccess.jsp";
               else
                  $('#joinspan').text("가입실패");
            },
            error : function(xhr) {
               alert(xhr.status);
            }
         //          ,dataType: ''
         });

         //2. 함수에 false값을 리턴해서 submit을 수행하지 않는 방법
         // 2번방식 사용시 모든 코드의 실행 후 가장 마지막에서 값을 반환해야 한다
         return false;
      }
      // 예시: 비밀번호 확인 필드 일치 검사
      const pw = document.getElementById('pw');
      const pwConfirm = document.getElementById('pw_confirm');

      pwConfirm.addEventListener('blur', function() {
          if (pw.value !== pwConfirm.value) {
			  $('#chk').text("비밀번호가 일치하지 않습니다!").css('color', 'red');
          }else {
              $('#chk').text("비밀번호 일치").css('color', 'green');
          }
         
      });
      
      const telInput = document.getElementById('tel');

      telInput.addEventListener('blur', function() {
        let tel = telInput.value.replace(/-/g, ''); // 하이픈 제거
        if (tel.length === 11) {
          tel = tel.substring(0, 3) + '-' + tel.substring(3, 7) + '-' + tel.substring(7, 11); // 하이픈 추가
          telInput.value = tel; // 입력 필드 값 업데이트
        }
      });
      
   </script>

   
<%@include file="/jsp/include/footer.jsp" %>
</body>
</html>
