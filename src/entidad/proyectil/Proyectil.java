package entidad.proyectil;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad_grafica.EntidadGraficaProyectil;
import movimiento.Movimiento;
import visitor.Visitor;

public abstract class Proyectil extends Entidad{
	protected int direccion,velocidad,cap_penetracion;
	protected EntidadGraficaProyectil grafica;
	protected Visitor visitor;
	protected Movimiento movimiento;	
	
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
	public int getCapPenetracion() {
		return cap_penetracion;
	}
	public void setCapPenetracion(int cap_penetracion) {
		this.cap_penetracion = cap_penetracion;
	}
	public EntidadGraficaProyectil getGrafica() {
		return grafica;
	}
	public void setGrafica(EntidadGraficaProyectil grafica) {
		this.grafica = grafica;
	}
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public Movimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
}
