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
	
	public abstract void aceptar(Visitor v);
	
	public abstract List<Entidad> detectarColisiones();
	
	public void desactivar() {
		activa=false;
	}
	
	public abstract void mover();
	
	public boolean estaActiva() {
		return activa;
	}
}