package entidad.enemigo;

import entidad.Entidad;
import fabrica.FabricaProyectil;
import movimiento.Movimiento;

public abstract class Enemigo extends Entidad{
	protected int vida,danio_ataque,rango,direccion,velocidad;
	protected FabricaProyectil fabrica;
	
	/**
	 * Metodo de ataque
	 */
	public abstract void atacar();

	/**
	 * Establece la vida
	 * @param vida int
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Establece el danio del ataque
	 * @param danio_ataque int
	 */
	public void setDanioAtaque(int danio_ataque) {
		this.danio_ataque = danio_ataque;
	}

	/**
	 * Establece la direccion
	 * @param direccion int
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Establece la velocidad
	 * @param velocidad int
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/**
	 * Establece el rango afectado
	 * @param rango int
	 */
	public void setRango(int rango) {
		this.rango = rango;
	}
	
	/**
	 * Establece la fabrica
	 * @param fabrica FabricaProyectil
	 */
	public void setFabrica(FabricaProyectil fabrica) {
		this.fabrica = fabrica;
	}
	
	/**
	 * Establece el movimiento
	 * @param mov Movimiento
	 */
	public void setMovimiento(Movimiento mov) {
		this.movimiento=mov;
	}
	
	/**
	 * Consulta la vida
	 * @return vida
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Consulta el danio del ataque
	 * @return danio
	 */
	public int getDanioAtaque() {
		return danio_ataque;
	}
	
	/**
	 * Consulta el rango afectado
	 * @return rango
	 */
	public int getRango() {
		return rango;
	}

	/**
	 * Consulta la direccion
	 * @return direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * Consulta velocidad
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * Consulta fabrica del proyectil
	 * @return fabrica
	 */
	public FabricaProyectil getFabrica() {
		return fabrica;
	}	
	
	/**
	 * Consulta el movimiento
	 * @return movimiento
	 */
	public Movimiento getMovimiento() {
		return this.movimiento;
	}

}
