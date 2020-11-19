package movimiento;

import entidad_grafica.EntidadGrafica;

public class MovimientoVertical extends Movimiento{
	
	public MovimientoVertical(int dir, int vel, EntidadGrafica e) {
		direccion = dir;
		velocidad = vel;
		entidad = e;
	}
	
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
	public void mover() {
		//Grafico g = entidad.getGrafico()
		//g.setPosition(g.getX() + direccion * velocidad, g.getY());
	}

}
