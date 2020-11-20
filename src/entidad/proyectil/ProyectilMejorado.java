package entidad.proyectil;

import java.util.List;
import javax.swing.JLabel;
import entidad.Entidad;
import entidad_grafica.*;
import visitor.Visitor;
import movimiento.*;

public class ProyectilMejorado extends Proyectil{
	private JLabel lbl;
	
	public ProyectilMejorado(int lim) {
		lbl = new JLabel();
		direccion = MovimientoVertical.ARRIBA;
		velocidad = 1;
		cap_penetracion = 5;
		grafica = new EntidadGraficaProyectilMejorado(lbl);
		movimiento = new MovimientoVerticalProyectilJugador(direccion,velocidad,grafica,lim);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mover() {
		movimiento.mover();
	}
	
}