package movimiento;

import javax.swing.JLabel;

import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGrafica;

public class MovimientoVerticalProyectilEnemigo extends MovimientoVertical{

	public MovimientoVerticalProyectilEnemigo(int dir, int vel, ProyectilEnemigo p, int lim_inf, int lim_sup) {
		direccion = dir;
		velocidad = vel;
		entidad = p;
		lim_inferior = lim_inf;
		lim_superior = lim_sup;
	}
	
	@Override
	public void mover() {
		JLabel lbl;
		int pos_y;
		
		lbl = entidad.getEntidadGrafica().getEtiqueta();
		pos_y = lbl.getY() + direccion * velocidad;
		
		//si se pasa del rango desaparece
		if (pos_y <= this.lim_inferior) {
			//entidad.destruir();
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}
	
}
