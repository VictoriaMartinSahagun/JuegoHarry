package entidad.proyectil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalProyectilEnemigo;
import visitor.Visitor;
import entidad.enemigo.*;

public class ProyectilEnemigo extends Proyectil{
	
	/**
	 * Crea un nuevo ProyectilEnemigo partiendo de ciertos parametros 
	 * @param juego Juego
	 * @param e Enemigo
	 * @param lim_inf int
	 * @param lim_sup int
	 */
	public ProyectilEnemigo(Juego juego, Enemigo e, int lim_inf,int lim_sup) {
		this.juego = juego;
		JLabel lbl = new JLabel();
		this.grafica = new EntidadGraficaProyectilEnemigo(lbl);
		this.direccion =-1;
		this.velocidad = 1;
		this.cap_penetracion = 5;
		this.movimiento = new MovimientoVerticalProyectilEnemigo(this,direccion,velocidad,lim_inf,lim_sup);
		
		pos_y = e.getBordeAbajo();
		pos_x = e.getPosX();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}
	

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilEnemigo(this);
	}
	
	/**
	 * Metodo colisionar
	 */
	public void colisionar() {
		juego.getJugador().recibirDanio(cap_penetracion);
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
