
  
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Module</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
        }

        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        .form-title {
            font-size: 28px;
            margin-bottom: 30px;
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-label {
            display: block;
            font-size: 16px;
            margin-bottom: 5px;
            color: #555;
        }

        .form-input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #f9f9f9;
            color: #333;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
            transition: border-color 0.3s ease;
        }

        .form-input:focus {
            border-color: #FF4081;
        }

        .form-submit {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #FF4081;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-submit:hover {
            background-color: #FF0055;
        }

        .form-back-container {
            text-align: center;
            margin-top: 20px;
        }

        .form-back {
            padding: 10px;
            font-size: 16px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-back:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1 class="form-title">Create Module</h1>
        <form action="createModulesuccess" method="post">
            <div class="form-group">
                <label class="form-label">Module Id:</label>
                <input type="number" name="moduleid" class="form-input">
            </div>

            <div class="form-group">
                <label class="form-label">Module Name:</label>
                <input type="text" name="module_name" placeholder="Enter module name" class="form-input">
            </div>

            <div class="form-group">
                <label class="form-label">Module Description:</label>
                <input type="text" name="module_desc" placeholder="Enter module description" class="form-input">
            </div>

            <div class="form-group">
                <label class="form-label">Module Project Id:</label>
                <input type="number" name="module_proj_id" placeholder="Enter module project id" class="form-input">
            </div>

            <input type="submit" value="Submit" class="form-submit">
        </form>

        <div class="form-back-container">
            <button class="form-back" onclick="goBack()">Back</button>
        </div>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
