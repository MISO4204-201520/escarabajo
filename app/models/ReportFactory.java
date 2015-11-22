package models;

public class ReportFactory {
	
	public static Reporte getReport(int criteria){
		
		if(criteria == Reporte.METRICAS){
			return new ReporteMetricas();
		}
		else if(criteria == Reporte.HISTORICO){
			
		}
		else if(criteria == Reporte.REPORTE){
			
		}
		
		return null;
	}

}
