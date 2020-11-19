package entidad.enemigo;

import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad_grafica.EntidadGrafica;
import entidad_grafica.EntidadGraficaEnemigo;
import juego.Juego;
import movimiento.Movimiento;
import movimiento.MovimientoVertical;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public class EnemigoBeta extends Enemigo{
	protected int rango,direccion,velocidad;
	
	public EnemigoBeta(Juego j,JLabel label) {
		juego = j;
		v = new VisitorEnemigo();
		activa=true;
		vida=100;
		danio_ataque=10;
		grafica = new EntidadGraficaEnemigo(label);
		rango = 15;
		direccion = -1;
		velocidad = 3;
		movimiento = new MovimientoVertical(direccion,velocidad, grafica);
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
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

	@Override
	public int getVida() {
		return vida;
	}

	@Override
	public void setVida(int vida) {
		this.vida=vida;
		
	}

	@Override
	public int getDanio() {
		return this.danio_ataque;
	}

	@Override
	public void setDanio(int danio) {
		this.danio_ataque=danio;	
	}

	@Override
	public EntidadGraficaEnemigo getEntidad() {
		return this.grafica;
	}

	@Override
	public void setEntidad(EntidadGraficaEnemigo ent) {
		this.grafica=ent;
	}

	@Override
	public Movimiento getMovimiento() {
		return this.movimiento;
	}

	@Override
	public void setMovimiento(Movimiento mov) {
		this.movimiento=mov;
	}
}
