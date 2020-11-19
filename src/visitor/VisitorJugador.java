package visitor;

import entidad.jugador.Jugador;

public class VisitorJugador extends Visitor{
	
	private Jugador j;
	
	public VisitorJugador(Jugador j) {
		this.j=j;
	}
	
}
