package models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RetosUsuarioPK {
	
	@Column(name="id_reto", nullable=false)
	public Long idReto;
	
	@Column(name="id_usuario", nullable=false)
	public Long idUsuario;
	
	public int hashCode(){
	    return  idReto.hashCode() * idUsuario.hashCode();
	}
	
	public boolean equals(Object o){
	    if(o == null)                return false;
	    if(!(o instanceof RetosUsuarioPK)) return false;

	    RetosUsuarioPK other = (RetosUsuarioPK) o;
	    if(this.idReto != other.idReto)      return false;
	    if(! this.idUsuario.equals(other.idUsuario)) return false;

	    return true;
	  }
	
	
}
