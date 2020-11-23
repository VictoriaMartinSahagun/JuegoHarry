package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import entidad.enemigo.EnemigoBeta;
import juego.Juego;

public class FabricaEnemigoBeta implements FabricaEnemigo{

	public Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y) {
		return new EnemigoBeta(j,etiqueta,0,1000, pos_x, pos_y);
	}
	
}
