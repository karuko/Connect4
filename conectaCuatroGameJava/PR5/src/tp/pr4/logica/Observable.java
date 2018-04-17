package tp.pr4.logica;

public interface Observable<T> {
	public void addObserver( T o);
	public void removeObserver(T o);
}
