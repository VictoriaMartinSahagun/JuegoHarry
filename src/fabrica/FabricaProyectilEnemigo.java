package fabrica;

import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilEnemigo;

public class FabricaProyectilEnemigo implements FabricaProyectil{

	@Override
	public Proyectil crearProyectil() {
		return new ProyectilEnemigo(0,500);
	}
	
}
