<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.Hotel.vo.MemberVO, java.util.List" %>
<%
    List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memList");
%>
<!DOCTYPE html>
<html>
<head>
    <title>블랙리스트 관리</title>
    <style>
        @font-face {
            font-family: 'MinSans-Regular';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/MinSans-Regular.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }

        .layout {
            display: flex;
            min-height: 73vh;
            align-items: center;
            background-color: #f9f9f9; /* 전체 배경 색상 */
        }

        .content {
            display: flex;
            width: 100%;
            background-color: #fff;
            box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);
            justify-content: center;
            border-radius: 10px;
            box-sizing: border-box;
            height: 700px;
        }
        
        .member-list {
		    flex: 1;
		    overflow-y: auto;
		}

        .blacklist-info {
            width: 80%;
            display: flex;
            flex-direction: column;
            height: 100%;
            padding: 20px 0;
            box-sizing: border-box;
        }

        table {
            table-layout: fixed;
            width: 100%;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden; /* 테두리가 둥글게 유지되도록 설정 */
            background-color: #fff;
        }

        thead {
            background-color: #f5deb3; /* 헤더 배경색 */
        }

        th, td {
            border: 1px solid #ddd;
            padding: 15px;
            text-align: left;
            color: #5a2d0c; /* 텍스트 색상 */
            font-size: 15px;
            white-space: nowrap; /* 텍스트 줄바꿈 방지 */
        }

        th {
            font-weight: bold;
        }

        td {
            color: #333;
            background-color: #fdf5e6; /* 테이블의 셀 배경색 */
        }

        tr:nth-child(even) td {
            background-color: #f9f9f9; /* 짝수 행의 배경색 */
        }

        tr:hover td {
            background-color: #f0e6d6; /* 마우스 오버 시 배경색 */
        }

        button {
            background-color: #cd5c5c;
            color: white;
            padding: 2px 2px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #b22222;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        .pagination button {
            margin: 0 5px;
            padding: 10px 15px;
            background-color: #8b4513;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .pagination button:hover {
            background-color: #5a2d0c;
        }

        .pagination button.active {
            background-color: #5a2d0c;
            font-weight: bold;
        }

    </style>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
        $(document).ready(function () {
            const itemsPerPage = 10; // 한 페이지당 출력할 회원 수
            const members = $(".member-item");
            const totalItems = members.length;
            const totalPages = Math.ceil(totalItems / itemsPerPage);

            // 페이지 버튼 생성
            function createPagination() {
                $("#pagination").empty();
                for (let i = 1; i <= totalPages; i++) {
                    $("#pagination").append(
                        '<button class="page-btn" data-page="' + i + '">' + i + '</button>'
                    );
                }
            }

            // 특정 페이지 보여주는 함수
            function showPage(pageNumber) {
                members.hide(); // 모든 회원 숨기기
                const start = (pageNumber - 1) * itemsPerPage;
                const end = start + itemsPerPage;
                members.slice(start, end).show(); // 선택된 페이지 회원만 표시

                // 활성화된 버튼 표시
                $(".page-btn").removeClass("active");
                $('.page-btn[data-page="' + pageNumber + '"]').addClass("active");
            }

            // 초기화
            createPagination();
            showPage(1); // 첫 번째 페이지 표시

            // 페이지 버튼 클릭 이벤트
            $(".page-btn").on("click", function () {
                const pageNumber = $(this).data("page");
                showPage(pageNumber);
            });
        });
    </script>
</head>
<body>
	<div class="layout">
	    <div class="content">
	        <div class="blacklist-info">
	            <h2 style="text-align: center; color: #5a2d0c; margin-bottom: 20px;">블랙리스트 관리</h2>
	            <table>
	                <thead>
	                    <tr>
	                        <th>회원 ID</th>
	                        <th>이름</th>
	                        <th>가입일자</th>
	                        <th>상태</th>
	                        <th>관리</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <% if (memList != null && !memList.isEmpty()) { %>
	                        <% for (MemberVO member : memList) { 
	                        	String memcr = member.getMem_create();
	                        	String create = memcr.split(" ")[0];
	                        	
	                        %>
	                            <tr class="member-item">
	                                <td><%= member.getMem_id() %></td>
	                                <td><%= member.getMem_name() %></td>
	                                <td><%= create %></td>
	                                <td><%= member.getGrade_no() %></td>
	                                <td>
									<% if ("Black".equals(member.getGrade_no())) { %>
										<!-- 블랙 상태 해제 버튼 -->
										<button class="revert-btn" data-id="<%= member.getMem_id() %>">일반으로 변경</button>
									<% } else { %>
										<!-- 블랙리스트로 변경 버튼 -->
										<button class="blacklist-btn" data-id="<%= member.getMem_id() %>">블랙리스트로 변경</button>
									<% } %>
								</td>
	                            </tr>
	                        <% } %>
	                    <% } else { %>
	                        <tr>
	                            <td colspan="5">회원 데이터가 없습니다.</td>
	                        </tr>
	                    <% } %>
	                </tbody>
	            </table>
	        </div>
	    </div>
	</div>
	
	<!-- 페이지네이션 버튼 -->
	<div id="pagination" class="pagination"></div>
</body>
</html>
