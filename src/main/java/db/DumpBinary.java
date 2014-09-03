package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DumpBinary {

	private String sqlString="select * from AWS_FINAL_DOCUMENT_CONTENT_BIN";
	private String folder="c:/temp/dump/";
	/**
	 * 
	 */
	public void dumpBinary()
	{
		Connection connection =getConnectionOracle();
		try {
		Statement st = connection.createStatement();
		ResultSet res = st.executeQuery(sqlString);
//        int i=0;
		while (res.next()) {

			int id = res.getInt(1);
			byte[] contents = res.getBytes(3);
            System.out.println(id);  	
            writeBinary(id, contents);
		}// while
		close(res);
		close(st);
	}// try
	catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	
	private void writeBinary(int id, byte[] contents)
	{
		OutputStream out=null;
		File file = new File(folder + id + ".pdf");
		try {
			out= new FileOutputStream(file);
			out.write(contents);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://aig-mssql2008:1433;DatabaseName=prod",
					"aws", // username
					"aws"); // password

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public Connection getConnectionOracle() {
	  Connection connection = null;
	  
	  try {
	    Class.forName("oracle.jdbc.OracleDriver");
	    connection = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:orcl",
	        "esep51", // username
	        "silanis1"); // password
	    
	  } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	  }
	  return connection;
	}
	private static void close(ResultSet r) {
		if (r != null) {
			try {
				r.close();
			} catch (SQLException e) { /* ignore */
			}
		}
	}

	private static void close(Statement s) {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) { /* ignore */
			}
		}
	}
	
	public static void main(String[] args)
	{
		DumpBinary db= new DumpBinary();
		db.dumpBinary();
	}

}
