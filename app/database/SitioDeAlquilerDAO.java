package database;

import java.util.List;

import models.Recorrido;
import models.SitioDeAlquiler;
import models.User;

public class SitioDeAlquilerDAO {
	
	public List<SitioDeAlquiler> listarSitiosDeAlquiler(){
		return SitioDeAlquiler.find.all();
	}	
	
	/**
	 * Agrega un sitio de alquiler a la BD 
	 * 
	 * @param sitio El sitio de alquiler
	 */
	public void agregarSitioDeAlquiler(SitioDeAlquiler sitio){
		sitio.save();
	}
	
	public void actualizarSitioDeAlquiler(SitioDeAlquiler sitio){
		SitioDeAlquiler sitioActual = consultarSitioDeAlquilerPorId(sitio.getIdSitio());
		sitioActual.setIndicativoTelefonoFijo(sitio.getIndicativoTelefonoFijo());
		sitioActual.setTelefonoFijo(sitio.getTelefonoFijo());
		sitioActual.setEmail(sitio.getEmail());
		sitioActual.setNombre(sitio.getNombre());
		sitioActual.setCelular(sitio.getCelular());
		sitioActual.setEstaciones(sitio.getEstaciones());
		sitioActual.save();
	}
	
	public void eliminarSitioDeAlquiler(SitioDeAlquiler sitio){
		SitioDeAlquiler sitioActual = consultarSitioDeAlquilerPorId(sitio.getIdSitio());
		sitioActual.delete();
	}
	
	public SitioDeAlquiler consultarSitioDeAlquilerPorId(Long id){
		return SitioDeAlquiler.find.byId(id);
	}
	
	public List<SitioDeAlquiler> consultarSitioDeAlquilerPorNombre(String nombre){
		return SitioDeAlquiler.find.where().eq("nombre", nombre).findList();
	}
	
	public List<SitioDeAlquiler> consultarSitiosDeAlquilerPorUsuario(User usuario){
		return SitioDeAlquiler.find.where().eq("usuario", usuario).findList();
	}

}
