package entidad.enemigo;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectil;
import movimiento.Movimiento;

public abstract class Enemigo extends Entidad{
	protected int vida,danio_ataque,rango,direccion,velocidad;
	protected FabricaProyectil fabrica;
	
	public abstract void atacar();

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDanioAtaque() {
		return danio_ataque;
	}

	public void setDanioAtaque(int danio_ataque) {
		this.danio_ataque = danio_ataque;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public FabricaProyectil getFabrica() {
		return fabrica;
	}

	public void setFabrica(FabricaProyectil fabrica) {
		this.fabrica = fabrica;
	}
	
	
}
