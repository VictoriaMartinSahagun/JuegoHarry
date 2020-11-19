package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidad.Entidad;
import entidad.enemigo.Enemigo;

public class EntidadGraficaEnemigo extends EntidadGrafica {
	private String [] imagenes;
	
	/**
	 * Crea una EntidadGraficaEnemigo nueva
	 */
	public EntidadGraficaEnemigo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagenes = new String[] {"/img/ElfoBueno.png","/img/ElfoLibre.png","/img/ElfoMalo.png","/img/ElfoMaloHerido.png"};
	}
	
	/**
	 * Metodo que consulta el grafico de la entidad grafica
	 * @return grafico de la entidad grafica.
	 */
	public ImageIcon getGrafico() {
		return this.grafica;
	}
	
	/**
	 * Metodo que consulta las imagenes de la entidad grafica
	 * @return arreglo de imagenes de la entidad grafica.	
	 */
	public String[] getImagenes() {
		return this.imagenes;
	}
	
	/**
	 * Metodo que consulta la etiqueta de la entidad grafica
	 * @return etiqueta de la entidad grafica.
	 */
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
	
	/**
	 * Metodo que actualiza el grafico de la entidad grafica
	 * @param graf grafico nuevo de la entidad grafica. 
	 */
	public void setGrafico(ImageIcon graf) {
		this.grafica=graf;
	}
	
	/**
	 * Metodo que actualiza las imagenes de la entidad grafica
	 * @param img arreglo de nuevas imagenes de la entidad grafica
	 */
	public void setImagenes(String [] img) {
		this.imagenes=img;
	}
	
	/**
	 * Metodo que actualiza la etiqueta de la entidad grafica
	 * @param lbl etiqueta nueva de la entidad grafica.
	 */
	public void setEtiqueta(JLabel lbl) {
		this.etiqueta=lbl;
	}
	
	public void daniar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[4]));
		grafica = nuevo;
	}
	
	public void liberar() {
		//ver como reproducir un gif y hacer q seaa herido, agarre la media y quede como bueno
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[2]));
		grafica = nuevo;
	}

	@Override
	public ImageIcon getGrafica() {
		return this.grafica;
	}

	@Override
	public void setGrafica(ImageIcon img) {
		this.grafica=img;
	}

}
