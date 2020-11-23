package visitor;

import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;

public class VisitorJugador extends Visitor{
	
	private Jugador j;
	
	public VisitorJugador(Jugador j) {
		this.j = j;
	}
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	public void visitarEnemgioBeta(EnemigoBeta e) {
		j.recibirDanio(e.getDanioAtaque());
	}
	
	//TODO AGREGAR PREMIOS
}
