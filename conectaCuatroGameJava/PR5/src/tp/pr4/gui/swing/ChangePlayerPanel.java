package tp.pr4.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.juego.ModoJuego;
import tp.pr4.juego.ModoJuegoAutomatico;
import tp.pr4.juego.ModoJuegoHumano;
import tp.pr4.juego.TipoTurno;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.Partida;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;

public class ChangePlayerPanel extends JPanel implements Observador{
	
	private ControladorGUI ctrl;
	
	private JComboBox<String> jugadorNegras;
	private JComboBox<String> jugadorBlancas;
	private JLabel blancas;
	private JLabel negras;
	
	private static ModoJuego juegoNegras;
	private static ModoJuego juegoBlancas;
	private static ModoJuego juego;
	private static TipoTurno turnoActual;
	
	
	

	public ChangePlayerPanel(ControladorGUI ctrl, Observable<Observador> partida) {
		this.ctrl = ctrl;
		juegoNegras = new ModoJuegoHumano(ctrl);
		juegoBlancas = new ModoJuegoHumano(ctrl);
		
		initGUI();
		partida.addObserver(this);
		
		
	}

	private void initGUI() {
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Gestión de jugadores"));
		
		
		String[] tipo = {"HUMANO","AUTOMATICO"};
		
		jugadorNegras = new JComboBox<String>(tipo);
		jugadorNegras.setSelectedItem(1);
		
		jugadorNegras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(jugadorNegras.getSelectedItem().toString().equals("HUMANO")) {
					juegoNegras = new ModoJuegoHumano(ctrl);
					turnoActual = TipoTurno.HUMANO;
					juego = juegoNegras;
				}
				else if(jugadorNegras.getSelectedItem().toString().equals("AUTOMATICO")) {
					juegoNegras = new ModoJuegoAutomatico(ctrl,FICHA.NEGRA);
					turnoActual = TipoTurno.AUTOMATICO;
					juego = juegoNegras;
				}
					

			}
		});
		
		
		jugadorBlancas = new JComboBox<String>(tipo);
		jugadorBlancas.setSelectedItem(1);
		
		jugadorBlancas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jugadorBlancas.getSelectedItem().toString().equals("HUMANO")) {
					juegoBlancas = new ModoJuegoHumano(ctrl);
					turnoActual = TipoTurno.HUMANO;
					juego = juegoNegras;
				}
				else if (jugadorBlancas.getSelectedItem().toString().equals("AUTOMATICO")) {
					juegoBlancas = new ModoJuegoAutomatico(ctrl,FICHA.BLANCA);
					turnoActual = TipoTurno.AUTOMATICO;
					juego = juegoNegras;
				}
					
				
			}
		});
		
		negras = new JLabel("Jugador de negras ");
		blancas = new JLabel("Jugador de blancas");
		
		JPanel panelNegras = new JPanel();
		panelNegras.add(negras);
		panelNegras.add(jugadorNegras, BorderLayout.EAST);
		
		JPanel panelBlancas = new JPanel();
		panelBlancas.add(blancas);
		panelBlancas.add(jugadorBlancas, BorderLayout.EAST);
		
		this.add(panelNegras, BorderLayout.NORTH);
		this.add(panelBlancas, BorderLayout.SOUTH);



		
	}
	
	private void comenzar(FICHA turno) {
		juegoBlancas.comenzar(turno);
		juegoNegras.comenzar(turno);
	}
	private void terminar() {
		juegoBlancas.terminar();
		juegoNegras.terminar();
	}
	static public ModoJuego getModoJuegoNegras() {
		return juegoNegras;
	}
	static public ModoJuego getModoJuegoBlancas() {
		return juegoBlancas;
	}
	static public TipoTurno getTipoTurno() {
		return turnoActual;
	}

	@Override
	public void onReset(TableroInmutable tab, FICHA turno) {
		//Aqui comienza la partida con los nuevos cambios.
		this.comenzar(turno);
	
		
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		// TODO Auto-generated method stub
		this.terminar();
	}

	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		
		
	}

	@Override
	public void onUndoNotPossible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		
		this.comenzar(turno);
		this.terminar();
	}

	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		
		this.comenzar(turno);
		
		
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
	
		
	}

}
