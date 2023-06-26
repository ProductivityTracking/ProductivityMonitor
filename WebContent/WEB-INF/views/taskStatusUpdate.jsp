<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Task Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }

        .task-details {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
        }

        .task-details h2 {
            margin-top: 0;
            color: #333;
        }

        .task-details p {
            margin: 0;
            line-height: 1.5;
        }

        .task-details label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }

        .task-details input[type="text"],
        .task-details select {
            width: 300px;
            margin-bottom: 10px;
        }

        .task-details textarea {
            width: 300px;
            height: 100px;
            margin-bottom: 10px;
        }

        .task-details button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="task-details">
        <h2>Task Details</h2>
        <p>
            <label>Task Id:</label>
            ${task.taskId}
        </p>
        <p>
            <label>Task Name:</label>
            ${task.taskName}
        </p>
        <p>
            <label>Task Supervisor:</label>
            ${task.taskSupervisor.userId}
        </p>
        <p>
            <label>Task Status:</label>
            ${task.taskStatus}
        </p>
        <p>
            <label>Project:</label>
            ${task.project.projectId}
        </p>
        <p>
            <label>Module:</label>
            ${task.module.moduleId}
        </p>


        <form action="setTaskDetails" method="get">
         <input type="hidden" name="taskId" value="${task.taskId}" />
            <p>
                <label for="remarks">Remarks:</label>
				<textarea id="remarks" name="remarks" ${readonlyAttribute}>${task.taskRemarks}</textarea>
            </p>
            <p>
                <label for="status">Task Status:</label>
                <select id="status" name="status">
                    <c:choose>
                        <c:when test="${user.userRole.roleId == 1 || user.userRole.roleId == 2}">
                            <option value="REVW">Review</option>
                            <option value="REFC">Refactor</option>
                            <option value="COMP">Completed</option>
                        </c:when>
                        <c:otherwise>
                            <option value="REVW">Review</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </p>
            <p>
                <button type="submit">Submit</button>
            </p>
        </form>
    </div>

    <script>
        // Disable textarea if user's role is not 1 or 2
        var userRoleId = ${user.userRole.roleId};
        if (userRoleId !== 1 && userRoleId !== 2) {
            $("#remarks").prop("readonly", true);
        }
    </script>
</body>
</html>
