package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.format.Formats;

/**
 * jm.soto569
 * Los retos cumplidos por el usuario
 */
@Entity
@Table(name = "retos_usuario")
public class RetosUsuario extends AppModel{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	public RetosUsuarioPK retosUsuarioPK;

	@Formats.DateTime(pattern = "dd-MM-yyyy")
	@Column(name="fecha")
	public Date fecha;
	
	@Column(name="nombre", nullable=false)
	public String nombre;
	
	@Column(name="estado", nullable=false)
	public String estado;
	
	@ManyToOne
	public User usuario;
	
	@ManyToOne
	public Reto reto;

	public static AppModel.Finder<Long, RetosUsuario> find;
	
	public  RetosUsuario() {
		super();
		find = new AppModel.Finder<Long, RetosUsuario> (RetosUsuario.class);
	}

}
