package entidad.enemigo;

import java.awt.geom.Area;
import javax.swing.JLabel;
import entidad.Entidad;
import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectilEnemigo;
import juego.Juego;
import movimiento.MovimientoVerticalEnemigo;
import visitor.*;

public class EnemigoAlfa extends Enemigo{
	private int delay;
	
	/**
	 * Crea un nuevo EnemigoAlfa partiendo de ciertos parametros
	 * @param j Juego
	 * @param etiqueta JLabel
	 * @param lim_inf int
	 * @param lim_sup int
	 * @param pos_X int 
	 * @param pos_y int
	 */
	public EnemigoAlfa(Juego j, JLabel etiqueta,int lim_inf, int lim_sup, int pos_X, int pos_y) {
		juego = j;
		vida=100;
		danio_ataque=5;
		ent_graf = new EntidadGraficaEnemigo(etiqueta);
		rango = 10;
		direccion = 1;
		velocidad = 10;
		movimiento = new MovimientoVerticalEnemigo(this,direccion,velocidad, lim_inf,lim_sup);
		fabrica = new FabricaProyectilEnemigo();
		v = new VisitorEnemigo(this);
		
		delay = 0;
	}
	
	@Override
	public void atacar() {
		ProyectilEnemigo proyectil = (ProyectilEnemigo) fabrica.crearProyectil(juego,this);
		juego.porAgregarEntidad(proyectil);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarEnemigoAlfa(this);
	}

	@Override
	public void mover() {
		movimiento.mover();
	}
	
	/**
	 * Establece el danio recibido
	 * @param danio int
	 */
	public void recibirDanio(int danio) {
		this.vida -= danio;
		
		if(this.vida <= 0) {
			ent_graf.desaparecer();
			//terminar juego?
		}else {
			ent_graf.daniar();
			//ent_graf.danio();
		}		
	}

	@Override
	public void accionar() {
		//if (delay++ % 7 ==0)
			this.mover();
	}	
	
}
