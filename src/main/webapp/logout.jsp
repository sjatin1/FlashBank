<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.logout{
padding : 250px;
font-size : 50px;
}
input[type=submit] {
 background: linear-gradient(90deg, var(--lime-green), var(--bright-cyan));
  color: var(--white);
  padding: 15px 30px;
  border-radius: 50px;
  font-size: 40px;
  font-weight: 700;
  padding: 16px 32px;
  diplay : block;
  margin: 1px 1px;
  cursor: pointer;
}
</style>
</head>
<body>
<form action="Logout" method="post">
<center>
<div class="logout">
<p> Are you sure you want to logout </p>
		<input type="submit" value ="logout"><br><br>
		<a href="dashboard.jsp">go back</a>
		</div>
		 
	</center>
	</form>

</body>
</html>