package database;

import java.util.List;

import models.Recompensa;

public class RecompensaDAO {
	
	public List<Recompensa> consultarRecompensasActivas(){
		return Recompensa.find.where().eq("estado", "activo").findList();
	}	
	
	public List<Recompensa> consultarRecompensas(){
		return Recompensa.find.all();
	}
	
	public void agregarRecompensa(Recompensa recompensa){
		if(recompensa.id==null){
			recompensa.id = Recompensa.find.nextId();
			recompensa.save();
		}

	}
	
	public void actualizarRecompensa(Recompensa recompensa){
		Recompensa recompensaActual = consultarRecompensaPorId(recompensa.id);
		
		if(recompensaActual!=null){
			recompensaActual = recompensa;		
			recompensaActual.update();
		}
	}
	
	public void eliminarRecompensa(Recompensa recompensa){
		Recompensa recompensaBorrar = consultarRecompensaPorId(recompensa.id);
		if(recompensaBorrar!=null){
			recompensaBorrar.delete();
		}		
	}
	
	public Recompensa consultarRecompensaPorId(Long id){
		return Recompensa.find.byId(id);
	}	

}
