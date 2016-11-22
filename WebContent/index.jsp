<!DOCTYPE html>
<%@page import="edu.cvtc.web.comparators.DirectorComparator"%>
<%@page import="edu.cvtc.web.comparators.MovieTitleComparator"%>
<%@page import="edu.cvtc.web.comparators.LengthComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="edu.cvtc.web.comparators.Sort"%>
<%@page import="java.io.File"%>
<%@page import="edu.cvtc.web.util.WorkbookUtility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.cvtc.web.model.Movie"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli</title>
		<meta name="description" content="This is a JSP example that demonstrantes how to build a dynamic website using JSPs">
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
			<img src="Assets/studioLogo.png"></img>
			<%@ include file="includes/navigation.jsp" %>
			
			<h1>Welcome!</h1>
			<div id="boxed">
				This website is devoted to Studio Ghibli and its many movies. Here you can sort through them based on a variety of stipulations, access the 
				IMDB page for the movie and much more to come. Click on a sort stipulation in order to start!
			</div>
	</div>
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>