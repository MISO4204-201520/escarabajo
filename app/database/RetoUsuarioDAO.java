package database;

import java.util.List;

import models.Reto;
import models.RetoUsuario;
import models.RetoUsuarioPK;
import models.User;

public class RetoUsuarioDAO {
	
	public List<RetoUsuario> consultarRetosUsuario(User usuario){
		return RetoUsuario.find.where().eq("usuario", usuario).findList();
	}
	
	public void agregarRetoUsuario(RetoUsuario retoUsuario){
		retoUsuario.save();
	}
	
	public void actualizarRetoUsuario(RetoUsuario retoUsuario){
		RetoUsuario retoUsuarioActual = consultarRetoUsuarioPorId(retoUsuario.retoUsuarioPK);
		
		if(retoUsuarioActual!=null){
			retoUsuarioActual = retoUsuario;
			retoUsuarioActual.save();
		}

	}
	
	public void eliminarRetoUsuario(RetoUsuario retoUsuario){
		RetoUsuario retoUsuarioBorrar = consultarRetoUsuarioPorId(retoUsuario.retoUsuarioPK);
		if(retoUsuarioBorrar!=null){
			retoUsuarioBorrar.delete();			
		}
	}
	
	public RetoUsuario consultarRetoUsuarioPorId(RetoUsuarioPK id){
		return RetoUsuario.find.byId(id);
	}	

}
