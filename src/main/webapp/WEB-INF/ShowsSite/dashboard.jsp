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
	<div class="container bg-light"> <!--start container-->

        <nav class="navbar navbar-expand-lg navbar-inverse bg-light top-fixed" role="navigation"> <!--start nav-->
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Welcome, ${ user.firstName }</a>
                <div class="navbar-collapse collapse">
                    <div class="mr-auto">     
                    </div>
                      <ul class="navbar-nav">
                        <li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav> <!--end nav-->

        <br>
        <h3>TV Shows</h3>

        <div class="row"> <!--start row-->          
            <div class="col"> <!--start col-->
                <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th scope="col">Show</th>
                        <th scope="col">Network</th>
                        <th scope="col">Avg Rating</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${shows}" var="show">   
                      <tr>
                        <th scope="row"><a href="shows/${ show.id }">${ show.title }</a></th>
                        <td>${ show.network }</td>
                        <td>temp</td>
                      </tr>
                    </c:forEach>  
                    </tbody>
                  </table>
                  <a class="btn btn-primary" href="/shows/new" role="button">Add A Show</a>
            </div> <!--end col-->
        </div> <!--end row-->

    </div> <!--end container-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>