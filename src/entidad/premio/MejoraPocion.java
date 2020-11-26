package entidad.premio;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad_grafica.EntidadGraficaPremio;
import entidad_grafica.EntidadGraficaPremioPocion;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class MejoraPocion extends Mejora{

	public MejoraPocion(int lim_inf,int lim_sup,String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremio ent_graf = new EntidadGraficaPremioPocion(etiqueta);
		int direccion=-1;
		int velocidad=3;
		movimiento = new MovimientoVerticalPremio(this, direccion, velocidad, lim_sup, lim_inf);
		v = new VisitorPremio(this);
	}
	@Override
	public void activar() {
		this.juego.getJugador().curar();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarPocion(this);
	}

	@Override
	public void mover() {
		movimiento.mover();
	}
	@Override
	public void accionar() {
		this.mover();
	}

}
