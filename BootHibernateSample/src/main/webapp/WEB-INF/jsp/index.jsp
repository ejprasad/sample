<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Employee Phone Numbers</title>
</head>
<body>

<c:if test="${not empty lists}">
 
		<ul>
			<c:forEach var="listValue" items="${lists}">
				
				<c:forEach var="phone" items="${listValue.phones}">
					<li>
						Phone Number: ${phone.contact}
					</li>
				</c:forEach>
				
			</c:forEach>
		</ul>
 
	</c:if>

</body>
</html>