package premio;

import javax.swing.JLabel;

import entidad_grafica.EntidadGraficaPremio;
import entidad_grafica.EntidadGraficaPremioPocion;
import juego.Juego;

public class MejoraPocion extends Mejora{

	public MejoraPocion(String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremio ent = new EntidadGraficaPremioPocion(etiqueta);
		//movimiento = new 
	}
	@Override
	public void activar() {
		this.juego.getJugador().curar();
	}

}
