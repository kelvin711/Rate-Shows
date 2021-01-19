<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/FILENAME.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
<title>Shows</title>
</head>
<body>
	<div class="row">

  <div class="col">
    <h3>Create a new show</h3>
   
    <form:form method="POST" action="/shows/create"
      modelAttribute="showObj">
      <form:hidden path="showCreator" value="${user.id}" />
      
      <div class="">
        <form:label class="col-sm-2 col-form-label" path="title">Title:</form:label>
        <form:input class="form-control col-sm-6" type="text" path="title" />
        <form:errors path="title" class="text-danger" />  
      </div>
        
      <div class="">
        <form:label class="col-sm-2 col-form-label" path="network">Network:</form:label>
        <form:input class="form-control col-sm-6" type="text" path="network" />
        <form:errors path="network" class="text-danger" />  
      </div>
        

      <input class="btn btn-primary" type="submit" value="Create" />
    </form:form>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>