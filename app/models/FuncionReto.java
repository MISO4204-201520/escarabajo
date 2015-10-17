package models;

public enum FuncionReto {

	MAX("max"),
	MIN("min"),
	PROMEDIO("avg"),
	CONTAR("count"),
	SUMA("sum");
	
	private String funcion;
	
	private FuncionReto(String funcion){
		this.funcion = funcion;
	}
	
	public String getFuncion(){
		return funcion;
	}
}
