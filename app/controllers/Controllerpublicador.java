package controllers;
import models.User;
import play.Logger;
import play.libs.EventSource;
import play.mvc.*;
import play.twirl.api.BufferedContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controllerpublicador extends Controller {
	
	
	public static Result index() {
		
		final User localUser = Application.getLocalUser(session());
		String mensaje = "Hola acabo de iniciar un recorrido quieres unirte aun estas a tiempo ";
		String url = "http://i844.photobucket.com/albums/ab7/MARTIN3280/af0821f4-f925-4b64-87e8-3a0f6454b19d_zpsbgsh2pue.jpg";
		
		return ok(views.html.chat.render("Sistema de Mensajeria Instantanea", localUser, null, views.html.publicadorfacebook.render("publicador", mensaje, url)));	
	}
}