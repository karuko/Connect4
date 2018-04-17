package tp.pr4.movimiento;

import tp.pr4.excepciones.ColumnaIncorrecta;
import tp.pr4.excepciones.FilaIncorrecta;
import tp.pr4.excepciones.MovimientoInvalido;
import tp.pr4.logica.FICHA;
import tp.pr4.logica.Tablero;

public class MovimientoGravity extends Movimiento {


	public MovimientoGravity(int fila, int columna, FICHA turno) {
		super(fila, columna, turno);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void undo(Tablero t) {
		int f = this.getFila();
		int c = this.getColumna();
		t.ponFicha(f, c, FICHA.VACIA);

	}

	@Override
	public void ejecutaMovimiento(Tablero t) throws ColumnaIncorrecta, FilaIncorrecta, MovimientoInvalido {
		
		if(!this.columnaValida(this.getColumna(), t)) 
			throw new ColumnaIncorrecta(this.getColumna());
		if(!this.filaValida(this.getFila(), t))
			throw new FilaIncorrecta(this.getFila());
		if(!this.CasillaCorrecta(t)) 
			throw new MovimientoInvalido("Casilla incorrecta");
		
		if(t.getAlto()%2 != 0 && t.getAncho()%2 != 0)
		{
			if(this.getFila()+1 == (t.getAlto()+1)/2 && this.getColumna()+1 == (t.getAncho()+1)/2 )
			
				t.ponFicha(this.getFila(), this.getColumna(), this.turno);
			
			else						
				this.menorTodos(t);
		}
		
		else this.menorTodos(t);
		

	}
	
	
	
	 private int contarColArriba(Tablero t, int f, int c) {

		
		int arriba = 0;
		
		while (filaValida(f+1,t) && t.getFicha(f+1, c) == FICHA.VACIA) {
			arriba++;
			f++;
		}

		this.fila = f;
		return arriba;

	}
	 
	 private int contarColAbajo(Tablero t, int f, int c){
		  
		 int abajo = 0;
		 
		
			while (filaValida(f-1,t) && t.getFicha(f-1, c) == FICHA.VACIA) {
				abajo++;
				f--;
			}
			
			this.fila = f;
		 return abajo;
	 }
	 private int contarFilasIzq(Tablero t, int f, int c) {

		
		
		int izquierda = 0;
		
		
		while (columnaValida(c-1,t) && t.getFicha(f, c-1) == FICHA.VACIA) {
			izquierda++;
			c--;
		}
		this.columna = c;
		return izquierda;

	}
	 
	 private int contarFilasDer(Tablero t, int f, int c){
		 
		 
		 
		 int derecha = 0;
		 
		 	while ( columnaValida(c+1,t) && t.getFicha(f, c+1) == FICHA.VACIA) {
				derecha++;
				c++;
				
			}
		 	this.columna = c;
		 	return derecha;
		  
	 }
	 
	 	 
	
	 private boolean filaValida(int f, Tablero tablero) {
		return 0 <= f && f < tablero.getAlto();
		
	}
	 private boolean columnaValida(int c,Tablero tablero) {
		return 0 <= c && c < tablero.getAncho();
	}
	 
	
	private void menorTodos(Tablero t){
		
		
		int mitadCol = t.getAncho()/2;
		int mitadFilas = t.getAlto()/2;
		int f = this.getFila();
		int c = this.getColumna();

		
		
		//Tercer cuadrante
		if(f+1 > mitadFilas && c+1 <= mitadCol){
			
			int izq = this.contarFilasIzq(t, f, c);
			int abajo = this.contarColArriba(t, f, c);
			
			if(izq < abajo){
				
				t.ponFicha(f, this.getColumna(), this.turno);
				this.fila = f;
			}
			else if(abajo < izq) {
				t.ponFicha(this.getFila(), c, this.turno);
				this.columna = c;
			}
			
			else 
			{
				if(t.getFicha(f+abajo, c-izq) == FICHA.VACIA) {
					t.ponFicha(f+abajo, c-izq, this.turno);
					this.FilaColumna(f+abajo, c-izq);
				}
				
				else{
					
					while(t.getFicha(f, c)==FICHA.VACIA){						
						f++;
						c--;
					}					
					t.ponFicha(f-1, c+1, this.turno);
					this.FilaColumna(f-1, c+1);
				}
				
	
			}
			
		}
		//Cuarto cuadrante
		else if(f+1 > mitadFilas && c+1 >= mitadCol){
			
			int der = this.contarFilasDer(t, f, c);
			int abajo = this.contarColArriba(t, f, c);
			
			if(der < abajo){
				
				t.ponFicha(f, this.getColumna(), this.turno);
				this.fila = f;
			}
			else if(abajo < der) {
				t.ponFicha(this.getFila(), c, this.turno);
				this.columna = c;
			}
			
			else 
			{
				if(t.getFicha(f+abajo, c+der) == FICHA.VACIA) {
					t.ponFicha(f+abajo, c+der, this.turno);
					this.FilaColumna(f+abajo, c+der);
				}
				else{
					while(t.getFicha(f, c)==FICHA.VACIA){						
						f++;
						c++;
					}					
					t.ponFicha(f-1, c-1, this.turno);
					this.FilaColumna(f-1, c-1);
				}					
				
			}
			
				
		}
		//primer cuadrante
		else if(f+1 <= mitadFilas && c+1 <= mitadCol){
			
			int izq = this.contarFilasIzq(t, f, c);
			int arriba = this.contarColAbajo(t, f, c);
			
			if(izq < arriba){
				
				t.ponFicha(f, this.getColumna(), this.turno);
				this.fila = f;
			}
			else if(arriba < izq) {
				t.ponFicha(this.getFila(), c, this.turno);
				this.columna = c;
			}
			else 
			{
				if(t.getFicha(f-arriba, c-izq) == FICHA.VACIA) {
					t.ponFicha(f-arriba, c-izq, this.turno);
					this.FilaColumna(-arriba, c-izq);
					
				}
				else{
					while(t.getFicha(f, c)==FICHA.VACIA){						
						f--;
						c--;
					}					
				t.ponFicha(f+1, c+1, this.turno);
				this.FilaColumna(f+1, c+1);
				}					
				
			}
			
		}
		//Segundo cuadrante
		else if(f+1 <= mitadFilas && c+1 >= mitadCol){
			
			int der = this.contarFilasDer(t, f, c);
			int arriba = this.contarColAbajo(t, f, c);
			
			if(der < arriba){
				
				t.ponFicha(f, this.getColumna(), this.turno);
				this.fila = f;
			}
			else if(arriba < der) {
				t.ponFicha(this.getFila(), c, this.turno);
				this.columna = c;
			}
			else 
			{
				if(t.getFicha(f-arriba, c+der) == FICHA.VACIA) {
					t.ponFicha(f-arriba, c+der, this.turno);
					this.FilaColumna(f-arriba, c+der);
				}
				else{
					while(t.getFicha(f, c)==FICHA.VACIA){						
						f--;
						c++;
					}					
					t.ponFicha(f+1, c-1, this.turno);
					this.FilaColumna(f+1, c-1);
				}					
					
			}
			
		}
		
		
		
		
	}
	private boolean CasillaCorrecta(Tablero t){
		if(t.getFicha(this.getFila(), this.getColumna()) == FICHA.VACIA)
			return true;
		else
			return false;
	}
	
	private void FilaColumna(int f, int c) {
		this.fila = f;
		this.columna = c;
	}
	

}


