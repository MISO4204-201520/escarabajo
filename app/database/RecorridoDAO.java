package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import scala.Array;
import model.Recorrido;

public class RecorridoDAO {
	
	private static final String SQL_CONSULTA_RECORRIDOS = "SELECT id_recorrido, tipo, nombre FROM recorrido";
	
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
				recorrido.setIdRecorrido(rs.getInt("id_recorrido"));
				recorrido.setIdRecorrido(rs.getInt("tipo"));
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
	
	
}
