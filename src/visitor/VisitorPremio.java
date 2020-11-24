package visitor;

import entidad.jugador.Jugador;
import entidad.premio.Premio;

public class VisitorPremio extends Visitor{
	Premio p;
	
	public VisitorPremio(Premio p) {
		this.p=p;
	}
	
	public void visitarJugador(Jugador j) {
		this.p.activar();;
	}
}
