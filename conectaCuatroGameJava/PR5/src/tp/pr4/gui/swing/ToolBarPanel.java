package tp.pr4.gui.swing;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;

@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel implements Observador{

	
	private ControladorGUI ctrl;
	private JButton aleatorio;
	private JButton exitButton;
		
	
	
	ToolBarPanel(ControladorGUI ctrl, Observable<Observador> partida){
		this.ctrl = ctrl;
		initGUI();
		partida.addObserver(this);
	}
	

	private void initGUI() {
		
		exitButton = new JButton("Salir");
		exitButton.setIcon(createImageIcon("exit.png"));
		exitButton.setToolTipText("Salir");
		this.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.exit();
				
			}
		});
		
	}


	private static ImageIcon createImageIcon(String path){
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if(imgURL != null) return new ImageIcon(imgURL);
		return null;
	}
	@Override
	public void onReset(TableroInmutable tab, FICHA turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		
		
	}

	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUndoNotPossible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMovimientoIncorrecto(MovimientoInvalido movimientoException) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onError(String s) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onMovimientoStart(FICHA turno) {
		// TODO Auto-generated method stub
		
	}
	
	
}
