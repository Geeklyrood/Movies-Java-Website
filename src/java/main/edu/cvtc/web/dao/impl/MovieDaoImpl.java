/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

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
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
			final File inputFile = new File(filePath);
			final List<Movie> people = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			for (final Movie Movie : people) {
				String insertValues = "insert into Movie (director, legnth, movieTitle) values ('"
									+ Movie.getDirector() + "', '" + Movie.getLength() + "', " + Movie.getMovieTitle()
									+ "', " + Movie.getIMDB() + "')";
				
				System.out.println(insertValues);
				
				statement.executeUpdate(insertValues);
			}
			
			statement.executeUpdate(SELECT_ALL_FROM_MOVIE);
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
	}

	
	@Override
	public List<Movie> retrieveMovies() throws MovieDatabaseException {
		
		final List<Movie> people = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (results.next()) {
				final String director = results.getString("director");
				final String movieTitle = results.getString("movieTitle");
				final int length = results.getInt("length");
				final String imbd = results.getString("imbd");
				
				final Movie Movie = new Movie(director, movieTitle, length, imbd);
				
				people.add(Movie);
			}
			
			results.close();
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieDatabaseException("Error retrieving people from the Database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return people;
	}


	public Integer insertMovie(final Movie movie) throws MovieDatabaseException {

		Connection connection = null; // Connection connection; does the same thing
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtility.createConnection();
			final String insertSQL = "insert into Movie (firstName, lastName, age, favoriteColor) values (?, ?, ?, ?);";
			
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, movie.getDirector());
			preparedStatement.setString(2, movie.getMovieTitle());
			preparedStatement.setInt(3, movie.getLength());
			
			preparedStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			return preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieDatabaseException("Error adding this Movie to the database.");
		} finally {
			DBUtility.closeConnections(connection, preparedStatement);
		}
		
	}

}
