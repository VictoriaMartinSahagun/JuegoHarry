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
	 * Crea un nuevo Jugador partiendo de un determinado juego
	 * @param juego Juego
	 */
	public Jugador(Juego juego) {
		this.juego = juego;
		this.danio_recibido=0;
		ent_graf = new EntidadGraficaJugador();
		pos_x=300;
		pos_y=460;
		fabrica_base = new FabricaProyectilBase();
		fabrica_mejorado = new FabricaProyectilMejorado();
		v = new VisitorJugador(this);
		
		borde_arriba =  pos_y + ent_graf.getEtiqueta().getY()/2;
		borde_abajo = pos_y - ent_graf.getEtiqueta().getY()/2;
		borde_izq = pos_x - ent_graf.getEtiqueta().getX()/2;
		borde_der = pos_x + ent_graf.getEtiqueta().getX()/2;
		
		actualizarBordes();
	}
	
	/**
	 * Ataque base
	 */
	public void atacarBase() {
		ProyectilBase p = (ProyectilBase) fabrica_base.crearProyectil(juego,this);
		juego.agregarProyectilActivo(p);
	}
	
	/**
	 * Ataque mejorado
	 */
	public void atacarMejorado() {
		ProyectilMejorado p = (ProyectilMejorado) fabrica_mejorado.crearProyectil(juego,this);
		juego.agregarProyectilActivo(p);
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitarJugador(this);
	}
	
	@Override
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for (Entidad e : juego.getMapa().ElementosActivos()) {
			if( (e.getBordeIzq()>=borde_izq && e.getBordeIzq()<=borde_der) || (e.getBordeDer()>=borde_izq && e.getBordeDer()<=borde_der) ) {
				
				if(borde_arriba>=e.getBordeAbajo()) {
					lista.add(e);
				}
				
			}
		}
		
		
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
	
	/**
	 * Metodo jugar
	 */
	public void curar() {
		this.danio_recibido=0;
	}
	
	/**
	 * Establece el danio recibido
	 * @param danio
	 */
	public void recibirDanio(int danio) {
		this.danio_recibido += danio;
		
		if(this.danio_recibido >= 100) {
			ent_graf.muerte();
			//terminar juego?
		}else {
			ent_graf.daniar();
		}
		
	}
	
	/**
	 * Establece la posicion respecto x
	 * @param posx int
	 */
	public void setPosX(int posX) {
		this.pos_x = posX;
	}
	
	/**
	 * Establece la posicion respecto y
	 * @param posy int
	 */
	public void setPosY(int posY) {
		this.pos_y = posY;
	}
	
	/**
	 * Establece las posiciones respecto x e y
	 * @param x int
	 * @param y int
	 */
	public void setPos(int x, int y) {
		pos_x = x;
		pos_y = y;
	}

	/**
	 * Consulta el danio recibido
	 * @return danio
	 */
	public int getDanioRecibido() {
		return danio_recibido;
	}
	
	/**
	 * Contulta la posicion respecto x
	 *  @param posicion respecto x
	 */
	public int getPosX() {
		return pos_x;
	}

	/**
	 * Consulta la posicion respecto y
	 * @return posicion respecto y
	 */
	public int getPosY() {
		return pos_y;
	}
}
