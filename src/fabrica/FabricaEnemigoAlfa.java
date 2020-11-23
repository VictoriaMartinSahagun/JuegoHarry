package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.enemigo.EnemigoAlfa;
import juego.Juego;

public class FabricaEnemigoAlfa implements FabricaEnemigo{

	public Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y) {
		return new EnemigoAlfa(j,etiqueta,0,1000, pos_x, pos_y);
	}
	
}
