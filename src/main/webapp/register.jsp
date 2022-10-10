<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="style.css">
  <style>
  h1{
  padding-top:25px;
  font-size: 38px;
  font-weight: 400;
  color: var(--dark-blue);
  }
  body{
 
  background: var(--very-light-gray);
  padding-bottom: 60px;
  border : 5px groove gray;
  margin: 25px 1150px;
  width : 500px;
  
  background: url(./images/bg-intro-mobile.svg) no-repeat top;
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
  .back{
  color:#0000CD;
  }
  .credentials{
  font-size:18px;
  }
  </style>

</head>
<body>
<form action="Register" method="post">
	<center>
	<font color="black">
		<h1>Sign Up</h1><br><br>
		
		<div class="credentials">
		
		Full Name : <input type="text" name="fname" ><br><br>
		Username : <input type="text" name="user" ><br><br>
		Password : <input type="password" name="pwd" ><br><br>
		Confirm Password : <input type="password" name="cpwd" ><br><br>
		
		Select Gender  :
		<input type="radio"  name="gender" value="male" >Male &nbsp;&nbsp;
		<input type="radio"  name="gender" value="female" >Female &nbsp;&nbsp;
		<input type="radio"  name="gender" value="other" >Other &nbsp;&nbsp;
		<br><br>
		
		
		Mobile : <input type="tel" name="mobile" ><br><br>
		Email : <input type="email" name="email" ><br><br>
		Address : <br><textarea row="5" cols="20" name="addr" ></textarea><br><br>
		Amount : <input min=0 max=100000 type="number" name="amt" ><br><br>
		Select Type of the account :
		<input type="radio"  name="acc_type" value="savings" >Savings &nbsp;&nbsp;
		<input type="radio"  name="acc_type" value="current" >Current &nbsp;&nbsp;<br><br>
		UPI ID : <input type="text" name="upi" ><br><br>
		</div>
		<input type="submit" value ="Register"><br><br>
		<a href = "index.jsp"> go back </a><br><br>
		<span class="back">Already an user ?<a href = "login.jsp"> login here </a><br><br></span>
		</font>
	</center>
</form>
</body>
</html>