package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.typesafe.config.ConfigException.Parse;

import database.Connector;
import database.RecorridoDAO;
import database.RutaDAO;
import play.*;
import play.mvc.*;
import play.data.Form;
import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.*;
import model.Recorrido;
import model.Ruta;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Array;
import views.html.*;


public class ControllerRecorrido extends Controller{
	
	public Result postFormRecorridos() {
		
		Form<FormularioRecorrido> form = Form.form(FormularioRecorrido.class).bindFromRequest();
        if(form.hasErrors()) {
            return ok("Error");//badRequest(views.html.recorridos.render(form, null, null, null));
        } else {
        	FormularioRecorrido formRecorrido = form.get();
        	
        	Recorrido recorrido = new Recorrido();
        	recorrido.setTipo(0);
        	if (formRecorrido.tipoRecorrido == "Recreacion")
        		recorrido.setTipo(1);
        	
        	recorrido.setNombre(formRecorrido.nombre);
        	recorrido.setDescripcion(formRecorrido.descripcion);
        	recorrido.setHoraFrecuente(formRecorrido.horaFrecuente);
        	
        	if(formRecorrido.diaFrecuente != null)
        	{
	        	String cadDias = "";
	    		for (String dia : formRecorrido.diaFrecuente) {
	    			cadDias += dia + ",";
	    		}
	        	recorrido.setDiaFrecuente(cadDias);
        	}
        	
        	Ruta ruta = new Ruta();
        	
        	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        	
        	try {
				Date fechaInicio = format.parse(formRecorrido.fechaInicioRuta);
				Date fechaFin = format.parse(formRecorrido.fechaFinRuta);
				
				ruta.setFechaInicioRuta(fechaInicio);
				ruta.setFechaFinRuta(fechaFin);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	ruta.setLugarInicio(formRecorrido.lugarInicio);
        	ruta.setLugarFin(formRecorrido.lugarFin);
        	  
        	insertarRecorrido(recorrido, ruta);
        	
        	return ok((formRecorrido.nombre));
        }
	}
	
	public String cadDias = "";
	public Result getFormRecorridos()
	{
        List<String> tipoRecorrido = new ArrayList<String>();
        tipoRecorrido.add("Frecuente");
        tipoRecorrido.add("Recreacion");
        
        Map<String, Boolean> diaFrecuente = new HashMap<String, Boolean>();
        diaFrecuente.put("Lu", false);
        diaFrecuente.put("Ma", false);
        diaFrecuente.put("Mi", false);
        diaFrecuente.put("Ju", false);
        diaFrecuente.put("Vi", false);
        diaFrecuente.put("Sa", false);
        diaFrecuente.put("Do", false);
        
        Map<String, Boolean> horaSalida = new HashMap<String, Boolean>();
        for (int i = 0; i < 24; i++) {
        	horaSalida.put(String.format("%02d", i) + ":00", false);
        	horaSalida.put(String.format("%02d", i) + ":30", false);
		}
        return ok(views.html.recorridos.render(Form.form(FormularioRecorrido.class), tipoRecorrido, diaFrecuente, horaSalida));
	}
	
	private void insertarRecorrido(Recorrido recorrido, Ruta ruta)
	{
		Connection con = Connector.getConnection();
		RecorridoDAO recorridoDao = new RecorridoDAO();
    	RutaDAO rutaDao =  new RutaDAO();
		try {
			String mensaje = recorridoDao.insertarRecorrido(con, recorrido);
			//mensaje += rutaDao.insertarRuta();
			Connector.closeConnection(con);
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}
	
	public static class FormularioRecorrido {
		@Required public String tipoRecorrido;
		@Required public String nombre;
		public String descripcion;
		public String horaFrecuente;
		public List<String> diaFrecuente;
		public String fechaInicioRuta;
		public String fechaFinRuta;
		public String latitudInicio;
		public String longitudInicio;
		public String lugarInicio;
		public String lugarFin;
    } 
	
}




