package tp.pr4.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.juego.ModoJuego;
import tp.pr4.juego.TipoTurno;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;

@SuppressWarnings("serial")
public class PartidaPanel extends JPanel implements Observador{

	
	
	private ControladorGUI ctrl;
	private JButton deshacer;
	private JButton reset;
	
	private boolean flag = true;
	private TipoTurno tipoTurno;
	private ModoJuego juegoNegras, juegoBlancas, juego;
	
	
	public PartidaPanel(ControladorGUI ctrl, Observable<Observador> partida) {
		this.ctrl = ctrl;
		initGUI();
		partida.addObserver(this);
		
	}

	
	private void initGUI() {
		
		
		this.setBorder(new TitledBorder("Partida"));
		
		deshacer = new JButton("Deshacer");
		deshacer.setIcon(createImageIcon("deshacer.png"));
		deshacer.setToolTipText("Deshacer");
		this.add(deshacer);
		deshacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				juego.deshacerPulsado();
				
			}
		});
		
		reset = new JButton("Reiniciar");
		reset.setIcon(createImageIcon("reiniciar.png"));
		reset.setToolTipText("Reiniciar");
		this.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.reset();
				
			}
		});
	}

	private Icon createImageIcon(String path) {
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if(imgURL != null) return new ImageIcon(imgURL);
		return null;
	}
	
	private void turnoActual(FICHA ficha) {
		
		juegoBlancas = ChangePlayerPanel.getModoJuegoBlancas();
		juegoNegras = ChangePlayerPanel.getModoJuegoNegras();
		
		if(ficha == FICHA.BLANCA){
			
			juego = juegoBlancas;
		}
		else if(ficha == FICHA.NEGRA) {
			juego = juegoNegras;
		
		}
	}



	@Override
	public void onReset(TableroInmutable tab, FICHA turno) {
		turnoActual(turno);
		
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		deshacer.setEnabled(false);
		reset.setEnabled(false);
		
	}

	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUndoNotPossible() {
		deshacer.setEnabled(false);
		
	}

	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		
		if(!hayMas)
			deshacer.setEnabled(false);
		
		
	}

	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		
		turnoActual(turno);
		deshacer.setEnabled(true);
		
		
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
		turnoActual(turno);
		
	}


	
	
}
