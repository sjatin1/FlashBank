<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="style1.css">
<style>
  h1{
  padding-top:50px;
  font-size: 38px;
  font-weight: 400;
  color: var(--dark-blue);
  }
  body{
 
  background: var(--very-light-gray);
  padding-bottom: 60px;
  border : 5px groove gray;
  margin: 200px 950px;
  width : 500px;
  background: url(./images/bg-intro-desktop.svg) no-repeat top;
  background-size: cover;

  }	
  body : hover {
  opacity : 0.5;
  }
  input[type=submit] {
  background: #0066A2;
  color: white;
  }
  input[type=submit] : hover {
  background: #016ABC;
  color: #fff;
  border: 1px solid #eee;
  border-radius: 20px;
  box-shadow: 5px 5px 5px #eee;
  text-shadow: none;
  }
  .credentials{
  font-size:25px;
  }

</style>
</head>
<body>
<form action="Login" method="post">
<center>
	<h1 align="center">Login Page</h1><br><br><br>
	
	<div class="credentials">
	UserName : <input type ="text" name ="user"><br><br>
	Password : <input type ="password" name ="pwd"><br><br>
	
	</div>
	
		<input class = "btn-primary" type="submit" value ="Login"><br>
		<span class="back"><a href = "index.jsp"> go back </a><br><br></span>
	</center>
	</form>

</body>
</html>