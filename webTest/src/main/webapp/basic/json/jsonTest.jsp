<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">
$(function(){
	
   $("#strBtn").on("click", function(){
      
      $.ajax({
         // 요청을 받아서 처리할 문서의 주소 (form태그의 action속성과 같은 기능)
         url : "<%=request.getContextPath()%>/json/jsonTest.do",
         
         type : "post",      // 전송방식 (get 또는 post)
         
         // 서버로 전송할 데이터 설정 ==> 전송할 데이터가 없으면 생략 가능
         data : "choice=String",
         
         
         // 응답이 성공했을 때 처리할 함수 설정
         //      ==> 이 함수의 매개변수(data)에는 서버에서 보내온 데이터가 
         //         자동으로 저장된다.
         success : function(data){
               // data = "안녕하세요."
               let htmlCode = "<h3>문자열 응답 결과</h3>";
               htmlCode += data
               
               $("#result").html(htmlCode);
               
         },
         
         // 응답이 오류일 때 처리할 함수 설정
         error : function(xhr, status, error){
            alert("code : " + xhr.code + "\n"
                  + "message : " + xhr.responseText + "\n"
                  + "error : " + error);
         },
         
         // 응답으로 오는 데이터의 타입을 설정한다.
         //      'text', 'html', 'xml', 'json'
         dataType : "json"
         
         
      });
      
   });
   //-----------------------------------------------------------
   
   // 배열 처리
   $("#arrayBtn").on("click",function(){
      
      $.ajax({
         url : "<%=request.getContextPath()%>/json/jsonTest.do",
         
         type : "post",
         
         data : "choice=array",
         
         success : function(data){
            // data = [1,2,3,4,5]
            let htmlCode = "<h3>배열 응답 결과</h3>";
            
            $.each(data, function(i,v){
               htmlCode += i + "번째 자료 : " + v + "<br>"
            });
            
            $("#result").html(htmlCode);
            
         },
         
         error : function(xhr, status, error){
            alert("code : " + xhr.code + "\n"
                  + "message : " + xhr.responseText + "\n"
                  + "error : " + error);
         },
         
         dataType : "json"
         
      });
      
   });
   //------------------------------------------------------------
   
   // 객체 처리
   $("#objBtn").on("click",function(){

      $.ajax({
         url : "<%=request.getContextPath()%>/json/jsonTest.do",
         
         type : "post",
         
         data : "choice=object",
         
         success : function(data){
            // data = ["num":100,"name":"홍길동"]
            
            let htmlCode = "<h3>배열 응답 결과</h3>";
            htmlCode += "번호 : " + data.num + "<br>";
            htmlCode += "이름 : " + data.name + "<br>";

            $("#result").html(htmlCode);
            
         },
         
         error : function(xhr, status, error){
            alert("code : " + xhr.code + "\n"
                  + "message : " + xhr.responseText + "\n"
                  + "error : " + error);
         },
         
         dataType : "json"
         
   });
   });
   //---------------------------------------------------------------
   
   // 리스트 처리
   $("#listBtn").on("click", function(){
      
      $.ajax({
         url : "<%=request.getContextPath()%>/json/jsonTest.do",
         
         type : "post",
         
         data : "choice=list",
         
         success : function(data){
            // data = [{"num":11,"name":"이순신"},
            //         {"num":12,"name":"강감찬"},
            //         {"num":13,"name":"일지매"}]
            
            let htmlCode = "<h3>리스트 응답 결과</h3>";
            
            $.each(data, function(i,v){
               htmlCode += i + "번째 데이터<br>";
               htmlCode += "번호 : " + data[i].num + "<br>";
               htmlCode += "이름 : " + data[i].name + "<br><br>";
               htmlCode += "번호 : " + v.num + "<br>";
               htmlCode += "이름 : " + v.name + "<br><hr>";
               
            });
            

            $("#result").html(htmlCode);
            
         },
         
         error : function(xhr, status, error){
            alert("code : " + xhr.code + "\n"
                  + "message : " + xhr.responseText + "\n"
                  + "error : " + error);
         },
         
         dataType : "json"
         
  		 });
   });
   // Map 데이터 처리
   $("#mapBtn").on("click",function(){
	   //명령1
	   $.ajax({
	         url : "<%=request.getContextPath()%>/json/jsonTest.do",
	         
	         type : "post",
	         
	         data : "choice=map",
	         
	         success : function(data){
	            // data = 
	          
	            let htmlCode = "<h3>Map 응답 결과</h3>";
	            
	            htmlCode += "이름 : " + data.name + "<br>";
	            htmlCode += "전화 : " + data.tel + "<br>";
	            htmlCode += "주소 : " + data.addr + "<br>";

	            $("#result").html(htmlCode);
	            
	         },
	         
	         error : function(xhr, status, error){
	            alert("code : " + xhr.code + "\n"
	                  + "message : " + xhr.responseText + "\n"
	                  + "error : " + error);
	         },
	         
	         dataType : "json"
	         
	  		 });
	   	//명령3
   });
   
});


</script>


</head>
<body>

<form>
   <input type="button" id="strBtn" value="문자열">
   <input type="button" id="arrayBtn" value="배 열">
   <input type="button" id="objBtn" value="객 체">
   <input type="button" id="listBtn" value="리스트">
   <input type="button" id="mapBtn" value="Map객체">
</form>
<hr>

<div id="result"></div>


</body>
</html>