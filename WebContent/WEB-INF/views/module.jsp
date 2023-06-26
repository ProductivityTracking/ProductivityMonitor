<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Module Details</title>
    <style>
        /* Apply styles to the container div */
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
        }
        
        /* Style the heading */
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        /* Style the table */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        /* Style the table rows */
        tr {
            cursor: pointer;
            background-color: #fff;
        }

        /* Style the selected row */
        .selected {
            background-color: #ccc;
        }

        /* Style the table cells */
        td {
            padding: 8px 16px;
            border: 1px solid #ccc;
        }

        /* Style the anchor tag */
        .anchor {
            text-decoration: none;
            color: #000;
            margin-top: 20px;
        }

        /* Style the anchor tag on hover */
        .anchor:hover {
            background-color: #ccc;
            border-radius: 5px;
            padding: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Module Details</h1>
        <table>
            <tr>
                <th>Module ID</th>
                <th>Module Name</th>
                <th>Project ID</th>
            </tr>
            <c:forEach var="module" items="${modules}">
                <tr>
                    <td><a href="moduledetails/${module.modl_id}">${module.modl_id}</a></td>
                    <td>${module.modl_name}</td>
                    <td>${module.modl_proj_id}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="createModule" class="anchor">Create Module</a>
    </div>
</body>
</html>