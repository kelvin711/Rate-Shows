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
<title>Login Registration</title>
</head>
<body>
	<div class="container">
		<!--start container-->
		<div class="row">
			<!-- start row-->
			<div class="col-6 mx-auto">
				<!-- start col-->
				<div class="card card-signin  my-5">
					<!--card start-->
					<div class="card-body">
						<!--start card body-->
						<h5 class="card-title text-center">Register</h5>	
						<form:form action="/register" method="POST"  modelAttribute="user">

							<div class="form-label-group">
								<form:label path="firstName">Name</form:label>
								<form:errors path="firstName" class="text-danger" />
								<form:input path="firstName" class="form-control m-2"
									placeholder="First Name" autofocus="true" />
							</div>


							<div class="form-label-group">
								<form:label path="email">Email</form:label>
								<form:errors path="email" class="text-danger" />
								<form:errors path="duplicate" class="text-danger" />
								<form:input path="email" class="form-control m-2"
									placeholder="Email" autofocus="true" type="email" />
							</div>


							<hr class="p-2">

							<div class="form-label-group">
								<form:label path="password">Password</form:label>
								<form:errors path="password" class="text-danger" />
								<form:password path="password" class="form-control m-2"
									placeholder="Password" autofocus="true" />
							</div>

							<div class="form-label-group">
								<form:label path="passwordConfirmation">password Confirmation</form:label>
								<form:errors path="passwordConfirmation" class="text-danger" />
								<form:password path="passwordConfirmation" class="form-control m-2"
									placeholder="password Confirmation" autofocus="true" />
							</div>

							<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

						</form:form>
					</div>
					<!--end card body-->

				</div>
				<!-- card end-->

			</div>
			<!-- end col-->

			<div class="col-6 mx-auto">
				<!--2nd col start-->

				<div class="card card-signin  my-5">
					<!--card begin-->

					<div class="card-body">
						<!--card body-->

						<div class="login-form">
							<h5 class="text-center">Log in</h5>
							<form action="/login" method="POST">

								<div class="form-group">
									<label for="loginEmail">Email</label> <input type="email"
										class="form-control m-2" placeholder="Email" name="loginEmail"
										required="required">

								</div>

								<div class="form-group">
									<label for="loginPassword">Password</label> <input
										type="password" class="form-control m-2"
										placeholder="Password" name="loginPassword"
										required="required">
										<p class="text-danger">${ loginError }</p>
								</div>

								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">Log
										in</button>
								</div>
						</div>
					</div>
					<!-- end card body-->
				</div>
				<!--card end-->
			</div>
			<!--2nd col end-->
		</div>
		<!-- end row-->
	</div>
	<!-- end container-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>