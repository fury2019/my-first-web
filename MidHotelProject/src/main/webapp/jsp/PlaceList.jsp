<%@ page import="com.Hotel.vo.Hotel_PlaceVO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nearby Spots</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Nearby Spots</h1>  
    <%
        List<Hotel_PlaceVO> filteredSpots = (List<Hotel_PlaceVO>) request.getAttribute("spots");
        if (filteredSpots != null && !filteredSpots.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Place ID</th>
                <th>Place Name</th>
                <th>Place Tel</th>
                <th>Place Address</th>
                <th>Place Category ID</th>
                <th>Place Like Amount</th>
                <th>Hotel ID</th>
            </tr>
        </thead>
        <tbody>
        <% for (Hotel_PlaceVO spot : filteredSpots) { %>
            <tr>
                <td><%= spot.getPlace_id() %></td>
                <td><%= spot.getPlace_name() %></td>
                <td><%= spot.getPlace_tel() %></td>
                <td><%= spot.getPlace_addr() %></td>
                <td><%= spot.getPlace_cat_id() %></td>
                <td><%= spot.getPlace_like_amt() %></td>
                <td><%= spot.getHotel_id() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% 
        } else { 
    %>
        <p>No spots available.</p>
    <% 
        } 
    %>
</body>
</html>
