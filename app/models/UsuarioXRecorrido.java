package models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

public class UsuarioXRecorrido extends Model {

	@Id
	@Column(name="id_usuario_recorrido", nullable=false)
	private Long idUsuarioXRecorrido;
	
	@ManyToOne
	@Column(nullable=false)
	private User usuario;

	@ManyToOne
	@Column(nullable=false)
	private Recorrido recorrido;
}
