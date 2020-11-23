package fabrica;

import entidad.Entidad;
import entidad.proyectil.Proyectil;
import juego.Juego;

public interface FabricaProyectil {
	public abstract Proyectil crearProyectil(Juego juego, Entidad e);
}
