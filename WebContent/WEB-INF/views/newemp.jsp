<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Project Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        form {
            width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input[type="number"],
        input[type="text"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
            height: 80px;
        }

        select {
            height: 30px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Add Project Task</h1>

    <form:form action="addprojecttask" method="POST" modelAttribute="projectTaskInput">
        <label for="taskId">Task ID:</label>
        <input type="number" id="taskId" name="taskId" required/><br/>

        <label for="assignedUserId">Assigned User:</label>
        <select id="assignedUserId" name="assignedUserId">
            <c:forEach items="${resources}" var="user">
                <option value="${user.userId}">${user.userDisplayName}</option>
            </c:forEach>
        </select><br/>

        <label for="taskName">Task Name:</label>
        <input type="text" id="taskName" name="taskName" required/><br/>

        <label for="taskCategory">Task Category:</label>
        <input type="text" id="taskCategory" name="taskCategory" required/><br/>

        <label for="taskDescription">Task Description:</label>
        <textarea id="taskDescription" name="taskDescription" rows="4" cols="50" required></textarea><br/>

        <label for="taskCreatorId">Task Creator ID:</label>
        <input type="number" id="taskCreatorId" name="taskCreatorId" required/><br/>

        <label for="numberOfHoursRequired">Number of Hours Required:</label>
        <input type="number" id="numberOfHoursRequired" name="numberOfHoursRequired" step="0.01" required/><br/>

        <label for="projectId">Project:</label>
        <select id="projectId" name="projectId">
            <c:forEach items="${projects}" var="project">
                <option value="${project.projectId}">${project.projectName}</option>
            </c:forEach>
        </select><br/>

        <input type="submit" value="Add Task"/>
    </form:form>
</body>
</html>
