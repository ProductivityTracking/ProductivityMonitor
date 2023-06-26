<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Sprint</title>
</head>
<body>
    <h1>Create New Sprint</h1><form action="/spring-orm/create_sprint" method="POST">

        <input type="text" name="moduleId" placeholder="Module ID" required><br>
        <input type="text" name="masterId" placeholder="Master ID" required><br>
        <input type="text" name="projectId" placeholder="Project ID" required><br>
        <input type="text" name="sprintName" placeholder="Sprint Name" required><br>
        <input type="date" name="startDate" required><br>
        <input type="date" name="endDate" required><br>
        <input type="submit" value="Create Sprint">
    </form>
</body>
</html>
