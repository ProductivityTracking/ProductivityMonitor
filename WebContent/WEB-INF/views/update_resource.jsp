<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Role" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Resource</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            margin: 0 auto;
            width: 300px;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 16px;
        }

        input[type="submit"],
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        button:hover {
            background-color: #45a049;
        }

        .back-button {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .back-button a {
            color: #333;
            text-decoration: none;
            padding: 8px 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <h1>Update Resource</h1>

    <form action="updateSuccess" method="POST">
        <label for="displayName">Display Name:</label>
        <input type="text" id="displayName" name="userDisplayName" value="${resource.userDisplayName}" readonly>

        <label for="role">Role:</label>
        <select name="userRole" id="role" required>
            <c:forEach items="${roles}" var="role">
                <option value="${role.roleId}" ${resource.userRole.roleId eq role.roleId ? 'selected' : ''}>${role.roleName}</option>
            </c:forEach>
        </select>

        <label for="status">Status:</label>
        <select name="userStatus" id="status" required>
            <option value="A" ${resource.userStatus eq 'A' ? 'selected' : ''}>Active</option>
            <option value="B" ${resource.userStatus eq 'B' ? 'selected' : ''}>Non-Active</option>
        </select>

        <input type="hidden" name="originalDisplayName" value="${resource.userDisplayName}">

        <button type="submit">Update</button>
    </form>

    <div class="back-button">
        <a href="http://localhost:8080/SpringOrm/resources">Back</a>
    </div>
</body>
</html>
