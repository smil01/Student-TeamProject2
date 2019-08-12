<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.0.0.js"></script>
<fmt:requestEncoding value="UTF-8"/>
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="dto" items="${requestScope.test}">
		${dto}<br>
	</c:forEach>
</body>
</html>