package database;

import java.util.List;

import models.Reto;

public class RetoDAO {
	
	public List<Reto> listarRetosActivos(){
		return Reto.find.where().eq("estado", "activo").findList();
	}	
	
	public void agregarReto(Reto reto){
		reto.save();
	}
	
	public void actualizarReto(Reto reto){
		Reto retoActual = consultarRetoPorId(reto.id);
		/*
		retoActual.estado = reto.estado;
		retoActual.fechaFin = reto.fechaFin;
		retoActual.fechaIni = reto.fechaIni;
		retoActual.funcion = reto.funcion;
		retoActual.id = reto.id;
		retoActual.metrica = reto.metrica;
		retoActual.nombre = reto.nombre;
		retoActual.operador = reto.operador;
		retoActual.puntaje = reto.puntaje;
		retoActual.valorCondicion = reto.valorCondicion;
		*/
		retoActual = reto;
		retoActual.save();
	}
	
	public void eliminarSitioDeAlquiler(Reto reto){
		Reto retoBorrar = consultarRetoPorId(reto.id);
		retoBorrar.delete();
	}
	
	public Reto consultarRetoPorId(Long id){
		return Reto.find.byId(id);
	}	

}
