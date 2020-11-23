package fabrica;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import juego.Juego;

public interface FabricaEnemigo {
	public abstract Enemigo crearEnemigo(Juego j, JLabel etiqueta, int pos_x, int pos_y);
}
