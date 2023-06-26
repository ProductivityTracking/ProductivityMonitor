<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Sprint" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sprint Home</title>
    <style>
        .sprint-card {
            width: 200px;
            height: 200px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin: 10px;
            display: inline-block;
            cursor: pointer;
        }
        
        .sprint-card:hover {
            background-color: #f2f2f2;
        }
        
        .sprint-card-header {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        
        .sprint-card-info {
            font-size: 14px;
            margin-bottom: 5px;
        }
        
        .sprint-details {
            margin-top: 20px;
            font-size: 16px;
            font-weight: bold;
        }
        
        .create-sprint-button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Sprint List</h1>

    <c:forEach items="${sprints}" var="sprint">
        <div class="sprint-card">
            <div class="sprint-card-header">
                Sprint ID: ${sprint.sprintId}
            </div>
            <div class="sprint-card-info">
                Module ID: ${sprint.moduleId}
            </div>
            <div class="sprint-card-info">
                Master ID: ${sprint.masterId}
            </div>
            <div class="sprint-card-info">
                Project ID: ${sprint.projectId}
            </div>
            <div class="sprint-card-info">
                Sprint Name: ${sprint.sprintName}
            </div>
            <c:url var="sprintDetailsUrl" value="/sprint_details">
                <c:param name="sprintId" value="${sprint.sprintId}" />
            </c:url>
            <div class="sprint-details">
                <a href="${sprintDetailsUrl}">View Details</a>
            </div>
           
        </div>
    </c:forEach>
            <c:url var="newsprintUrl" value="newsprint">   
            </c:url>
            <div class="new-sprint">
                <a href="${newsprintUrl}">add new sprint</a>
            </div>
</body>
</html>
