package premio;

import juego.Juego;
import movimiento.Movimiento;

public abstract class Premio {
	protected String nombre;
	protected Juego juego;
	protected Movimiento movimiento;
	public abstract void activar(); 
}
