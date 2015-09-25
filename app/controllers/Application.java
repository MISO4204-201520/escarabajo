package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.Recorrido;
import database.Connector;
import database.RecorridoDAO;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
    public Result index() {
    
    	/*Connection c = Connector.getConnection();
    	RecorridoDAO rec = new RecorridoDAO();
    	List<Recorrido> lst = rec.consultarRecorridos(c);
    	
    	System.out.println(lst.get(0).getNombre());
    	try {
			Statement st = c.createStatement();
			st.close();
			
			c.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	*/
        return ok(index.render("Proyecto escarabajo prueba github"));
    }

}
