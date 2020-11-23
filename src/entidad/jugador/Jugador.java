package entidad.jugador;

import java.util.*;
import javax.swing.JLabel;
import entidad.*;
import entidad_grafica.*;
import visitor.*;

public class Jugador extends Entidad{
	
	private int danio_recibido,pos_x,pos_y;
	private EntidadGraficaJugador ent_graf;
	
	/**
	 * Constructor del jugador.
	 * @param label etiqueta del jugador.
	 */
	public Jugador() {
		pos_x=200;
		pos_y=460;
		v = new VisitorJugador(this);
		activa = true;
		ent_graf = new EntidadGraficaJugador();
	}
	
	@Override
	public void aceptar(Visitor v) {
		
	}

	@Override
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		//TODO
		
		return lista;
	}

	@Override
	public void mover() {
		ent_graf.moverEtiqueta(pos_x, pos_y);
	}
	
	public void atacar() {
		
	}
	
	//Getters y setters
	
	public int getDanioRecibido() {
		return danio_recibido;
	}

	public void recibir_danio(int danio) {
		this.danio_recibido += danio;
		
		if(this.danio_recibido >= 100) {
			ent_graf.muerte();
			//terminar juego?
		}else {
			ent_graf.danio();
		}
		
	}

	public int getPosX() {
		return pos_x;
	}

	public void setPosX(int posX) {
		this.pos_x = posX;
	}

	public int getPosY() {
		return pos_y;
	}

	public void setPosY(int posY) {
		this.pos_y = posY;
	}
	
	public void setPos(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	public EntidadGraficaJugador getEntidadGraficaJugador() {
		return ent_graf;
	}
}
