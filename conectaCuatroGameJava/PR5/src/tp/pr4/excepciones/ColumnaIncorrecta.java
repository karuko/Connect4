package tp.pr4.excepciones;

@SuppressWarnings("serial")
public class ColumnaIncorrecta extends RuntimeException {

	private int c;
	
	public ColumnaIncorrecta(int c) {
		this.c = c+1;
	}
	public String toString(){
		String text = "La columna " + this.c + " es incorrecta";
		return text;
	}

}
