package movimiento;

import javax.swing.JLabel;
import entidad_grafica.EntidadGrafica;

public class MovimientoVerticalProyectilJugador extends MovimientoVertical{
	
	public MovimientoVerticalProyectilJugador(int dir, int vel, EntidadGrafica ent_graf, int lim) {
		direccion = dir;
		velocidad = vel;
		entidad = ent_graf;
		lim_superior = lim;
	}
	
	
	@Override
	public void mover() {
		JLabel lbl = entidad.getEtiqueta();
		int pos_y = lbl.getY() + direccion * velocidad;
		
		//si se pasa del rango desaparece
		if (pos_y >= this.lim_superior) {
			//entidad.destruir();
		}else {
			lbl.setLocation(lbl.getX(), pos_y);
		}
		
	}

}
