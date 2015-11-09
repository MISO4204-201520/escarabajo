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
		
		return ok(views.html.chat.render("Sistema de Mensajeria Instantanea", localUser, null, null));	
	}
}