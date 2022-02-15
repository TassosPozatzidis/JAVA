package model;

import services.NewsAPIService;

public class NewsAPI {
	public static NewsAPIService getNewsAPIService() {
		return new NewsAPIService ("https://newsapi.org/","201a235997424b2197c0dfb6aab86cb2");
	}

	
}
