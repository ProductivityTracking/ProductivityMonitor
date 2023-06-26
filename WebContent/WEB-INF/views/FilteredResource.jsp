<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Filtered Resources</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
            text-align: center;
            margin: 20px 0;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        select {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            color: #337ab7;
            text-decoration: none;
        }
    </style>
    
</head>
<body>
    <h1>Filtered Resources</h1>

    <form action="filter" method="GET">
        <label for="project">Project:</label>
        <select name="projectFilter" id="project">
            <option value="">All</option>
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}" ${project.projectId == param.projectFilter ? 'selected' : ''}>${project.projectName}</option>
            </c:forEach>
        </select>

        <label for="role">Role:</label>
        <select name="roleFilter" id="role">
            <option value="">All</option>
            <c:forEach items="${roles}" var="role">
                <option value="${role.roleId}" ${role.roleId == param.roleFilter ? 'selected' : ''}>${role.roleName}</option>
            </c:forEach>
        </select>

        <button type="submit">Filter</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Display Name</th>
                
                <th>Display Name</th>
                <th>Employee ID</th>
                <th>Role</th>
                <th>Action</th>
                <th>Tasks</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${resources}" var="resource">
                <tr>
                
                    <td>${resource.userId}</td>
                    <td><a href="details?displayName=${resource.userDisplayName}">${resource.userDisplayName}</a></td>
                    <td>${resource.userEmployeeId}</td>
                    <td>${resource.userRole.roleName}</td>
                    <td>
                        <a href="update?displayName=${resource.userDisplayName}">Update</a> |
                        <a href="tasks?userId=${resource.userId}">View Tasks</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="AddResource">Add Resource</a>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>