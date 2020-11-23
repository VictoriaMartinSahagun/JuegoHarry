package entidad.proyectil;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.EnemigoAlfa;
import entidad.enemigo.EnemigoBeta;
import entidad.jugador.Jugador;
import entidad_grafica.*;
import juego.Juego;
import visitor.Visitor;
import movimiento.*;

public class ProyectilMejorado extends Proyectil{
	private JLabel lbl;
	
	public ProyectilMejorado(int lim, Juego juego, Jugador j) {
		lbl = new JLabel();
		direccion = MovimientoVertical.ARRIBA;
		velocidad = 1;
		cap_penetracion = 10;
		grafica = new EntidadGraficaProyectilMejorado(lbl);
		movimiento = new MovimientoVerticalProyectilJugador(direccion,velocidad,this,lim);
	    this.juego = juego;
	    
	    pos_y = j.getBordeArriba();
		pos_x = j.getPosX();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
	}
	
	public void colisionarAlfa(EnemigoAlfa e) {
		e.recibirDanio(cap_penetracion);
	}
	
	public void colisionarBeta(EnemigoBeta e) {
		e.recibirDanio(cap_penetracion);
	}
	
	@Override
	public List<Entidad> detectarColisiones() {
		//int borde_arriba, borde_abajo, borde_izq, borde_der;
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for(Entidad e: juego.getMapa().ElementosActivos()) {
			if( (e.getBordeIzq()>=borde_izq && e.getBordeIzq()<=borde_der) || (e.getBordeDer()>=borde_izq && e.getBordeDer()<=borde_der) ) {
				
				//ASEGURARSE QUE UNA VEZ QUE LO TOCA EL PROYECTIL YA NO SIGUE HACIENDO DANO
				
				if(borde_arriba>=e.getBordeAbajo()) {
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