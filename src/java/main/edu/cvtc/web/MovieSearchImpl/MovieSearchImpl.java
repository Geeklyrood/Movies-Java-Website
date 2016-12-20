package edu.cvtc.web.MovieSearchImpl;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthComparator;
import edu.cvtc.web.comparators.MovieTitleComparator;
import edu.cvtc.web.comparators.Sort;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predicates.DirectorPredicate;
import edu.cvtc.web.predicates.LengthPredicate;
import edu.cvtc.web.predicates.MovieTitlePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * 
 */

/**
 * @author Keenan
 *
 */
public class MovieSearchImpl implements MovieSearch {

	private MovieDao movieDao = new MovieDaoImpl();
	
	@Override
	public List<Movie> retrieveMovies(String sortType) throws MovieSearchException {
		try {
			
			final List<Movie> movies = movieDao.retrieveMovies();
			
			if (null != sortType) {
				sortMovies(movies, sortType);
			}
			
			return movies;
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("The list of movies could not be retrieved from the database");
		}
	}

	private void sortMovies(final List<Movie> movies, final String sortType) {
		switch (sortType) {
			case Sort.DIRECTOR:
				Collections.sort(movies, new DirectorComparator());
				break;
			case Sort.MOVIE_TITLE:
				Collections.sort(movies, new MovieTitleComparator());
				break;
			case Sort.LENGTH:
				Collections.sort(movies, new LengthComparator());
				break;
			default:
				break;
		}
	}
	
	@Override
	public List<Movie> findMoviesByDirector(String director) throws MovieSearchException {
		try {
			
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new DirectorPredicate(director)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by last name.");
		}
	}

	
	@Override
	public List<Movie> findMoviesByMovieTitle(String movieTitle) throws MovieSearchException {
		try {
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new MovieTitlePredicate(movieTitle)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by favorite color.");
		}
	}

	
	@Override
	public List<Movie> findMoviesByLength(int length) throws MovieSearchException {
		try {
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new LengthPredicate(length)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by age.");
		}
	}

}
