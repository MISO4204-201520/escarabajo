package controllers.mapas;

import model.Metrica;
import database.MetricaDAO;
import play.mvc.Controller;

public class ControllerMetrica extends Controller{
	
	private MetricaDAO mDAO;
	
	public void prueba(){
		Metrica m = new Metrica();
    	m.setNombreMetrica("Distancia");
    	m.setUnidadMedida("Km");
    	m.setIdMetrica(2L);
    	
    	mDAO = new MetricaDAO();
    	mDAO.agregarMetrica(m);
    	
    	System.out.println(mDAO.consultarMetricaPorId(m.getIdMetrica()).getNombreMetrica());
    	
    	m.setNombreMetrica("Distance");
    	mDAO.actualizarMetrica(m);
    	
    	System.out.println(mDAO.consultarMetricaPorId(m.getIdMetrica()).getNombreMetrica());
    	
    	System.out.println(mDAO.consultarMetricaPorNombre(m.getNombreMetrica()).get(0).getIdMetrica());
	}

}
