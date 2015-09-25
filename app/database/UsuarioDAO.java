package database;

import java.util.List;

import model.Usuario;
import model.UsuarioPK;

public class UsuarioDAO {
	
	public void agregarUsuario(Usuario u){
		u.save();
	}
	
	public void actualizarUsuario(Usuario u){
		Usuario usuarioActual = consultarUsuarioPorId(u.getUsuarioPK());
		usuarioActual.setNombre(u.getNombre());
		usuarioActual.setEmail(u.getEmail());
		usuarioActual.save();
	}
	
	public void eliminarUsuario(Usuario u){
		Usuario usuarioActual = consultarUsuarioPorId(u.getUsuarioPK());
		usuarioActual.delete();
	}
	
	public Usuario consultarUsuarioPorId(UsuarioPK id){
		return Usuario.find.byId(id);
	}

	public List<Usuario> consultarusuarioPorEmail(String email){
		return Usuario.find.where().eq("email", email).findList();
	}
}
