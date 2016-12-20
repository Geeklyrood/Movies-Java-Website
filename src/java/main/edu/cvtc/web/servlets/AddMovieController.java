package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;

/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = null;
		
		try {
			
			final String director = request.getParameter("director");
			final String movieTitle = request.getParameter("movieTitle");
			final int length = Integer.parseInt(request.getParameter("length"));
			final String imdb = request.getParameter("imdb");
			
			final Movie movie = new Movie(director, movieTitle, length, imdb);
			
			final MovieDao movieDao = new MovieDaoImpl();
			movieDao.insertMovie(movie);
			
			request.setAttribute("success", "Success, a new movie was added to the database.");
			target = "success.jsp";
			
		} catch (MovieDatabaseException e) {
			e.printStackTrace();
			
			target = "error.jsp";
			request.setAttribute("error", e.getMessage());
			
		}
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
