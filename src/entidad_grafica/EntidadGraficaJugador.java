package entidad_grafica;

import javax.swing.*;

public class EntidadGraficaJugador{
	private String harry = "/img/Harry.png", harry_daniado = "/img/HarryDaniado2.png";
	private String[] harry_muerto = {"/img/HarryMuerte2.png","/img/HarryMuerte3.png"};
	private JLabel label;
	private ImageIcon grafico,imagen;
	
	public EntidadGraficaJugador(JLabel label) {
		this.label = label;
		grafico = new ImageIcon();
		imagen = new ImageIcon(this.getClass().getResource(harry));
		grafico.setImage(imagen.getImage());
	}
	
	
}
