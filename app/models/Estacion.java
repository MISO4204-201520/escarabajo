package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import scala.Array;

import com.avaje.ebean.Model;


@Entity
@Table(name="estacion")
public class Estacion extends Model {	      

	@Id
	@Column(name="id_estacion", nullable=false)
	private Long idEstacion;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="lugar")
	private String lugar;
	
	@Column(name="latitud")
	private double latitud;
	
	@Column(name="longitud")
	private double longitud;
	
	@Column(name="tarifa_x_h")
	private int tarifaXhora;
	
	@Column(name="hora_inicio_atencion")
	private Timestamp horaInicioAtencion;
	
	@Column(name="hora_fin_atencion")
	private Timestamp horaFinAtencion;
	
	@Column(name="para_alquiler")
	private boolean paraAlquiler;
	
	@Column(name="para_entrega")
	private boolean paraEntrega;
	
	@Column(name="indicativo_telefono_fijo")
	private String indicativoTelefonoFijo;
	
	@Column(name="telefono_fijo")
	private String telefonoFijo;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="dia_frecuente")
	private String diaFrecuente; 
		
	@ManyToOne
	private SitioDeAlquiler sitioDeAlquiler;
	
	public static Finder<Long, Estacion> find;
	
	public Estacion() {
		super();
		find = new Finder<Long, Estacion>(Estacion.class);
	}

	public Estacion(Long idEstacion, String nombre, String lugar, double latitud, double longitud, int tarifaXhora,
			Timestamp horaInicioAtencion, Timestamp horaFinAtencion, boolean paraAlquiler, boolean paraEntrega,
			String indicativoTelefonoFijo, String telefonoFijo, String celular, String diaFrecuente,
			SitioDeAlquiler sitioDeAlquiler) {
		super();
		find = new Finder<Long, Estacion>(Estacion.class);
		this.idEstacion = idEstacion;
		this.nombre = nombre;
		this.lugar = lugar;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tarifaXhora = tarifaXhora;
		this.horaInicioAtencion = horaInicioAtencion;
		this.horaFinAtencion = horaFinAtencion;
		this.paraAlquiler = paraAlquiler;
		this.paraEntrega = paraEntrega;
		this.indicativoTelefonoFijo = indicativoTelefonoFijo;
		this.telefonoFijo = telefonoFijo;
		this.celular = celular;
		this.diaFrecuente = diaFrecuente;
		this.sitioDeAlquiler = sitioDeAlquiler;
	}

	public Long getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public int getTarifaXhora() {
		return tarifaXhora;
	}

	public void setTarifaXhora(int tarifaXhora) {
		this.tarifaXhora = tarifaXhora;
	}

	public Timestamp getHoraInicioAtencion() {
		return horaInicioAtencion;
	}

	public void setHoraInicioAtencion(Timestamp horaInicioAtencion) {
		this.horaInicioAtencion = horaInicioAtencion;
	}

	public Timestamp getHoraFinAtencion() {
		return horaFinAtencion;
	}

	public void setHoraFinAtencion(Timestamp horaFinAtencion) {
		this.horaFinAtencion = horaFinAtencion;
	}

	public boolean isParaAlquiler() {
		return paraAlquiler;
	}

	public void setParaAlquiler(boolean paraAlquiler) {
		this.paraAlquiler = paraAlquiler;
	}

	public boolean isParaEntrega() {
		return paraEntrega;
	}

	public void setParaEntrega(boolean paraEntrega) {
		this.paraEntrega = paraEntrega;
	}

	public String getIndicativoTelefonoFijo() {
		return indicativoTelefonoFijo;
	}

	public void setIndicativoTelefonoFijo(String indicativoTelefonoFijo) {
		this.indicativoTelefonoFijo = indicativoTelefonoFijo;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDiaFrecuente() {
		return diaFrecuente;
	}

	public void setDiaFrecuente(String diaFrecuente) {
		this.diaFrecuente = diaFrecuente;
	}

	public SitioDeAlquiler getSitioDeAlquiler() {
		return sitioDeAlquiler;
	}

	public void setSitioDeAlquiler(SitioDeAlquiler sitioDeAlquiler) {
		this.sitioDeAlquiler = sitioDeAlquiler;
	}
	
	
	
}
