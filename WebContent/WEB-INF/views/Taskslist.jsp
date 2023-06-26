<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tasks</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
    
<center><h1>Tasks List</h1></center>
    <!-- Add filters for project-wise and resource-wise views -->
    <form id="filterForm">
        <label for="projectId">Tasks:</label>
        <select name="projectId" id="projectId">
            <option value="">All</option>
            <!-- Populate project options -->
            <c:forEach items="${tasks}" var="task">
                <option value="${task.projectId}">${task.projectId}</option>
            </c:forEach>
        </select>

        <label for="taskStatus">Task Status:</label>
        <select name="taskStatus" id="taskStatus">
            <option value="">All</option>
            <!-- Populate task status options -->
            <c:forEach items="${tasks}" var="task">
                <option value="${task.taskStatus}">${task.taskStatus}</option>
            </c:forEach>
        </select>

        <label for="taskSupervisor">Task Supervisor:</label>
        <select name="taskSupervisor" id="taskSupervisor">
            <option value="">All</option>
            <!-- Populate task supervisor options -->
            <c:forEach items="${tasks}" var="task">
                <option value="${task.taskSupervisorId}">${task.taskSupervisorId}</option>
            </c:forEach>
        </select>
        <button type="submit">Apply Filters</button>
    </form>

    <table id="taskTable">
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Task Supervisor</th>
            <th>Task Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
              <tr class="task-row" onclick="window.location.href='taskdetailsbyid?taskId=${task.taskId}'">
                <td>${task.taskId}</td>
                <td>${task.taskName}</td>
                <td>${task.taskSupervisorId}</td>
                <td>${task.taskStatus}</td>
                <td>
                    <c:if test="${task.taskStatus == 'INPR'}">
							<form action="updateSuccess" method="GET" style="display: inline;">
    							<input type="hidden" name="taskId" value="${task.taskId}" />
    							<button type="submit" class="btn btn-primary update-button">Update Status</button>
							</form>
							<form action="createSubtask" method="GET" style="display: inline;">
    							<input type="hidden" name="taskId" value="${task.taskId}" />
   								<button type="submit" class="btn btn-success create-button">Create Subtask</button>
							</form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script>
$(document).ready(function() {
    // Handle filter form submission using AJAX
    $('#filterForm').submit(function(event) {
        event.preventDefault(); // Prevent form submission
        var filterData = $(this).serialize(); // Serialize form data

        // Send AJAX request to the server
        $.ajax({
            url: 'Taskfilter',
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
                        '<td>' + task.taskSupervisorId + '</td>' +
                        '<td>' + task.taskStatus + '</td>' +
                        '<td>' +
                        '<c:if test="${task.taskStatus == 'Open'}">' +
                        '<form action="updateTaskStatus" method="POST" style="display: inline;">' +
                        '<input type="hidden" name="taskId" value="' + task.taskId + '" />' +
                        '<button type="submit">Update Status</button>' +
                        '</form>' +
                        '<form action="createSubtask" method="POST" style="display: inline;">' +
                        '<input type="hidden" name="taskId" value="' + task.taskId + '" />' +
                        '<button type="submit">Create Subtask</button>' +
                        '</form>' +
                        '</c:if>' +
                        '</td>' +
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

//function to update
$(document).ready(function() {
    $('#submit').on('submit', function(e) {
        e.preventDefault(); // Prevent the form from submitting normally

        // Get the form data
        var formData = $(this).serialize();

        // Send an AJAX request to update the status
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: formData,
            success: function(response) {
                // Handle the response
                // Update the status on the back page using JavaScript or jQuery
            },
            error: function(xhr, status, error) {
                // Handle the error if necessary
            }
        });
    });
});


</script>
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
     .update-button {
        background-color: green;
        color: white;
    }

    .create-button {
        background-color: blue;
        color: white;
    }
</style>
</html>