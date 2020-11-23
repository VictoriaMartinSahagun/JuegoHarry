package entidad.enemigo;

import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectilEnemigo;
import juego.Juego;
import movimiento.Movimiento;
import movimiento.MovimientoVerticalEnemigo;
import visitor.Visitor;

public class EnemigoBeta extends Enemigo{
	protected int rango,direccion,velocidad;
	
	public EnemigoBeta(Juego j,JLabel label,int lim_inf, int lim_sup, int pos_x, int pos_y) {
		juego = j;
		activa=true;
		vida=150;
		danio_ataque=10;
		ent_graf = new EntidadGraficaEnemigo(label);
		rango = 15;
		direccion = -1;
		velocidad = 3;
		movimiento = new MovimientoVerticalEnemigo(direccion,velocidad, this,lim_inf,lim_sup);
		fabrica = new FabricaProyectilEnemigo();
		
		actualizarBordes();
	}
	
	@Override
	public void atacar() {
		ProyectilEnemigo proyectil = (ProyectilEnemigo) fabrica.crearProyectil(juego,this);
		juego.agregarProyectilActivo(proyectil);
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
		actualizarBordes();
	}
	
	/**
	 * Actualiza los bordes del enemigo.
	 */
	private void actualizarBordes() {
		JLabel lbl;
		
		lbl = ent_graf.getEtiqueta();
		
		borde_arriba =  pos_y + lbl.getY()/2;
		borde_abajo = pos_y - lbl.getY()/2;
		borde_izq = pos_x - lbl.getX()/2;
		borde_der = pos_x + lbl.getX()/2;
	}
	
	public void recibirDanio(int danio) {
		this.vida -= danio;
		
		if(this.vida <= 0) {
			ent_graf.desaparecer();
			//terminar juego?
		}else {
			ent_graf.daniar();
			//ent_graf.danio();
		}
		
	}
	
	/*
	//getters y setters

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
	public int getRango() {
		return this.rango;
	}

	@Override
	public void setRango(int rango) {
		this.rango=rango;
		
	}

	@Override
	public int getDireccion() {
		return this.direccion;
	}

	@Override
	public void setDireccion(int direccion) {
		this.direccion=direccion;
	}

	@Override
	public int getVelocidad() {
		return this.velocidad;
	}

	@Override
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
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
	}*/
}
