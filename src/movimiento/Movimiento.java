package movimiento;

import entidad.Entidad;
import entidad_grafica.EntidadGrafica;

public abstract class Movimiento {
	protected int direccion;
	protected int velocidad;
	protected EntidadGrafica entidad;
	
	public abstract int getDireccion();
	public abstract void setDireccion(int d);
	public abstract EntidadGrafica getEntidad();
	public abstract void setEntidad(EntidadGrafica e);
	public abstract void mover();
}
