package entidad_grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class EntidadGraficaPremioSnitch extends EntidadGraficaPremio{
	
	/**
	 * Crea una EntidadGraficaPremioSnitch nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaPremioSnitch(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/PremioSnitch.png";
		etiqueta.setIcon(grafica);
		//etiqueta.setBorder(new LineBorder(Color.black));
	}
	
	@Override
	public void iniciar() {
		//System.out.println(imagen);
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
