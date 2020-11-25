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
import visitor.VisitorProyectilMejorado;
import movimiento.*;

public class ProyectilMejorado extends Proyectil{
	private JLabel lbl;
	
	/**
	 * Crea un nuevo ProyectilMejorado partiendo de ciertos parametros
	 * @param juego Juego
	 * @param j Jugador
	 * @param lim int
	 */
	public ProyectilMejorado(Juego juego, Jugador j,int lim) {
	    this.juego = juego;
		lbl = new JLabel();
		direccion = MovimientoVertical.ARRIBA;
		velocidad = 1;
		cap_penetracion = 10;
		grafica = new EntidadGraficaProyectilMejorado(lbl);
		movimiento = new MovimientoVerticalProyectilJugador(this,direccion,velocidad,lim);
	    visitor = new VisitorProyectilMejorado(this);
		
	    pos_y = j.getBordeArriba();
		pos_x = j.getPosX();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilMejorado(this);
	}
	
	/**
	 * Establece el danio de la colision con un enemigo alfa
	 * @param e EnemigoAlfa
	 */
	public void colisionarAlfa(EnemigoAlfa e) {
		e.recibirDanio(cap_penetracion);
	}
	
	/**
	 * Establece el danio de la colision con un enemigo beta
	 * @param e EnemigoBeta
	 */
	public void colisionarBeta(EnemigoBeta e) {
		e.recibirDanio(cap_penetracion);
	}
	
	@Override
	public List<Entidad> detectarColisiones() {
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