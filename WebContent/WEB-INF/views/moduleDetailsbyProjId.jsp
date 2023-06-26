
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

        .module-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 30px;
        }

        .module-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin: 10px;
            width: 250px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            background-color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .module-card:hover {
            background-color: #f5f5f5;
        }

        .module-card h2 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .module-card p {
            margin: 5px 0;
        }

        .create-button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .create-button {
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

        .back-button-container {
            text-align: center;
            margin-top: 20px;
        }

        .back-button {
            background-color: #333;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<h1>Module List</h1>

<div class="module-container">
    <c:forEach items="${moduleDTO}" var="module">
        <div class="module-card" onclick="calldfunit('${module.modl_id}')">
            <h2>Module ID: ${module.modl_id}</h2>
            <p><strong>Name:</strong> ${module.modl_name}</p>
            <p><strong>Description:</strong> ${module.modl_desc}</p>
            <p><strong>Project ID:</strong> ${module.getModl_project_id()}</p>
        </div>
    </c:forEach>
</div>

<div class="create-button-container">
    <button class="button create-button" onclick="window.location.href = 'createModule'">Add Module</button>
</div>

<div class="back-button-container">
    <button class="button back-button" onclick="window.history.back()">Back</button>
</div>

<script>
    function calldfunit(modId) {
        window.location.href = 'funitsbymodlId?modId=' + modId;
    }
</script>
</body>
</html>