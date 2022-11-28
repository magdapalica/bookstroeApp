<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<div>
<style>
		.badge1 {
			position:relative;
		}
		.badge1[data-badge]:after {
			content:attr(data-badge);
			position:absolute;
			top:2px;
			right:2px;
			font-size:.8em;
			background: red;
			color:white;
			width:20px;height:20px;
			text-align:center;
			line-height:18px;
			border-radius:50%;
			box-shadow:0 0 1px #333;
		}
		.badge1[data-badge="0"]:after {
			display: none;
		}
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			let elem = document.getElementById("own-products");
			if (elem)
				elem.dataset.badge = "${notificationCount}";
		});
	</script>
  <a href="/" class="w3-bar-item w3-button w3-mobile w3-left"><img src="/images/bookstore-logo.webp" width=60></a>
</div>
 <div class="nav-bar w3-white w3-large w3-right" style="margin-top:15px; margin-bottom:20px">
  <a href="/categories" class="w3-bar-item w3-button w3-lime w3-mobile" style="margin-right:5px">Category</a>
  <a href="/personal" class="w3-bar-item w3-button w3-lime  w3-mobile" style="margin-right:5px">Personal</a>
  <a href="#cart" class="w3-bar-item w3-button w3-lime w3-mobile" style="margin-right:5px">Cart</a>
  
  
  <security:authorize access="isAuthenticated()">
   <a href="/logout" class="w3-bar-item w3-button w3-lime w3-right w3-mobile">Logout</a>
  </security:authorize>
  <security:authorize access="not isAuthenticated()">
  <a href="/login" class="w3-bar-item w3-button w3-lime   w3-mobile">Login</a>
   </security:authorize>
</div>