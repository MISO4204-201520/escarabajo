package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.typesafe.config.ConfigException.Parse;

import database.Connector;
import database.RecorridoDAO;
import play.*;
import play.mvc.*;
import play.data.Form;
import play.data.validation.Constraints.*;
import model.Recorrido;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Array;
import views.html.*;


public class ControllerRecorrido extends Controller{
	
	public static Result postFormRecorridos() {
    	
		
		Form<Recorrido> form = Form.form(Recorrido.class).bindFromRequest();
        if(form.hasErrors()) {
            return ok("Error");//badRequest(views.html.recorridos.render(form, null, null, null));
        } else {
        	Recorrido recorrido = form.get();
        	System.out.println(recorrido.getNombre()+ "     " + recorrido.getTipo());
            
        	insertarRecorrido(recorrido);

        	return ok((recorrido.getNombre())
            );
        }
		
	}
	
	public String cadDias = "";
	public static Result getFormRecorridos()
	{
        List<String> tipoRecorrido = new ArrayList<String>();
        tipoRecorrido.add("Frecuente");
        tipoRecorrido.add("Recreación");
        
        Map<String, Boolean> diasRecorrido = new HashMap<String, Boolean>();
        diasRecorrido.put("Lu", false);
        diasRecorrido.put("Ma", false);
        diasRecorrido.put("Mi", false);
        diasRecorrido.put("Ju", false);
        diasRecorrido.put("Vi", false);
        diasRecorrido.put("Sa", false);
        diasRecorrido.put("Do", false);
        
        Map<String, Boolean> horaSalida = new HashMap<String, Boolean>();
        for (int i = 0; i < 24; i++) {
        	horaSalida.put(String.format("%02d", i) + ":00", false);
        	horaSalida.put(String.format("%02d", i) + ":30", false);
		}
        return ok(views.html.recorridos.render(Form.form(Recorrido.class), tipoRecorrido, diasRecorrido, horaSalida));
	}
	
	private static void insertarRecorrido(Recorrido recorrido)
	{
		recorrido.setIdRecorrido(67);
		recorrido.setTipo(100);
		
		Connection con = Connector.getConnection();
		RecorridoDAO rec = new RecorridoDAO();
    	
		try {
			String mensaje = rec.insertarRecorrido(con, recorrido);
    		con.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}
}



