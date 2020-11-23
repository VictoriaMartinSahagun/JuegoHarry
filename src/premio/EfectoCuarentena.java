package premio;

import javax.swing.JLabel;

import entidad_grafica.EntidadGraficaPremioTiempo;
import juego.Juego;

public class EfectoCuarentena extends Efecto{

	public EfectoCuarentena(String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremioTiempo ent = new EntidadGraficaPremioTiempo(etiqueta);
		//movimiento = new 
	}
	
	@Override
	public void activar() {
		juego.pausar();
	}

}
