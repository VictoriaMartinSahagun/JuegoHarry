package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class EntidadGraficaEnemigo extends EntidadGrafica {
	private String [] imagenes;
	
	/**
	 * Crea una EntidadGraficaEnemigo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaEnemigo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagenes = new String[] {"/img/ElfoBueno.png","/img/ElfoLibre.png","/img/ElfoMalo.png","/img/ElfoMaloHerido.png"};
	}
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[2]));
		grafica = nuevo;
	}
	
	@Override
	public void liberar() {
		//ver como reproducir un gif y hacer q seaa herido, agarre la media y quede como bueno
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[1]));
		grafica = nuevo;
	}

	@Override
	public void daniar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[3]));
		grafica = nuevo;
	}
	
	@Override
	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}

	/**
	 * Establece las imagenes de la entidad grafica
	 * @param img arreglo de nuevas imagenes de la entidad grafica
	 */
	public void setImagenes(String [] img) {
		this.imagenes=img;
	}
	
	/**
	 * Consulta las imagenes de la entidad grafica
	 * @return arreglo de imagenes de la entidad grafica.	
	 */
	public String[] getImagenes() {
		return this.imagenes;
	}
	
	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
}
