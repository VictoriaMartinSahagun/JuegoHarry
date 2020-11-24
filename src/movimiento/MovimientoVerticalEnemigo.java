package movimiento;

import javax.swing.JLabel;

import entidad.enemigo.Enemigo;

public class MovimientoVerticalEnemigo extends MovimientoVertical {
	
	public MovimientoVerticalEnemigo(int dir, int vel, Enemigo e, int lim_inf, int lim_sup) {
		direccion = dir;
		velocidad = vel;
		entidad = e;
		lim_inferior = lim_inf;
		lim_superior = lim_sup;
	}
	
	@Override
	public void mover() {
		JLabel lbl;
		int pos_y;
		
		lbl = entidad.getEntidadGrafica().getEtiqueta();
		pos_y = lbl.getY() + direccion * velocidad;
		
		//si llega al final del mapa, aparece arriba
		if (pos_y <= this.lim_inferior) {
			lbl.setLocation(lbl.getX(), this.lim_superior);
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}
}
