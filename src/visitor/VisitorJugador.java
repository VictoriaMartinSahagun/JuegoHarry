package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;
import entidad.premio.EfectoArma;
import entidad.premio.EfectoCuarentena;
import entidad.premio.MejoraPocion;

public class VisitorJugador extends Visitor{
	
	private Jugador j;
	
	public VisitorJugador(Jugador j) {
		this.j = j;
	}
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	public void visitarEnemigoBeta(EnemigoBeta e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	public void visitarEfectoCuarentena(EfectoCuarentena e) {
		e.activar();
	}
	
	public void visitarEfectoSuperArma(EfectoArma e) {
		e.activar();
	}
	
	public void visitarPocion(MejoraPocion p) {
		p.activar();
	}
}
