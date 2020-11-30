package juego;

import entidad.jugador.Jugador;

import entidad.enemigo.Enemigo;
import entidad.proyectil.Proyectil;
import gui.JFrameJuego;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidad.*;

public class Juego implements Runnable{
	private Jugador harry;
	private Horda horda;
	private Mapa mapa;
	private JFrameJuego gui;
	private boolean activo,gano;
	private int horda_actual;
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
    	gano=false;
    	horda_actual=1;
    	horda = new Horda(this,horda_actual);
    	
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
    public void pausar() {
    	
    }
    
    /**
     * Metodo mejorar hechizos
     */
    public void mejorarHechizos() {
    	if (harry.getProyectilActual()=="Base") {
    		harry.setProyectilActual("Mejorado");
    	}
    }
    
    public void porAgregarEntidad(Entidad e){
    	//if (this.por_agregar==null) System.out.println("AAAAA");
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
    public void setHordas(Horda hordas) {
		this.horda = hordas;
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
	public Horda getHordas() {
		return horda;
	}
	
	/**
	 * Consulta el mapa
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}
	
	public int getHordaActual() {
		return horda_actual;
	}
	public void descontarEnemigo() {
		this.horda.enemigoAbatido();
	}

	public void accionar() {
		if(horda.termino() && horda_actual<4) {
			horda = new Horda(this,++horda_actual);
		}else if(horda.termino() && horda_actual==4) {
			gano=true;
			activo=false;
		}
		
		if(harry.getDanioRecibido()>=100) {
			activo=false;
		}
		
		for (Entidad e: mapa.getEntidadesActivas()) {
			e.accionar();
		}
	}
	
	@Override
	public void run() {		
		int cont=0;
		this.porAgregarEntidad(harry);
		
		while(activo) {
			accionar();
			
			for(Entidad e: por_agregar) {
				mapa.agregarEntidadActiva(e);
				e.getEntidadGrafica().iniciar();
				gui.getPanel().add(e.getEntidadGrafica().getEtiqueta());
			}
			por_agregar = new ArrayList<Entidad>();
			
			for(Entidad e: por_eliminar) {
				mapa.eliminarEntidadActiva(e);
				e.getEntidadGrafica().desaparecer();
				cont++;
			}
			
			por_eliminar = new ArrayList<Entidad>();
			
			gui.getPanel().repaint();
			gui.actualizarVida();
			gui.actualizarNivel();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		if(gano) {
			JOptionPane.showMessageDialog(null, "Ganaste. Todos los elfos han sido liberados.");
			System.exit(0);
		}else {
			JOptionPane.showMessageDialog(null, "Perdiste. Los elfos de Voldemort te han derrotado.");
			System.exit(0);
		}
		
	}
	
    
}
