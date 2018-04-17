package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;

public class Salir implements Comando {

	public Salir(){
		
	}
	@Override
	public void execute(Controlador control) throws ErrorDeEjecucion {
		// le indica al controlador que termine el juego
		control.exit();
	}

	@Override
	public Comando parsea(String[] cadena) {
		 if (cadena.length==1 && cadena[0].equalsIgnoreCase("SALIR"))
			 return new Salir();
		 
		 else return null;
		
	}

	@Override
	public String textoAyuda() {
		String text = "SALIR: Termina la aplicación.";
		return text;
	}
	

}
