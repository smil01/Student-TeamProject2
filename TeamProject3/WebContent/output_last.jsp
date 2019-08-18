<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Fullscreen Layout with Page Transitions</title>
		<meta name="description" content="Fullscreen Layout with Page Transitions" />
		<meta name="keywords" content="fullscreen layout, boxes, responsive, page transitions, css transitions, jquery, portfolio, template" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		 <link rel="stylesheet" type="text/css" href="../GW_CSS/Loding.css">
		<script src="js/modernizr.custom.js"></script>
		<script src="https://code.jquery.com/jquery-3.0.0.js"></script>
		
		<fmt:requestEncoding value="UTF-8" />
		<title>Insert title here</title>
		<style type="text/css">
		table {
			width: 100%;
			height: 700px;
			margin-top: 150px;
		}
		
		td{
			height: 30px;
		}
		
		</style>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2c31ce0bfdf6ac450e55f852bdb19a2a&libraries=services,clusterer,drawing"></script>
		<!--  Page Loding Script Start -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
		
  		<script>
		//paste this code under the head tag or in a separate js file.
			// Wait for window load
			$(window).load(function() {
				// Animate loader off screen
				$(".se-pre-con").fadeOut("slow");;
			}); 
		</script>
		<!--  Page Loding Script End -->
		
		<!--  chart code start  -->
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart);

	      function drawChart() {
	        var data = google.visualization.arrayToDataTable([
	          ['Time', '상계동', '월계동'],
	          ['3시',  225, 61],
	          ['4시',  175, 93],
	          ['5시',  257,  343],
	          
	        ]);

	        var options = {
	          title: '시간대별 유동인구수 비교',
	          curveType: 'function',
	          legend: { position: 'bottom' }
	        };

	        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

	        chart.draw(data, options);
	      }
	    
		
		
		</script>
		<!--  chart code end -->
	</head>
	<body>
	<div class="se-pre-con" style="width: 100%; height: 100%"></div>
		<div class="container">	
			<div id="bl-main" class="bl-main">
				<section>
					<div class="bl-box">
						<h2 class="bl-icon bl-icon-about">1.선거유세 지역 추천</h2>
					</div>
					<!-- 선거지역 확인하기 내용 시작-->
					<div class="bl-content" style="scrollbar-face-color: #FFFFFF; scrollbar-shadow-color: #A0A0A0; 
scrollbar-highlight-color: #FFFFFF; scrollbar-3dlight-color: #A0A0A0; 
scrollbar-darkshadow-color: #F6F6F6; scrollbar-track-color: #F6F6F6; 
scrollbar-arrow-color: #A0A0A0;">
							<table style="margin-top: 10px">
								<caption>
									<h2>예측 결과가 출력되었습니다.</h2>
								</caption>
								<tr>
									<td align="center">
										<div id="map" style="width: 1200px; height: 860px;"></div>
									</td>
								</tr>
							</table>
						<h2 style="text-align: center;">이 지도는 다음의 정보를 출력한 내용입니다.</h2>
						<p style="text-align: center;" id="mapdata">상계동,월계동의 3시~5시 사이의 남성 20대 유동인구의 상위 2곳을 출력한 내용입니다.</p>
						<p style="text-align: center;" id="mapdata">하단의 사진은 해당 데이터를 기반으로 출력되는 장소의 실 사진입니다.(시간에 따라 현재의 모습과 달라질수있습니다)</p>
						<p style="text-align: center;">
							<img src="images/Sample_target1.jpg" width="500px;" height="500px;">
							<img src="images/Sample_target2.jpg" width="500px;" height="500px;">
						</p>
					</div>
					<!-- 선거지역 확인하기 내용 끝-->
					<span class="bl-icon bl-icon-close"></span>
				</section>
				<section id="bl-work-section">
					<div class="bl-box">
						<h2 class="bl-icon bl-icon-works">2.지역 상세 분석</h2>
					</div>
					<!-- 지역 분석 상세확인 내용 시작-->
					<div class="bl-content">
						
						<h2 style="text-align: center;">지역 분석 상세표</h2>
						<p style="text-align: center;">지도 클러스터를 기준으로 데이터 해석을 제공합니다.</p>
						 <div id="curve_chart" style="width: 850px;; height: 400px; float: left;	"></div>
						 <div style="float: right;">
						 <p id="outputdata">상계동지역에서 가장 많은 인구분포를 가지고 있습니다.</p>
						 <table class="table1" style="width: 900px; height: auto; margin: 0px; padding: 0px; text-align: center;">
						 	<tr>
						 		<td>순위</td>
						 		<td>지역명</td>
						 		<td>20대 총 예상</td>
						 		
						 	</tr>
						 	<tr>
						 		<td>1</td>
						 		<td>서울 특별시 상계1동 수락현대아파트</td>
						 		<td>시간당 평균 219명</td>
						 		
						 	</tr>
						 	
						 	<tr>
						 		<td>2</td>
						 		<td>서울특별시 상계6.7동 상계동 733번지 승경빌딩</td>
						 		<td>시간당 평균 165명</td>

						 	</tr>
						 	
						 	
						 </table>
						 
						 </div>
						
					</div>
					<!-- 지역 분석 상세확인 내용 끝-->
					<span class="bl-icon bl-icon-close"></span>
				</section>
				<section>
					<div class="bl-box">
						<h2 class="bl-icon bl-icon-blog">3.지역 맞춤형 키워드 추천</h2>
					</div>
					<!-- 워드 클라우드 분석 확인 내용 시작-->
					<div class="bl-content">
						<h2 style="text-align: center;" >해당지역의 워드 클라우드 분석 현황입니다.</h2>
						<p style="text-align: center;" >해당지역의  공공데이터를 기반으로 가장 많은 관심사가 담긴 워드를 출력해줍니다.</p>
						<div style="width: 700px; height: 400px; float: left;">
							<img src="images/wordcloud.png" width="700px;" height="400px">
						</div>
						<div style="float: right;">
							<p style="text-align: center;" >해당지역의 20대에서  20대까지 남성에게 가장 이슈가 되는 단어는<br><strong style="color: red;">자동차</strong>입니다.</p> 
							
							<table class="table1" style="width: 900px; height: auto; margin: 0px; padding: 0px; text-align: center;">
							 	<tr>
							 		<td >순위</td>
							 		<td>단어명</td>
							 		<td>총 빈도수</td>
							 	</tr>
							 	<tr>
							 		<td >1</td>
							 		<td>자동차</td>
							 		<td>357</td>
							 	</tr>
							 	<tr>
							 		<td >2</td>
							 		<td>지구</td>
							 		<td>340</td>
							 	</tr>
							 	<tr>
							 		<td >3</td>
							 		<td>아파트</td>
							 		<td>259</td>
							 	</tr>
							 	<tr>
							 		<td >4</td>
							 		<td>입주</td>
							 		<td>252</td>
							 	</tr>
							 	<tr>
							 		<td >5</td>
							 		<td>주택</td>
							 		<td>79</td>
							 	</tr>
							 	
							 	

							 	
						 	</table>
							
						
						</div>

					</div>
					<!-- 워드 클라우드 분석 확인 내용 끝-->
					<span class="bl-icon bl-icon-close"></span>
				</section>
				<section>
					<div class="bl-box">
						<h2 class="bl-icon bl-icon-contact">4.선거유세 음성톤 분석</h2>
					</div>
					<!-- 4.음성 비교분석하기(미완성) 내용 시작-->
					<div class="bl-content">

