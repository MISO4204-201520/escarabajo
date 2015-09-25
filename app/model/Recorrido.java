package model;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {

	private int idRecorrido;
	private int tipo;
	private String nombre;
	private String horaSalida;
	public List<String> diasRecorrido = new ArrayList<>(); 
	private String lugarSalida;
	private String lugarLlegada;
	
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

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public List<String> getDiasRecorrido() {
		return diasRecorrido;
	}

	public void setDiasRecorrido(List<String> diasRecorrido) {
		this.diasRecorrido = diasRecorrido;
	}

	public String getLugarSalida() {
		return lugarSalida;
	}

	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}

	public String getLugarLlegada() {
		return lugarLlegada;
	}

	public void setLugarLlegada(String lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}
	
	
}
