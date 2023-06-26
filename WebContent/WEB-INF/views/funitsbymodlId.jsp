
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
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
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #555;
        }

        .back-button-container {
            text-align: center;
            margin-top: 20px;
        }

        .back-button {
            background-color: #555;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #777;
        }
    </style>
</head>
<body>

<h1>Functional Units</h1>

<table>
    <tr>
        <th>Module ID</th>
        <th>Functional Unit ID</th>
        <th>Functional Unit Description</th>
    </tr>
    <c:forEach items="${funitdto}" var="funit">
        <tr>
            <td>${funit.modl_id}</td>
            <td>${funit.funt_id}</td>
            <td>${funit.funit_desc}</td>
        </tr>
    </c:forEach>
</table>

<div class="buttons-container">
    <button class="button create-button" onclick="window.location.href = 'createfunit'">Create Functional Unit</button>
</div>

<div class="back-button-container">
    <button class="button back-button" onclick="window.history.back()">Back</button>
</div>

</body>
</html>