package juego;

import entidad.jugador.Jugador;

import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad.jugador.Jugador;
import entidad.proyectil.Proyectil;

public class Juego {
	private Jugador harry;
	private Horda horda;
	private Mapa mapa;
	private int cantHorda1,cantHorda2,cantHorda3,cantHorda4;
	
	
    public void iniciar() {
    	horda = new Horda(1,this); //nose si esto esta bien
    	harry = new Jugador(this);
    	//mapa = new Mapa(harry,horda); //<-- esto tiraba exception, hay que verlo despues
    	
    }
    
    public void ganar() {}
    public void perder() {}
    
    //premios con timers
    public void pausar() {}
    public void mejorarHechizos() {}
    
    public void agregarEnemigoActivo(Enemigo en) {
    	mapa.agregarEnemigoActivo(en);
    }
    
    public void agregarProyectilActivo(Proyectil p) {
    	mapa.agregarProyectilActivo(p);
    }
    
    public void eliminarEnemigoActivo(Enemigo en) {
    	mapa.eliminarEnemigoActivo(en);
    }
    
    public void eliminarProyectilActivo(Proyectil p) {
    	mapa.eliminarProyectilActivo(p);;
    }
    
    public Jugador getJugador() {
        return harry;
    }
	public void setJugador(Jugador harry) {
		this.harry = harry;
	}
	public Horda getHorda() {
		return horda;
	}
	public void setHorda(Horda horda) {
		this.horda = horda;
	}
	public Mapa getMapa() {
		return mapa;
	}
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	public int getCantHorda1() {
		return cantHorda1;
	}
	public void setCantHorda1(int cantHorda1) {
		this.cantHorda1 = cantHorda1;
	}
	public int getCantHorda2() {
		return cantHorda2;
	}
	public void setCantHorda2(int cantHorda2) {
		this.cantHorda2 = cantHorda2;
	}
	public int getCantHorda3() {
		return cantHorda3;
	}
	public void setCantHorda3(int cantHorda3) {
		this.cantHorda3 = cantHorda3;
	}
	public int getCantHorda4() {
		return cantHorda4;
	}
	public void setCantHorda4(int cantHorda4) {
		this.cantHorda4 = cantHorda4;
	}
    
}
