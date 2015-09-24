package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Metrica;

public class MetricaDAO {
	
	private static final String SQL_CONSULTA_METRICAS = "SELECT id_metrica, nombre_metrica, unidad_medida FROM metrica";
	
	public List<Metrica> consultarMetricas(Connection con){
		
		List<Metrica> lsMetrica = new ArrayList<Metrica>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = con.prepareStatement(SQL_CONSULTA_METRICAS);
			rs = ps.executeQuery();
			while(rs.next()){
				Metrica metrica = new Metrica();
				metrica.setIdMetrica(rs.getInt("id_metrica"));
				metrica.setNombreMetrica(rs.getString("nombre_metrica"));
				metrica.setUnidadMedida(rs.getDouble("unidad_medida"));
				lsMetrica.add(metrica);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			Connector.closeStatement(ps);
			Connector.closeResultSet(rs);
		}
		return lsMetrica;
	}
}
