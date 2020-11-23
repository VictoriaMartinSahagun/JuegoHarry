package fabrica;

import entidad.Entidad;
import entidad.enemigo.*;
import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilEnemigo;
import juego.Juego;

public class FabricaProyectilEnemigo implements FabricaProyectil{

	@Override
	public Proyectil crearProyectil(Juego juego, Entidad e) {
		return new ProyectilEnemigo(0,500, juego, (Enemigo) e);
	}
	
}
