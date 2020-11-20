package movimiento;

import javax.swing.JLabel;

import entidad_grafica.EntidadGrafica;

public class MovimientoVertical extends Movimiento{
	protected int lim_inferior,lim_superior;
	
	public MovimientoVertical(int dir, int vel, EntidadGrafica e, int lim_inf, int lim_sup) {
		direccion = dir;
		velocidad = vel;
		entidad = e;
		lim_inferior = lim_inf;
		lim_superior = lim_sup;
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
		JLabel lbl;
		int pos_y;
		
		lbl = entidad.getEtiqueta();
		pos_y = lbl.getY() + direccion * velocidad;
		
		//si llega al final de la pantalla vuelve a aparecer arriba
		if (pos_y <= this.lim_inferior) {
			lbl.setLocation(lbl.getX(), this.lim_superior);
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
	}

}
