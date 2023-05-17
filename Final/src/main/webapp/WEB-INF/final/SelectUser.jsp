<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select User</title>
</head>
<body>
	<p> <b>Please select a user:</b>
		<br/>
		<form action="ListReadings" method="get">
			<select name="user">
				<option>-Select-</option>
				<c:forEach items="${users}" var="user">
				<option value="${user.id}">${user.name}</option>
				</c:forEach>
			</select>&nbsp;<input type="submit"/>
		</form>
	</p>
</body>
</html>