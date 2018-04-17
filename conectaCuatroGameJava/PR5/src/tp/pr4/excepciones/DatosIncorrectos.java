package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class DatosIncorrectos extends RuntimeException {

	private String s;
	public DatosIncorrectos(String string) {
		this.s = string;
	}
	public String toString(){
		
		String text = this.s;
		return text;
	}

}
