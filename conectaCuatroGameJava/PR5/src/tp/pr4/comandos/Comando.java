package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;

public interface Comando {
	
	void execute(Controlador control) throws ErrorDeEjecucion;
	Comando parsea(String[] cadena);
	String textoAyuda();
	

}
