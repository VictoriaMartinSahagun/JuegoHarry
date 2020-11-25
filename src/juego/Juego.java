package juego;

import entidad.jugador.Jugador;

import entidad.enemigo.Enemigo;
import entidad.proyectil.Proyectil;

public class Juego {
	private Jugador harry;
	private Horda horda;
	private Mapa mapa;
	private int cantHorda1,cantHorda2,cantHorda3,cantHorda4;
	
	/**
	 * Metodo iniciar juego
	 */
    public void iniciar() {
    	mapa = new Mapa(harry);
    	horda = new Horda(this,1); //nose si esto esta bien
    	harry = new Jugador(this);
    }
    
    /**
     * Metodo ganar juego
     */
    public void ganar() {}
    
    /**
     * Metodo perder juego
     */
    public void perder() {}
    
    /**
     * Metodo pausar juego
     */
    public void pausar() {}
    
    /**
     * Metodo mejorar hechizos
     */
    public void mejorarHechizos() {}
    
    /**
     * Establece un enemigo activo
     * @param en Enemigo
     */
    public void agregarEnemigoActivo(Enemigo en) {
    	mapa.agregarEnemigoActivo(en);
    }
    
    /**
     * Establece un proyectil activo
     * @param p Proyectil
     */
    public void agregarProyectilActivo(Proyectil p) {
    	mapa.agregarProyectilActivo(p);
    }
    
    /**
     * Elimina un enemigo activo
     * @param en Enemigo
     */
    public void eliminarEnemigoActivo(Enemigo en) {
    	mapa.eliminarEnemigoActivo(en);
    }
    
    /**
     * Elimina un proyectil activo
     * @param p Proyectil
     */
    public void eliminarProyectilActivo(Proyectil p) {
    	mapa.eliminarProyectilActivo(p);;
    }
    
    /**
     * Establece el jugador 
     * @param harry Jugador
     */
    public void setJugador(Jugador harry) {
		this.harry = harry;
	}
    
    /**
     * Establece la horda 
     * @param horda Horda
     */
    public void setHorda(Horda horda) {
		this.horda = horda;
	}
    
    /**
     * Establece el mapa
     * @param mapa Mapa
     */
    public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
    
    /**
     * Establece la cantidad de la primer horda
     * @param cantHorda1 int
     */
    public void setCantHorda1(int cantHorda1) {
		this.cantHorda1 = cantHorda1;
	}
    
    /**
     * Establece la cantidad de la segunda horda
     * @param cantHorda2 int
     */
    public void setCantHorda2(int cantHorda2) {
		this.cantHorda2 = cantHorda2;
	}
    
    /**
     * Establece la cantidad de la tercer horda
     * @param cantHorda3 int
     */
    public void setCantHorda3(int cantHorda3) {
		this.cantHorda3 = cantHorda3;
	}
    
    /**
     * Establece la cantidad de la cuarta horda
     * @param cantHorda4 int
     */
    public void setCantHorda4(int cantHorda4) {
		this.cantHorda4 = cantHorda4;
	}
    
    /**
     * Consulta el jugador
     * @return jugador
     */
    public Jugador getJugador() {
        return harry;
    }
	
    /**
     * Consulta la horda
     * @return horda
     */
	public Horda getHorda() {
		return horda;
	}
	
	/**
	 * Consulta el mapa
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}
	
	/**
	 * Consulta la cantidad de la primer horda
	 * @return cantidad
	 */
	public int getCantHorda1() {
		return cantHorda1;
	}
	
	/**
	 * Consulta la cantidad de la segunda horda
	 * @return cantidad
	 */
	public int getCantHorda2() {
		return cantHorda2;
	}
	
	/**
	 * Consulta la cantidad de la tercer horda
	 * @return cantidad
	 */
	public int getCantHorda3() {
		return cantHorda3;
	}
	
	/**
	 * Consulta la cantidad de la cuarta horda
	 * @return cantidad
	 */
	public int getCantHorda4() {
		return cantHorda4;
	}
	
    
}
