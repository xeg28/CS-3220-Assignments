<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>List Patients</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex justify-content-center mt-3">
			<div class="col-sm-8 col-lg-7">
				<table class="table table-striped">
				  <thead>
				    <tr>
				      <th class="text-center" scope="col">Id</th>
				      <th class="text-center" scope="col">Name</th>
				      <th class="text-center" scope="col">Vaccine</th>
				      <th class="text-center" scope="col">1st Dose</th>
				      <th class="text-center" scope="col">2nd Dose</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${patients}" var="patient" varStatus="status">
				   <tr>
				      <td class="text-center">${patient.id}</td>
				      <td class="text-center">${patient.name}</td>
				      <td class="text-center">${patient.vaccine.name}</td>
				      <td class="text-center"><fmt:formatDate value="${patient.firstDose}" pattern="M/d/yyyy"/></td>
				      <c:choose>
				      <c:when test="${patient.vaccine.dosesRequired == 1}">
				      	<td class="text-center">-</td>
				      </c:when>
				      <c:when test="${empty patient.secondDose && patient.vaccine.totalDosesLeft < 1}">
				      	<td class="text-center">Out of Stock</td>
				      </c:when>
				      <c:when test="${empty patient.secondDose}">
				      	<td class="text-center"><a class="btn btn-primary" href="ReceiveSecondDose?id=${patient.id}">Received</a></td>
				      </c:when>
				      <c:otherwise>
				      <td class="text-center"><fmt:formatDate value="${patient.secondDose}" pattern="M/d/yyyy"/></td>
				      </c:otherwise>
				      </c:choose>
				    </tr>
				  </c:forEach>
				  </tbody>
				</table>
				<a class="btn btn-primary mt-2 mb-2" href = NewPatient>New Patient</a>
				<a class="btn btn-primary mt-2 mb-2 mx-4" href="ManagementChoice">Home</a>
			</div>
		</div>
	</div>
</body>
</html>