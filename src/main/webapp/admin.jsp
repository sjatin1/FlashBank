<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>admin page</title>
  <style>
  h1{
  padding: 60px;
  text-align: center;
  font-size: 45px;
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
        
        <h1>Flash Bank</h1>
        <ul class="navbar-nav">


          <li><a href="accounts.jsp">Accounts</a></li>
          <li><a href="fd_history.jsp">FDs</a></li>
          <li><a href="tran_history.jsp">Transactions</a></li>
          <li><a href="Exch_history.jsp">Foreign Currency Exchange</a></li>
        
          <form action="logout.jsp">
         <button class="btn-primary">Log Out</button>
</form>
          

        </ul>



      </nav>

    </header>

<main>

      <!--
        - #HOME SECTION
      -->

      <section class="home" id="home">

        <div class="home-img-box">
          <img src="./images/image-mockups.png" alt="Image for Flashbank Banner" class="home-img" width="100%">
        </div>

        <div class="wrapper">
          <h1 class="home-title">Next generation digital banking</h1>

          <p class="home-text">
            Take your financial life online. Your Flash bank account will be a one-stop-shop
            for spending, saving, budgeting, investing, and much more.
          </p>

     
        </div>

      </section> 

    </main>





    <!--
      - #FOOTER
    -->

    <footer>

      <div class="wrapper-flex">

        <div>

      

          <div class="social-link">
            <a href="#">
              <ion-icon name="logo-facebook"></ion-icon>
            </a>
            <a href="#">
              <ion-icon name="logo-youtube"></ion-icon>
            </a>
            <a href="#">
              <ion-icon name="logo-twitter"></ion-icon>
            </a>
            <a href="#">
              <ion-icon name="logo-pinterest"></ion-icon>
            </a>
            <a href="#">
              <ion-icon name="logo-instagram"></ion-icon>
            </a>
          </div>

        </div>

        <div class="footer-nav" id ="footer">

          <ul>
            <li><a href="#service">About Us</a></li>
            <li><a href="#blog">Contact</a></li>
            <li><a href="#blog">Services</a></li>
          </ul>


        </div>

      </div>

      <div class="wrapper">

        <p class="copyright">&copy; Flashbank. All Rights Reserved</p>

      </div>

    </footer>

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