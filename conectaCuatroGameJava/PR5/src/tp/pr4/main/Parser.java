package tp.pr4.main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Parser {

	private final String game = "g";
	private final String gameLong = "game";
	private final String tamanoX = "x";
	private final String tamanoLongX = "tamX";
	private final String tamanoY = "y";
	private final String tamanoLongY = "tamY";
	private final String hName = "h";
	private final String hNameLong = "help";
	private final String uiName = "u";
	private final String uiNameLong = "ui";

	private final static String progName = "[-g <game>] [-h] [-x <tamanoX>] [-y <tamanoY>]";

	private static String g;
	private static String x;
	private static String y;
	private static Boolean u = false;
	private static Boolean h = false;
	private static int m;
	
	CommandLine cmd;
	static Options options = new Options();
	
	
	Parser(String[] args) throws ParseException {
		options = new Options();
		options.addOption(game, gameLong, true, "Jugar, c4 para conecta 4, co para complica y gr para gravity");
		options.addOption(hName, hNameLong, false, "Muestra la ayuda");
		options.addOption(tamanoX, tamanoLongX, true, "Numero columnas juego Gravity");	
		options.addOption(tamanoY, tamanoLongY, true, "Numero filas juego Gravity");
		options.addOption(uiName, uiNameLong, true, "interfaz");
		
		CommandLineParser parser = new GnuParser();
		cmd = parser.parse(options, args);

		extractValues();
	}
	
	
	private void extractValues() {
		if (cmd.hasOption(game)) {
			
			if (cmd.getOptionValue(game).equalsIgnoreCase("c4")) {
				m = 0;
			}
				
			if (cmd.getOptionValue(game).equalsIgnoreCase("co")) {
				m = 1;
			}
				
			if (cmd.getOptionValue(game).equalsIgnoreCase("gr")) {
				m = 2;
				if(cmd.hasOption(tamanoX))
					x = cmd.getOptionValue(tamanoLongX);
				if (cmd.hasOption(tamanoY)) 
					y = cmd.getOptionValue(tamanoLongY);
					
				g = cmd.getOptionValue(game);
			}
			if(cmd.getOptionValue(game).equalsIgnoreCase("re")){
				m = 3;
			}
		}
		if (cmd.hasOption(hName)) {
			h = true;
		}
		if(cmd.hasOption(uiName)) {
			if(cmd.getOptionValue(uiName).equalsIgnoreCase("window"))
				u = true;
			else if(cmd.getOptionValue(uiName).equalsIgnoreCase("console"))
				u = false;
				
		}
	}

	public static void usage() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(progName, options);
	}

	public static String getG() {
		return g;
	}

	public static int getX() {
		return Integer.parseInt(x);
	}

	public static int getY() {
		return Integer.parseInt(y);
	}

	public static Boolean getH() {
		return h;
	}
	
	public static int getM() {
		return m;
	}
	public static Boolean getU() {
		return u;
	}
}
