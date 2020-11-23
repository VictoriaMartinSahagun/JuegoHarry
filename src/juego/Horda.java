package juego;

import java.util.Random;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;
import fabrica.*;

public class Horda {
	private Enemigo[] horda;
	private int enemigos_restantes;
	private Juego juego;
	
	public Horda(int dificultad,Juego j) {
		this.juego = j;
		//Creo q lo mejor seria llamar a un metodo privado que con el parametro dificultad cree los Enemigos con los random
		switch (dificultad) {
			case 1: crearHorda(8);
			case 2: crearHorda(12);
			case 3: crearHorda(16);
			case 4: crearHorda(20);
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
	
	private void crearHorda(int chance) {
		Random rand = new Random();
		int randInt,posx,posy=0;
		JLabel etiquetaEnemigo;
		FabricaEnemigo fabrica;
		Enemigo enemigo;
		int cantLineas = chance / 4;
		for(int l=0;l<cantLineas;l++) {
			posx=0;
			for(int i=0;i<4;i++) {
				etiquetaEnemigo = new JLabel();
				etiquetaEnemigo.setBounds(200, 500, 100, 100);
				randInt = rand.nextInt(chance);
				if(randInt==0) {
					fabrica = new FabricaEnemigoBeta();
					enemigo = fabrica.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}else {
					fabrica = new FabricaEnemigoAlfa();
					enemigo = fabrica.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}
				posy=posy+150;
				//juego.agregarEnemigoActivo(enemigo);
			}
		}
	}
}
