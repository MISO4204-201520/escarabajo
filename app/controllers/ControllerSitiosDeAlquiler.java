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

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import database.Connector;
import database.RecorridoDAO;
import database.SitioDeAlquilerDAO;

import database.RutaDAO;

import play.*;
import play.mvc.*;
import play.data.Form;
import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.*;

import static play.libs.Json.toJson;

import models.Recorrido;
import models.Ruta;
import models.SitioDeAlquiler;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Array;
import views.html.*;

@Restrict(@Group(Application.USER_ROLE))
public class ControllerSitiosDeAlquiler extends Controller{
	
	private static final Form<SitioDeAlquiler> sitioForm = Form
			.form(SitioDeAlquiler.class);	
	
	public static Result listarSitiosDeAlquiler(){
		
		SitioDeAlquilerDAO sitioDAO = new SitioDeAlquilerDAO();
		
		List<SitioDeAlquiler> sitios = sitioDAO.consultarSitiosDeAlquilerPorUsuario(Application.getLocalUser(session()));
		
		return ok(views.html.misSitiosAlquiler.render( sitios));
		
	}	
		
	public static Result save() {
		Form<SitioDeAlquiler> boundForm = sitioForm.bindFromRequest();
		SitioDeAlquilerDAO sitioDAO = new SitioDeAlquilerDAO();
		if(boundForm.hasErrors()) {
			flash("error", "Por favor corregir el formulario.");
			return badRequest(detalleAlquiler.render(boundForm));
		}
		SitioDeAlquiler sitioA = boundForm.get();
		SitioDeAlquiler sitioBD = sitioDAO.consultarSitioDeAlquilerPorId(sitioA.getIdSitio());
		if(sitioBD!=null){
			sitioDAO.actualizarSitioDeAlquiler(sitioA);
		}else{
			sitioA.setUsuario(Application.getLocalUser(session()));
			sitioA.save();
		}		
		flash("success",
		String.format("El sitio %s ha sido añadido.", sitioA));
		return redirect(routes.ControllerSitiosDeAlquiler.listarSitiosDeAlquiler());
	}
	
	public static Result details(Long idSitio) {
		SitioDeAlquilerDAO sitioDAO = new SitioDeAlquilerDAO();
		final SitioDeAlquiler sitio = sitioDAO.consultarSitioDeAlquilerPorId(idSitio);
		if (sitio == null) {
			return notFound(String.format("Sitio de alquiler %s no existe.", idSitio));
		}
		Form<SitioDeAlquiler> filledForm = sitioForm.fill(sitio);
		return ok(detalleAlquiler.render(filledForm));
	}
	
	public static Result newSitio() {
		return ok(detalleAlquiler.render(sitioForm));
	}
	
	
}




