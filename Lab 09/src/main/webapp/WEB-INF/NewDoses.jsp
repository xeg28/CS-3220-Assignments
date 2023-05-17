<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>New Doses</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-center">
			<div class="col-sm-5 col-lg-7 py-5">
				<form class="form" action='NewDoses' method='post'>
				<div class="form-group">
					<table class="table">
						<tr>
							<th>Vaccines</th>
							<td>
								<select class="form-select" name='id'>
									<c:forEach items="${vaccines}" var="vaccine">
										<option value="${vaccine.id}">${vaccine.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<th>Doses Received</th>
							<td><input class="form-control" type='text' name='dosesReceived' value=''></td>
						</tr>
												
						<tr>
							<td colspan='2' scope='row'>
								<button class="btn btn-primary" type='submit'>Add</button>
							</td>
						</tr>	
					</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>