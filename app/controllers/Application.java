package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.Connector;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
    public Result index() {
    
    	Connection c = Connector.getConnection();
    	
    	try {
			Statement st = c.createStatement();
			st.close();
			
			c.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
        return ok(index.render("Your new application is ready."));
    }

}
