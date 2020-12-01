package entidad_grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class EntidadGraficaPremioPocion extends EntidadGraficaPremio {
	
	/**
	 * Crea una EntidadGraficaPremioPocion nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioPocion(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/PremioPocion.png";
		this.etiqueta.setIcon(grafica);
		//etiqueta.setBorder(new LineBorder(Color.black));
	}
	
	public void iniciar() {
		//System.out.println(imagen);
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
