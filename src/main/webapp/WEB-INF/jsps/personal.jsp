<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>My profile</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}
</style>
<title>Personal settings</title>

</head>

 
<body>
<div class="w3-display-container w3-content" style="max-width: 1500px;">
<jsp:include page="headerBar.jsp"/>
<div class="w3-bar w3-white w3-large">

</div>
	
		<div class="w3-bar w3-white w3-large">
			<h2 class="w3-center w3-purple">Welcome ${user.getUsername()}</h2>
			<img src="/profile-pictures/${user.getPictures().getName()}" alt="">
			<h3 class="w3-center">Your Personal Information</h3>
			
		
			<div class="w3-center">
				<p>First Name: ${user.getFirstName()}</p>
				<p>Last Name: ${user.getLastName()}</p>
				<p>Email: ${user.getEmail()}</p>
				<p>Number: ${user.getNumber()}</p>


			</div>
			<div>
				<h4 class="w3-center">Update your information</h4>
				<br />

				<form method="POST" action="/personal">

				<form class="w3-center" method="POST" action="/personal">


					<input type="hidden" name="username" readonly="readonly"
						value="${user.getUsername()}" /> <label> First Name:</label> <input
						type="text" name="firstName" value="${user.getFirstName()}" /> <label>
						Last Name:</label> <input type="text" name="lastName"
						value="${user.getLastName()}" /><label> Email:</label> <input
						type="text" name="email" value="${user.getEmail()}" /> <label>
						Number:</label> <input type="text" name="number"
						value="${user.getNumber()}" /> 
						<input type="submit"
						class="w3-bar-item w3-button w3-blue w3-mobile" value="Update" style="margin-left:47%; margin-top:25px"/>
						
						
						
				</form>

			</div>

		</div>
	</div>
	<jsp:include page="homeBar.jsp"/>
</body>
</html>