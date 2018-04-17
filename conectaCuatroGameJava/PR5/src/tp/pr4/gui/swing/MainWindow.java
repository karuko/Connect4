package tp.pr4.gui.swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.juego.ModoJuego;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;
import tp.pr4.reglas.ReglasJuego;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements Observador {
	
	private ControladorGUI ctrl;
	private Observable<Observador> partida;
	private TableroSoloLectura tab;
	private ReglasJuego juego;
	private BoardPanel boardView;
	private ToolBarPanel toolBar;
	private PartidaPanel partidaView;
	private ChangeGamePanel changeGameView;
	private ChangePlayerPanel changePlayerView;


	public MainWindow(ControladorGUI ctrl, Observable<Observador> partida, TableroSoloLectura tab) {
		super("tablero");
		this.ctrl = ctrl;
		this.partida = partida;
		this.tab = tab;
	
		initGUI();
		partida.addObserver(this);
		
	}
	
	
	private void reportError(String msg, String title){
		JOptionPane.showMessageDialog(new JFrame(), msg, title,
				JOptionPane.ERROR_MESSAGE);
	}; 
	
	private void initGUI() {
		
		this.setLayout(new BorderLayout());
		
		boardView = new BoardPanel(ctrl, partida, tab);
		toolBar = new ToolBarPanel(ctrl,partida);
		partidaView = new PartidaPanel(ctrl, partida);
		changeGameView = new ChangeGamePanel(ctrl, partida, juego);
		changePlayerView = new ChangePlayerPanel(ctrl, partida);
		
		
		
		//Hemos elegido esta forma para colocarlo todo porque de la otra manera se descuadra.
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 1; c.gridheight = 3;
		c.weightx = 0.5; c.weighty = 0.5;
		mainPanel.add(boardView, c);
		
		c.gridx = 0; c.gridy = 3;
		c.gridwidth = 3; c.gridheight = 1;
		c.weightx = 0; c.weighty = 0;
		mainPanel.add(toolBar, c);
		
		c.gridx = 2; c.gridy = 0;
		c.gridwidth = 1; c.gridheight = 1;
		c.weightx = 0; c.weighty = 0;
		mainPanel.add(partidaView, c);
		
		c.gridx = 2; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 1;
		c.weightx = 0.2; c.weighty = 0.2;
		mainPanel.add(changePlayerView, c);
		
		c.gridx = 2; c.gridy = 2;
		c.gridwidth = 1; c.gridheight = 1;
		c.weightx = 0.1; c.weighty = 0.1;
		mainPanel.add(changeGameView, c);
		
		
		
		
		this.setContentPane(mainPanel);
		
		this.addWindowListener(new WindowAdapter() {
	
			@Override
			public void windowClosing(WindowEvent e) {
				
					ctrl.exit();
			}
			
		});
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}




	@Override
	public void onReset(TableroInmutable tab, FICHA turno) {
		
		
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		this.tab = tab;
		
	}

	@Override
	public void onUndoNotPossible() {
		this.reportError("No se puede deshacer", "Deshacer");
		
	}

	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		
		
	}

	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMovimientoIncorrecto(MovimientoInvalido movimientoException) {
		this.reportError(movimientoException.toString(), "Movimiento incorrecto");
		
	}


	@Override
	public void onError(String s) {
		this.reportError(s, "Movimiento incorrecto");
		
	}



	@Override
	public void onMovimientoStart(FICHA turno) {
		// TODO Auto-generated method stub
		
	}

}
