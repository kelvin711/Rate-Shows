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
	<div class="container">
        <nav class="navbar navbar-expand-lg navbar-inverse bg-light top-fixed" role="navigation">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">${ show.title }</a>
                <div class="navbar-collapse collapse">
                    <div class="mr-auto">     
                    </div>
                      <ul class="navbar-nav">
                        <li class="nav-item"><a href="/logout" class="btn btn-outline-info">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <br>



    <div class="container"> <!--start container-->
        <div class="row"> <!--start row-->

            <div class="col-3"><!--start col-->
                Rate Show:
                <br>
                <form:form method="POST" action="/shows/{show.id}/review" modelAttribute="ratingObj">
                <form:label path="rating">Rating:</form:label>
			            <form:select path="rating">
			            	<form:option value="5">5</form:option>
			            	<form:option value="4">4</form:option>
			            	<form:option value="3">3</form:option>
			            	<form:option value="2">2</form:option>
			            	<form:option value="1">1</form:option>
			            </form:select>
			        </p>
			        <form:errors path="rating" class="text-danger"/>
			        <form:input type="hidden" path="critic" value="${user.id}" />
			        <form:input type="hidden" path="show" value="${show.id}" />
			        <input type="submit" value="Submit Rating"/>
			    </form:form> 
            </div><!--end col-->



            <div class="col-9"> <!--start col 2-->
                <h3>${show.title}</h3>
                <h4>Network: ${show.network}</h4>
                  <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th scope="col">Name</th>
                          <th scope="col">Rating</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${show.reviews}" var="show">  
                        <tr>
                          <td>${ show.critic.firstName}</td>
                          <td> ${ show.rating } </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                    <a class="btn btn-primary" href="/shows/${show.id}/edit" role="button">Edit Show</a>
            </div><!--end col 2-->   
        </div> <!--end row-->   
    </div> <!--end container-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>