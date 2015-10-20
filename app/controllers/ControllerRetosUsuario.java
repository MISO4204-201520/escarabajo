package controllers;

import java.util.Date;
import java.util.List;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import database.RetoUsuarioDAO;
import models.RetoUsuario;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

@Restrict(@Group(Application.USER_ROLE))
public class ControllerRetosUsuario extends Controller{
	
	
	public static Result listarRetosUsuario(){
		
		RetoUsuarioDAO retoUsuarioDAO = new RetoUsuarioDAO();
		
		List<RetoUsuario> retos = retoUsuarioDAO.consultarRetosUsuario(Application.getLocalUser(session()));
		
		return ok(views.html.retosUsuario.render(retos));
		
	}	
	
}




