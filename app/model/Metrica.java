package model;

public class Metrica {
	
	private int idMetrica;
	private String nombreMetrica;
	private double unidadMedida;
	
	public Metrica(){
		
	}

	public Metrica(int idMetrica, String nombreMetrica, double unidadMedida) {
		super();
		this.idMetrica = idMetrica;
		this.nombreMetrica = nombreMetrica;
		this.unidadMedida = unidadMedida;
	}

	public int getIdMetrica() {
		return idMetrica;
	}

	public void setIdMetrica(int idMetrica) {
		this.idMetrica = idMetrica;
	}

	public String getNombreMetrica() {
		return nombreMetrica;
	}

	public void setNombreMetrica(String nombreMetrica) {
		this.nombreMetrica = nombreMetrica;
	}

	public double getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(double unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	

}
