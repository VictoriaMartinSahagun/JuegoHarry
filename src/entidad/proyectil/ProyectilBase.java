package entidad.proyectil;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.*;
import entidad.jugador.Jugador;
import entidad_grafica.*;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorProyectilBase;
import movimiento.*;

public class ProyectilBase extends Proyectil{
	private JLabel lbl;
	private int delay;
	
	/**
	 * Crea un nuevo ProyectilBase partiendo de ciertos parametros
	 * @param juego Juego
	 * @param j Jugador
	 * @param lim
	 */
	public ProyectilBase(Juego juego, Jugador j, int lim) {
		this.juego = juego;
		lbl = new JLabel();
		grafica = new EntidadGraficaProyectilBase(lbl);
		direccion = MovimientoVertical.ARRIBA;
		velocidad = 1;
		cap_penetracion = 5;
		movimiento = new MovimientoVerticalProyectilJugador(this,direccion,velocidad,lim);
		visitor = new VisitorProyectilBase(this);
		
		delay=0;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarProyectilBase(this);
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
		//cada 3 llamadas al hilo muevo el proyectil
		if (delay++ % 3==0)
			this.mover();
	}
	
}
