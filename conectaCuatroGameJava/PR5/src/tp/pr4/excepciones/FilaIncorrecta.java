package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class FilaIncorrecta extends RuntimeException {

private int f;
	
	public FilaIncorrecta(int f) {
		this.f = f+1;
	}
	public String toString(){
		String text = "La fila " + this.f + " es incorrecta";
		return text;
	}
}
