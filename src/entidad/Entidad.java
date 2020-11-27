package entidad;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import entidad_grafica.EntidadGrafica;
import juego.Juego;
import movimiento.Movimiento;

import visitor.Visitor;

public abstract class Entidad {
	
	protected Juego juego;
	protected Visitor v;
	protected EntidadGrafica ent_graf;
	protected Movimiento movimiento;
	protected int pos_x, pos_y;
	
	/**
	 * Acepta el visitor.
	 * @param v Visitor.
	 */
	public abstract void aceptar(Visitor v);

	/**
	 * Desactiva la entidad.
	 */
	public void desactivar() {
		juego.porEliminarEntidad(this);
		ent_graf.desaparecer();
	}
	
	/**
	 * Mueve la entidad
	 */
	public abstract void mover();
	
	/**
	 * 
	 */
	public abstract void accionar();
	
	/**
	 * Obtiene una lista de objetos que estan colisionando con la entidad.
	 * @return Lista de entidades.
	 */
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		Area area_e, area_this = new Area(this.getEntidadGrafica().getEtiqueta().getBounds());
		
		for (Entidad e: juego.getMapa().getEntidadesActivas()) {
			area_e = new Area(e.getEntidadGrafica().getEtiqueta().getBounds());
			
			if(area_this.intersects(area_e.getBounds2D())){
				lista.add(e);
			}
			
		}
		
		/*Rectangle rect_this = this.getEntidadGrafica().getEtiqueta().getBounds();
		
		for (Entidad e: juego.getMapa().getEntidadesActivas()) {
			//System.out.println(e.toString());
			JLabel lbl_ent = e.getEntidadGrafica().getEtiqueta();
			Rectangle rect_colision = SwingUtilities.computeIntersection(lbl_ent.getX(), lbl_ent.getY(), lbl_ent.getWidth(), lbl_ent.getHeight(), rect_this);	
			
			if (rect_colision.getWidth()>0 && rect_colision.getHeight()>0) {
				lista.add(e);
				System.out.println(this.toString()+"-"+e.toString());
			}
			
		}*/
		return lista;
	}
	
	//Getters y setters
	
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

	/**
	 * Consulta la entidad grafica
	 * @return entidad grafica
	 */
	public EntidadGrafica getEntidadGrafica() {
		return ent_graf;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Visitor getVisitor() {
		return v;
	}

	public void setVisitor(Visitor v) {
		this.v = v;
	}
	
	public String toString(Entidad e) {
		return e.getClass().getName();
	}
	

}

