<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Movies by Studio Ghibli: View Movies</title>
		<%@ include file="includes/styles.jsp" %>
	</head>
	<body>
	<div class="page">
		<%@ include file="includes/navigation.jsp" %>
		
		<h1>Movie Search</h1>
		
		<jsp:include page="includes/movies-view.jsp"></jsp:include>
		
	</div>
			
			<%@ include file="/includes/footer.jsp" %>
	</body>
</html>