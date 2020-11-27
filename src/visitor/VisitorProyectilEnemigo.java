package visitor;

import entidad.jugador.Jugador;
import entidad.proyectil.ProyectilEnemigo;

public class VisitorProyectilEnemigo extends Visitor{
	
	private ProyectilEnemigo p;
	
	public VisitorProyectilEnemigo(ProyectilEnemigo p) {
		this.p = p;
	}
	
	public void visitarJugador(Jugador j) {
		System.out.println("A");
		p.colisionar();
		p.desactivar();
	}
	
}
