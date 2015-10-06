package models;

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
@Table(name="sitio_de_alquiler")
public class SitioDeAlquiler extends Model {

	@Id
	@Column(name="id_sitio", nullable=false)
	private Long idSitio;  
	
	@Column(name="nombre", nullable=false, unique=true)
	private String nombre;
	
	@Column(name="indicativo_telefono_fijo")
	private String indicativoTelefonoFijo;
	
	@Column(name="telefono_fijo")
	private String telefonoFijo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="celular")
	private String celular;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sitioDeAlquiler")
	private List<Estacion> estaciones;	
	
	@ManyToOne
	private User usuario;
	
	public static Finder<Long, SitioDeAlquiler> find;
	
	public SitioDeAlquiler(Long idSitio, String nombre, String indicativoTelefonoFijo, String telefonoFijo,
			String email, String celular, List<Estacion> estaciones, User usuario) {
		super();
		find = new Finder<Long, SitioDeAlquiler>(SitioDeAlquiler.class);
		this.idSitio = idSitio;
		this.nombre = nombre;
		this.indicativoTelefonoFijo = indicativoTelefonoFijo;
		this.telefonoFijo = telefonoFijo;
		this.email = email;
		this.celular = celular;
		this.estaciones = estaciones;
		this.usuario = usuario;
	}
	
	public SitioDeAlquiler() {
		super();
		find = new Finder<Long, SitioDeAlquiler>(SitioDeAlquiler.class);
		estaciones = new ArrayList<Estacion>();
	}

	public Long getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(Long idSitio) {
		this.idSitio = idSitio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

}
