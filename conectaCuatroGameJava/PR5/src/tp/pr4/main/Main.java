

//// TODO: Auto-generated Javadoc
///**
// * The Class Main.
// */
//public class Main {
//	
//	/** The in. */
//	private static Scanner in = new Scanner(System.in);
//	
//	/**
//	 * The main method.
//	 *
//	 * @param args the arguments
//	 * @throws IOException Signals that an I/O exception has occurred.
//	 */
//	public static void main(String args[]){
//			
//		ReglasJuego juego = new ReglasJuegoConecta4(10, 10);
//		Partida partida = new Partida(juego);
//		FactoriaJuego f = new FactoriaJuegoConecta4();
//		
//		Controlador c = new Controlador(partida, in,f);
//		
//			try {
//				c.run();
//			} catch (IOException | ErrorDeEjecucion e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	}
//	
//}


package tp.pr4.main;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.cli.ParseException;

import tp.pr4.control.Controlador;
import tp.pr4.control.ControladorGUI;
import tp.pr4.factorias.FactoriaJuegoComplica;
import tp.pr4.factorias.FactoriaJuegoConecta4;
import tp.pr4.factorias.FactoriaJuegoGravity;
import tp.pr4.gui.swing.ConsoleView;
import tp.pr4.gui.swing.MainWindow;
import tp.pr4.juego.ModoJuego;
import tp.pr4.juego.ModoJuegoAutomatico;
import tp.pr4.juego.ModoJuegoHumano;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Partida;
import tp.pr4.logica.TableroSoloLectura;
import tp.pr4.reglas.ReglasJuego;
import tp.pr4.reglas.ReglasJuegoComplica;
import tp.pr4.reglas.ReglasJuegoConecta4;
import tp.pr4.reglas.ReglasJuegoGravity;



public class Main {
	
	private static Scanner in = new Scanner(System.in);
	private static final int CONECTA4 = 0;
	private static final int COMPLICA = 1;
	private static final int GRAVITY = 2;
	private static int executionMode = CONECTA4;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
	
		ReglasJuego juego = new ReglasJuegoConecta4();
		Partida partida = new Partida(juego);
		
		
		Controlador c = new Controlador(partida,in,new FactoriaJuegoConecta4());
		ControladorGUI ctrl = new ControladorGUI(partida,new FactoriaJuegoConecta4());
		
		try {
			if(args.length==0) {	
				ConsoleView view = new ConsoleView(partida);
					c.run();
			}
				
			else {
				new Parser(args);
				executionMode = Parser.getM();
				
			//Si es consola	
			if(!Parser.getU()) {
				if (!Parser.getH()) {
					
					switch(executionMode) {
						case CONECTA4: c = new Controlador(partida,in, new FactoriaJuegoConecta4()); break;
						
						case COMPLICA: juego = new ReglasJuegoComplica(); 
										partida = new Partida(juego);
										c = new Controlador(partida,in, new FactoriaJuegoComplica()); break;
										
						case GRAVITY: juego = new ReglasJuegoGravity();  
									  ReglasJuegoGravity.c = Parser.getX(); ReglasJuegoGravity.f = Parser.getY();
									  partida = new Partida(juego); 
									  c = new Controlador(partida,in, new FactoriaJuegoGravity()); 
									  break;
					}
				}
				
				ConsoleView view = new ConsoleView(partida);
				
					c.run();
				
			}
				
			//Si es ventana
			else if(Parser.getU()) {
					 
					 if (!Parser.getH()) {
							
							switch(executionMode) {
								case CONECTA4: ctrl = new ControladorGUI(partida,new FactoriaJuegoConecta4()); break;
								
								case COMPLICA: juego = new ReglasJuegoComplica(); 
												partida = new Partida(juego);
												ctrl = new ControladorGUI(partida, new FactoriaJuegoComplica()); break;
												
								case GRAVITY: juego = new ReglasJuegoGravity();  
											  ReglasJuegoGravity.c = Parser.getX(); ReglasJuegoGravity.f = Parser.getY();
											  partida = new Partida(juego); 
											  ctrl = new ControladorGUI(partida, new FactoriaJuegoGravity()); 
											  break;
											  
							}

							TableroSoloLectura tab = new TableroSoloLectura(partida);
						
							MainWindow view = new MainWindow(ctrl, partida, tab);
							view.setVisible(true);
						}

				}
				else 
					Parser.usage();
					
				}	

		}
		catch(ParseException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}
		
}

