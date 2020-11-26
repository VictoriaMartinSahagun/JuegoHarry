package juego;

import java.util.ArrayList;
import java.util.List;

import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;
import gui.JFrameJuego;

public class Mapa {
	private List<Entidad> entidades;
	private JFrameJuego gui;
	
	/**
	 * Crea un nuevo Mapa
	 */
	public Mapa() {
		entidades = new ArrayList<Entidad>();
	}
	
	/**
	 * Agrega una nueva entidad activa
	 * @param e Entidad
	 */
	public void agregarEntidadActiva(Entidad e) {
		entidades.add(e);
	}
	
	/**
	 * Elimina una entidad activa del mapa
	 * @param e Entidad
	 */
	public void eliminarEntidadActiva(Entidad e) {
		entidades.remove(e);
	}
	
	//Getters y setters
	
	/**
	 * Consulta los elementos activos
	 * @return iterable de elementos activos
	 */
	public Iterable<Entidad> getEntidadesActivas() {
		return entidades;
	}
	
}
