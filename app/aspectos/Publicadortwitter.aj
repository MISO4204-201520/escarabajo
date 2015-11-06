package aspectos;

import controllers.ChatApplication;

public aspect Publicadortwitter {
	
	pointcut postwitter(): 
		call(public ChatApplication.index(..));
	
	after() : postwitter(){
		try {
			System.out.println("Valor impuestos ");
			
		} catch (Exception e) {
			
			System.out.println("Valor exeption ");
		}
	}

}
