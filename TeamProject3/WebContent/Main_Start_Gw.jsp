<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Main_Gw</title>
 <link rel="stylesheet" type="text/css" href="./GW_CSS/Main_001.css">
 <style type="text/css">
 
 @media only screen {
  html,
  body {
    background: #222;
    overflow: hidden;
    height: 100%;
  }

  .logo {
    font-size: 8rem;
    font-family: 'sonos-logoregular';
    text-align: center;
    background: -webkit-linear-gradient(left, #33235B, #D62229, #E97639, #792042, #33235B);
    background: linear-gradient(left, #33235B, #D62229, #E97639, #792042, #33235B);
    background-size: 3200px 200px;
    margin-top: 20vh;
    color: transparent;
    -webkit-background-clip: text;
    -webkit-animation: animate-logo;
    -webkit-animation-delay: 0;
    -webkit-animation-duration: 7s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-fill-mode: forwards;
    transition: font-size 500ms ease-in-out;
  }
}
@media only screen and (min-width: 40.063em) {
  .logo {
    margin-top: 30vh;
    font-size: 13rem;
  }
}
@media only screen and (min-width: 64.063em) {
  .logo {
    margin-top: 25vh;
    font-size: 20rem;
  }
}
@media only screen and (min-width: 90.063em) {
  .logo {
    margin-top: 20vh;
    font-size: 30rem;
  }
}
@media only screen and (min-width: 120.063em) {
  .logo {
    margin-top: 15vh;
    font-size: 40rem;
  }
}
@-webkit-keyframes animate-logo {
  0% {
    background-position: 0 3200px;
  }
  100% {
    background-position: 3200px 0;
  }
}

A:link { text-decoration:none; color:#646464;}
A:visited { text-decoration:none; color:#646464;}
A:active { text-decoration:none; color:#646464;}
A:hover { text-decoration:none; color:#646464;}
 </style>

</head>
<body>



<div style="text-align: center; margin:auto;">
<a href="main.do"><h1 class="logo">보좌관들</h1></a>

</div>


</body>
</html>