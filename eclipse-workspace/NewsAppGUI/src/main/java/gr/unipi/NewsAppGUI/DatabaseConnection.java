package gr.unipi.NewsAppGUI;

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

public class DatabaseConnection {
	  static final String SQL_CONN_STRING = "jdbc:mariadb://localhost:3306/news_db";
	  static final String USER = "user1";
	  static final String PASS = "pass";
	 static final NewsAPIService newsAPIService = NewsAPI.getNewsAPIService();
	 static final IpAPIService IpAPIService = IpAPI.getIpAPIService();
	
	public static ResultSet readNews() throws SQLException {
	    try (Connection con = DriverManager.getConnection(SQL_CONN_STRING, USER, PASS)) {//������� �������� �� ��� ����
	        try(Statement pstmt = con.createStatement()){
	        try (ResultSet resultSet = pstmt.executeQuery("select * from NEWS_CRITERIA ORDER BY CREATED_AT DESC LIMIT 5")) {//��� queries ��� �������� ����������
//	          List<String> criteriaList = new ArrayList<>();							//���������� ��� ��� ����� ��� �� ������� �� �� ������������
//	          while (resultSet.next()) {											//loop ��� ���� ������ ��� ������
//	            String country = resultSet.getString("COUNTRY");
//	            String category = resultSet.getString("CATEGORY");
//	            String keyword = resultSet.getString("KEYWORD");
//	            String language = resultSet.getString("LANG");
//	            String domains = resultSet.getString("DOMAINS");
//	            String from = resultSet.getString("DATE_FROM");
//	            String to = resultSet.getString("DATE_TO");
//	            String row= (country +"|"+category+"|"+keyword+"|"+language+"|"+domains+"|"+from+"|"+to);
//	            criteriaList.add(row);
//	          }
//	         
//	          System.out.println(criteriaList);
	        	//System.out.println(resultSet);
	        	return   resultSet;
	        
	        }
	        }
	      }
	    }
	
	public static void addNews(String country,String category,String key,String lan,String src,String from,String to) throws SQLException{//add search criteria to a db
	    try (Connection con = DriverManager.getConnection(SQL_CONN_STRING, USER, PASS)) {
	        try(PreparedStatement pstmt = con.prepareStatement("INSERT INTO NEWS_CRITERIA(COUNTRY, CATEGORY , KEYWORD, LANG, DOMAINS, DATE_FROM,DATE_TO)"
	                + " VALUES(?, ?, ?, ?, ?, ?, ?)")){
	          pstmt.setString(1, country);
	          pstmt.setString(2, category);
	          pstmt.setString(3, key);
	          pstmt.setString(4, lan);
	          pstmt.setString(5, src);
	          pstmt.setString(6, from);
	          pstmt.setString(7, to);
	          pstmt.executeUpdate();
	        }
	      }
	    }



}
