<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Project</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body >
<div class="container">
    <div class="form-container">
        <h2>Add Project</h2>
        <form action="savenewproject" method="get">
            <div class="mb-3">
                <label for="proj_name" class="form-label">Project Name:</label>
                <input type="text" id="proj_name" name="projectName" class="form-control" required maxlength="100">
            </div>


            <div class="mb-3">
                <label for="proj_id" class="form-label">Project Id:</label>
                <input type="number" id="proj_id" name="projectId" class="form-control" required maxlength="100">
            </div>

            <div class="mb-3">
                <label for="proj_desc" class="form-label">Project Description:</label>
                <input type="text" id="proj_desc" name="projectDescription" class="form-control" maxlength="255">
            </div>

            <div class="mb-3">
                <label for="proj_manager" class="form-label">Project Manager:</label>
				<select id="proj_manager" name="projectManager" class="form-control" required>
				    <option value="">Select Project Manager</option>
				    <c:forEach var="projmng" items="${allMngs}">
				        <option value="${projmng.userId}">${projmng.userDisplayName}</option>
				    </c:forEach>
				</select>
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-primary">Add Project</button>
            </div>
        </form>
    </div>
</div>
</body>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f8f9fa;
        }
        
    </style>
</html>