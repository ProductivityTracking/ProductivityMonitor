<%@page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Productivity Monitor</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
            text-align: center;
            margin-top: 50px;
        }

        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }

        th {
            background-color: #f9f9f9;
            color: #333;
        }

        .clickable-row {
            cursor: pointer;
            background-color: #fff;
        }

        .clickable-row:hover {
            background-color: #f5f5f5;
        }

        .buttons-container {
            text-align: center;
            margin-top: 20px;
        }

        .button {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>Sprint ID</th>
        <th>Sprint Name</th>
        <th>Sprint master</th>
        <th>Sprint module id</th>
        <th> Sprint startDate</th>
        <th>Sprint End date</th>
        <th>Sprint project id</th>
    </tr>
    <c:forEach items="${sprintdto}" var="sprint">
        <tr>
            <td>${sprint.sprn_id}</td>
            <td>${sprint.sprint_name}</td>
             <td>${sprint.sprn_master}</td>
            <td>${sprint.sprn_modl_id}</td>
            <td>${sprint.startDate}</td>
            <td>${sprint.sprn_enddate}</td>
            <td>${sprint.proj_id}</td>
        </tr>
    </c:forEach>
</table>
<!-- 
<div class="buttons-container">
    <button class="button" onclick="calls()">Modules</button>
    <button class="button" onclick="location.href='resources1.jsp'">Resources</button>
    <button class="button" onclick="location.href='sprintbyprojectid'">Sprints</button>
</div> -->
</body>
<script>
    function calls() {
        window.location.href = 'moduleDetailsByProjId?projectId=' + ${moduleDTO[0].modl_project_id};
    }
</script>
</html>
