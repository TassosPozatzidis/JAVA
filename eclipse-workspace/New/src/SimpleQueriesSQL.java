
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleQueriesSQL {

	public static void main(String[] args) throws SQLException {
		SimpleQueriesSQL m = new SimpleQueriesSQL();
		String sql = "";
		String connectionUrl = "";
		String uname = "";
		String password = "";
		String tableName = "";
		String where="",colnames="",val="";
		ArrayList<Object> dt=new ArrayList<Object>();
		m.connect(connectionUrl, uname, password);
		m.insert(sql,tableName,dt);
		m.select(connectionUrl,tableName);
		m.select(connectionUrl,tableName,where,colnames);
		m.update(connectionUrl, tableName, where, colnames, val);
		m.delete(connectionUrl,tableName,where);

	}
	
	Connection con;
	public void connect(String connectionUrl, String uname, String password)  {
		
			try {
				con = DriverManager.getConnection(connectionUrl,uname, password);
				System.out.println("Connection to SQL has been established.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	public void select(String connectionUrl,String tableName) {//select for all rows
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQL has been established.");
			String SQL = "SELECT * FROM "+tableName;
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(" | ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue);
			    }
				System.out.println("");

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void select(String connectionUrl,String tablename, String where, String colnames) {//select with where clause-- displays specific results
		Statement stmt = null;
		ResultSet rs = null;
		String SQL=null;
		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQL has been established.");
			if (!where.equals("")){
				SQL = "SELECT "+colnames+" FROM "+tablename +" WHERE "+where;
				System.out.println(SQL);
				
			}
			else {
				SQL = "SELECT "+colnames+" FROM "+tablename;
				System.out.println(SQL);
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) System.out.print(" | ");
			        String columnValue = rs.getString(i);
			        System.out.print(columnValue);
			    }
				System.out.println("");

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(String connectionUrl,String tablename, String where, String colnames,String val)  {//update table --
		Statement stmt = null;

		String SQL=null;
		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQL has been established.");
			if (!where.equals("")){
				SQL = "UPDATE "+tablename+" SET "+colnames+" = "+ val+" WHERE "+where;
				System.out.println(SQL);
				
			}
			else {
				 Scanner myObj = new Scanner(System.in);
				System.out.println("No where clause--every row will be updated with the same value!!Are you sure[y/n]?");
				String input = myObj.nextLine();
				if(input.equals("y")) {
					SQL = "UPDATE "+tablename+" SET "+colnames+" = "+ val ;
					myObj.close();
				}
				else {
					System.out.println("No actions occured");
					myObj.close();
					return;
				}
			}
			stmt = con.createStatement();
			stmt.execute(SQL);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String connectionUrl,String tablename, String where) {
		Statement stmt = null;

		String SQL=null;
		try {
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQL has been established.");
			if (!where.equals("")){
				SQL = "DELETE FROM "+tablename+" WHERE "+where;
				System.out.println("Delete action applied :"+SQL);
				
			}
			else {
				Scanner myObj = new Scanner(System.in);
				System.out.println("No where clause--every row will be deleted !!Are you sure[y/n]?");
				String input = myObj.nextLine();
				if(input.equals("y")) {
						SQL = "DELETE FROM "+tablename;
						System.out.println("Delete action applied :"+SQL);
						myObj.close();
				}
				else {
					System.out.println("No actions occured");
					myObj.close();
					return;
				}
			}
			stmt = con.createStatement();
			stmt.execute(SQL);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<String> getColumns(String connectionUrl,String tableName, Connection conn) throws  SQLException{//getColumns for insert method

	    ResultSet rs=null;

	    ResultSetMetaData rsmd=null;
	    PreparedStatement stmt=null;
	    List<String> columnNames =null;
	    //String qualifiedName = (schemaName!=null&&!schemaName.isEmpty())?(schemaName+"."+tableName):tableName;
	    try{
//	    	Connection conn = DriverManager.getConnection(connectionUrl);
	        stmt=conn.prepareStatement("select * from "+tableName+" where 0=1");
	        rs=stmt.executeQuery();//you'll get an empty ResultSet but you'll still get the metadata
	        rsmd=rs.getMetaData();
	        columnNames = new ArrayList<String>(); 
	        for(int i=1;i<=rsmd.getColumnCount();i++)
	            columnNames.add(rsmd.getColumnLabel(i));    
	    }catch(SQLException e){
	        throw e;//or log it
	    }
	    finally{
	        if(rs!=null)
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                throw e;
	            }
	        if(stmt!=null)
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                throw e;
	            }
	    }
	    return columnNames;
	}

	
	public void insert(String connectionUrl,String tablename,List<Object> data) {//insert into statement
		PreparedStatement pst = null;
		String insertColumns = ""; 
	    String insertValues = "";
		try {
		con = DriverManager.getConnection(connectionUrl);
		System.out.println("Connection to SQL has been established.");
		List<String> columnNames = getColumns(connectionUrl,tablename,con);
        if(columnNames != null && columnNames.size() > 0){
            insertColumns += columnNames.get(0);
            insertValues += "?";
        }

        for(int i = 1; i < columnNames.size();i++){
          insertColumns += ", " + columnNames.get(i) ;
          insertValues += ",?";
        }
        System.out.println(columnNames);
        String query = "INSERT INTO "+tablename+" (" + insertColumns + ") values(" + insertValues + ")"; 
        System.out.println(query);
       try {
         pst = con.prepareStatement(query);	
         int currentPosition=0;
         for(Object o : data){
        	 currentPosition++;
        	 System.out.println(o);
             pst.setObject(currentPosition,o); //you must pass objects of correct type
            }
	    pst.execute();
		}catch(SQLException sqle){
	      }
		pst.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}