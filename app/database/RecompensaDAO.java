package database;

import java.util.List;

import models.Recompensa;

public class RecompensaDAO {
	
	public List<Recompensa> listarRecompensasActivos(){
		return Recompensa.find.where().eq("estado", "activo").findList();
	}	
	
	public void agregarRecompensa(Recompensa recompensa){
		recompensa.save();
	}
	
	public void actualizarRecompensa(Recompensa recompensa){
		Recompensa recompensaActual = consultarRecompensaPorId(recompensa.id);
		
		recompensaActual = recompensa;		
		recompensaActual.save();
	}
	
	public void eliminarSitioDeAlquiler(Recompensa recompensa){
		Recompensa recompensaBorrar = consultarRecompensaPorId(recompensa.id);
		recompensaBorrar.delete();
	}
	
	public Recompensa consultarRecompensaPorId(Long id){
		return Recompensa.find.byId(id);
	}	

}
