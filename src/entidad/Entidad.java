package entidad;

import java.util.List;

import entidad_grafica.EntidadGrafica;
import juego.Juego;
import movimiento.Movimiento;

import visitor.Visitor;

public abstract class Entidad {
	
	protected Juego juego;
	protected Visitor v;
	protected boolean activa;
	protected EntidadGrafica ent_graf;
	protected Movimiento movimiento;
	protected int borde_arriba, borde_abajo, borde_izq, borde_der, pos_x, pos_y;

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
		ent_graf.desaparecer();
	}
	
	public abstract void mover();
	
	/**
	 * Getter estaActiva
	 * @return verdadero si esta activa, falso en caso contrario.
	 */
	public boolean estaActiva() {
		return activa;
	}
	
	public int getBordeArriba() {
		return borde_arriba;
	}

	public void setBordeArriba(int borde_arriba) {
		this.borde_arriba = borde_arriba;
	}

	public int getBordeAbajo() {
		return borde_abajo;
	}

	public void setBordeAbajo(int borde_abajo) {
		this.borde_abajo = borde_abajo;
	}

	public int getBordeIzq() {
		return borde_izq;
	}

	public void setBordeIzq(int borde_izq) {
		this.borde_izq = borde_izq;
	}

	public int getBordeDer() {
		return borde_der;
	}

	public void setBordeDer(int borde_der) {
		this.borde_der = borde_der;
	}
	
	public int getPosX() {
		return pos_x;
	}

	public void setPosX(int posX) {
		this.pos_x = posX;
	}

	public int getPosY() {
		return pos_y;
	}

	public void setPosY(int posY) {
		this.pos_y = posY;
	}
	
	public void setPos(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return ent_graf;
	}

	public void setEntidadGrafica(EntidadGrafica ent_graf) {
		this.ent_graf = ent_graf;
	}
	
}

