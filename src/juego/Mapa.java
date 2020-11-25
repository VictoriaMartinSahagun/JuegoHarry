package juego;

import java.util.ArrayList;
import java.util.List;

import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;

public class Mapa {
	private List<Enemigo> enemigos;
	private List<Proyectil> proyectiles;
	private Jugador jugador;
	
	/**
	 * Crea un nuevo Mapa partiendo del parametro jugador
	 * @param j Jugador
	 */
	public Mapa(Jugador j) {
		this.jugador=j;
		this.enemigos = new ArrayList<Enemigo>();
		this.proyectiles = new ArrayList<Proyectil>();
	}
	
	/**
	 * Establece un nuevo enemigo activo
	 * @param e Enemigo
	 */
	public void agregarEnemigoActivo(Enemigo e) {
		enemigos.add(e);
		e.getEntidadGrafica().iniciar();
	}
	
	/**
	 * Elimina un enemigo activo
	 * @param e Enemigo
	 */
	public void eliminarEnemigoActivo(Enemigo e) {
		enemigos.remove(e);
		e.getEntidadGrafica().desaparecer();
	}
	
	/**
	 * Establece un nuevo proyectil activo
	 * @param p Proyectil
	 */
	public void agregarProyectilActivo(Proyectil p) {
		proyectiles.add(p);
		p.getGrafica().disparo();
	}
	
	/**
	 * Elimina un proyectil activo
	 * @param p Proyectil
	 */
	public void eliminarProyectilActivo(Proyectil p) {
		proyectiles.remove(p);
		p.getGrafica().desaparecer();
	}
	
	/**
	 * Consulta los elementos activos
	 * @return lista de elementos activos
	 */
	public List<Entidad> ElementosActivos() {
		List<Entidad> lista = new ArrayList<Entidad>();
		lista.add(jugador);
		
		for(Enemigo e:enemigos)
			lista.add(e);
		
		for(Proyectil p:proyectiles)
			lista.add(p);
		return lista;
	}
	
}
