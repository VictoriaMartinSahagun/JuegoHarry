package entidad.proyectil;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad_grafica.EntidadGraficaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalProyectilEnemigo;
import visitor.Visitor;
import entidad.enemigo.*;

public class ProyectilEnemigo extends Proyectil{
	public ProyectilEnemigo(int lim_inf,int lim_sup, Juego juego, Enemigo e) {
		JLabel lbl = new JLabel();
		this.direccion =-1;
		this.velocidad = 1;
		this.cap_penetracion = 5;
		this.grafica = new EntidadGraficaProyectilEnemigo(lbl);
		this.movimiento = new MovimientoVerticalProyectilEnemigo(direccion,velocidad,this,lim_inf,lim_sup);
		this.juego = juego;
		
		pos_y = e.getBordeAbajo();
		pos_x = e.getPosX();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}
	
	public void colisionar() {
		juego.getJugador().recibirDanio(cap_penetracion);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entidad> detectarColisiones() {
		//int borde_arriba, borde_abajo, borde_izq, borde_der;
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
