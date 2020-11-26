package entidad.proyectil;

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
	protected int delay;
	
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
		ent_graf = new EntidadGraficaProyectilMejorado(lbl);
		movimiento = new MovimientoVerticalProyectilJugador(this,direccion,velocidad,lim);
	    visitor = new VisitorProyectilMejorado(this);
		
		delay = 0;
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
	public void mover() {
		movimiento.mover();
	}

	@Override
	public void accionar() {
		//cada 2 llamadas al metodo muevo el proyectil
		if (delay++ % 2 ==0)
			this.mover();
	}
	
}