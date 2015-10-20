package database;

import java.util.List;

import models.Metrica;
import models.User;

public class UserDAO {
	
	public List<User> listarUsuarios(){
		return User.find.all();
	}
	
	public User consultarUsuarioPorId(Long id){
		return User.find.byId(id);
	}

}