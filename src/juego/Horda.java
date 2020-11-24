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
		switch (dificultad) {
			case 1: crearHorda(8,5);
			case 2: crearHorda(12,4);
			case 3: crearHorda(16,3);
			case 4: crearHorda(20,2);
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
	
	private void crearHorda(int cant_enemigos, int probabilidad) {
		int randInt,posx,posy=0;
		JLabel etiquetaEnemigo;
		FabricaEnemigo fabricaBase, fabricaMejorado;
		Enemigo enemigo;
		Random rand = new Random();
		horda = new Enemigo[cant_enemigos];
		
		int cantLineas = cant_enemigos / 4;
		int contEnemigos=0;
		
		fabricaBase = new FabricaEnemigoAlfa();
		fabricaMejorado = new FabricaEnemigoBeta();
		
		for(int l=0;l<cantLineas;l++) {
			posx=0;
			for(int i=0;i<4;i++) {
				etiquetaEnemigo = new JLabel();
				etiquetaEnemigo.setBounds(200, 500, 100, 100);
				randInt = rand.nextInt(probabilidad);
				if(randInt==0) {
					enemigo = fabricaMejorado.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}else {
					enemigo = fabricaBase.crearEnemigo(juego, etiquetaEnemigo, posx, posy);
				}
				posy=posy+150;
				horda[contEnemigos++] = enemigo;
				juego.agregarEnemigoActivo(enemigo);
			}
		}
	}
}
