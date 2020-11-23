package entidad_grafica;

import javax.swing.*;

public class EntidadGraficaJugador extends EntidadGrafica{
	private String harry = "/img/Harry.png", harry_daniado = "/img/HarryDaniado2.png";
	private String[] harry_muerto = {"/img/HarryMuerte2.png","/img/HarryMuerte3.png"};
	
	public EntidadGraficaJugador() {
		ImageIcon imagen;
		grafica = new ImageIcon();
		imagen = new ImageIcon(this.getClass().getResource(harry));
		grafica.setImage(imagen.getImage());
	}
	
	public void moverEtiqueta(int x, int y) {
		etiqueta.setLocation(x,y);
	}
	
	public void daniar() {
		ImageIcon imagen;
		
		imagen = new ImageIcon(this.getClass().getResource(harry_daniado));
		grafica.setImage(imagen.getImage());
		
		//COMO METO UN DELAY ACA?
		
		imagen = new ImageIcon(this.getClass().getResource(harry));
		grafica.setImage(imagen.getImage());
	}
	
	public void muerte() {
		ImageIcon imagen;
		
		imagen = new ImageIcon(this.getClass().getResource(harry_muerto[0]));
		grafica.setImage(imagen.getImage());
	}
	
	
}












