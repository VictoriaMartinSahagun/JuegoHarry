package movimiento;

import javax.swing.JLabel;

import entidad_grafica.EntidadGrafica;

public abstract class MovimientoVertical extends Movimiento{
	protected int lim_inferior,lim_superior;
	
	@Override
	public int getDireccion() {
		return direccion;
	}

	@Override
	public void setDireccion(int d) {
		direccion = d;
		
	}

	@Override
	public EntidadGrafica getEntidad() {
		return entidad;
	}

	@Override
	public void setEntidad(EntidadGrafica e) {
		entidad = e;
		
	}

	@Override
	public abstract void mover();
}
