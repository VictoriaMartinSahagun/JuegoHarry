package juego;

import entidad.jugador.Jugador;

import entidad.enemigo.Enemigo;
import entidad.proyectil.Proyectil;
import gui.JFrameJuego;

import java.util.ArrayList;
import java.util.List;

import entidad.*;

public class Juego implements Runnable{
	private Jugador harry;
	private Horda [] hordas;
	private Mapa mapa;
	private JFrameJuego gui;
	private boolean activo;
	
	private List<Entidad> por_eliminar;
	private List<Entidad> por_agregar;
	
	public Juego(JFrameJuego gui) {
		this.gui = gui;
	}
	
	/**
	 * Metodo iniciar juego
	 */
    public void iniciar() {
    	por_eliminar = new ArrayList<Entidad>();
    	por_agregar = new ArrayList<Entidad>();
    	activo=true;
    	mapa = new Mapa();
    	harry = new Jugador(this);
    	
    	hordas = new Horda[4];
    	//System.out.println("Horda 1");
    	hordas[0] = new Horda(this,1);
    	//System.out.println("Horda 2");
    	hordas[1] = new Horda(this,2);
    	//System.out.println("Horda 3");
    	hordas[2] = new Horda(this,3);
    	//System.out.println("Horda 4");
    	hordas[3] = new Horda(this,4);
    	
    	
    }
    
    /**
     * Metodo ganar juego
     */
    public void ganar() {
    	activo=false;
    }
    
    /**
     * Metodo perder juego
     */
    public void perder() {
    	activo=false;
    }
    
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
    	if (this.por_agregar==null) System.out.println("AAAAA");
    	por_agregar.add(e);
    }
    
    public void porEliminarEntidad(Entidad e) {
    	por_eliminar.add(e);
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

	public void accionar() {
		
		for (Entidad e: mapa.getEntidadesActivas()) {
			e.accionar();
		}
	}
	
	@Override
	public void run() {
		int cant=0;
		
		while(true) {
			accionar();
			
			for(Entidad e: por_agregar) {
				mapa.agregarEntidadActiva(e);
				e.getEntidadGrafica().iniciar();
				gui.getPanel().add(e.getEntidadGrafica().getEtiqueta());
				e.getEntidadGrafica().getEtiqueta().setVisible(true);
				cant++;
			}
			por_agregar = new ArrayList<Entidad>();
			
			for(Entidad e: por_eliminar) {
				//eliminar
			}
			por_eliminar = new ArrayList<Entidad>();
			
			gui.getPanel().repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}
