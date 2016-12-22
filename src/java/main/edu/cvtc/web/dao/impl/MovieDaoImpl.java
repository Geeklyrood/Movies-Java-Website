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
	private static final String CREATE_TABLE_MOVIE = "create table movie (id integer primary key autoincrement,"
			+ " movieTitle text, director text, length integer, imdb text);";
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
			
			for (final Movie movie : people) {
				String insertValues = "insert into movie (movieTitle, director, length, imdb) values (\""
									+ movie.getMovieTitle() + "\", \"" + movie.getDirector() + "\", " + movie.getLength()
									+ ", \"" + movie.getIMDB() + "\");";
				
				System.out.println(insertValues);
				
				statement.executeUpdate(insertValues);
			}
			
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
				final String imdb = results.getString("imdb");
				
				final Movie movie = new Movie(movieTitle, director, length, imdb);
				
				people.add(movie);
			}
			
			results.close();
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieDatabaseException("Error retrieving movies from the Database.");
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
			final String insertSQL = "insert into Movie (movieTitle, director, length, imdb) values (?, ?, ?, ?);";
			
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, movie.getMovieTitle());
			preparedStatement.setString(2, movie.getDirector());
			preparedStatement.setInt(3, movie.getLength());
			preparedStatement.setString(4, movie.getIMDB());
			
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
