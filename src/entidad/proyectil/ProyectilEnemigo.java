package entidad.proyectil;

import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad.jugador.Jugador;
import entidad_grafica.EntidadGraficaProyectilEnemigo;
import movimiento.MovimientoVerticalProyectilEnemigo;
import visitor.Visitor;

public class ProyectilEnemigo extends Proyectil{
	public ProyectilEnemigo(int lim_inf,int lim_sup) {
		JLabel etiqueta = new JLabel();
		this.direccion =-1;
		this.velocidad = 1;
		this.cap_penetracion = 5;
		this.grafica = new EntidadGraficaProyectilEnemigo(etiqueta);
		this.movimiento = new MovimientoVerticalProyectilEnemigo(direccion,velocidad,grafica,lim_inf,lim_sup);
		
	}
	
	public void colisionar(Jugador j) {
		//hacer danio al jugador
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
