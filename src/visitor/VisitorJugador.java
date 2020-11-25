package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;
import entidad.premio.EfectoArma;
import entidad.premio.EfectoCuarentena;
import entidad.premio.MejoraPocion;

public class VisitorJugador extends Visitor{
	
	private Jugador j;
	
	/**
	 * Crea nuevo visitorJugador partiendo de un parametro
	 * @param j Jugador
	 */
	public VisitorJugador(Jugador j) {
		this.j = j;
	}
	
	@Override
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	@Override
	public void visitarEnemigoBeta(EnemigoBeta e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	@Override
	public void visitarEfectoCuarentena(EfectoCuarentena e) {
		e.activar();
	}
	
	@Override
	public void visitarEfectoSuperArma(EfectoArma e) {
		e.activar();
	}
	
	@Override
	public void visitarPocion(MejoraPocion p) {
		p.activar();
	}
}
