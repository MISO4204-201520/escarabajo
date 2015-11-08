package notificaciones;

public interface ICatalogoNotificaciones {

	
	public enum EstadoParticipacion{
		UNIDO_A_RECORRIDO,
		RETIRADO_DE_RECORRIDO
	}		
	
	
	public enum TipoNotificacion {
		
		CAMBIO_PARTICIPACION_RECORRIDO ("views.html.notifications.templates.notificacion_cambio_participacion"), 
		INVITACION_A_UN_RECORRIDO ("views.html.notifications.templates.notification_invitacion_recorrido"), 
		ALCANCE_DE_UN_NUEVO_RETO ("views.html.notifications.templates.notification_alcance_reto"), 
		RECLAMO_DE_RECOMPENSA ("views.html.notifications.templates.notification_reclamo_recompensa");

		private final String templateNotificacion;

		private TipoNotificacion(String templateNotificacion) {
			this.templateNotificacion = templateNotificacion;

		}
		public String getNombreTemplate() {
			return templateNotificacion;
		}
		
	}
	
	/**
	 * 
	 * @param emailUsuario
	 * @param nombreUsuario
	 * @param nuevoEstado
	 */
	public void notificacionCambioParticipacionRecorrido(String emailUsuario, String nombreUsuario, 
			EstadoParticipacion nuevoEstado);
}
