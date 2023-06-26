<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Task" %>
<%@ page import="com.pennant.prodmtr.model.Entity.User,com.pennant.prodmtr.model.Entity.Project" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Tasks</title>
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
            flex-direction: row;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }

        label {
            margin-right: 10px;
            font-weight: bold;
        }

        select,
        button {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        select {
            width: 150px;
        }

        button {
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f9f9f9;
            font-weight: bold;
        }

        /* Back button styles */
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

        /* Additional styles (300 lines) */

        /* Example: Increase font size of table headers */
        table th {
            font-size: 18px;
        }

        /* Example: Add background color to even table rows */
        table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* Example: Add margin to the form inputs */
        form select,
        form button {
            margin-right: 10px;
        }

        /* Example: Increase font size of form labels */
        form label {
            font-size: 16px;
        }

        /* Example: Add padding to the table cells */
        table td {
            padding: 12px;
        }

        /* Example: Change background color of back button on hover */
        .back-button:hover {
            background-color: #0056b3;
        }

        /* Example: Add a border to the table */
        table {
            border: 1px solid #ddd;
        }

        /* Example: Add margin to the table */
        table {
            margin-bottom: 20px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#filterForm').on('submit', function (event) {
                event.preventDefault();
                var formData = {};
                $(this).serializeArray().forEach(function (item) {
                    formData[item.name] = item.value;
                });
                console.log(formData);

                var projectFilter = formData['projectFilter'];
                var statusFilter = formData['statusFilter'];
                var categoryFilter = formData['categoryFilter'];

                $.ajax({
                    type: 'GET',
                    url: 'tasks/filter',
                    data: {
                        projectFilter: projectFilter,
                        statusFilter: statusFilter,
                        categoryFilter: categoryFilter,
                        userId: '${userId}' // Use the userId from JSP
                    },
                    dataType: 'json',
                    success: function (response) {
                        var filteredTasksHtml = '';
                        $.each(response, function (index, task) {
                            filteredTasksHtml += '<tr>' +
                                '<td>' + task.taskName + '</td>' +
                                '<td>' + task.taskDescription + '</td>' +
                                '<td>' + task.taskCategory + '</td>' +
                                '<td>' + task.taskCreator.userDisplayName + '</td>' +
                                '<td>' + task.taskSupervisor.userDisplayName + '</td>' +
                                '<td>' + task.taskStatus + '</td>' +
                                '</tr>';
                        });
                        $('#filteredTasks tbody').html(filteredTasksHtml);
                    },
                    error: function () {
                        console.log('Error occurred during filter request.');
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h1>Tasks for User</h1>

    <a href="../resources" class="back-button">Back</a>

    <form id="filterForm">
        <label for="project">Project:</label>
        <select name="projectFilter" id="project">
            <option value="">All</option>
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}">${project.projectName}</option>
            </c:forEach>
        </select>

        <label for="taskStatus">Status:</label>
        <select name="statusFilter" id="taskStatus">
            <option value="">All</option>
            <option value="Pending">Pending</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
        </select>

        <label for="category">Category:</label>
        <select name="categoryFilter" id="category">
            <option value="">All</option>
            <option value="Category 1">Category 1</option>
            <option value="Category 2">Category 2</option>
            <option value="Category 3">Category 3</option>
        </select>

        <input type="hidden" name="userId" value="${userId}"> <!-- Add the userId as a hidden input field -->

        <button type="submit">Filter</button>
    </form>

    <table id="filteredTasks">
        <thead>
            <tr>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Task Category</th>
                <th>Task Creator</th>
                <th>Task Supervisor</th>
                <th>Task Status</th>
                <!-- Add more task properties as needed -->
            </tr>
        </thead>
        <tbody>
            <%-- Display filtered tasks --%>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.taskName}</td>
                    <td>${task.taskDescription}</td>
                    <td>${task.taskCategory}</td>
                    
                    <td>${task.taskStatus}</td>
                    <!-- Add more task properties as needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
 <table id="projectTasks">
        <thead>
            <tr>
                <th>Project ID</th>
                <th>Number of Tasks</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the taskCountList and display the results --%>
            <c:forEach items="${taskCountList}" var="taskCounts">
                <tr>
                    <td>${taskCounts.projectId}</td>
                    <td>${taskCounts.taskCount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
    <%-- Include the necessary script or link tags here --%>
</body>
</html>
