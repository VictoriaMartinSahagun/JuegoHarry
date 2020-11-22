package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.enemigo.EnemigoAlfa;
import juego.Juego;

public class FabricaEnemigoAlfa implements FabricaEnemigo{

	public Enemigo crearEnemigo(Juego j, JLabel etiqueta) {
		return new EnemigoAlfa(j,etiqueta,0,1000);
	}
	
}
