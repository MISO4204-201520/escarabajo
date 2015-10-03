package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Recorrido;
import scala.Array;

import models.Metrica;
import models.Recorrido;


public class RecorridoDAO {
	
	/**
	 * Agregar una recorrido al repositorio 
	 * 
	 * @param r El recorrido que se desea agregar
	 */
	public void agregarRecorrido(Recorrido r){
		r.save();
	}
	
	
	
	/*private static final String SQL_CONSULTA_RECORRIDOS = "SELECT id_recorrido, tipo, nombre FROM recorrido";
	private static final String SQL_INSERTAR_RECORRIDO = "INSERT INTO recorrido(tipo, nombre, descripcion, hora_frecuente, dia_frecuente) VALUES (?,?,?,?,?)";
	
	public List<Recorrido> consultarRecorridos(Connection con)
	{
		List<Recorrido> lsRecorrido = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(SQL_CONSULTA_RECORRIDOS);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Recorrido recorrido = new Recorrido();
				recorrido.setIdRecorrido(rs.getLong("id_recorrido"));
				recorrido.setIdRecorrido(rs.getLong("tipo"));
				recorrido.setNombre(rs.getString("nombre"));
				lsRecorrido.add(recorrido);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Connector.closeStatement(ps);
			Connector.closeResultSet(rs);
		}
		return lsRecorrido;
	}
	
	
	public String insertarRecorrido(Connection con, Recorrido recorrido) throws SQLException
	{
		String mensaje = "OK";
		PreparedStatement ps = null;
		
		try {
			ps=con.prepareStatement(SQL_INSERTAR_RECORRIDO);
			ps.setInt(1, recorrido.getTipo());
			ps.setString(2, recorrido.getNombre());
			ps.setString(3, recorrido.getDescripcion());
			ps.setString(4, recorrido.getHoraFrecuente());
			ps.setString(5, recorrido.getDiaFrecuente());
			ps.executeUpdate();
		} catch (SQLException e) {
			mensaje = e.toString();
			e.printStackTrace();
			
		}finally{
			Connector.closeStatement(ps);
			Connector.closeConnection(con);
		}
		return mensaje;
	}*/
	
}
