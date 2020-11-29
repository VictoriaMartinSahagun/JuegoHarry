package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.premio.MejoraPocion;
import entidad.premio.Premio;
import juego.Juego;

public class FabricaPremioMejoraPocion implements FabricaPremio{

	@Override
	public Premio crearPremio(Juego j, Enemigo e) {
		return new MejoraPocion(500, 0, null, j, e);
	}

}
