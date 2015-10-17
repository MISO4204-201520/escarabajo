package database;

import java.util.List;

import models.Recorrido;


public class RecorridoDAO {
	
	/**
	 * Agregar una recorrido al repositorio 
	 * 
	 * @param r El recorrido que se desea agregar
	 */
	public void agregarRecorrido(Recorrido r){
		r.save();
	}
	
	public List<Recorrido> listarRecorridos(){
		return Recorrido.find.all();
	}
	
	public Recorrido consultarRecorridoPorId(Long id){
		return Recorrido.find.byId(id);
	}
}
