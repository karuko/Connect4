package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;

public class Ayuda implements Comando {

	public Ayuda(){
		
	}
	public void execute(Controlador c) throws ErrorDeEjecucion {
		 System.out.println("Los comandos disponibles son: ");
		 System.out.println(ParserAyudaComandos.AyudaComandos());
	}
	
		public Comando parsea(String[] cadena) {
			
			 
			 if (cadena.length == 1 && cadena[0].equalsIgnoreCase("AYUDA"))
				 return new Ayuda();
			 
			 else return null;
		 
		}
		
		public String textoAyuda() {
		 return "AYUDA: Muestra la ayuda";
		}

}
