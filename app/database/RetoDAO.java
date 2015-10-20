package database;

import java.util.List;

import models.Reto;

public class RetoDAO {
	
	public List<Reto> consultarRetosActivos(){
		return Reto.find.where().eq("estado", "activo").findList();
	}
	
	public List<Reto> consultarRetos(){
		return Reto.find.all();
	}
	
	public void agregarReto(Reto reto){
		reto.id = Reto.find.nextId();
		reto.save();
	}
	
	public void actualizarReto(Reto reto){
		Reto retoActual = consultarRetoPorId(reto.id);
		
		if(retoActual!=null){
			retoActual = reto;
			retoActual.update();
		}

	}
	
	public void eliminarReto(Reto reto){
		Reto retoBorrar = consultarRetoPorId(reto.id);
		if(retoBorrar!=null){
			retoBorrar.delete();			
		}
	}
	
	public Reto consultarRetoPorId(Long id){
		return Reto.find.byId(id);
	}	

}
