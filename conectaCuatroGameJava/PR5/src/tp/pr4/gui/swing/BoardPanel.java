package tp.pr4.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import tp.pr4.control.ControladorGUI;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.juego.ModoJuego;
import tp.pr4.juego.ModoJuegoHumano;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Observable;
import tp.pr4.logica.Observador;
import tp.pr4.logica.TableroInmutable;
import tp.pr4.logica.TableroSoloLectura;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements Observador {

	GridBagConstraints c;
	boolean active;
	private ControladorGUI ctrl;
	private TableroSoloLectura tab;
	private ModoJuego juegoNegras, juegoBlancas, juego;
	
	
	
	private static final int AnchoCelda = 50;
	private static final int AltoCelda = 50;
	private int numCols;
	private int numFilas;
	private String turnoActual = "Blancas";
	private boolean terminada = false;
	
	
	
	
	//Swing
	private JTextArea text;
    Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	public BoardPanel(ControladorGUI ctrl, Observable<Observador> partida, TableroSoloLectura tab) {
		this.ctrl = ctrl;
		this.tab = tab;
		this.juego = new ModoJuegoHumano(ctrl);
		initGUI();
		partida.addObserver(this);

	}

	private void initGUI() {
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		numCols = tab.getColumnas();
		numFilas = tab.getFilas();
		
		this.setPreferredSize(new Dimension(numCols * AnchoCelda + 1, numFilas
				* AltoCelda + 1));
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				//Flag que invalide esto cuando este ejecutando automatico. Pararcurrent flag [false][true]
				 if(!terminada ) {
					int col = e.getX() / AltoCelda;
					int fila = e.getY() / AnchoCelda;
					
						juego.tableroPulsado(fila+1, col+1);

				}

			}
			
			
		});
		
		
		text = new JTextArea();
		text.setOpaque(true);
		this.mostrarTurno(turnoActual);
		text.setFont(new Font("Arial", Font.BOLD, 18));
		text.setForeground(Color.blue);
		text.setEditable(false);
		text.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
				this.add(text, BorderLayout.SOUTH);
		
		
		
		repaint();
	}
	
	private void mostrarTurno(String s) {
		text.setText("Juegan " + s);
	}
	private void mostrarGanador(String s) {
		text.setText("Ganan las " + s);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (tab != null)
			fillBoard(g);
	}

	private void fillBoard(Graphics g) {
		

		for (int i = 0; i < numFilas; i++)
			for (int j = 0; j < numCols; j++) {
				drawCell(i, j, g);
			}
	}

	private void drawCell(int row, int col, Graphics g) {
		
		int x = col * AnchoCelda;
		int y = row * AltoCelda;
		

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x + 2, y + 2, AnchoCelda - 2, AltoCelda - 2);

		FICHA p = tab.getCasilla(row, col);

		if (p != FICHA.VACIA) {
			Color c;
			if (p == FICHA.BLANCA)
				c = Color.WHITE;
			else
				c = Color.BLACK;
			g.setColor(c);
			g.fillRect(x + 2, y + 2, AnchoCelda - 2, AltoCelda - 2);
		}

		g.setColor(Color.black);

	}

	
	
	private void turnoActual(FICHA ficha) {
		
		juegoBlancas = ChangePlayerPanel.getModoJuegoBlancas();
		juegoNegras = ChangePlayerPanel.getModoJuegoNegras();
		
		if(ficha == FICHA.BLANCA){
			turnoActual = "Blancas";
			juego = juegoBlancas;
		}
		else if(ficha == FICHA.NEGRA) {
			juego = juegoNegras;
			turnoActual = "Negras";
		}
	}
	

	@Override
	public void onReset(TableroInmutable tablero, FICHA turno) {

		this.turnoActual(turno);
		this.mostrarTurno(turnoActual);
		numCols = tab.getColumnas();
		numFilas = tab.getFilas();
		
		repaint();
	
	}

	@Override
	public void onPartidaTerminada(TableroInmutable tablero, FICHA ganador) {
		
		this.turnoActual(ganador);
		this.mostrarGanador(turnoActual);
		terminada = true;
		repaint();
		
	}

	@Override
	public void onCambioJuego(TableroSoloLectura tab, FICHA turno) {
		this.tab = tab;
		this.turnoActual(turno);
		this.mostrarTurno(turnoActual);
		
		numCols = tab.getColumnas();
		numFilas = tab.getFilas();
		
		repaint();
		
	}

	@Override
	public void onUndoNotPossible() {
		
		
	}

	@Override
	public void onUndo(TableroSoloLectura tablero, FICHA turno, boolean hayMas) {
		
			this.turnoActual(turno);
			this.mostrarTurno(turnoActual);
			repaint();
		
	}


	@Override
	public void onMovimientoIncorrecto(MovimientoInvalido movimientoException) {
			
		
	}

	@Override
	public void onMovimientoEnd(TableroInmutable tablero, FICHA jugador,
			FICHA turno) {
		
		this.turnoActual(turno);
		this.mostrarTurno(turnoActual);

	
		repaint();

		
	}

	@Override
	public void onError(String s) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onMovimientoStart(FICHA turno) {

		
		
	}
	
}
