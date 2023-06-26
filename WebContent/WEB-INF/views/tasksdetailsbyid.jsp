<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Task Details</title>
    <style>
        .task-card {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        .task-card-header {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .task-card-label {
            font-weight: bold;
        }
    </style>
</head>

<body>
    <h1>Task Details</h1>

    <c:forEach items="${tasks}" var="task">
        <c:if test="${task.taskId eq param.taskId}">
            <div class="task-card">
                <div class="task-card-header">Task ID: ${task.taskId}</div>
                <div class="task-card-label">Task Name:</div>
                <div>${task.taskName}</div>
                <div class="task-card-label">Task Creation Date/Time:</div>
                <div>${task.taskCreationDateTime}</div>
                <div class="task-card-label">Task Type:</div>
                <div>${task.taskType}</div>
                <div class="task-card-label">Task Category:</div>
                <div>${task.taskCategory}</div>
                <div class="task-card-label">Task Description:</div>
                <div>${task.taskDescription}</div>
                <div class="task-card-label">Task Creator:</div>
                <div>${task.taskCreatorId}</div>
                <div class="task-card-label">Number of Hours Required:</div>
                <div>${task.numberOfHoursRequired}</div>
                <div class="task-card-label">Task Expected Date/Time:</div>
                <div>${task.taskExpectedDateTime}</div>
                <div class="task-card-label">Task Completed Date/Time:</div>
                <div>${task.taskCompletedDateTime}</div>
                <div class="task-card-label">Task Supervisor:</div>
                <div>${task.taskSupervisorId}</div>
                <div class="task-card-label">Task Remarks:</div>
                <div>${task.taskRemarks}</div>
                <div class="task-card-label">Task Status:</div>
                <div>${task.taskStatus}</div>
                <div class="task-card-label">Project ID:</div>
                <div>${task.projectId}</div>
                <div class="task-card-label">Module ID:</div>
                <div>${task.moduleId}</div>
            </div>
        </c:if>
    </c:forEach>
</body>
</html>