package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.proyectil.*;

public class VisitorProyectilMejorado {
	
	private ProyectilMejorado p;
	
	public VisitorProyectilMejorado(ProyectilMejorado p) {
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
