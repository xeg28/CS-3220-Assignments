<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lab 8 - Questions</title>
</head>
<body>
	<p> ${questions[index].description}<br>
		1. ${questions[index].answerA}<br>
		2. ${questions[index].answerB}<br>
		3. ${questions[index].answerC}<br>
		Correct answer: ${questions[index].correctAnswer}
	</p>
		
	<a href="DrivingTestBrowser">Next</a>
</body>
</html>