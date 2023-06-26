<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project Task Details</title>
    <style>
        /* CSS styles for the page layout */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }
        
        .task-details {
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            max-width: 500px;
            margin: 0 auto;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        
        .detail {
            margin-bottom: 15px;
        }
        
        .detail label {
            font-weight: bold;
        }
        
        .detail span {
            margin-left: 10px;
        }
        
        .back-button {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="task-details">
        <h1>Project Task Details</h1>
        
        <div class="detail">
            <label>Task ID:</label>
            <span>${task.taskId}</span>
        </div>
        
        <div class="detail">
            <label>Assigned User Id:</label>
            <span>${task.assignedUserId}</span>
        </div>
        
        <div class="detail">
            <label>Task Name:</label>
            <span>${task.taskName}</span>
        </div>
        
        <div class="detail">
            <label>Task Creation Date/Time:</label>
            <span>${task.taskCreationDateTime}</span>
        </div>
        
        <div class="detail">
            <label>Task Category:</label>
            <span>${task.taskCategory}</span>
        </div>
        
        <div class="detail">
            <label>Task Description:</label>
            <span>${task.taskDescription}</span>
        </div>
        
        <div class="detail">
            <label>Task Creator Id:</label>
            <span>${task.taskCreatorId}</span>
        </div>
        
        <div class="detail">
            <label>Number of Hours Required:</label>
            <span>${task.numberOfHoursRequired}</span>
        </div>
        
        <div class="detail">
            <label>Task Expected Date/Time:</label>
            <span>${task.taskExpectedDateTime}</span>
        </div>
        
        <div class="detail">
            <label>Actual Hours:</label>
            <span>${task.actualHours}</span>
        </div>
        
    
        <a class="back-button" href="projecttasks">&larr; Back to All Project Tasks</a>
    </div>
</body>
</html>
