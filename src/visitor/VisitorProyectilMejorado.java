package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.proyectil.*;

public class VisitorProyectilMejorado {
	
	private ProyectilMejorado p;
	
	public VisitorProyectilMejorado(ProyectilMejorado p) {
		this.p = p;
	}
	
	//AGREGAR LA DESAPARICION
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		p.colisionarAlfa(e);
	}
	
	public void visitarEnemigoBeta(EnemigoBeta e) {
		p.colisionarBeta(e);
	}
}
