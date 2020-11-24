package entidad.premio;

import entidad.Entidad;
import juego.Juego;
import movimiento.Movimiento;

public abstract class Premio extends Entidad{
	protected String nombre;
	public abstract void activar(); 
}
