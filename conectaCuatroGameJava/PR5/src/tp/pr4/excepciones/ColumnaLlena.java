package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class ColumnaLlena extends RuntimeException {

	private int c;
	public ColumnaLlena(int columna) {
		this.c = columna+1;
	}
	public String toString(){
		String text = "La columna " + this.c + " esta llena";
		return text;
	}

}
