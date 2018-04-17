package tp.pr4.comandos;



public abstract class CommandParser {
	
	
	/** The Command set. */
	private static Comando CommandSet[] = {new Salir(), new Deshacer(), new Jugar(),new Poner(), new PonJugador(), new Ayuda(), new Reset()};
	
	
	/**
	 * Parseo de comandos.
	 *
	 * @param line
	 * @return the commandint
	 */
	public static Comando parseCommand(String line)
	{
		
		Comando comint  = null;
        boolean stop = false;
        int i = 0;
        
        String[] components = line.split(" ");
        
        while (i < CommandParser.CommandSet.length && !stop) {
            comint = CommandParser.CommandSet[i].parsea(components);
            
            if (comint != null) 
                stop = true;
            
            else 
                i++; 
        }
        return comint; 
						
	}
	
}
