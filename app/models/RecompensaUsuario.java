package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.format.Formats;

@Entity
@Table(name="recompensa_usuario")
public class RecompensaUsuario extends AppModel{

	@EmbeddedId
	public RecompensaUsuarioPK recompensaUsuarioPK;
	
	@ManyToOne
	public Recompensa recompensa;
	
	@ManyToOne
	public User usuario;
	
	@Formats.DateTime(pattern = "dd-MM-yyyy")
	@Column(name="fecha", nullable=false)
	public Date fecha;
	
	public static AppModel.Finder<Long, RecompensaUsuario> find;

	public RecompensaUsuario() {
		super();
		find = new AppModel.Finder<Long, RecompensaUsuario> (RecompensaUsuario.class);
	}

	public RecompensaUsuario(RecompensaUsuarioPK recompensaUsuarioPK, Date fecha) {
		super();
		find = new AppModel.Finder<Long, RecompensaUsuario> (RecompensaUsuario.class);
		this.recompensaUsuarioPK = recompensaUsuarioPK;
		this.fecha = fecha;
	}
	
}
