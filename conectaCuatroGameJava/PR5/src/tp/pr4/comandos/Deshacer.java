package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;

public class Deshacer implements Comando {

	public Deshacer(){
		
	}
	@Override
	public void execute(Controlador control) throws ErrorDeEjecucion {
		control.undo();
		
	}

	@Override
	public Comando parsea(String[] cadena) {
		if (cadena.length==1 && cadena[0].equalsIgnoreCase("DESHACER"))
			 return new Deshacer();
		 
		 else return null;
	}

	@Override
	public String textoAyuda() {
		String text = "DESHACER: Deshace el último movimiento hecho en la partida.";
		return text;
	}

}
