 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pennant.prodmtr.model.Entity.Subtask" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Subtask</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Create Subtask</h1>
        <form action="saveSubtask" method="GET">
              <<div class="form-group">
    <label for="taskId">Task ID:</label>
    <input type="number" class="form-control" id="taskId" name="taskId" value="${taskId}">
</div>

            <div class="form-group">
                <label for="subtaskId">Subtask ID:</label>
                <input type="number" class="form-control" name="subtaskId" id="subtaskId">
            </div>
            <div class="form-group">
                <label for="subtaskDesc">Subtask Description:</label>
                <input type="text" class="form-control" name="subtaskDescription" id="subtaskDesc">
            </div>
            <div class="form-group">
                <label for="subtaskHours">Subtask Hours:</label>
                <input type="number" class="form-control" name="numberOfHours" id="subtaskHours" step="0.01">
            </div>
             <div class="form-group">
                <label for="subtaskDate">Subtask Creation Date:</label>
                <input type="date" class="form-control" name="creationDate" id="subtaskDate">
            </div>
            <button type="submit" class="btn btn-primary" onclick="addSubtask()">Submit</button>
        </form>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
    	function addSubtask(){
    		window.alert("Subtask added succesfully");
    	}
    </script>
</body>
</html>