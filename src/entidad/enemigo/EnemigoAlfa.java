package entidad.enemigo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import entidad.Entidad;
import entidad.proyectil.ProyectilEnemigo;
import entidad_grafica.EntidadGraficaEnemigo;
import fabrica.FabricaProyectilEnemigo;
import juego.Juego;
import movimiento.Movimiento;
import movimiento.MovimientoVerticalEnemigo;
import visitor.*;

public class EnemigoAlfa extends Enemigo{
	
	public EnemigoAlfa(Juego j, JLabel etiqueta,int lim_inf, int lim_sup, int pos_X, int pos_y) {
		juego = j;
		activa=true;
		vida=100;
		danio_ataque=5;
		ent_graf = new EntidadGraficaEnemigo(etiqueta);
		rango = 10;
		direccion = -1;
		velocidad = 2;
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
		v.visitarEnemigoAlfa(this);
	}

	@Override
	public List<Entidad> detectarColisiones() {
		List<Entidad> lista = new ArrayList<Entidad>();
		
		for (Entidad e: juego.getMapa().ElementosActivos()) {
			if( (e.getBordeIzq()>=borde_izq && e.getBordeIzq()<=borde_der) || (e.getBordeDer()>=borde_izq && e.getBordeDer()<=borde_der) ) {
				
				if(borde_abajo<=e.getBordeArriba()) {
					lista.add(e);
				}
				
			}
		}
		return lista;
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
	//Getters y setters
	
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
