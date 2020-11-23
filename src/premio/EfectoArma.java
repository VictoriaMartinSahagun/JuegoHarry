package premio;

import javax.swing.JLabel;

import entidad_grafica.EntidadGraficaPremio;
import entidad_grafica.EntidadGraficaPremioSnitch;
import juego.Juego;

public class EfectoArma extends Efecto {

	public EfectoArma(String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremio ent_graf = new EntidadGraficaPremioSnitch(etiqueta);
		//movimiento = new 
	}
	
	@Override
	public void activar() {
		juego.mejorarHechizos();
	}

}
