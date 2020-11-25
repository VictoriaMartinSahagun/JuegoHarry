package juego;

import entidad.jugador.Jugador;

import entidad.enemigo.Enemigo;
import entidad.proyectil.Proyectil;

import java.util.ArrayList;
import java.util.List;

import entidad.*;

public class Juego implements Runnable{
	private Jugador harry;
	private Horda [] hordas;
	private Mapa mapa;
	
	private List<Entidad> porEliminar;
	private List<Entidad> porAgregar;
	
	/**
	 * Metodo iniciar juego
	 */
    public void iniciar() {
    	porEliminar = new ArrayList<Entidad>();
    	porAgregar = new ArrayList<Entidad>();
    	
    	mapa = new Mapa();

    	
    	harry = new Jugador(this);
    	
    	hordas = new Horda[4];
    	hordas[0] = new Horda(this,1);
    	hordas[1] = new Horda(this,2);
    	hordas[2] = new Horda(this,3);
    	hordas[3] = new Horda(this,4);
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
    public void mejorarHechizos() {
    	if (harry.getProyectilActual()=="Base") {
    		harry.setProyectilActual("Mejorado");
    	}
    }
    
    public void porAgregarEntidad(Entidad e){
    	if (this.porAgregar==null) System.out.println("AAAAA");
    	porAgregar.add(e);
    }
    
    public void porEliminarEntidad(Entidad e) {
    	porEliminar.add(e);
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
    public void setHordas(Horda [] hordas) {
		this.hordas = hordas;
	}
    
    /**
     * Establece el mapa
     * @param mapa Mapa
     */
    public void setMapa(Mapa mapa) {
		this.mapa = mapa;
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
	public Horda[] getHordas() {
		return hordas;
	}
	
	/**
	 * Consulta el mapa
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
    
}
