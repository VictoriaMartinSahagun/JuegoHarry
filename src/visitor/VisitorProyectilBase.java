package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;

public class VisitorProyectilBase extends Visitor{
	
	private ProyectilBase p;
	
	public VisitorProyectilBase(ProyectilBase p) {
		this.p = p;
	}
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		p.colisionarAlfa(e);
		p.desactivar();
	}
	
	public void visitarEnemigoBeta(EnemigoBeta e) {
		p.colisionarBeta(e);
		p.desactivar();
	}
	
}
