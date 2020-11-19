package entidad_grafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidad.Entidad;

public abstract class EntidadGrafica {
	protected JLabel etiqueta;
	protected ImageIcon grafica;
	protected Entidad entidad;
	
	public abstract JLabel getEtiqueta();
	public abstract void setEtiqueta(JLabel eti);
	public abstract ImageIcon getGrafica();
	public abstract void setGrafica(ImageIcon img);
	public abstract Entidad getEntidad();
	public abstract void setEntidad(Entidad ent);
}
