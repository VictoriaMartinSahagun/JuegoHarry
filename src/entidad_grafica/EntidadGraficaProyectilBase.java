package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	}
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(imagen));
		grafica.setImage(nuevo.getImage());
	}
}
