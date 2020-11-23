package movimiento;

import javax.swing.JLabel;
import entidad.proyectil.*;

public class MovimientoVerticalProyectilJugador extends MovimientoVertical{
	
	public MovimientoVerticalProyectilJugador(int dir, int vel, Proyectil p, int lim) {
		direccion = dir;
		velocidad = vel;
		entidad = p;
		lim_superior = lim;
	}
	
	
	@Override
	public void mover() {
		JLabel lbl = entidad.getEntidadGrafica().getEtiqueta();
		int pos_y = lbl.getY() + direccion * velocidad;
		
		//si se pasa del rango desaparece
		if (pos_y >= this.lim_superior) {
			//entidad.destruir();
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
		entidad.setPosY(pos_y);
	}

}
