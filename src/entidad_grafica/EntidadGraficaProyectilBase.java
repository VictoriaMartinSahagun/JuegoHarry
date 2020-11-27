package entidad_grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class EntidadGraficaProyectilBase extends EntidadGraficaProyectil {
	
	/**
	 * Crea una EntidadGraficaProyectilBase nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaProyectilBase(JLabel etiqueta) {
		this.etiqueta = etiqueta;
		grafica = new ImageIcon();
		imagen = "/img/HechizoBase.png";
		etiqueta.setIcon(grafica);
		etiqueta.setBorder(new LineBorder(Color.black));
	}
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
