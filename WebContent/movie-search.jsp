<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli</title>
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
			<%@ include file="includes/navigation.jsp" %>
			
			<h1>Welcome!</h1>
			<div id="boxed">
				<div class="container">
				<form action="Search" method="post">
						<label for="movieTitle"><strong>Search by Movie Title:</strong></label>
						<input name="movieTitle">
						<input name="searchType" type="hidden" value="movieTitle">
						<input type="submit" value="Search!">
				</form>
			</div>
			<div class="container">
				<form action="Search" method="post">
						<label for="director"><strong>Search by Director:</strong></label>
						<input name="director">
						<input name="searchType" type="hidden" value="director">
						<input type="submit" value="Search!">
				</form>
			</div>
			</div>
	</div>
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>