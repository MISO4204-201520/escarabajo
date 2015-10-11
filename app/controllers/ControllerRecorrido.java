package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import database.RecorridoDAO;
import database.UserDAO;
import play.data.Form;
import play.data.validation.Constraints.*;
import static play.libs.Json.toJson;
import models.Recorrido;
import models.Ruta;
import models.User;
import models.UsuarioXRecorrido;
import play.mvc.Controller;
import play.mvc.Result;

@Restrict(@Group(Application.USER_ROLE))
public class ControllerRecorrido extends Controller{

	public static List<String> tipoRecorrido = new ArrayList<String>();;
	public static Map<String, Boolean> diaFrecuente = new HashMap<String, Boolean>();
	public static Map<String, Boolean> horaSalida = new HashMap<String, Boolean>();
	public static Map<String, Boolean> lstAmigos = new HashMap<String, Boolean>();
	
	public static Result postFormRecorridos() {
		
		Form<FormularioRecorrido> form = Form.form(FormularioRecorrido.class).bindFromRequest();
        if(form.hasErrors()) {
        	flash("error", "Se encontraron errores al crear el recorrido.");
            return badRequest(views.html.recorridos.render(Form.form(FormularioRecorrido.class), tipoRecorrido, diaFrecuente, horaSalida, lstAmigos));
      
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
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        	
        	try {
				Date fechaInicio = format.parse(formRecorrido.fechaInicioRuta);//new Date();
				Date fechaFin = format.parse(formRecorrido.fechaFinRuta);//new Date();
				
				ruta.setFechaInicioRuta(fechaInicio);
				ruta.setFechaFinRuta(fechaFin);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	
			ruta.setLatitudInicio(Float.parseFloat(formRecorrido.latitudInicio));
			ruta.setLongitudInicio(Float.parseFloat(formRecorrido.longitudInicio));
			ruta.setLatitudFin(Float.parseFloat(formRecorrido.latitudFin));
			ruta.setLongitudFin(Float.parseFloat(formRecorrido.longitudFin));
			
        	ruta.setLugarInicio(formRecorrido.lugarInicio);
        	ruta.setLugarFin(formRecorrido.lugarFin);
        	
        	List<UsuarioXRecorrido> listUsuarioRecorrido = new ArrayList<UsuarioXRecorrido>();
        	        	
        	User usuario = Application.getLocalUser(session()) ; 
        	UsuarioXRecorrido usuarioRecorrido = new UsuarioXRecorrido();
        	usuarioRecorrido.setUsuario(usuario);
        	usuarioRecorrido.setIndAdministrador(true);
        	usuarioRecorrido.setIndConfirmado(true);
        	
        	listUsuarioRecorrido.add(usuarioRecorrido);
        	UserDAO userDao = new UserDAO();
        	        	
        	for (String amigo : formRecorrido.lstAmigos) {
        		System.out.println("2***************** " + amigo.split("-")[0]);
        		usuario = userDao.consultarUsuarioPorId(Long.parseLong(amigo.split("-")[1]));
        		usuarioRecorrido = new UsuarioXRecorrido();
            	usuarioRecorrido.setUsuario(usuario);
            	usuarioRecorrido.setIndAdministrador(false);
            	usuarioRecorrido.setIndConfirmado(false);
            	listUsuarioRecorrido.add(usuarioRecorrido);
			}
        	
        	insertarRecorrido(recorrido, ruta, listUsuarioRecorrido);
        	
        	flash("success", "Se ha creado correctamente el recorrido.");
        	return ok(views.html.recorridos.render(Form.form(FormularioRecorrido.class), tipoRecorrido, diaFrecuente, horaSalida, lstAmigos));
        }
	}
	
	public static Result getFormRecorridos()
	{
		cargarListas();
		response().setContentType("text/html; charset=utf-8");
		return ok(views.html.recorridos.render(Form.form(FormularioRecorrido.class), tipoRecorrido, diaFrecuente, horaSalida, lstAmigos));
	}
	
	private static void cargarListas()
	{
		tipoRecorrido = new ArrayList<String>();
        tipoRecorrido.add("Frecuente");
        tipoRecorrido.add("Recreacion");
        
        diaFrecuente = new HashMap<String, Boolean>();
        diaFrecuente.put("Lu", false);
        diaFrecuente.put("Ma", false);
        diaFrecuente.put("Mi", false);
        diaFrecuente.put("Ju", false);
        diaFrecuente.put("Vi", false);
        diaFrecuente.put("Sa", false);
        diaFrecuente.put("Do", false);
        
        horaSalida = new HashMap<String, Boolean>();
        for (int i = 0; i < 24; i++) {
        	horaSalida.put(String.format("%02d", i) + ":00", false);
        	horaSalida.put(String.format("%02d", i) + ":30", false);
		}
        
        UserDAO userDao = new UserDAO();
        List<User> lstUser = userDao.listarUsuarios();
        
        User usuarioSession = Application.getLocalUser(session()); 
        lstAmigos = new HashMap<String, Boolean>();
        for (User usuario : lstUser) {
        	if(usuarioSession.id != usuario.id)
        		lstAmigos.put(usuario.name + "-" + usuario.id, false);
        }
	}
	
	private static void insertarRecorrido(Recorrido recorrido, Ruta ruta, List<UsuarioXRecorrido> listUsuarioRecorrido)
	{
		RecorridoDAO recorridoDao = new RecorridoDAO();
    	recorrido.getLstRuta().add(ruta);
    	recorrido.setLstUsuarioXRecorrido(listUsuarioRecorrido);
		recorridoDao.agregarRecorrido(recorrido);
	}
	
	public static Result listarRecorridos(){
		
		RecorridoDAO recorridoDAO = new RecorridoDAO();
		List<Recorrido> lstRecorridos = recorridoDAO.listarRecorridos();
		return ok(toJson(lstRecorridos));
	}
	
	public static Result listarRecorridosWeb(){
		
		RecorridoDAO recorridoDAO = new RecorridoDAO();
		List<Recorrido> lstRecorridos = recorridoDAO.listarRecorridos();
		return ok(views.html.recorridosConsulta.render(lstRecorridos));
	}
	
	public static class FormularioRecorrido {
		@Required public String tipoRecorrido;
		@Required public String nombre;
		@Required public String descripcion;
		@Required public String horaFrecuente;
		@Required public List<String> diaFrecuente;
		public List<String> lstAmigos;
		public String fechaInicioRuta;
		public String fechaFinRuta;
		@Required public String latitudInicio;
		@Required public String longitudInicio;
		@Required public String latitudFin;
		@Required public String longitudFin;
		@Required public String lugarInicio;
		@Required public String lugarFin;
    }
	
}




