package controllers;

import java.util.List;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import database.RetoDAO;
import models.Reto;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

@Restrict(@Group(Application.USER_ROLE))
public class ControllerRetos extends Controller{
	
	private static final Form<Reto> retoForm = Form
			.form(Reto.class);	
	
	public static Result listarSitiosDeAlquiler(){
		
		RetoDAO retoDAO = new RetoDAO();
		
		List<Reto> retos = retoDAO.listarRetosActivos();
		
		return ok(views.html.retos.render( retos ));
		
	}	
		
	public static Result save() {
		
		return ok(index.render("Proyecto escarabajo" ));
	}
	
	public static Result details(Long idSitio) {
		return ok(index.render("Proyecto escarabajo" ));
	}
	
	public static Result newSitio() {
		return ok(index.render("Proyecto escarabajo" ));
	}
	
	
}




