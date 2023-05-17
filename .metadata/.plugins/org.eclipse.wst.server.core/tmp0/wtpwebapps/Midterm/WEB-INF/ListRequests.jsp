<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Requests</title>
</head>
<body>
	<div style="margin-left: 40px;">
	<table border="1" cellpadding="2" cellspacing="2">
		<thead>
			<tr>
				<th scope="col">
					Request Time</th>
				<th scope="col">
					Scheduled For</th>
				<th scope="col">
					Department</th>
				<th scope="col">
					Status</th>
				<th scope="col">
					Assigned To</th>
				<th scope="col">
					&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					2022-10-27 11:30 AM</td>
				<td>
					Default Row</td>
				<td>
					Computers</td>
				<td>
					Completed
				</td>
				<td>
					default
				</td>
				<td>
					
				</td>
			</tr>
			<c:forEach items="${requests}" var="request">
			<tr>
				<td><fmt:formatDate value="${request.requestTime}" pattern="yyyy-MM-dd h:mm a"/></td> 
				<td>${request.scheduledFor}</td>
				<td>${request.department}</td>
				<td>${request.status}</td>
				<td>${request.assignedTo}</td>
				<td>
					<c:if test="${(request.status ne 'Completed') && (request.status ne 'Cancelled')}">
					<a href="UpdateStatus?id=${request.id}">Update</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="CreateRequest">Create Service Request</a></p>
</div>

</body>
</html>