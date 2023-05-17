<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Readings</title>
</head>
<body>
	<b>${user.name}'s Readings</b>
	<table border="1" cellpadding="2" cellspacing="2">
		<thead>
			<tr>
				<th>
					Systolic</th>
				<th>
					Diastolic</th>
				<th>
					Time</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<form action = "AddReading" method="post">
				<input type="hidden" name="userId" value="${user.id}">
				<td>
					<input name="systolic" type="text" /></td>
				<td>
					<input name="diastolic" type="text" /></td>
				<td style="text-align: center;">
					<input type="submit" /></td>
				</form>
			</tr>
			<c:forEach items="${readings}" var="reading">
			<tr>
				<td style="text-align: center;">
					<c:choose>
					<c:when test="${reading.systolic < 120}">
					<span style="color: green;">${reading.systolic}</span></td>
					</c:when>
					<c:when test="${reading.systolic > 180}">
					<span style="color: red;">${reading.systolic}</span></td>
					</c:when>
					<c:otherwise>
					<span style="color: orange;">${reading.systolic}</span></td>
					</c:otherwise>
					</c:choose>
				<td style="text-align: center;">
					<c:choose>
					<c:when test="${reading.diastolic < 80}">
					<span style="color: green;">${reading.diastolic}</span></td>
					</c:when>
					<c:when test="${reading.diastolic > 110}">
					<span style="color: red;">${reading.diastolic}</span></td>
					</c:when>
					<c:otherwise>
					<span style="color: orange;">${reading.diastolic}</span></td>
					</c:otherwise>
					</c:choose>
				<td style="text-align: center;">
					<fmt:formatDate value="${reading.readingTime}" pattern="M/d/yyyy h:mm a"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>