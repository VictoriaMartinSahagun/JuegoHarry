package entidad;

import java.util.List;
import visitor.Visitor;

public abstract class Entidad {
	
	protected Visitor v;
	protected boolean activa;
	
	/**
	 * Acepta el visitor.
	 * @param v Visitor.
	 */
	public abstract void aceptar(Visitor v);
	
	/**
	 * Obtiene una lista de objetos que estan colisionando con la entidad.
	 * @return Lista de entidades.
	 */
	public abstract List<Entidad> detectarColisiones();
	
	/**
	 * Desactiva la entidad.
	 */
	public void desactivar() {
		activa=false;
	}
	
	public abstract void mover();
	
	/**
	 * Getter estaActiva
	 * @return verdadero si esta activa, falso en caso contrario.
	 */
	public boolean estaActiva() {
		return activa;
	}
}
