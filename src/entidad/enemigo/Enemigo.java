package entidad.enemigo;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaEnemigo;
import movimiento.Movimiento;

public abstract class Enemigo extends Entidad{
	protected int vida;
	protected int danio_ataque;
	protected EntidadGraficaEnemigo grafica;
	
	public abstract void atacar();
	
	public abstract int getVida();
	public abstract void setVida(int vida);
	public abstract int getDanio();
	public abstract void setDanio(int danio);
	public abstract EntidadGraficaEnemigo getEntidad();
	public abstract void setEntidad(EntidadGraficaEnemigo ent);
	public abstract Movimiento getMovimiento();
	public abstract void setMovimiento(Movimiento mov);
}
