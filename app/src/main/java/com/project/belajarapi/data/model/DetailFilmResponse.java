package com.project.belajarapi.data.model;

import com.google.gson.annotations.SerializedName;

public class DetailFilmResponse{
	@SerializedName("Released")
	private String released;

	@SerializedName("imdbID")
	private String imdbID;

	@SerializedName("Plot")
	private String plot;

	@SerializedName("Director")
	private String director;

	@SerializedName("Title")
	private String title;

	@SerializedName("Actors")
	private String actors;

	@SerializedName("imdbRating")
	private String imdbRating;

	@SerializedName("imdbVotes")
	private String imdbVotes;

	@SerializedName("Response")
	private String response;

	@SerializedName("Runtime")
	private String runtime;

	@SerializedName("Type")
	private String type;

	@SerializedName("Year")
	private String year;

	@SerializedName("Language")
	private String language;

	@SerializedName("Rated")
	private String rated;

	@SerializedName("Poster")
	private String poster;

	@SerializedName("Country")
	private String country;

	@SerializedName("Genre")
	private String genre;

	@SerializedName("Writer")
	private String writer;


	public void setReleased(String released){
		this.released = released;
	}

	public String getReleased(){
		return released;
	}

	public void setImdbID(String imdbID){
		this.imdbID = imdbID;
	}

	public String getImdbID(){
		return imdbID;
	}

	public void setPlot(String plot){
		this.plot = plot;
	}

	public String getPlot(){
		return plot;
	}

	public void setDirector(String director){
		this.director = director;
	}

	public String getDirector(){
		return director;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setActors(String actors){
		this.actors = actors;
	}

	public String getActors(){
		return actors;
	}

	public void setImdbRating(String imdbRating){
		this.imdbRating = imdbRating;
	}

	public String getImdbRating(){
		return imdbRating;
	}

	public void setImdbVotes(String imdbVotes){
		this.imdbVotes = imdbVotes;
	}

	public String getImdbVotes(){
		return imdbVotes;
	}

	public void setResponse(String response){
		this.response = response;
	}

	public String getResponse(){
		return response;
	}

	public void setRuntime(String runtime){
		this.runtime = runtime;
	}

	public String getRuntime(){
		return runtime;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setRated(String rated){
		this.rated = rated;
	}

	public String getRated(){
		return rated;
	}

	public void setPoster(String poster){
		this.poster = poster;
	}

	public String getPoster(){
		return poster;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setGenre(String genre){
		this.genre = genre;
	}

	public String getGenre(){
		return genre;
	}

	public void setWriter(String writer){
		this.writer = writer;
	}

	public String getWriter(){
		return writer;
	}
}
