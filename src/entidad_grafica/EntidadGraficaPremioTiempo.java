package entidad_grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class EntidadGraficaPremioTiempo extends EntidadGraficaPremio{
	
	/**
	 * Crea una EntidadGraficaPremioTiempo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioTiempo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/PremioTiempo.png";
		etiqueta.setIcon(grafica);
		etiqueta.setBorder(new LineBorder(Color.black));
	}
	
	@Override
	public void iniciar() {
		//System.out.println(imagen);
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
