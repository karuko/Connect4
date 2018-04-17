package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.logica.FICHA;

public class PonJugador implements Comando {
	
	 private FICHA color;
	 private String tipoJugador;
	 
	 public PonJugador(FICHA c, String j) {
		 this.color = c;
		 this.tipoJugador = j;
	 }
	 public PonJugador() {}
	 
	 public void execute(Controlador control) {
		 control.jugador(color,tipoJugador);
	 // manda al controlador que ponga el tipo de jugador y la ficha
	 }
	 // resto de código
	@Override
	public Comando parsea(String[] cadena) {
		if (cadena.length==3 && cadena[0].equalsIgnoreCase("JUGADOR") && cadena[1].equalsIgnoreCase("BLANCAS") 
				&& (cadena[2].equalsIgnoreCase("HUMANO") || cadena[2].equalsIgnoreCase("ALEATORIO")))
			 return new PonJugador(FICHA.BLANCA, cadena[2]);
		
		else if( cadena.length==3 && cadena[0].equalsIgnoreCase("JUGADOR") && cadena[1].equalsIgnoreCase("NEGRAS") 
				&& (cadena[2].equalsIgnoreCase("HUMANO") || cadena[2].equalsIgnoreCase("ALEATORIO")))	
			 return new PonJugador(FICHA.NEGRA, cadena[2]);		
				
		 else return null;
	}
	@Override
	public String textoAyuda() {
		String text = "JUGADOR: [blancas|negras] [humano|aleatorio]: cambia el tipo de jugador.";
		return text;
	}

}
