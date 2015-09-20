package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import play.db.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	private Connection conn;
	private Statement st;

    public Result index() {
    	
    	try{
    	
    		conn = DB.getConnection();
    		
    		String sql = "INSERT INTO tabla_pruebas (id_prueba, nombre_prueba, telefono_prueba) "
    				+ "VALUES (2, 'Henry', 01800321654)";
    		
    		st = conn.prepareStatement(sql);
    		
    		int rows = st.executeUpdate(sql);
    		
    		System.out.println("TEST " + rows);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	finally{
    		try {
				st.close();
			} 
    		catch (SQLException e) {
				e.printStackTrace();
			}
    		
    		try {
				conn.close();
			} 
    		catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
        return ok(index.render("Your new application is ready."));
    }

}
