package database;

import java.util.List;

import models.Recompensa;
import models.RecompensaUsuario;
import models.RecompensaUsuarioPK;
import models.User;

public class RecompensaUsuarioDAO {
	
	public List<RecompensaUsuario> consultarRecompensasUsuario(User usuario){
		return RecompensaUsuario.find.where().eq("usuario", usuario).findList();
	}	
	
	public boolean guardarRecompensaUsuario(RecompensaUsuario recompensaUsuario){
		RecompensaUsuario recompensaUsuarioActual = consultarRecompensaUsuarioPorId(recompensaUsuario.recompensaUsuarioPK);
		boolean retorno = false;
		if(recompensaUsuarioActual==null){
			recompensaUsuario.save();
			retorno =  true;
		}else{
			retorno = false;
		}
		return retorno;
	}
	
	public void actualizarRecompensaUsuario(RecompensaUsuario recompensaUsuario){
		RecompensaUsuario recompensaUsuarioActual = consultarRecompensaUsuarioPorId(recompensaUsuario.recompensaUsuarioPK);
		
		if(recompensaUsuarioActual!=null){
			recompensaUsuarioActual = recompensaUsuario;		
			recompensaUsuarioActual.update();
		}
	}
	
	public void eliminarRecompensaUsuario(RecompensaUsuario recompensaUsuario){
		RecompensaUsuario recompensaUsuarioBorrar = consultarRecompensaUsuarioPorId(recompensaUsuario.recompensaUsuarioPK);
		recompensaUsuarioBorrar.delete();
	}
	
	public RecompensaUsuario consultarRecompensaUsuarioPorId(RecompensaUsuarioPK id){
		return RecompensaUsuario.find.byId(id);
	}	

}
