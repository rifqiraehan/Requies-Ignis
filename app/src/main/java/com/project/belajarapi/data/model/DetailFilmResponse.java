package com.project.belajarapi.data.model;

import com.google.gson.annotations.SerializedName;

public class DetailFilmResponse{
	@SerializedName("imdbID")
	private String imdbID;

	@SerializedName("Plot")
	private String plot;

	@SerializedName("Title")
	private String title;

	@SerializedName("imdbRating")
	private String imdbRating;

	@SerializedName("Response")
	private String response;

	@SerializedName("Runtime")
	private String runtime;

	@SerializedName("Type")
	private String type;

	@SerializedName("Year")
	private String year;

	@SerializedName("Rated")
	private String rated;

	@SerializedName("Poster")
	private String poster;

	@SerializedName("Genre")
	private String genre;

	public String getPlot(){
		return plot;
	}

	public String getTitle(){
		return title;
	}

	public String getImdbRating(){
		return imdbRating;
	}

	public String getRuntime(){
		return runtime;
	}

	public String getType(){
		return type;
	}

	public String getResponse(){
		return response;
	}

	public String getYear(){
		return year;
	}

	public String getRated(){
		return rated;
	}

	public String getPoster(){
		return poster;
	}

	public String getGenre(){
		return genre;
	}
}
