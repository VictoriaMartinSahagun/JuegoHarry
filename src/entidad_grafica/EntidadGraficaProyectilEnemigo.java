package entidad_grafica;

import javax.swing.JLabel;

public class EntidadGraficaProyectilEnemigo extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilEnemigo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilEnemigo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		imagen = "/img/AtaqueEnemigo.png";
	}
	

	
}
