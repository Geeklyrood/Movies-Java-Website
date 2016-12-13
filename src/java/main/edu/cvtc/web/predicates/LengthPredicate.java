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
public class LengthPredicate implements Predicate<Movie> {

	private int length;
	
	public LengthPredicate(final int length) {
		this.length = length;
	}
	@Override
	public boolean apply(Movie movie) {
		// TODO Auto-generated method stub
		
		return movie.getLength().equals(length);
	}
}
