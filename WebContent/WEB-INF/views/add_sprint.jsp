<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.pennant.prodmtr.model.Dto.ProjectDto" %>
<%@ page import="com.pennant.prodmtr.model.Dto.ModuleDTO" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.pennant.prodmtr.model.Entity.User" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Sprint</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    
    <script>
    function fetchModules() {
        var projectId = $('#projectId').val();

        $.ajax({
            url: 'getModuleById',
            method: 'POST',
            dataType: 'json',
            data: { projectId: projectId },
            success: function(response) {
                $('#moduleId').empty();
                response.forEach(function(module) {
                    var option = $('<option></option>').attr('value', module.modl_id).text(module.modl_name);
                    $('#moduleId').append(option);
                });
            },

            error: function(jqXHR, textStatus, errorThrown) {
                console.log('AJAX Error:', textStatus, errorThrown);
            }
        });
    }
    </script>
</head>
<body>
    <div class="container">
        <h1>Create Sprint</h1>
        
        <form action="ShowFunctionalUnits" method="post">
            <div class="form-group">
                <label for="sprintName">Sprint Name:</label>
                <input type="text" class="form-control" id="sprintName" name="sprintName" required>
            </div>
           
            <div class="form-group">
                <label for="SprintMaster">Sprint Master:</label>
                <select class="form-control" id="masterId" name="masterId" onchange="role()">
                    <option disabled selected hidden>Sprint Master</option>
                    <c:forEach items="${users}" var="user">
                        <option value="${user.getUserId()}">${user.getUserDisplayName()}</option>
                    </c:forEach>
                </select>
            </div>
            
           
            <div>
            <input type="hidden" id="role" name="role" value="" >
            
            </div>

            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="datetime-local" class="form-control" id="startDate" name="startDate" required>
            </div>
            
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="datetime-local" class="form-control" id="endDate" name="endDate" required>
            </div>
            
            <div class="form-group">
                <label for="project">Project:</label>
                <select class="form-control" id="projectId" name="projectId" onchange="fetchModules()" required>
                    <option disabled selected hidden>Projects</option>
                    <c:forEach items="${projects}" var="project">
                        <option value="${project.getProjectId()}">${project.getProjectName()}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="modules">Modules:</label>
                <select class="form-control" id="moduleId" name="moduleId" required>
<!--                     <option disabled selected hidden>Modules</option>
 -->                </select>
            <div class="form-group" style="display: none;">
    <label for="sprintId">Sprint Status:</label>
    <input type="hidden" class="form-control" id="sprintStatus" name="sprintStatus" value="InProgress" >
           </div>

            
            <input type="submit" class="btn btn-primary" value="Create Sprint">
        </form>
    </div>
</body>
</html>
