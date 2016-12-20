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
public class ImdbPredicate  implements Predicate<Movie>{

	private String imdb;
	
	public ImdbPredicate(final String imdb) {
		this.imdb = imdb;
	}
	@Override
	public boolean apply(Movie movie) {
		// TODO Auto-generated method stub
		
		return movie.getIMDB().equalsIgnoreCase(imdb);
		
	}
}