<h1 style="text-align: center;" >현 대통령과 회원님의 음성을 비교분석하여 얼마나 유사한지 판별합니다.</h1>
<div style="width: 600px; height: 400px; float: left;	">
<img src="images/mic.png">
</div>
<div style="float: right; margin-top: 150px;">
음성을 녹음하여 해당 사이트에 업로드하여 자신의 목소리가 얼마나 국민들에게 어필될수있는지를 확인해보세요!<br>
대사는 다음과같습니다.<br>
<strong>"존경하고 사랑하는 국민여러분 안녕하십니까, 저는 반드시 약속을 지킬것입니다. 준비된 대통령으로써 대한민국의 위기를 극복하겠습니다."</strong>
<p/>
<audio controls="controls">
  <source src="audio/base.wav" type="audio/wav" />
</audio>		

<% 
int checker =0;
String[] file = null;
if(request.getAttribute("file")!=null){
file = (String[])request.getAttribute("file");
checker=1;
}
%>

<form action="Voice_Running_Servlet" method="post" enctype="multipart/form-data">
<input type="file" name="file" id="file" size="60" class="inputText" accept="audio/*"/><!--  onchange="reviewUploadImg(this);"--> 
<br>
<input type="submit" value="전송" >
</form>
<br>


<% 
if(checker==1){
	

if(file[1].equals("mp3")){ %>
<audio controls autoplay loop>
<source src="upload\<%=file[0] %>" type="audio/mp3" id="mp3" >
</audio>
<%}else if(file[1].equals("ogg")){ %>

<audio controls autoplay loop>
<source src="upload\<%=file[0] %>" type="audio/ogg" id="ogg" >
</audio>
<%} %>
<%} %>
</div>						
					</div>
					<!-- 4.음성 비교분석하기(미완성) 내용 끝-->
					<span class="bl-icon bl-icon-close"></span>
				</section>

			</div>
		</div><!-- /container -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script src="js/boxlayout.js"></script>
		<script>
			$(function() {
				Boxlayout.init();
			});
		</script>
	<script>
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.65763319531902, 127.07144214697134), // 지도의 중심좌표 
        level : 10 // 지도의 확대 레벨 
    });
    
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 1 // 클러스터 할 최소 지도 레벨 
    });
 
    $.get("/map.jsons?day=${param.day}&start_time=${param.start_time}&end_time=${param.end_time}&sex_count=${param.sex_count}&sex_choice=${param.sex_choice}&start_age=${param.start_age}&end_age=${param.end_age}&max=${param.max}&dong=${param.dong}", function(datas) {
        var data = JSON.parse(datas);
        
        var markers = $(data.positions).map(function(i, position) {
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
            });
        });

        clusterer.addMarkers(markers);
    });
</script>
	</body>
</html>
