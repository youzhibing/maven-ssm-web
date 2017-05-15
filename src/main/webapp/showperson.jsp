<%@ page language="java" contentType="text/html; charset=utf-8"
     pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>person list</title>
	</head>
	<body>
		SessionID:<%=session.getId()%><BR>  
		SessionIP:<%=request.getServerName()%>  
		<BR>  
		SessionPort:<%=request.getServerPort()%>  
		<%  
			out.println("This is Tomcat Server 111111！");  
		%>  
			<br />
	    	<c:forEach items="${persons}" var="person">
	    		${person.name }, ${person.age }<br />&nbsp;&nbsp;
	    		${person.homeAddress.country }&nbsp;${person.homeAddress.province }&nbsp;${person.homeAddress.city }&nbsp;
	    		${person.homeAddress.town }&nbsp;${person.homeAddress.village }&nbsp;${person.homeAddress.street }&nbsp;${person.homeAddress.houseNumber }
	    		<br />
	    		<c:forEach items="${person.books}" var="book">
	    			&nbsp;&nbsp;${book.name}, ${book.price }, ${book.publisher }<br />
	    		</c:forEach>
	    	</c:forEach>
	</body>
</html>
