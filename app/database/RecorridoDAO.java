package database;

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
	
}
