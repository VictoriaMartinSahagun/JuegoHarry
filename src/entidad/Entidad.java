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
	
	/**
	 * Mueve la entidad
	 */
	public abstract void mover();
	
	//Setters
	/**
	 * Establece el borde superior
	 * @param borde_arriba int
	 */
	public void setBordeArriba(int borde_arriba) {
		this.borde_arriba = borde_arriba;
	}
	
	/**
	 * Establece el borde inferior
	 * @param borde_abajo int
	 */
	public void setBordeAbajo(int borde_abajo) {
		this.borde_abajo = borde_abajo;
	}
	
	/**
	 * Establece el borde izquierdo
	 * @param borde_izq int
	 */
	public void setBordeIzq(int borde_izq) {
		this.borde_izq = borde_izq;
	}

	/**
	 * Establece el borde derecho
	 * @param borde_der int
	 */
	public void setBordeDer(int borde_der) {
		this.borde_der = borde_der;
	}
	
	/**
	 * Establece la posicion respecto de x
	 * @param posX int
	 */
	public void setPosX(int posX) {
		this.pos_x = posX;
	}
	
	/**
	 * Establece la posicion respecto de y
	 * @param posY int
	 */
	public void setPosY(int posY) {
		this.pos_y = posY;
	}
	
	/**
	 * Establece la posicion respecto de x e y
	 * @param x int
	 * @param y int
	 */
	public void setPos(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	/**
	 * Establece la entidad grafica
	 * @param ent_graf EntidadGrafica
	 */
	public void setEntidadGrafica(EntidadGrafica ent_graf) {
		this.ent_graf = ent_graf;
	}
	
	//Getters
	/**
	 * Consulta estado activo o inactivo de entidad
	 * @return verdadero si esta activa, falso en caso contrario.
	 */
	public boolean estaActiva() {
		return activa;
	}
	
	/**
	 * Consulta borde superior
	 * @return borde superior
	 */
	public int getBordeArriba() {
		return borde_arriba;
	}

	/**
	 * Consulta el borde inferior
	 * @return borde inferior
	 */
	public int getBordeAbajo() {
		return borde_abajo;
	}

	/*
	 * Consulta el borde izquierdo
	 * @return borde izquierdo
	 */
	public int getBordeIzq() {
		return borde_izq;
	}

	/**
	 * Consulta el borde derecho
	 * @return borde derecho
	 */
	public int getBordeDer() {
		return borde_der;
	}

	/**
	 * Consulta la coordenada respecto x
	 * @return coordenada respecto x
	 */
	public int getPosX() {
		return pos_x;
	}

	/**
	 * Consulta la coordenada respecto y
	 * @return coordenada respecto y
	 */
	public int getPosY() {
		return pos_y;
	}

	/**
	 * Consulta la entidad grafica
	 * @return entidad grafica
	 */
	public EntidadGrafica getEntidadGrafica() {
		return ent_graf;
	}

}

