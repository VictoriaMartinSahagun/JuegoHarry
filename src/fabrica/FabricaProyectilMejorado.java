package fabrica;

import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilMejorado;

public class FabricaProyectilMejorado implements FabricaProyectil{

	@Override
	public Proyectil crearProyectil() {
		return new ProyectilMejorado(1000);
	}

}
