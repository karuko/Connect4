package tp.pr4.juego;

import tp.pr4.control.ControladorGUI;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Partida;

public class ModoJuegoAutomatico implements ModoJuego{

	Thread t1;
	protected ControladorGUI ctrl;
	private FICHA jugador;
	
	
	 public ModoJuegoAutomatico(ControladorGUI ctrl, FICHA jugador) {
		this.ctrl = ctrl;
		this.jugador = jugador;
	
		
	}
	@Override
	public void comenzar(FICHA turno) {
		if(turno == jugador) {
		 t1 = new Thread() {
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					
				}
				
				ctrl.ponerAleatorio();
			}
			
		 };
		 t1.start();
		}
		
	}

	
	@Override
	public void terminar() {
		if(t1.isAlive())
			t1.interrupt();
	}

	@Override
	public void deshacerPulsado() {
		
	}
	@Override
	public void tableroPulsado(int f, int c) {
	
		
	}



}
