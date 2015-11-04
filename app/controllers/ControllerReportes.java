package controllers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import models.User;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import play.db.DB;
import play.mvc.Result;
import play.mvc.Controller;


public class ControllerReportes extends Controller{
	
	static String REPORT_DEFINITION_PATH = "./app/reports/";
	
	public static Result generarReportePDF(){
		
		String fileName="./app/reports/TestReport";

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
	
	
}
