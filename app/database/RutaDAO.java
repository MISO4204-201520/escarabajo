package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Ruta;

public class RutaDAO {
	
	private static final String SQL_INSERTAR_RUTA = "INSERT INTO ruta(id_recorrido, fecha_inicio_ruta, fecha_fin_ruta, latitud_inicio, longitud_inicio, latitud_fin, longitud_fin, lugar_inicio, lugar_fin) VALUES (%d,'%tD%n','%tD%n','%f','%f','%f','%f','%s','%s')";
	
	public String insertarRuta(Connection con, Ruta ruta) throws SQLException
	{
		String mensaje = "OK";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(String.format(SQL_INSERTAR_RUTA, ruta.getIdRecorrido(), ruta.getFechaInicioRuta(), ruta.getFechaFinRuta(), ruta.getLatitudInicio(), ruta.getLongitudInicio(),
										ruta.getLatitudFin(), ruta.getLongitudFin(), ruta.getLugarInicio(), ruta.getLugarFin()));
			ps.executeUpdate();
		} catch (SQLException e) {
			mensaje = e.toString();
			e.printStackTrace();
			
		}finally{
			Connector.closeStatement(ps);
			Connector.closeConnection(con);
		}
		return mensaje;
	}
}
