package database;

import java.sql.SQLException;

import models.Ruta;

public class RutaDAO {
	
	/**
	 * Agregar una ruta al repositorio 
	 * 
	 * @param rt La ruta que se debe agregar
	 */
	public void agregarRuta(Ruta rt) throws SQLException
	{
		rt.save();
	}
}
