<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
오류가 발생하였습니다.
<br/>
<%
	String type=exception.toString();
	String msg=exception.getMessage();
	out.print("오류유형 : "+type);
	out.print("<br/>메세지 : "+ msg);
%>
</body>
</html>