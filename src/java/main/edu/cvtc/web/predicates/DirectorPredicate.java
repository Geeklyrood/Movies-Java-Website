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
public class DirectorPredicate implements Predicate<Movie> {

	private String director;
	
	public DirectorPredicate(final String director) {
		this.director = director;
	}
	@Override
	public boolean apply(Movie movie) {
		// TODO Auto-generated method stub
		
		return movie.getDirector().equalsIgnoreCase(director);
	}
	
}
