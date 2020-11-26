package entidad.proyectil;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad_grafica.EntidadGraficaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalProyectilEnemigo;
import visitor.Visitor;
import entidad.enemigo.*;

public class ProyectilEnemigo extends Proyectil{
	private int delay;
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
		//visitor = new Visitor();
		
		delay = 0;
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
	public void mover() {
		movimiento.mover();
	}


	@Override
	public void accionar() {
		//cada 5 llamadas al hilo muevo el proyectil
		if (delay++ % 5 == 0)
			this.mover();
	}
}
