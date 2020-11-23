package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;

public class VisitorProyectilBase extends Visitor{
	
	private ProyectilBase p;
	
	public VisitorProyectilBase(ProyectilBase p) {
		this.p = p;
	}
	
	//AGREGAR LA DESAPARICION
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		p.colisionarAlfa(e);
	}
	
	public void visitarEnemgioBeta(EnemigoBeta e) {
		p.colisionarBeta(e);
	}
	
}
