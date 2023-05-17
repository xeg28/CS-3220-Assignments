<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Request</title>
</head>
<body>
	<div style="margin-left: 40px;">
	<form action='CreateRequest' method='post'>
	<table border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td>
					Your Name:</td>
				<td>
					<input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>
					Department:</td>
				<td>
					<select name="department" value="" multiple>
						<option value="Computers">Computers</option>
						<option value="Video Games">Video Games</option>
						<option value="Appliances">Appliances </option>
						<option value="Movies">Movies</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					Reason:</td>
				<td>
					<textarea cols="60" name="description" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input name="create" type="submit" value="Create" /></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</body>
</html>