<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resources Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            line-height: 1.5;
            position: relative;
        }

        .action-column {
            white-space: nowrap;
        }

        .action-column a {
            margin-right: 10px;
        }

        .divider {
            margin: 0 5px;
        }

        h1 {
            color: #333;
            text-align: center;
            margin: 20px 0;
            font-size: 28px;
        }

        form {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        label {
            margin-right: 10px;
            font-weight: bold;
        }

        select {
            padding: 5px;
            font-size: 14px;
        }

        button {
            padding: 8px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table thead {
            background-color: #007bff;
            color: #fff;
        }

        table th,
        table td {
            padding: 10px;
            text-align: left;
            font-size: 14px;
            border-bottom: 1px solid #ddd;
        }

        table tbody tr:hover {
            background-color: #f9f9f9;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        #filteredResources {
            margin-top: 20px;
        }

        #filteredResources table {
            margin-top: 10px;
        }

        #filteredResources table th,
        #filteredResources table td {
            font-size: 14px;
        }

        #filteredResources table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        #filteredResources table tbody tr:hover {
            background-color: #eaeaea;
        }

        .add-resource-link {
            position: absolute;
            top: 10px;
            right: 10px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .add-resource-link:hover {
            background-color: #0056b3;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#filterForm').on('submit', function(event) {
                event.preventDefault();
                var formData = $(this).serialize();
                $.ajax({
                    type: 'GET',
                    url: 'resources/filter',
                    data: formData,
                    dataType: 'json',
                    success: function(response) {
                        var filteredResourcesHtml = '';
                        $.each(response, function(index, resource) {
                            filteredResourcesHtml += '<tr>' +
                                '<td>' + resource.userId + '</td>' +
                                '<td><a href="resources/details?displayName=' + resource.userDisplayName + '">' + resource.userDisplayName + '</a></td>' +
                                '<td>' + resource.userEmployeeId + '</td>' +
                                '<td>' + resource.userRole.roleName + '</td>' +
                                '<td>' +
                                '<a href="resources/update?displayName=' + resource.userDisplayName + '">Update</a> | ' +
                                '<a href="resources/tasks?userId=' + resource.userId + '">View Tasks</a>' +
                                '</td>' +
                                '</tr>';

                            // Append the additional information
                            filteredResourcesHtml += '<tr>' +
                                '<td colspan="5">' +
                                'Hours Worked: ' + resource.hoursWorked + '<br>' +
                                'Tasks Completed: ' + resource.tasksCompleted + '<br>' +
                                'Performance Score: ' + resource.performanceScore +
                                '</td>' +
                                '</tr>';
                        });

                        // Update the table body with the generated HTML
                        $('#resourcesTable tbody').html(filteredResourcesHtml);
                    },
                    error: function(xhr, status, error) {
                        console.log(error);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <h1>Resources</h1>

    <form id="filterForm">
        <label for="project">Project:</label>
        <select name="projectFilter" id="project">
            <option value="">All</option>
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}">${project.projectName}</option>
            </c:forEach>
        </select>

        <label for="role">Role:</label>
        <select name="roleFilter" id="role">
            <option value="">All</option>
            <c:forEach items="${roles}" var="role">
                <option value="${role.roleId}">${role.roleName}</option>
            </c:forEach>
        </select>

        <button type="submit">Filter</button>
    </form>

    <div id="filteredResources">
        <table id="resourcesTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Display Name</th>
                    <th>Employee ID</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${resources}" var="resource">
                    <tr>
                        <td>${resource.userId}</td>
                        <td><a href="resources/details?displayName=${resource.userDisplayName}">${resource.userDisplayName}</a></td>
                        <td>${resource.userEmployeeId}</td>
                        <td>${resource.userRole.roleName}</td>
                        <td>
                            <a href="resources/update?displayName=${resource.userDisplayName}">Update</a> |
                            <a href="resources/tasks?userId=${resource.userId}">View Tasks</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            Hours Worked: ${resource.hoursWorked}<br>
                            Tasks Completed: ${resource.tasksCompleted}<br>
                            Performance Score: ${resource.performanceScore}
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="resources/AddResource" class="add-resource-link">Add Resource</a>
</body>
</html>