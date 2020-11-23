package entidad.enemigo;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectil;
import movimiento.Movimiento;

public abstract class Enemigo extends Entidad{
	protected int vida,danio_ataque,rango,direccion,velocidad;
	protected EntidadGraficaEnemigo grafica;
	protected FabricaProyectil fabrica;
	
	public abstract void atacar();
	
	public abstract int getVida();
	public abstract void setVida(int vida);
	public abstract int getDanio();
	public abstract void setDanio(int danio);
	public abstract int getRango();
	public abstract void setRango(int rango);
	public abstract int getDireccion();
	public abstract void setDireccion(int direccion);
	public abstract int getVelocidad();
	public abstract void setVelocidad(int velocidad);
	public abstract EntidadGraficaEnemigo getEntidad();
	public abstract void setEntidad(EntidadGraficaEnemigo ent);
	public abstract Movimiento getMovimiento();
	public abstract void setMovimiento(Movimiento mov);
}
