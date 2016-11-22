package edu.cvtc.web.model;

public class Movie {
	
	private String movieTitle;
	private String director;
	private Integer length;
	private String imdb;
	
	public Movie(final String movieTitle, final String director, final int length, final String imdb) {
		this.movieTitle = movieTitle;
		this.director = director;
		this.length = length;
		this.imdb = imdb;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getDirector() {
		return director;
	}

	public Integer getLength() {
		return length;
	}
	
	public String getIMDB() {
		return imdb;
	}
	
	@Override
	public String toString() {
		return "Movie [movie=" + movieTitle + ", director=" + director + ", length=" + length  + "]";
	}
	
}
