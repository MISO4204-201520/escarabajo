package models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RecompensaUsuarioPK {

	@ManyToOne
	@JoinColumn(name = "id_recompensa", referencedColumnName = "id")
	public Long idRecompensa;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
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
