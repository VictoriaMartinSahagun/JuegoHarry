package entidad;

import java.util.List;
import visitor.Visitor;

public abstract class Entidad {
	
	protected Visitor v;
	protected boolean activa;
	
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
