<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Status</title>
</head>
<body>
	<div style="margin-left: 40px;">
		<form action="UpdateStatus" method="post">
		<table border="0" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td>
						<p><strong>${request.department} Service requested by ${request.scheduledFor} at <fmt:formatDate value="${request.requestTime}" pattern="yyyy-MM-dd h:m a" /></strong></p>
						<c:choose>
							<c:when test="${request.status eq 'Assigned'}">
								<p><strong>Status</strong>: ${request.status} to ${request.assignedTo}</p>
								<p><strong>Reason</strong>:</p>
								<p>${request.reason}</p>
								<p><strong>Change status to Completed?</strong>
									<a href="UpdateStatus?status=Completed&id=${request.id}">Yes</a>
									<a href="ListRequests">No</a>
									<a href="UpdateStatus?status=Cancelled&id=${request.id}">Cancelled</a>
								</p>
							</c:when>
							<c:otherwise>
								<p><strong>Status</strong>: ${request.status}</p>
								<p><strong>Reason</strong>:</p>
								<p>${request.reason}</p>
								<p><strong>Assign this request to</strong> <select name="technician"><option value="Amy">Amy</option><option value="Bob">Bob</option><option value="Tom">Tom</option></select> <input name="ok" type="submit" value="OK" /></p>
							</c:otherwise>
						</c:choose>
						
						<input type="hidden" name="id" value="${request.id}">
						
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>