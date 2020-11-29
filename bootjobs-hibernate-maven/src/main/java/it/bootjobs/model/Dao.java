package it.bootjobs.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//classe singleton
public class Dao {
	
	private static Connection con=null;
	private static Dao dao=null;
	private DataSource ds=null;
	
	
	private Dao() {
		
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			// Look up our data source
			ds = (DataSource)envCtx.lookup("jdbc/mercury_drop");
			con=ds.getConnection();
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public static Connection getConnection() {
		
		if(con==null) {
			
			new Dao();
			
		}
		
		
		return con;
	}
	
	

}

