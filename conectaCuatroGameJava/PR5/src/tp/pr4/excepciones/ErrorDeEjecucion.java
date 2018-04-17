package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class ErrorDeEjecucion extends RuntimeException {

	private String s;
	public ErrorDeEjecucion(String string) {
		this.s = string;
	}
	public String toString(){
		String text = this.s;
		
		return text;
	}

}
