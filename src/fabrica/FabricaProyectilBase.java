package fabrica;

import entidad.proyectil.Proyectil;
import entidad.proyectil.ProyectilBase;

public class FabricaProyectilBase implements FabricaProyectil{

	@Override
	public Proyectil crearProyectil() {
		return new ProyectilBase(1000);
	}

}
