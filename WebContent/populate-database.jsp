<!DOCTYPE html>

<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli: Populate Database</title>
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
			<img src="Assets/studioLogo.png"></img>
			<%@ include file="includes/navigation.jsp" %>
			
			<h1>Populate the Database</h1>
			<div id="boxed">
				<%
				try {
					final String filePath = session.getServletContext().getRealPath("/Assets/movies.xlsx");
					
					final MovieDao movieDao = new MovieDaoImpl();
					movieDao.populateMovieTable(filePath);
					
					%>
					<p>Success: Database populated!</p>
					<%
					
				} catch (final Exception e) {
					e.printStackTrace();
					
					%>
					<p>Error: sorry, we are unable to populate the database at this time.</p>
					<%
				}
				%>
			</div>
	</div>
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>