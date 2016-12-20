<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty movies}">
		<p>Sorry the list of movies is empty</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="movie" items="${movies}">
			<div id="page">
						<h2>${movie.movieTitle}</h2>
						<h4>Directed By ${movie.director}</h4>
						<p>${movie.movieTitle} is ${movie.length} minutes long.</p>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>