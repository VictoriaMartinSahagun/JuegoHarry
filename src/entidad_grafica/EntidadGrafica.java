package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	protected JLabel etiqueta;
	protected ImageIcon grafica;
	
	public abstract JLabel getEtiqueta();
	
	public void setEtiqueta(JLabel etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public ImageIcon getGrafica() {
		return grafica;
	}
	
	public void setGrafica(ImageIcon grafica) {
		this.grafica = grafica;
	}
	
	public void iniciar() {}
	
	public void liberar() {}
	
	public void disparo() {}
	
	public void daniar() {}
	
	public void desaparecer() {
		//this.etiqueta.setVisible(false);
	}
	
	public void moverEtiqueta(int x, int y) {}
	
	public void muerte() {}
}