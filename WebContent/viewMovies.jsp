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
		
		<% 
			
			try {
				
				List<Movie> movies = new ArrayList<>();
				final String filePath = session.getServletContext().getRealPath("/Assets/movies.xlsx");
				final File inputFile = new File(filePath);
				movies = WorkbookUtility.retrievePeopleFromWorkbook(inputFile);
				
			
				final String sortType = request.getParameter("sort");
				
				if (sortType != null) {
					
					switch (sortType) {
					
						case Sort.DIRECTOR:
							%> <h1>Movies by Director</h1>
							<%
							Collections.sort(movies, new DirectorComparator());
							break;
							
						case Sort.LENGTH:
							%> <h1>Movies by Length</h1>
							<%
							Collections.sort(movies, new LengthComparator());
							break;
							
						case Sort.MOVIE_TITLE:
							%> <h1>Movies by Title</h1>
							<%
							Collections.sort(movies, new MovieTitleComparator());
							break;
							
						default:
							%> <h1>Unsorted</h1>
							<%
							break;
					}
				}
				
			
				for (final Movie movie : movies) {
					
					%>
					
					<div id="lined">
						<h2><%=movie.getMovieTitle() %></h2>
						<h4>Directed  By <%=movie.getDirector() %></h4>
						<p><%=movie.getMovieTitle() %> is <%=movie.getLength() %> minutes long. You can find more information about the movie as well as trailers here 
						<a href="<%=movie.getIMDB() %>"><%=movie.getIMDB() %></a>.</p>
					</div>
					<%
				}
				
			} catch (final Exception waffle) {
				waffle.printStackTrace();
				%>
				<div id="lined">
					<h1>Error</h1>
					<p>Sorry, we are unable to retrieve the list of people</p>
				</div>
				<%
			}
			%>
			</div>
			
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>