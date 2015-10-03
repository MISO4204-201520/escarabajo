package database;

import java.util.List;

import model.Metrica;
import model.MetricasXRecorrido;
import model.Usuario;

public class MetricasXRecorridoDAO {

	public void agregarMetrica(MetricasXRecorrido mR){
		mR.save();
	}
	
	public void actualizarMetrica(MetricasXRecorrido mR){
		MetricasXRecorrido metricaActual = consultarMetricaEnRecorridoPorId(mR.getIdMetricaXRecorrido());
		metricaActual.setValorMetrica(mR.getValorMetrica());
		metricaActual.setFecha(mR.getFecha());
		metricaActual.save();
	}
	
	public void eliminarMetrica(MetricasXRecorrido mR){
		MetricasXRecorrido metricaActual = consultarMetricaEnRecorridoPorId(mR.getIdMetricaXRecorrido());
		metricaActual.delete();
	}
	
	public MetricasXRecorrido consultarMetricaEnRecorridoPorId(Long id){
		return MetricasXRecorrido.find.byId(id);
	}
	
	public List<MetricasXRecorrido> consultarMetricaEnRecorridoPorMetricaYUsuario(Metrica m, Usuario u){
		return MetricasXRecorrido.find.where().eq("id_usuario", u.getUsuarioPK().getIdUsuario())
				.eq("username",u.getUsuarioPK().getUsername())
				.eq("metrica_id_metrica",m.getIdMetrica()).findList();
	}


}
