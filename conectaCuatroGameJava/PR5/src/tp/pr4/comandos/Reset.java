package tp.pr4.comandos;

import tp.pr4.control.Controlador;
import tp.pr4.excepciones.ErrorDeEjecucion;

public class Reset implements Comando {

	public Reset(){
		
	}
	@Override
	public void execute(Controlador control) throws ErrorDeEjecucion {
		control.reset();
		
	}

	@Override
	public Comando parsea(String[] cadena) {
		 if (cadena.length==1 && cadena[0].equalsIgnoreCase("REINICIAR"))
			 return new Reset();
		 
		 else return null;
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return null;
	}

}
