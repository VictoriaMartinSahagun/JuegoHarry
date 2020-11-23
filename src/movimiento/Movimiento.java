package movimiento;


import entidad.Entidad;
import entidad_grafica.EntidadGrafica;

public abstract class Movimiento {
	protected int direccion;
	protected int velocidad;
	protected Entidad entidad;
	
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
	public Entidad getEntidad() {
		return entidad;
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
	public abstract void mover();
}
