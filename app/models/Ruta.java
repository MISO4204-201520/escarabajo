package models;

import java.util.Date;

public class Ruta {
	
	private int idRuta;
	private int idRecorrido;
	private Date fechaInicioRuta;
	private Date fechaFinRuta;
	private float latitudInicio;
	private float longitudInicio;
	private float latitudFin;
	private float longitudFin;
	private String lugarInicio;
	private String lugarFin;
	
	
	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
	public int getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	public Date getFechaInicioRuta() {
		return fechaInicioRuta;
	}
	public void setFechaInicioRuta(Date fechaInicioRuta) {
		this.fechaInicioRuta = fechaInicioRuta;
	}
	public Date getFechaFinRuta() {
		return fechaFinRuta;
	}
	public void setFechaFinRuta(Date fechaFinRuta) {
		this.fechaFinRuta = fechaFinRuta;
	}
	public float getLatitudInicio() {
		return latitudInicio;
	}
	public void setLatitudInicio(float latitudInicio) {
		this.latitudInicio = latitudInicio;
	}
	public float getLongitudInicio() {
		return longitudInicio;
	}
	public void setLongitudInicio(float longitudInicio) {
		this.longitudInicio = longitudInicio;
	}
	public float getLatitudFin() {
		return latitudFin;
	}
	public void setLatitudFin(float latitudFin) {
		this.latitudFin = latitudFin;
	}
	public float getLongitudFin() {
		return longitudFin;
	}
	public void setLongitudFin(float longitudFin) {
		this.longitudFin = longitudFin;
	}
	public String getLugarInicio() {
		return lugarInicio;
	}
	public void setLugarInicio(String lugarInicio) {
		this.lugarInicio = lugarInicio;
	}
	public String getLugarFin() {
		return lugarFin;
	}
	public void setLugarFin(String lugarFin) {
		this.lugarFin = lugarFin;
	}
}
