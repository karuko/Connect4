package tp.pr4.comandos;


import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.factorias.FactoriaJuegoComplica;
import tp.pr4.factorias.FactoriaJuegoConecta4;
import tp.pr4.factorias.FactoriaJuegoGravity;

public class Jugar implements Comando {
	
	
	private int f;
	private int c;
	private FactoriaJuego factoria;
	
	 public Jugar(){}
	 
	 
	 public Jugar(FactoriaJuego juego, int n1 , int n2){
		 
		 this.factoria = juego;		 
		 this.f = n1;
		 this.c = n2;
	 }
	 
	 public Jugar(FactoriaJuego juego) {
		 this.factoria = juego;
	 }
	 
	 // resto de la implementación
	@Override
	public void execute(Controlador control) throws ErrorDeEjecucion {
		control.jugar(factoria,f,c);
		
	}
	@Override
	public Comando parsea(String[] cadena) {
		
//		if (cadena.length==2 && cadena[0].equalsIgnoreCase("JUGAR") && (cadena[1].equalsIgnoreCase("CO") || cadena[1].equalsIgnoreCase("C4") || cadena[1].equalsIgnoreCase("GR")))
//			 return new Jugar(cadena[1]);
		
		if(cadena.length == 2 && cadena[0].equalsIgnoreCase("JUGAR") && (cadena[1].equalsIgnoreCase("C4")))
			return new Jugar(new FactoriaJuegoConecta4());
		else if(cadena.length == 2 && cadena[0].equalsIgnoreCase("JUGAR") && (cadena[1].equalsIgnoreCase("CO")))
			return new Jugar(new FactoriaJuegoComplica());
		else if(cadena.length == 2 && cadena[0].equalsIgnoreCase("JUGAR") && (cadena[1].equalsIgnoreCase("GR")))
			return new Jugar(new FactoriaJuegoGravity(), 10, 10);
		else if(cadena.length == 4 && cadena[0].equalsIgnoreCase("JUGAR") && (cadena[1].equalsIgnoreCase("GR") && Number.isNumber(cadena[2]) && Number.isNumber(cadena[3])))
			return new Jugar(new FactoriaJuegoGravity(),Integer.parseInt(cadena[2]), Integer.parseInt(cadena[3]));

		
		else return null;
	}
	@Override
	public String textoAyuda() {
		String text = "JUGAR: [c4|co|gr] [tamX tamY]: cambia el tipo de juego.";
		return text;
	}
	
	
}
