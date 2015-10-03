package controllers;



import models.Metrica;
import database.MetricaDAO;
import play.mvc.Result;

import play.mvc.Controller;

public class ControllerMetrica extends Controller{
	
	
	
	public static Result agregarMetrica(){
		
		Metrica m = new Metrica();
    	m.setNombreMetrica("Distancia");
    	m.setUnidadMedida("Km");
    	m.setIdMetrica(2L);
    	
    	MetricaDAO mDAO;
    	mDAO = new MetricaDAO();
    	mDAO.agregarMetrica(m);
    	
    	System.out.println(mDAO.consultarMetricaPorId(m.getIdMetrica()).getNombreMetrica());
    	
    	return ok("Métrica agregada!");
	}

}
