<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.0.0.js"></script>
<fmt:requestEncoding value="UTF-8" />
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
	height: 700px;
	margin-top: 150px;
}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2c31ce0bfdf6ac450e55f852bdb19a2a&libraries=services,clusterer,drawing"></script>
</head>
<body>
	<table>
		<caption>
			<h2>예측 결과</h2>
		</caption>
		<tr>
			<td align="center" width="100%">
				<div id="map" style="width: 100%; height: 100%;"></div>
			</td>
		</tr>
	</table>



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