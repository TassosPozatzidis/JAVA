

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class connectionURL extends SimpleQueriesSQL{
	public static void main(String[] args) {
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Northwind;username=sa;password=123456;";
		String tableName="Customers";
		String where="",colnames="City";
		String val="'Athens'";
		// Declare the JDBC object.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		SimpleQueriesSQL m = new SimpleQueriesSQL();
		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add("IWER");
		arr.add("Cosco");
		arr.add("Giorgos Parasxos");
		arr.add("Owner");
		arr.add("Falafelas 8");
		arr.add("Athens");
		arr.add("Attica");
		arr.add("15128");
		arr.add("Greece");
		arr.add("");
		arr.add("");
		System.out.print(
	            "ArrayList after all insertions: ");
		display(arr);
		try {
			// 1. Establish the connection.
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connection to SQL has been established.");
			//m.connect(connectionUrl, username, password);
			// 2. Create and execute an SQL statement that returns some data.
			//m.select(connectionUrl,tableName);
			m.select(connectionUrl,tableName);//select * rows
			//m.select( connectionUrl, tableName, where, colnames);//select specific rows and columns
			//m.delete( connectionUrl,tableName, where);//delete
			//m.select( connectionUrl, tableName, where, colnames);
			// 3. Update records to the DB.
			//m.update(connectionUrl, tableName, where, colnames, val);//update
			m.select(connectionUrl,tableName);
			// 3. Insert one record to the DB.
			//m.insert(connectionUrl, tableName,arr); //insert into 
			// 4. Delete records from a table.
			//m.delete( connectionUrl,tableName, where);
			// 5. Insert multiple records to the DB.
//			query = "INSERT INTO Sailors (sid, sname, rating, age) VALUES (?,?,?,?)";
//			BufferedReader csvReader = new BufferedReader(new FileReader("sailors.txt"));
//			String row = "";
//			while ((row = csvReader.readLine()) != null) {
//			    String[] data = row.split(",");
//			    pst = con.prepareStatement(query);
//				pst.setInt(1, Integer.parseInt(data[0].trim()));
//				pst.setString(2, data[1].trim());
//				pst.setInt(3, Integer.parseInt(data[2].trim()));
//				pst.setDouble(4, Double.parseDouble(data[3].trim()));
//				pst.executeUpdate();
//			}
//			csvReader.close();
			// 6.  Insert multiple records to the DB *EFFICIENTLY*
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) try { rs.close(); } catch(Exception e) { System.out.println("Rs closed"); }
			if (stmt != null) try { stmt.close(); } catch(Exception e) { System.out.println("Stmt closed"); }
			if (pst != null) try { pst.close(); } catch(Exception e) { System.out.println("Pst closed"); }
			if (con != null) try { con.close(); } catch(Exception e) { System.out.println("Con closed"); }
		}
	}
	public static void display(ArrayList<Object> arr)
    {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}

