package gr.unipi.newssqlapp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.NewsAPIException;

import java.sql.*;

import model.IpAPI;
import model.NewsAPI;
import model.NewsInfo;
import services.NewsAPIService;
import services.IpAPIService;

public class Application {
	  static final String SQL_CONN_STRING = "jdbc:mariadb://localhost:3306/news_db";
	  static final String USER = "user1";
	  static final String PASS = "pass";
	 static final NewsAPIService newsAPIService = NewsAPI.getNewsAPIService();
	 static final IpAPIService IpAPIService = IpAPI.getIpAPIService();
	
	public static List<NewsInfo> readNews() throws SQLException {
	    try (Connection con = DriverManager.getConnection(SQL_CONN_STRING, USER, PASS)) {//άνοιγμα σύνδεσης με την βάση
	        try(Statement pstmt = con.createStatement()){
	        try (ResultSet resultSet = pstmt.executeQuery("SELECT * FROM news")) {//για queries που πέρνουμε αποτέλεσμα
	          List<NewsInfo> newsInfos = new ArrayList<>();							//φτιάχνουμε μια νέα Λίστα για να γεμίσει με τα αποτελέσματα
	          while (resultSet.next()) {											//loop για κάθε γραμμή του πίνακα
	            String title = resultSet.getString("NEWS_TITLE");
	            String description = resultSet.getString("NEWS_DESCRIPTION");
	            String url = resultSet.getString("NEWS_URL");
	            String upload_date = resultSet.getString("NEWs_DATE");
	            String urlToImage = resultSet.getString("NEWS_IMG_URL");
	            String author = resultSet.getString("NEWS_AUTHOR");
	            newsInfos.add(new NewsInfo(title, description, url, upload_date,urlToImage,author));
	          }
	          return newsInfos;
	        }
	        }
	      }
	    }
	
	public static void deleteNews(String name) throws SQLException {
	    try (Connection con = DriverManager
	            .getConnection(SQL_CONN_STRING, USER, PASS)) {
	      try(PreparedStatement pstmt = con
	              .prepareStatement("DELETE FROM news WHERE NEWS_TITLE=?")){
	        pstmt.setString(1, name);
	        pstmt.executeUpdate();
	      }
	    }
	  }
	
	public static void updateNews(NewsInfo newsInfo) throws SQLException{
	    try (Connection con = DriverManager.getConnection(SQL_CONN_STRING, USER, PASS)) {
	        try(PreparedStatement pstmt = con.prepareStatement("UPDATE news SET NEWS_DESCRIPTION=?, NEWS_URL=?,NEWs_DATE=?,NEWS_IMG_URL=?,NEWS_AUTHOR=? WHERE NEWS_TITLE=?")){
	          pstmt.setString(6, newsInfo.getTitle());
	          pstmt.setString(1, newsInfo.getDescription());
	          pstmt.setString(2, newsInfo.getUrl());
	          pstmt.setString(3, newsInfo.getUpload_date());
	          pstmt.setString(4, newsInfo.getUrlToImage());
	          pstmt.setString(5, newsInfo.getAuthor());
	          pstmt.executeUpdate();
	        }
	      }
	    }
	public static void addNews(NewsInfo newsInfo) throws SQLException{
	    try (Connection con = DriverManager.getConnection(SQL_CONN_STRING, USER, PASS)) {
	        try(PreparedStatement pstmt = con.prepareStatement("INSERT INTO news(NEWS_TITLE, NEWS_DESCRIPTION, NEWS_URL, NEWs_DATE, NEWS_IMG_URL, NEWS_AUTHOR)"
	                + " VALUES(?, ?, ?, ?, ?, ?)")){
	          pstmt.setString(1, newsInfo.getTitle());
	          pstmt.setString(2, newsInfo.getDescription());
	          pstmt.setString(3, newsInfo.getUrl());
	          pstmt.setString(4, newsInfo.getUpload_date());
	          pstmt.setString(5, newsInfo.getUrlToImage());
	          pstmt.setString(6, newsInfo.getAuthor());
	          pstmt.executeUpdate();
	        }
	      }
	    }
	public static void getNewsFromNewsAPISearch( String parameter, String parameter2,String parameter3,String parameter4,String parameter5)throws SQLException, NewsAPIException {
	    List<NewsInfo> newsInfos = newsAPIService.searchAllCriteria( parameter,  parameter2,parameter3, parameter4, parameter5);
	    for (NewsInfo newsinfo : newsInfos) {
	    	addNews(newsinfo);
	    }
	  }
	public static void getNewsFormNewsAPIDiscover(String country) throws SQLException, NewsAPIException {
		List<NewsInfo> newsInfos = null;
		if(country==null || country.equals("")) {
			 newsInfos = newsAPIService.getTopHeadlinesInaCountryByCategory(IpAPIService.findCountry(null),"");
		}else
		{
			 newsInfos = newsAPIService.getTopHeadlinesInaCountryByCategory(country,"");
		}
	    for (NewsInfo newsinfo : newsInfos) {
	    	addNews(newsinfo);
	    }
	    
	  }


}
