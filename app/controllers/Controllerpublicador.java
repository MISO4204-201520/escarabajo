package controllers;

import models.User;
import play.Logger;
import play.libs.EventSource;
import play.mvc.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controllerpublicador extends Controller {
	
	
	public static Result index() {
		return ok(views.html.publicador.render("Publicador"));
	  }

}
