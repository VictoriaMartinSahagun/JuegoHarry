package entidad.jugador;

import java.util.*;
import javax.swing.JLabel;
import entidad.*;
import entidad.proyectil.*;
import entidad_grafica.*;
import fabrica.*;
import juego.Juego;
import visitor.*;

public class Jugador extends Entidad{
	
	private int danio_recibido,pos_x,pos_y;
	private FabricaProyectil fabrica_base, fabrica_mejorado;
	
	/**
	 * Constructor del jugador.
	 * @param label etiqueta del jugador.
	 */
	public Jugador(Juego juego) {
		pos_x=200;
		pos_y=460;
		v = new VisitorJugador(this);
		activa = true;
		ent_graf = new EntidadGraficaJugador();
		this.juego = juego;
		fabrica_base = new FabricaProyectilBase();
		fabrica_mejorado = new FabricaProyectilMejorado();
		
		borde_arriba =  pos_y + ent_graf.getEtiqueta().getY()/2;
		borde_abajo = pos_y - ent_graf.getEtiqueta().getY()/2;
		borde_izq = pos_x - ent_graf.getEtiqueta().getX()/2;
		borde_der = pos_x + ent_graf.getEtiqueta().getX()/2;
		
		actualizarBordes();
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
		actualizarBordes();
	}
	
	/**
	 * Actualiza los bordes del jugador.
	 */
	private void actualizarBordes() {
		JLabel lbl;
		
		lbl = ent_graf.getEtiqueta();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}
	
	//Ataques
	
	public void atacarBase() {
		ProyectilBase p = (ProyectilBase) fabrica_base.crearProyectil(juego,this);
		juego.agregarProyectilActivo(p);
	}
	
	public void atacarMejorado() {
		ProyectilMejorado p = (ProyectilMejorado) fabrica_mejorado.crearProyectil(juego,this);
		juego.agregarProyectilActivo(p);
	}
	
	//Getters y setters
	
	public int getDanioRecibido() {
		return danio_recibido;
	}

	public void recibirDanio(int danio) {
		this.danio_recibido += danio;
		
		if(this.danio_recibido >= 100) {
			ent_graf.muerte();
			//terminar juego?
		}else {
			ent_graf.daniar();
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
	
}
