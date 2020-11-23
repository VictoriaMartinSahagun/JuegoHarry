package fabrica;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilMejorado;
import juego.Juego;

public class FabricaProyectilMejorado implements FabricaProyectil{

	@Override
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilMejorado(1000, juego, (Jugador) e);
	}

}
