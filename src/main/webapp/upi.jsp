<%@page import="perfios.pojo.Services"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UPI page</title>
  <style>
  .popup {
  position: relative;
  display: inline-block;
  font-size:25px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* The actual popup */
.popup .popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
  from {opacity: 0;} 
  to {opacity: 1;}
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity:1 ;}
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
  h1{
  padding: 60px;
  text-align: center;
  font-size: 50px;
  cursor : default;
}
.credentials{
  padding-right: 220px;
  text-align: center;
  font-size: 20px;
}
.amt{
font-size: 40px;
}
input[type=number], input[type=text] {
font-size: 40px;
}
  </style>

  <!--
    - custom css link
  -->
  <link rel="stylesheet" href="style1.css">

  <!--
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@300;400;700&display=swap" rel="stylesheet">
</head>

<body>

  <!--
    - #main container
  -->

  <div class="container">

    <!--
      - #HEADER SECTION
    -->

    <header>

      <nav class="navbar">

        <svg xmlns="http://www.w3.org/2000/svg" width="139" height="20">
          <defs>
            <linearGradient id="a" x1="72.195%" x2="17.503%" y1="0%" y2="100%">
              <stop offset="0%" stop-color="#33D35E" />
              <stop offset="100%" stop-color="#2AB6D9" />
            </linearGradient>
          </defs>
          <g fill="none" fill-rule="evenodd">
            <path fill="#2D314D" fill-rule="nonzero"/>
            <g fill="url(#a)">
              <path d="M10.802 0L0 19.704h5.986L16.789 0z" />
              <path opacity=".5" d="M18.171 0L7.368 19.704h5.986L24.157 0z" />
              <path opacity=".15" d="M25.539 0L14.737 19.704h5.986L31.525 0z" />
            </g>
          </g>
        </svg>

        <button class="navbar-toggle-btn">
          <span class="one"></span>
          <span class="two"></span>
          <span class="three"></span>
        </button>
        
        <h1>UPI Transfer</h1>
        <ul class="navbar-nav">  


 <% Services s = new Services();
String accno = (String) session.getAttribute("acc");
double amt = s.getAmt(accno);
%>
<div class="popup" onclick="myFunction()">Check Balance
  <span class="popuptext" id="myPopup">Balance : <%= amt %></span>
</div>

<script>
// When the user clicks on div, open the popup
function myFunction() {
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}
</script>

<form action="dashboard.jsp">
         <button class="btn-primary">Dashboard</button>
</form>

</ul>
          

      



      </nav>

    </header>

<main>

      <!--
        - #HOME SECTION
      -->
<form action="Upi" method="post">
<center>
	

	<span class="amt">
	&nbsp;&nbsp;&nbsp;&nbsp;UPI ID : &nbsp;&nbsp;&nbsp;<input type="text" name="upi_id"><br><br>
	Target UPI ID : &nbsp;&nbsp;&nbsp;<input type="text" name="tarUpi_id">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
	Amount : &nbsp;&nbsp;&nbsp;<input min=0 type="number" name="amt"><br><br>
	</span>
	
	
		<input type="submit" value ="transfer"><br><br>
		 <span><a href = "money.jsp"> Go back</a></span>
	</center>
	</form>

    </main>





    
  </div>




  <!--
    - custom js
  -->

  <script>

    const navbarToggleBtn = document.querySelector('.navbar-toggle-btn');
    const navbarNav = document.querySelector('.navbar-nav');

    const navbarToggleFunc = function () {
      navbarToggleBtn.classList.toggle('active');
      navbarNav.classList.toggle('active');
    }

    navbarToggleBtn.addEventListener('click', navbarToggleFunc);

  </script>



  <!--
    - ionicon link
  -->
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

</body>

</html>