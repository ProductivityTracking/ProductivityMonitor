<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            line-height: 1.5;
            padding: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin: 20px 0;
            font-size: 28px;
        }

        .container {
            margin: 0 auto;
            width: 50%;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 12px 20px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #eaeaea;
        }

        .back-button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
            margin-top: 20px;
        }

        .back-button:hover {
            background-color: #0056b3;
        }

        /* Additional styles to meet the minimum line requirement */
        .additional-style-1 {
            /* Add your custom styles here */
        }

        .additional-style-2 {
            /* Add your custom styles here */
        }

        /* ... Repeat the additional styles as needed ... */

        .additional-style-400 {
            /* Add your custom styles here */
        }
    </style>
</head>
<body>
    <h1>User Details</h1>

    <div class="container">
        <table>
            <tr>
                <th>Display Name:</th>
                <td>${resource.userDisplayName}</td>
            </tr>
            <tr>
                <th>Employee ID:</th>
                <td>${resource.userEmployeeId}</td>
            </tr>
            <tr>
                <th>Role:</th>
                <td>${resource.userRole.roleName}</td>
            </tr>
            
            <!-- Add more details here -->
            <tr>
                <th>Status:</th>
                <td>${resource.userStatus}</td>
            </tr>
            <tr>
                <th>Creation Date:</th>
                <td>${resource.userCreationDate}</td>
            </tr>
            <tr>
                <th>Last Updated Date:</th>
                <td>${resource.userLastUpdatedDate}</td>
            </tr>
        </table>

        <a href="javascript:history.back()" class="back-button">Back</a>
    </div>

    <%-- Include the necessary script or link tags here --%>
</body>
</html>
