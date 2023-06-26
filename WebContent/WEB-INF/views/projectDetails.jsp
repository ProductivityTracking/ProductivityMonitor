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
        <th>Project ID</th>
        <th>Project Name</th>
        <th>Project Description</th>
        <th>Project Start Date</th>
       
        <th>Project Status</th>
        <th>Project Last Updated Date</th>
    </tr>
    <tr>
        <td>${projectDto.projectId}</td>
        <td>${projectDto.projectName}</td>
        <td>${projectDto.projectDescription}</td>
        <td>${projectDto.projectStartDate}</td>
     
        <td>${projectDto.projectStatus}</td>
        <td>${projectDto.projectLastUpdatedDate}</td>
    </tr>
</table>

    <div class="buttons-container">
        <button class="button" onclick="callModuleDetailsByProjId()">Modules</button>
        <button class="button" onclick="callResourceDetailsByProjId()">Resources</button>
        <button class="button" onclick="callSprintDetailsByProjId()">Sprints</button>
    </div>
</body>

<script>

function callModuleDetailsByProjId() {
	alert("callModuleDetailsByProjId");
    window.location.href = 'moduleDetailsByProjId?projectId=' + ${projectDto.projectId};
}

function callResourceDetailsByProjId() {
	alert("callResourceDetailsByProjId");
    window.location.href = 'resourceDetailsByProjId?projectId=' + ${projectDto.projectId};
}

function callSprintDetailsByProjId() {
    var projectId = parseInt('${projectDto.projectId}');
    window.location.href = 'sprintDetailsByProjId?projectId=' + projectId;
}
</script>

</html>