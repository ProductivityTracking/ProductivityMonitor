<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Sprint" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sprint Details</title>
    <style>
        .sprint-details-container {
            width: 400px;
            margin: 20px auto;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
        }
        
        .sprint-details-header {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        
        .sprint-details-info {
            font-size: 16px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="sprint-details-container">
        <div class="sprint-details-header">
            Sprint Details
        </div>
        <div class="sprint-details-info">
            Sprint ID: ${sprint.sprintId}
        </div>
        <div class="sprint-details-info">
            Module ID: ${sprint.moduleId}
        </div>
        <div class="sprint-details-info">
            Master ID: ${sprint.masterId}
        </div>
        <div class="sprint-details-info">
            Start Date: ${sprint.startDate}
        </div>
        <div class="sprint-details-info">
            End Date: ${sprint.endDate}
        </div>
        <div class="sprint-details-info">
            Project ID: ${sprint.projectId}
        </div>
        <div class="sprint-details-info">
            Sprint Name: ${sprint.sprintName}
        </div>
    </div>
</body>
</html>
