package models;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RetoUsuarioPK {
	
	/*@Column(name="id_reto", nullable=false)
	public Long idReto;
	
	@Column(name="id_usuario", nullable=false)
	public Long idUsuario;*/
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	public Long idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "id_reto", referencedColumnName = "id")
	public Long idReto;
	
	public int hashCode(){
	    return  idUsuario.hashCode() * idReto.hashCode();
	}
	
	public boolean equals(Object o){
	    if(o == null)                return false;
	    if(!(o instanceof RetoUsuarioPK)) return false;

	    RetoUsuarioPK other = (RetoUsuarioPK) o;
	    if(this.idReto != other.idReto)      return false;
	    if(! this.idUsuario.equals(other.idUsuario)) return false;

	    return true;
	  }
	
	
}
