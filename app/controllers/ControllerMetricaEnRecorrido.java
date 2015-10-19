package controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import controllers.ControllerRecorrido.FormularioConsultaRecorrido;
import models.Metrica;
import models.MetricasXRecorrido;
import models.Recorrido;
import database.MetricaDAO;
import database.MetricasXRecorridoDAO;
import database.RecorridoDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ControllerMetricaEnRecorrido extends Controller{
	
	public static Result iniciarRecorridoWeb(Long idRecorridoSeleccionado){
		System.out.println(idRecorridoSeleccionado.longValue());
		RecorridoDAO recorridoDAO = new RecorridoDAO();
		Recorrido recorrido = recorridoDAO.consultarRecorridoPorId(idRecorridoSeleccionado);
		
		return ok(views.html.ejecucionRecorrido.render(recorrido));
	}
	
	public static Result guardarMetricas(){
		
		RecorridoDAO recorridoDAO = new RecorridoDAO();
		MetricaDAO metricaDAO = new MetricaDAO();
		MetricasXRecorridoDAO metricasXRecorridoDAO = new MetricasXRecorridoDAO();
		
		DynamicForm requestData = Form.form().bindFromRequest();
		
		String txtRecorridoId = requestData.get("recorridoId");
		
        String txtDistanciaRealVal = requestData.get("txtDistanciaRealVal");
        String txtTiempoEstimadoVal = requestData.get("txtTiempoEstimadoVal"); 
        String txtDistanciaEstimadaVal = requestData.get("txtDistanciaEstimadaVal");
        String txtTiempoRealVal = requestData.get("txtTiempoRealVal");
        
        String txtClimaCondicionOrigenVal = requestData.get("txtClimaCondicionOrigenVal");
        String txtClimaCondicionDestinoVal = requestData.get("txtClimaCondicionDestinoVal");
        String txtClimaTemperaturaOrigenVal = requestData.get("txtClimaTemperaturaOrigenVal");
        String txtClimaTemperaturaDestinoVal = requestData.get("txtClimaTemperaturaDestinoVal");
        String txtClimaHumedadOrigenVal = requestData.get("txtClimaHumedadOrigenVal");
        String txtClimaHumedadDestinoVal = requestData.get("txtClimaHumedadDestinoVal");
        String txtClimaNubosidadOrigenVal = requestData.get("txtClimaNubosidadOrigenVal");
        String txtClimaNubosidadDestinoVal = requestData.get("txtClimaNubosidadDestinoVal");
        String txtClimaVientoOrigenVal = requestData.get("txtClimaVientoOrigenVal");
        String txtClimaVientoDestinoVal = requestData.get("txtClimaVientoDestinoVal");
        
        try{
        	Long recorridoPK = Long.parseLong(txtRecorridoId);
        	Recorrido recorrido = recorridoDAO.consultarRecorridoPorId(recorridoPK);
        	
        	List<MetricasXRecorrido> lstMetricas = new ArrayList<MetricasXRecorrido>();
        	
        	if(metricaDAO.consultarMetricaPorNombre("Distancia Real").size() <= 0){
        		Metrica m = new Metrica();
        		m.setNombreMetrica("Distancia Real");
        		m.setUnidadMedida("Km");
        		metricaDAO.agregarMetrica(m);
        	}
        	
        	MetricasXRecorrido metricasRecorrido = new MetricasXRecorrido();
        	metricasRecorrido.setIdMetricaXRecorrido(1L);
        	metricasRecorrido.setRecorrido(recorrido);
        	metricasRecorrido.setUsuario(Application.getLocalUser(session()));
        	metricasRecorrido.setMetrica(metricaDAO.consultarMetricaPorNombre("Distancia Real").get(0));
        	metricasRecorrido.setValorMetrica(Double.parseDouble(txtDistanciaRealVal));
        	metricasRecorrido.setFecha(new Date(new java.util.Date().getTime()));
        	
        	lstMetricas.add(metricasRecorrido);
        	
        	metricasXRecorridoDAO.agregarMetrica(metricasRecorrido);
        	
        	
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        
		System.out.println("txtDistanciaRealVal= " + txtDistanciaRealVal);
		System.out.println("txtTiempoRealVal= " + txtTiempoRealVal);
		
		
		
		
		
		List<Recorrido> lstRecorridos = recorridoDAO.listarRecorridos();
		response().setContentType("text/html; charset=utf-8");
		return ok(views.html.recorridosConsulta.render(Form.form(FormularioConsultaRecorrido.class), lstRecorridos));
	}

}
