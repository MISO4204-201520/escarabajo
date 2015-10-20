package controllers;

import java.util.List;

import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;
import database.RecompensaUsuarioDAO;
import models.RecompensaUsuario;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

@Restrict(@Group(Application.USER_ROLE))
public class ControllerRecompensasUsuario extends Controller{
	
	
	public static Result listarRecompensasUsuario(){
		
		RecompensaUsuarioDAO recomUsuarioDAO = new RecompensaUsuarioDAO();
		
		User usuario = Application.getLocalUser(session());
		List<RecompensaUsuario> recom = recomUsuarioDAO.consultarRecompensasUsuario(usuario);
		
		return ok(views.html.recompensasUsuario.render(recom));
		
	}	
	
}




