package entidad.premio;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad_grafica.EntidadGraficaPremioTiempo;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class EfectoCuarentena extends Efecto{

	public EfectoCuarentena(int lim_inf,int lim_sup,String nombre, Juego juego) {
		this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremioTiempo ent_graf = new EntidadGraficaPremioTiempo(etiqueta);
		int direccion=-1;
		int velocidad=2;
		movimiento = new MovimientoVerticalPremio(this,direccion,velocidad,lim_inf,lim_sup);
		v = new VisitorPremio(this);
	}
	
	@Override
	public void activar() {
		juego.pausar();
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarEfectoCuarentena(this);
	}

	@Override
	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		Iterable<Entidad> colisiones = this.detectarColisiones();
		for (Entidad e:colisiones)
			e.aceptar(this.v);

		this.mover();
	}

}
