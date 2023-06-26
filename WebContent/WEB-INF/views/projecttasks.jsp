<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project Tasks</title>
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
            text-align: center;
            margin-bottom: 20px;
        }

        select,
        button {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            background-color: #fff;
            color: #333;
            font-size: 14px;
            margin-right: 10px;
        }

        select:hover,
        button:hover {
            background-color: #e6e6e6;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border: 1px solid #ccc;
        }

        th,
        td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            color: #333;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-button {
            margin-bottom: 10px;
        }

        .view-details-link {
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }

        .view-details-link:hover {
            color: #0066cc;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Handle filter form submission using AJAX
            $('#filterForm').submit(function(event) {
                event.preventDefault(); // Prevent form submission
                var filterData = $(this).serialize(); // Serialize form data

                // Send AJAX request to the server
                $.ajax({
                    url: 'projectfiltertasks',
                    type: 'POST',
                    data: filterData,
                    dataType: 'json', // Expect JSON response
                    success: function(data) {
                        // Replace the table body with the updated data
                        var tbody = $('#taskTable tbody');
                        tbody.empty(); // Clear existing rows

                        // Iterate over the filtered tasks and add them to the table
                        for (var i = 0; i < data.length; i++) {
                            var task = data[i];
                            var row = '<tr>' +
                                '<td>' + task.taskId + '</td>' +
                                '<td>' + task.taskName + '</td>' +
                                '<td>' + task.taskDescription + '</td>' +
                                '<td>' + task.assignedUserId + '</td>' +
                                '<td>' + task.projectId + '</td>' +
                                '<td><a class="view-details-link" href="taskdetails?taskId=' + task.taskId + '">View Details</a></td>' +
                                '</tr>';
                            tbody.append(row);
                        }
                    },
                    error: function() {
                        alert('An error occurred while retrieving filtered tasks.');
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h1>Project Tasks (without sprints)</h1>

    <!-- Add button for adding a project task -->
    <form action="addProjectTaskForm" method="GET">
        <button class="add-button" type="submit">Add Project Task</button>
    </form>

    <!-- Add filters for project-wise and resource-wise views -->
    <form id="filterForm" action="/projecttasks" method="get">
        <label for="projectId">Project:</label>
        <select name="projectId" id="projectId">
            <option value="">All</option>
            <!-- Populate project options -->
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}">${project.projectName}</option>
            </c:forEach>
        </select>

        <label for="resourceId">Resource:</label>
        <select name="resourceId" id="resourceId">
            <option value="">All</option>
            <!-- Populate resource options -->
            <c:forEach items="${resources}" var="resource">
                <option value="${resource.userId}">${resource.userDisplayName}</option>
            </c:forEach>
        </select>

        <button type="submit">Apply Filters</button>
    </form>

    <table id="taskTable">
        <thead>
            <tr>
                <th>Task ID</th>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Task Assigned User ID</th>
                <th>Project ID</th>
                <th>Actions</th> <!-- Add column for actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${projectTasks}" var="task">
                <tr>
                    <td>${task.taskId}</td>
                    <td>${task.taskName}</td>
                    <td>${task.taskDescription}</td>
                    <td>${task.assignedUserId}</td>
                    <td>${task.projectId}</td>
                    <td>
                        <!-- Add link for viewing task details -->
                        <a class="view-details-link" href="taskdetails?taskId=${task.taskId}">View Details</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>