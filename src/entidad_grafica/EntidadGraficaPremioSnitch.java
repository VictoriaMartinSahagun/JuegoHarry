package entidad_grafica;

import javax.swing.JLabel;

public class EntidadGraficaPremioSnitch extends EntidadGraficaPremio{
	
	/**
	 * Crea una EntidadGraficaPremioSnitch nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioSnitch(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		imagen = "/img/PremioSnitch.png";
	}
}
