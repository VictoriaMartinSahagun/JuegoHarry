package entidad;

import java.util.List;

import juego.Juego;
import movimiento.Movimiento;

import visitor.Visitor;

public abstract class Entidad {
	
	protected Juego juego;
	protected Visitor v;
	protected boolean activa;
	protected Movimiento movimiento;
	
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

