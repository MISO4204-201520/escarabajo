package controllers;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import models.ReportFactory;
import models.Reporte;
import models.User;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import play.db.DB;
import play.mvc.Result;
import play.mvc.Controller;


public class ControllerReportes extends Controller{
	
	static String REPORT_DEFINITION_PATH = "./app/reports/";
	
	public static Result generarReportePDF(int criteriaReporte){
		
		Reporte reporte = ReportFactory.getReport(criteriaReporte);
		try {
			String printFileName = reporte.generarReporteCompilado();
			
			if (printFileName != null) {
				JasperExportManager.exportReportToPdfFile(printFileName, reporte.getFileName() + ".pdf");
				
				return ok(new File(reporte.getFileName() + ".pdf"));
			}
			
			return null;
		} 
		catch (JRException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Result generarReporteMetricasPDF(){
		
		String fileName="./app/reports/ReporteMetricas";

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			User usuario = Application.getLocalUser(session());
			
			parameters.put("p_usuario", usuario.id);
			parameters.put("p_fecha", new Date());
	
			JasperCompileManager.compileReportToFile(fileName + ".jrxml");
			
			String printFileName = JasperFillManager.fillReportToFile(fileName + ".jasper" , parameters, DB.getConnection());
			
			if (printFileName != null) {
				JasperExportManager.exportReportToPdfFile(printFileName, fileName + ".pdf");
			}
		
			return ok(new File(fileName + ".pdf"));

		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Result generarReporteHistoricoPDF(){
		
		String fileName="./app/reports/ReporteHistoricos";

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			User usuario = Application.getLocalUser(session());
			
			parameters.put("p_usuario", usuario.id);
			parameters.put("p_fecha", new Date());
	
			JasperCompileManager.compileReportToFile(fileName + ".jrxml");
			
			String printFileName = JasperFillManager.fillReportToFile(fileName + ".jasper" , parameters, DB.getConnection());
			
			if (printFileName != null) {
				JasperExportManager.exportReportToPdfFile(printFileName, fileName + ".pdf");
			}
		
			return ok(new File(fileName + ".pdf"));

		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Result generarReporteRecorridoPDF(Long idRecorrido){
		
		String fileName="./app/reports/ReporteRecorrido";

		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			User usuario = Application.getLocalUser(session());
			
			parameters.put("p_usuario", usuario.id);
			parameters.put("p_fecha", new Date());
			parameters.put("p_recorrido", idRecorrido);
	
			JasperCompileManager.compileReportToFile(fileName + ".jrxml");
			
			String printFileName = JasperFillManager.fillReportToFile(fileName + ".jasper" , parameters, DB.getConnection());
			
			if (printFileName != null) {
				JasperExportManager.exportReportToPdfFile(printFileName, fileName + ".pdf");
			}
		
			return ok(new File(fileName + ".pdf"));

		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
