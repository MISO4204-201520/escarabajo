package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class ControllerMetricaEnRecorrido extends Controller{
	
	public static Result iniciarRecorridoWeb(){
		return ok(views.html.ejecucionRecorrido.render());
	}

}
