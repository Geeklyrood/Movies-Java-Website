/**
 * 
 */
package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;

/**
 * @author Keenan
 *
 */
public interface MovieDao {

	void populateMovieTable(String filePath) throws Exception;
	
	
	List<Movie> retrieveMovies() throws MovieDatabaseException;


	Integer insertMovie(Movie movie) throws MovieDatabaseException;
}
