<%@page import="main.member.DTO.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보좌관들</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link rel="stylesheet" href="./GW_CSS/style.css">
<link rel="stylesheet" href="./GW_CSS/logo.css">

<style>
.sr-only {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}
</style>

<script src="https://use.fontawesome.com/926fe18a63.js"></script>

<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(function(){
	$(".headC").click(function(){
		$(".headB").slideToggle();
	});
});
</script>
<%
	memberDTO login = (memberDTO)request.getSession().getAttribute("login");
%>
</head>
<body>

<header>
<div class="container">
	<div class="container-small">
		<a href="Main_Gw.html" class="headA">LOGGER</a>

		<button type="button" class="headC">
			<span class="fa fa-bars" title="MENU"></span>
		</button>
	</div>

	<nav class="headB">
		<ul>
			<li><a href="Main_Gw.html">TOP</a></li>
			<li><a href="about.html">ABOUT</a></li>
			<%if(login==null){ %>
			<li><a href="login.do">로그인</a></li>
			<%} else {%>
			<li><a href="search.do?id=<%=login.getId()%>&pw=<%=login.getPw()%>">분석보러가기</a></li>
			<%}%>
		</ul>
	</nav>
</div>
</header>


<section class="conA">

<div class="container" style="float: left;">
	<div class="sign" style="margin-left: 70px; margin-top: 200px;">
	<span class="sign__word">당신의</span>
	<span class="sign__word">선거를</span>
	<span class="sign__word">책임집니다.</span>
	<span class="sign__word"> 당.선.책</span>
	
	</div>	


	
</div>
</section>


<section class="conB">
<div class="container">
	<div class="text">
		<span class="fa fa-bar-chart icon"></span>
		<h2>당선책 이란?</h2>
		<p>유동인구 및 공공민원 빅데이터를 활용하여 선거활동에 도움을 주는 플랫폼입니다. 

	</div>

	<div class="text">
		<span class="fa fa-gears icon"></span>
		<h2>무엇을 할수있나요?</h2>
		<p>연령,시간,지역을 선택하면 해당 지역의 선거활동 추천지역 및 추천 키워드를 사용자에게 제공합니다.</p>
		
	</div>

	<div class="text">
		<span class="fa fa-rocket icon"></span>
		<h2>간편한 사용성</h2>
		<p>간단한 회원가입 이후 해당 기능을 무료로 사용할수있습니다!</p>
		</a>
	</div>
</div>
</section>



<section class="conC">
<div class="container">
	<div class="photo"></div>
	<div class="text">
		<h2>더이상 귀찮은 조사와 데이터 관리를 하지 않아도 됩니다</h2>
		<p>언제든지 사이트에 접속하세요! 버튼 하나만 누르면 됩니다.</p>
		<!-- 로그인이 안되어있다면 로그인으로, 아니면 바로 컨텐츠 사이트로 -->
		<%if(login==null){ %>
			<a href="login.do">우리 지역 선거 키워드 확인하러가기!
			<span class="fa fa-chevron-right"></span>
			</a>
		<%} else {%>
			<a href="search.do?id=<%=login.getId()%>&pw=<%=login.getPw()%>">우리 지역 선거 키워드 확인하러가기!
			<span class="fa fa-chevron-right"></span>
			</a>
		<%}%>
		

	</div>
</div>
</section>


<section class="conD">
<div class="container">
	<div class="photo"></div>
	<div class="text">
		<h2>당선책 개발진</h2>
		<p>그때그때 일상을 기록하는 당선책!, 나중에 과거의 일상을 보면 그때는 알지 못했던 다양한 즐거움이 보일 것입니다.</p>
		<a href="./OUTPUT/output_GW.html">개발진 보러가기!
		<span class="fa fa-chevron-right"></span>
		</a>
	</div>
</div>
</section>


<footer>
<div class="container">

	<div class="footA">
		<h2>보좌관들</h2>
		<p>
		주소: (61740) 광주광역시 남구 송암로60 광주CGI센터 203호 (송하동)<br>
		<a href="https://www.smhrd.or.kr/">https://www.smhrd.or.kr/</a>
		</p>

		<nav class="footD">
			<ul>
				<li><a href="#">
					<span class="fa fa-twitter"
					 title="Twitter"></span>
				</a></li>

				<li><a href="#">
					<span class="fa fa-facebook"
					 title="Facebook"></span>
				</a></li>

				<li><a href="#">
					<span class="fa fa-google-plus"
					 title="Google Plus"></span>
				</a></li>

				<li><a href="#">
					<span class="fa fa-instagram"
					 title="Instagram"></span>
				</a></li>

				<li><a href="#">
					<span class="fa fa-youtube"
					 title="YouTube"></span>
				</a></li>
			</ul>
		</nav>
	</div>

	<nav class="footB">
		<div>
			<h3>ABOUT</h3>
			<ul>
				<li><a href="#">설립</a></li>
				<li><a href="#">주소</a></li>
				<li><a href="#">지도</a></li>
				<li><a href="#">스태프</a></li>
			</ul>
		</div>

		<div>
			<h3>SUPPORT</h3>
			<ul>
				<li><a href="#">다운로드</a></li>
				<li><a href="#">매뉴얼</a></li>
				<li><a href="#">자주 묻는 질문</a></li>
				<li><a href="#">문의</a></li>
			</ul>
		</div>

		<div>
			<h3>CONTENTS</h3>
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">비즈니스</a></li>
				<li><a href="#">프로필</a></li>
				<li><a href="#">개발자</a></li>
				<li><a href="#">블로그</a></li>
			</ul>
		</div>
	</nav>

	<div class="footC">
		© LOGGER corp. All rights reserved.
	</div>

</div>
</footer>


</body>
</html>