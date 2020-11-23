package fabrica;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilBase;
import juego.Juego;

public class FabricaProyectilBase implements FabricaProyectil{
	
	@Override
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilBase(1000, juego, (Jugador) e);
	}

}
