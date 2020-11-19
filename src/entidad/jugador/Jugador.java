package entidad.jugador;

import java.util.*;
import javax.swing.JLabel;
import entidad.*;
import entidad_grafica.*;
import entidad_grafica.EntidadGraficaJugador;
import visitor.*;

public class Jugador extends Entidad{
	
	private int danio_recibido,velocidad,coords;
	private EntidadGraficaJugador ent_graf;
	
	public Jugador(JLabel label) {
		v = new VisitorJugador(this);
		activa = true;
		ent_graf = new EntidadGraficaJugador(label);
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
		//TODO
	}
	
	
	//Getters y setters
	
	public int getDanioRecibido() {
		return danio_recibido;
	}

	public void setDanioRecibido(int danio_recibido) {
		this.danio_recibido = danio_recibido;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getCoords() {
		return coords;
	}

	public void setCoords(int coords) {
		this.coords = coords;
	}
	
}
