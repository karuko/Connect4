package tp.pr4.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.factorias.FactoriaJuego;
import tp.pr4.factorias.FactoriaJuegoComplica;
import tp.pr4.factorias.FactoriaJuegoConecta4;
import tp.pr4.factorias.FactoriaJuegoGravity;
import tp.pr4.factorias.FactoriaJuegoReversi;
import tp.pr4.juego.ModoJuego;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoComplica;
import tp.pr4.reglas.ReglasJuegoConecta4;
import tp.pr4.reglas.ReglasJuegoGravity;
import tp.pr4.reglas.ReglasJuegoReversi;

@SuppressWarnings("serial")
public class ChangeGamePanel extends JPanel implements Observador {
	
	private ControladorGUI ctrl;
	private ReglasJuego juego;
	private FactoriaJuego fac;
	
	private JComboBox<String> tipoJuego;
	private JButton cambiar;
	
	private JPanel tablero;
	private JLabel filas;
	private JLabel columnas;
	private JTextField numFilas;
	private JTextField numCols;
	
	public ChangeGamePanel(ControladorGUI ctrl, Observable<Observador> partida,
			ReglasJuego juego) {
		this.ctrl = ctrl;
		this.juego = juego;
		initGUI();
		partida.addObserver(this);
		
	}

	private void initGUI() {
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Cambio de Juego"));
		
		String[] tipo = {"CONECTA4", "COMPLICA", "GRAVITY", "REVERSI"};
		
		tipoJuego = new JComboBox<String>(tipo);
		tipoJuego.setSelectedItem(3);
		this.add(tipoJuego, BorderLayout.NORTH);
		tipoJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(tipoJuego.getSelectedItem().toString().equals("COMPLICA")){
					juego = new ReglasJuegoComplica();
					fac = new FactoriaJuegoComplica();
					tablero.setVisible(false);
					
				}
				else if(tipoJuego.getSelectedItem().toString().equals("CONECTA4")) {
					juego = new ReglasJuegoConecta4();
					fac = new FactoriaJuegoConecta4();
					tablero.setVisible(false);
					
				}
				else if(tipoJuego.getSelectedItem().toString().equals("GRAVITY")) {
					juego = new ReglasJuegoGravity();
					fac = new FactoriaJuegoGravity();
					tablero.setVisible(true);
				}
				else if(tipoJuego.getSelectedItem().toString().equals("REVERSI")) {
					juego = new ReglasJuegoReversi();
					fac = new FactoriaJuegoReversi();
					tablero.setVisible(false);
					
				}
								
			}
			
		});
		
		cambiar = new JButton("Cambiar");
		this.add(cambiar, BorderLayout.SOUTH);
		cambiar.setIcon(createImageIcon("cambiar.png"));
		cambiar.setToolTipText("Cambiar");
		cambiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numFilas.getText().equalsIgnoreCase("") && numCols.getText().equalsIgnoreCase(""))
					ctrl.cambioJuego(fac, juego);
					
				else
					ctrl.cambioJuego(fac, juego,numFilas.getText(), numCols.getText());
				
				
			}
		});
	
		tablero = new JPanel();
		filas = new JLabel("Filas ");
		columnas = new JLabel("Columnas ");
		numFilas = new JTextField(5);
		numCols = new JTextField(5);
		
		tablero.add(filas);
		tablero.add(numFilas);
		tablero.add(columnas);
		tablero.add(numCols);
	
		tablero.setVisible(false);
		this.add(tablero, BorderLayout.WEST);
		
		

	}
	
	private Icon createImageIcon(String path) {
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
		this.cambiar.setEnabled(false);
		
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
