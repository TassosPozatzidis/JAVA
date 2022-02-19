package model;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.Before;
import org.junit.Test;

import exception.NewsAPIException;
import gr.unipi.newssqlapp.Application;

public class NewsDBServiceTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testReadNews() throws SQLException {
//		System.out.println(Application.readNews());
//	}
//	@Test
//	 public void testAddMovie() throws SQLException {
//		    Application.addNews(
//		        new NewsInfo("ΠΑΟΚ-ΠΑΟ 2-1", "Ο ΠαναθηναΪκός παρότι προηγήθηκε στο σκόρ από νωρίς , έχασε τελικά απο τον ανώτερο ΠΑΟΚ","2022-06-22", "https://www.sport24.gr/football/paok-panathinaikos-2-1-to-efere-toympa-me-gkolara-toy-sastre.9521079.html",  "https://www.sport24.gr/img/3574/9521180/258000/we1200/1200/sastre.jpg", "Σπορτ24"));
//		    System.out.println(Application.readNews());
//		  }
//	@Test
//	 public void testUpdateMovie() throws SQLException {
//		    Application.updateNews(
//		        new NewsInfo("ΠΑΟΚ-ΠΑΟ 2-1", "Ο ΠαναθηναΪκός παρότι προηγήθηκε στο σκόρ από νωρίς , έχασε τελικά απο τον ανώτερο ΠΑΟΚ","2022-06-22", "https://www.sport24.gr/football/paok-panathinaikos-2-1-to-efere-toympa-me-gkolara-toy-sastre.9521079.html",  "https://www.sport24.gr/img/3574/9521180/258000/we1200/1200/sastre.jpg", "Σπορτ24"));
//		    System.out.println(Application.readNews());
//		  }
//	@Test
//	 public void testDeleteMovie() throws SQLException {
//		    Application.deleteNews("ΠΑΟΚ-ΠΑΟ 2-1");
//		    System.out.println(Application.readNews());
//		  }
//	@Test
//		  public void testAddMoviesFromAPI_Search() throws NewsAPIException, SQLException {
//			  Application.getNewsFromNewsAPISearch("123","","bbc.co.uk","2022-01-12","2022-02-02");
//		    System.out.println(Application.readNews());
//		  }
	@Test
		  public void testAddMoviesFromAPI_Discover() throws NewsAPIException, SQLException {
			  Application.getNewsFormNewsAPIDiscover("de");
		      System.out.println(Application.readNews());

		  }

}
