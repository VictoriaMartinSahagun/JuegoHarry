package entidad_grafica;

import javax.swing.JLabel;

public class EntidadGraficaPremioTiempo extends EntidadGraficaPremio{
	
	/**
	 * Crea una EntidadGraficaPremioTiempo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioTiempo(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		imagen = "/img/PremioTiempo.png";
	}
}
