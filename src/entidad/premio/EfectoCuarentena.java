package entidad.premio;

import java.util.ArrayList;
import java.util.List;

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
		int direccion=-1;
		int velocidad=2;
		JLabel etiqueta = new JLabel();
		EntidadGraficaPremioTiempo ent = new EntidadGraficaPremioTiempo(etiqueta);
		movimiento = new MovimientoVerticalPremio(direccion,velocidad,this,lim_inf,lim_sup);
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
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for(Entidad e: juego.getMapa().ElementosActivos()) {
			if( (e.getBordeIzq()>=borde_izq && e.getBordeIzq()<=borde_der) || (e.getBordeDer()>=borde_izq && e.getBordeDer()<=borde_der) ) {
				
				if(borde_abajo<=e.getBordeArriba()) {
					lista.add(e);
				}
				
			}
		}
		
		return lista;
	}

	@Override
	public void mover() {
		movimiento.mover();
	}

}
