/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;

/**
 * @author Keenan
 *
 */
public class MovieDaoImpl implements MovieDao {

	private static final String DROP_TABLE_MOVIE = "drop table if exists movie;";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key auto increment,"
			+ "movieTitle text, director text, length integer, imdb text);";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie;";
	
	@Override
	public void populateMovieTable(final String filePath) throws Exception {

		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
	}

	
	@Override
	public List<Movie> retrieveMovies() throws MovieDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
