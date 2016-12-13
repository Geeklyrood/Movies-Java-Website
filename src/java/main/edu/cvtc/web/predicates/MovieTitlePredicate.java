/**
 * 
 */
package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author Keenan
 *
 */
public class MovieTitlePredicate implements Predicate<Movie> {

	private String movieTitle;
	
	public MovieTitlePredicate(final String movieTitle) {
		this.movieTitle = movieTitle;
	}
	@Override
	public boolean apply(Movie movie) {
		// TODO Auto-generated method stub
		
		return movie.getMovieTitle().equalsIgnoreCase(movieTitle);
	}
	
}
