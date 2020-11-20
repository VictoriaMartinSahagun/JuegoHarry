package entidad_grafica;

import javax.swing.ImageIcon;

public class EntidadGraficaProyectil extends EntidadGrafica{
	protected String imagen;
	
	public String getImagen() {
		return this.imagen;
	}
	
	public void setImagen(String s) {
		imagen = s;
	}
	
	public void disparo() {
		this.etiqueta.setIcon(new ImageIcon(this.getClass().getResource(imagen)));
	}
	
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}
}
