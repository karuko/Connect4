package tp.pr4.comandos;


public class ParserAyudaComandos {

	public ParserAyudaComandos(){
		
	}
	private static Comando[] comandos = {
		 new Salir(), new Deshacer(), new Jugar(),new Poner(),
		 new PonJugador(), new Ayuda(), new Reset()
		 };
	
		 static public String AyudaComandos(){
			String text = "";
			for(int i = 0; i < comandos.length; i++)
				text += comandos[i].textoAyuda() + System.getProperty("line.separator");
			return text;
			
		 }
		 

}
