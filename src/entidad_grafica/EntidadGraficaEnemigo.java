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
	 * Metodo que consulta las imagenes de la entidad grafica
	 * @return arreglo de imagenes de la entidad grafica.	
	 */
	public String[] getImagenes() {
		return this.imagenes;
	}
	
	/**
	 * Metodo que actualiza las imagenes de la entidad grafica
	 * @param img arreglo de nuevas imagenes de la entidad grafica
	 */
	public void setImagenes(String [] img) {
		this.imagenes=img;
	}
	
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[2]));
		grafica = nuevo;
	}
	
	public void daniar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[3]));
		grafica = nuevo;
	}
	
	public void liberar() {
		//ver como reproducir un gif y hacer q seaa herido, agarre la media y quede como bueno
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[1]));
		grafica = nuevo;
	}

	public void desaparecer() {
		this.etiqueta.setVisible(false);
	}

	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
}
