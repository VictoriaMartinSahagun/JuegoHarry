package entidad_grafica;

import javax.swing.JLabel;

public class EntidadGraficaPremioPocion extends EntidadGraficaPremio {
	
	/**
	 * Crea una EntidadGraficaPremioPocion nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioPocion(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		imagen = "/img/PremioPocion.png";
	}
}
