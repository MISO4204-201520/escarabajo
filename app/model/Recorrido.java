package model;

public class Recorrido {

	private int idRecorrido;
	private String nombre;
	private int tipo;
	
	public Recorrido()
	{
		
	}
	
	public Recorrido(int tipo,String nombre){
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public int getIdRecorrido() {
		return idRecorrido;
	}

	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
