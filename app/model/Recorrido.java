package model;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {

	private int idRecorrido;
	private int tipo;
	private String nombre;
	private String descripcion;
	private String horaFrecuente;
	private String diaFrecuente; 
		
	public Recorrido()
	{
		
	}
	
	public Recorrido(int tipo,String nombre){
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public int getIdRecorrido() {
		return idRecorrido;
	}

	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getDiaFrecuente() {
		return diaFrecuente;
	}

	public void setDiaFrecuente(String diaFrecuente) {
		this.diaFrecuente = diaFrecuente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHoraFrecuente() {
		return horaFrecuente;
	}

	public void setHoraFrecuente(String horaFrecuente) {
		this.horaFrecuente = horaFrecuente;
	}

	
}
