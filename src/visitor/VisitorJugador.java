package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;
import entidad.premio.EfectoArma;
import entidad.premio.EfectoCuarentena;
import entidad.premio.MejoraPocion;
import entidad.proyectil.ProyectilEnemigo;

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
		e.getMovimiento().moverArriba();
	}
	
	@Override
	public void visitarEnemigoBeta(EnemigoBeta e) {
		j.recibirDanio(e.getDanioAtaque());
		e.getMovimiento().moverArriba();
	}
	
	public void visitarProyectilEnemigo(ProyectilEnemigo p) {
		j.recibirDanio(p.getCapPenetracion());
		p.desactivar();
		//System.out.println("Danio recibido: "+j.getDanioRecibido());
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
