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
public class ImbdPredicate  implements Predicate<Movie>{

	private String imbd;
	
	public ImbdPredicate(final String imbd) {
		this.imbd = imbd;
	}
	@Override
	public boolean apply(Movie movie) {
		// TODO Auto-generated method stub
		
		return movie.getIMDB().equalsIgnoreCase(imbd);
		
	}
}
