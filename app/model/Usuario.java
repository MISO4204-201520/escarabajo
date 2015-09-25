package model;

public class Usuario {

	private int idUsuario;
	private String username;
	private String nombre;
	private String email;
	
	public Usuario(){
		
	}

	public Usuario(int idUsuario, String username, String nombre, String email) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.nombre = nombre;
		this.email = email;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
