package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGraficaPremio extends EntidadGrafica{
	protected String imagen;
	
	@Override
	public void iniciar() {
		this.etiqueta.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	
	@Override
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}

	/**
	 * Establece la imagen
	 * @param s ruta de ka imagen
	 */
	public void setImagen(String s) {
		imagen = s;
	}
	
	/**
	 * Consulta la imagen 
	 * @return imagen
	 */
	public String getImagen() {
		return this.imagen;
	}
	
	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
	
}
