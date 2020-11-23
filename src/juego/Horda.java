package juego;

import entidad.enemigo.Enemigo;

public class Horda {
	private Enemigo[] horda;
	private int enemigos_restantes;
	
	public Horda(int cant, int dificultad) {
		
		//Creo q lo mejor seria llamar a un metodo privado que con el parametro dificultad cree los Enemigos con los random
		switch (dificultad) {
			case 1: //crear enemigos faciles
			case 2: //crear enemigos medios
			case 3: //crear enemigos dificiles
		}
	}

	public Enemigo[] getHorda() {
		return horda;
	}

	public void setHorda(Enemigo[] horda) {
		this.horda = horda;
	}

	public int getEnemigosRestantes() {
		return enemigos_restantes;
	}

	public void setEnemigosRestantes(int enemigos_restantes) {
		this.enemigos_restantes = enemigos_restantes;
	}
}
