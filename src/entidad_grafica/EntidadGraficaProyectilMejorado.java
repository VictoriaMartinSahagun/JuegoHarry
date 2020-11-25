package entidad_grafica;

import javax.swing.JLabel;

public class EntidadGraficaProyectilMejorado extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilMejorado nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilMejorado(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		imagen = "/img/HechizoMejorado.png";
	}
	
}