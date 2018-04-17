package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class MovimientoInvalido extends RuntimeException {

	private String s;
	public MovimientoInvalido(String string) {
		this.s = string;
	}
	public String toString(){
		String text = this.s;
		
		return text;
	}

}
