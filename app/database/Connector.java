package database;

import java.sql.Connection;
import java.sql.SQLException;

import play.db.DB;

public class Connector {
	
	private static Connection conn = null;
	
	public static Connection getConnection(){

    	try{    	
    		if(conn == null){
    			conn = DB.getConnection();
    		}
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try {
				conn.close();
			} 
    		catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	return conn;
	}

}
