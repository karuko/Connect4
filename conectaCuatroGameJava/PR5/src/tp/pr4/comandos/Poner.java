package tp.pr4.comandos;


import tp.pr4.control.Controlador;
public class Poner implements Comando {

	
	public Poner(){}
	
	@Override
	public void execute(Controlador control){
		
			control.poner();
		
	}

	@Override
	public Comando parsea(String[] cadena) {
		 
		 if (cadena.length==1 && cadena[0].equalsIgnoreCase("PONER"))
			 return new Poner();
		 
		 else return null;
	}

	@Override
	public String textoAyuda() {
		String text = "PONER : Utilízalo para poner la siguiente ficha.";
		return text;
	}
// el método execute le pide al controlador que ejecute
// el movimiento
	

}
