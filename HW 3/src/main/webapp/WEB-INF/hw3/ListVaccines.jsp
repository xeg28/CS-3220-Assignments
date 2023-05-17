<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>List Vaccines</title>
</head>
<body>
	<div class="container-fluid">		
		<div class="row d-flex justify-content-center mt-3">
			<div class="col-sm-10 col-lg-9">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th class="text-center" scope="col">#</th>
				      <th class="text-center" scope="col">Vaccine</th>
				      <th class="text-center" scope="col">Doses Required</th>
				      <th class="text-center" scope="col">Days Between Doses</th>
				      <th class="text-center" scope="col">Total Doses Received</th>
				      <th class="text-center" scope="col">Total Doses Left</th>
				      <th class="text-center" scope="col">&nbsp;</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${vaccines}" var="vaccine" varStatus="status">
				   <tr>
				      <th class="text-center" scope="row">${status.index + 1}</th>
				      <td class="text-center">${vaccine.name}</td>
				      <td class="text-center">${vaccine.dosesRequired}</td>
				      <c:choose>
				      <c:when test="${vaccine.dosesRequired == 1}">
				      	<td class="text-center">-</td>
				      </c:when>
				      <c:otherwise><td class="text-center">${vaccine.daysBetweenDoses}</td></c:otherwise>
				      </c:choose>
				      <td class="text-center">${vaccine.totalDosesReceived}</td>
				      <td class="text-center">${vaccine.totalDosesLeft}</td>
				      <td class="text-center"><a href='EditVaccine?id=${vaccine.id}'>Edit</a></td>
				    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				<a class="btn btn-primary mt-2 mb-2" href = NewDoses>New Doses</a>
				<a class="btn btn-primary mt-2 mb-2 mx-4" href = NewVaccine>New Vaccine</a>
				<a class="btn btn-primary mt-2 mb-2" href="ManagementChoice">Home</a>
			</div>
		</div>
	</div>
</body>
</html>