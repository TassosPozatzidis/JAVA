package model;

public class MovieInfo {
	
	private String title;
	private String description;
	private String rating;
	private String release_date;
	
	public MovieInfo(String title, String description, String rating, String release_date) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getRating() {
		return rating;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	
	public String tostring() {
		return "MovieInfo{"+
				"title='"+ title +"'\n"+
				",description='" + description + "'\n"+
				",rating='" + rating + "'\n"+
				",release_date='" + release_date + "'\n"+
		'}';
		
		
	}
}
