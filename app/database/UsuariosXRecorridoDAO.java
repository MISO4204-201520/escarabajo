package database;

import models.UsuarioXRecorrido;

public class UsuariosXRecorridoDAO {

	public void agregarMetrica(UsuarioXRecorrido uR){
		uR.save();
	}

}
