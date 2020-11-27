package entidad_grafica;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class EntidadGraficaJugador extends EntidadGrafica{
	private String harry = "/img/Harry.png", harry_daniado = "/img/HarryDaniado2.png";
	private String[] harry_muerto = {"/img/HarryMuerte2.png","/img/HarryMuerte3.png"};
	
	/**
	 * Crea una EntidadGraficaJugador nueva
	 */
	public EntidadGraficaJugador() {
		etiqueta = new JLabel();
		grafica = new ImageIcon();
		ImageIcon imagen = new ImageIcon(this.getClass().getResource(harry));
		grafica.setImage(imagen.getImage());
	}
	
	@Override
	public void daniar() {
		ImageIcon imagen;
		
		imagen = new ImageIcon(this.getClass().getResource(harry_daniado));
		grafica.setImage(imagen.getImage());
	}
	
	@Override
	public void moverEtiqueta(int x, int y) {
		etiqueta.setLocation(x,y);
	}
	
	@Override
	public void muerte() {
		ImageIcon imagen;
		
		imagen = new ImageIcon(this.getClass().getResource(harry_muerto[0]));
		grafica.setImage(imagen.getImage());
	}

	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
	
	
}












