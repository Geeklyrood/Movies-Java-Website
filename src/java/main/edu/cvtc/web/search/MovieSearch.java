package edu.cvtc.web.search;
import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;


/**
 * 
 */

/**
 * @author Keenan
 *
 */
public interface MovieSearch {
	List<Movie> retrieveMovies(String sortType) throws MovieSearchException;
	
	List<Movie> findMoviesByDirector(String director) throws MovieSearchException;
	
	List<Movie> findMoviesByMovieTitle(String movieTitle) throws MovieSearchException;
	
	List<Movie> findMoviesByLength(int length) throws MovieSearchException;
}
