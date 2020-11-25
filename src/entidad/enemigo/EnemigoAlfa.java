package entidad.enemigo;

import java.util.ArrayList;
import java.util.List;

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
		direccion = -1;
		velocidad = 2;
		movimiento = new MovimientoVerticalEnemigo(this,direccion,velocidad, lim_inf,lim_sup);
		fabrica = new FabricaProyectilEnemigo();
	//	v = new Visitor();
		
		actualizarBordes();
		
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
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for (Entidad e: juego.getMapa().getEntidadesActivas()) {
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
		actualizarBordes();
	}
	
	/**
	 * Actualiza los bordes del enemigo.
	 */
	private void actualizarBordes() {
		JLabel lbl;
		
		lbl = ent_graf.getEtiqueta();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
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
		if (delay++ % 7 ==0)
			this.mover();
	}	
	
}
