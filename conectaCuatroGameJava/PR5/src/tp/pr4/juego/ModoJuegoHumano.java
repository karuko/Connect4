package tp.pr4.juego;

import tp.pr4.control.ControladorGUI;
import tp.pr4.logica.FICHA;

public class ModoJuegoHumano implements ModoJuego {

	private ControladorGUI ctrl;

	
	public ModoJuegoHumano(ControladorGUI ctrl) {
		this.ctrl = ctrl;
		
	}
	

	@Override
	public void terminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deshacerPulsado() {
		// ctrl.deshacer misma funcionalidad que tableropulsado().
		ctrl.undo();
	}


	@Override
	public void comenzar(FICHA turno) {
		// TODO Auto-generated method stub
		
	}
	//tableropulsado() se incluye y llama a mouseclicked.


	@Override
	public void tableroPulsado(int f, int c) {
		ctrl.poner(f, c);
		
	}

	

}
