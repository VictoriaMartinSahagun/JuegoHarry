package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaPremio extends EntidadGrafica{
	protected String imagen;
	
	public String getImagen() {
		return this.imagen;
	}
	
	public void setImagen(String s) {
		imagen = s;
	}
	
	public void iniciar() {
		this.etiqueta.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}

	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
}
