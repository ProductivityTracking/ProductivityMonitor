<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Project" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Role" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Resource</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            line-height: 1.5;
            position: relative;
        }

        h1 {
            color: #333;
            text-align: center;
            margin: 20px 0;
            font-size: 28px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 20px;
        }

        label {
            margin-bottom: 10px;
            font-weight: bold;
        }

        input,
        select {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        select {
            width: 100%;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            border-radius: 4px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .back-button {
            position: absolute;
            top: 10px;
            left: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #0056b3;
        }

        /* Optional: Add additional styles as needed */
        /* Example: Increase spacing between form elements */
        form > * {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Add Resource</h1>

    <a href="../resources" class="back-button">cancel</a>

    <form action="addSuccess" method="POST">
        <label for="id">ID:</label>
        <input type="text" id="id" name="userId" required>

        <label for="displayName">Display Name:</label>
        <input type="text" id="displayName" name="userDisplayName" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="userPassword" required>

        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="userEmployeeId" required>

        <label for="status">Status:</label>
        <select name="userStatus" id="status" required>
            <option value="A">Active</option>
            <option value="B">Non-Active</option>
        </select>

        <label for="userRole">Role:</label>
        <select name="userRole" id="userRole" required>
            <c:forEach items="${roles}" var="role">
                <option value="${role.roleId}">${role.roleName}</option>
            </c:forEach>
        </select>

        <button type="submit">Add</button>
    </form>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
