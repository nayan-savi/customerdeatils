<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 style="color: blue;">cmd UI language</h2>
		<form action="/cmd-ui-language/generateCode" method="post">
			<div class="form-group">
				<label for="comment">Code:</label>
				<textarea class="form-control" rows="10" name="code" 
				style="color: blue; font-family: Courier New; font-size: 20px; font-weight:bold"></textarea>
				<br /> 
				<input type="Submit" value="Run" class="btn btn-primary btn-lg" />
			</div>
		</form>
	</div>

</body>
</html>
