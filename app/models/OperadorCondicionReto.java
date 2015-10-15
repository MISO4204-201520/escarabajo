package models;

public enum OperadorCondicionReto {

	MAYOR(">"),
	MAYOR_O_IGUAL(">="),
	MENOR("<"),
	MENOR_O_IGUAL("<="),
	IGUAL("="),
	DIFERENTE("!=");
	
	private String operador;
	
	private OperadorCondicionReto(String operador){
		this.operador = operador;
	}
	
	public String getOperador(){
		return operador;
	}
}
