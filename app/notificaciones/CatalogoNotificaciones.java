package notificaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.feth.play.module.mail.Mailer;

public class CatalogoNotificaciones implements ICatalogoNotificaciones
{
	
	private CatalogoNotificaciones() {
		super();
	}
	
	@Override
	public void notificacionCambioParticipacionRecorrido(String emailUsuario, String nombreUsuario,
			EstadoParticipacion nuevoEstado) {

		List<String> destinatarios = new ArrayList<String>();
		destinatarios.add (emailUsuario);

		Map<String, DatoNotificacion> contenidos = new HashMap<String, DatoNotificacion>(10);
		DatoNotificacion datoSinDescripcion = new DatoNotificacion();
		datoSinDescripcion.clave = "USUARIO_NAME"  ;
		datoSinDescripcion.informacion = nombreUsuario;
		contenidos.put(datoSinDescripcion.clave, datoSinDescripcion);

		DatoNotificacion datoConDescripcion = new DatoNotificacion();
		datoConDescripcion.clave = "DATO_EJEMPLO_INFORMACION";
		datoConDescripcion.informacion ="Se ha " + (nuevoEstado==EstadoParticipacion.UNIDO_A_RECORRIDO?"UNIDO a":"RETIRADO de") + " un recorrido";
		datoConDescripcion.descripcion ="Ha habido un cambio en el estado de uno de sus recorridos programados";
		contenidos.put(datoConDescripcion.clave,datoConDescripcion);

		DatoNotificacion datoCSS = new DatoNotificacion();
		datoCSS.clave = "DATO_EJEMPLO_CSS";
		datoCSS.informacion = nuevoEstado==EstadoParticipacion.UNIDO_A_RECORRIDO?"#0000ff":"#ff0000";
		contenidos.put(datoCSS.clave,datoCSS);

		Mailer.Mail notificacion = Notificador.crearEmailHtml("Notificación de recorridos", 
				TipoNotificacion.CAMBIO_PARTICIPACION_RECORRIDO, 
				contenidos, 
				destinatarios);

		Notificador.enviarEmail(notificacion);	

	}

	/**
	 * 
	 * @return
	 */
	public static ICatalogoNotificaciones getICatalogoInstance()
	{
		ICatalogoNotificaciones cn = new CatalogoNotificaciones();
		return cn;
	}





}
