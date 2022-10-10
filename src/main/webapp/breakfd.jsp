<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>FD page</title>
  <style>
  input[type=submit] {
  background: linear-gradient(90deg, var(--lime-green), var(--bright-cyan));
  color: var(--white);
  padding: 15px 30px;
  border-radius: 50px;
  font-size: 15px;
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
  padding-right: 180px;
  text-align: center;
  font-size: 20px;
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
        
        <h1>Break Fixed Deposit</h1>
        <ul class="navbar-nav">


          <form action="viewfd.jsp">
         <button class="btn-primary">View Your FDs</button>
</form>
<form action="Fixeddep.jsp">
         <button class="btn-primary">Create FD</button>
</form>
          
          

        </ul>



      </nav>

    </header>

<main>

      <!--
        - #HOME SECTION
      -->
<form action="Breakfd" method="post">

     <div class="credentials">
	<center>
	<span >FD_Name : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fd_name"><br><br></span>
	
		<input type="submit" value ="Break"><br><br>
		<span class="back"><a href = "Fixeddep.jsp"> Go back </a><br><br></span>
		

		 
	</center>
	</div>
	

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