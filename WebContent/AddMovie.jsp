<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli: Add Movie</title>
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
			<img src="Assets/studioLogo.png"></img>
			<%@ include file="includes/navigation.jsp" %>
			
			<form action="addMovie" method="post">
					<div class="form-group">
						<label for="director"><strong>Director:</strong></label>
						<input name="director">
						
						<label for="movieTitle"><strong>Movie Title:</strong></label>
						<input name="movieTitle">
						
						<label for="length"><strong>Length:</strong></label>
						<input name="length">
						
						<input type="submit" value="Add Movie">
						
					</div>
			</form> 
	</div>
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>