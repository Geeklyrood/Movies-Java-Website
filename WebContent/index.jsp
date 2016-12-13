<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli</title>
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
			<img src="Assets/studioLogo.png"></img>
			<%@ include file="includes/navigation.jsp" %>
			
			<h1>Welcome!</h1>
			<div id="boxed">
				<p>This website is devoted to Studio Ghibli and its many movies. Here you can sort through them based on a variety of stipulations, access the 
				IMDB page for the movie and much more to come. Click on a sort stipulation in order to start!</p>
				<p>Click <a href="populate-database.jsp">here</a> to re-populate the database.</p>
			</div>
	</div>
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>