package notificaciones;

public class DatoNotificacion {

	/**
	 * Computer Friendly - USAR FORMATO DE CONSTATE	
	 * Nombre/identificador del campo para hacer el mapping con el templade de notificaciones
	 */
	public String nombreID;
		
	/**
	 * Informacion que se quiere dar al usuario. 
	 * (un texto, el string de un entero,  puede incluir incluso
	 * cosas con HTML)
	 */
	public String informacion;
	
	
	/**
	 * Human Friendly - Descripcion de la informacion que contiene el campo de informacion
	 * (opcional)
	 */
	public String descripcion;
	
	

	public DatoNotificacion() {
		super();
	}

	/**
	 * Crea una no
	 * @param nombreID
	 * @param informacion
	 */
	public DatoNotificacion(String nombreID, String informacion) {
		super();
		this.nombreID = nombreID;
		this.informacion = informacion;
	}

	public DatoNotificacion(String nombreID, String informacion, String descripcion) {
		super();
		this.nombreID = nombreID;
		this.informacion = informacion;
		this.descripcion = descripcion;
	}
	
	
	
		
}
