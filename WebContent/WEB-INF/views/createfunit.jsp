
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Functional Unit Creation</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f2f2f2;
  }

  h1 {
    text-align: center;
  }

  form {
    width: 300px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  input[type="number"], input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  button[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  button[type="submit"]:hover {
    background-color: #45a049;
  }

  .back-button {
    display: block;
    margin-top: 10px;
    text-align: center;
  }
</style>
</head>
<body>
<center>
<h1>New Functional Unit Creation</h1></center>
  <form action="createFunitsuccess" method="post">
    <label for="modl_id">Modl_id:</label>
    <input type="number" id="modl_id" name="modl_id" placeholder="Enter Module Id">

    <label for="funt_id">Funit_id:</label>
    <input type="number" id="funt_id" name="funt_id" placeholder="Enter Functional unit id">

    <label for="funit_desc">Funbit_desc:</label>
    <input type="text" id="funit_desc" name="funit_desc" placeholder="Enter Functional unit description">

    <button type="submit">Create</button>
    <a href="javascript:history.back()" class="back-button">Back</a>
  </form>
</body>
</html>
