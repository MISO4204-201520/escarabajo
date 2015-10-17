package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecompensaUsuarioPK {

	@Column(name="id_recompensa", nullable=false)
	public Long idRecompensa;
	
	@Column(name="id_usuario", nullable=false)
	public Long idUsuario;
	
	public int hashCode(){
	    return  idRecompensa.hashCode() * idUsuario.hashCode();
	}
	
	public boolean equals(Object o){
	    if(o == null)                return false;
	    if(!(o instanceof RecompensaUsuarioPK)) return false;

	    RecompensaUsuarioPK other = (RecompensaUsuarioPK) o;
	    if(this.idRecompensa != other.idRecompensa)      return false;
	    if(! this.idUsuario.equals(other.idUsuario)) return false;

	    return true;
	  }
}
