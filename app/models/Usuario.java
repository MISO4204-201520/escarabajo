package models;

import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.avaje.ebean.Model;

@Entity
@Table(name="usuario")
public class Usuario extends Model{

	@EmbeddedId
	private UsuarioPK usuarioPK;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="email", nullable=false)
	private String email;
	
	public static Finder<UsuarioPK, Usuario> find;
	
	public Usuario(){
		super();
		find = new Finder<UsuarioPK, Usuario>(Usuario.class);
	}

	public Usuario(UsuarioPK usuarioPK, String nombre, String email) {
		super();
		this.usuarioPK = usuarioPK;
		this.nombre = nombre;
		this.email = email;
	}

	public UsuarioPK getUsuarioPK() {
		return usuarioPK;
	}

	public void setUsuarioPK(UsuarioPK usuarioPK) {
		this.usuarioPK = usuarioPK;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
