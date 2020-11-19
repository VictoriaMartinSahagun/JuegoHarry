package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import img.ImagenFondo;
import juego.Juego;

public class JFrameJuego extends JFrame {
	private Juego juego;
	/**
	 * Create the frame.
	 */
	public JFrameJuego() {
		
		//Creo el panel
		this.setIconImage(new ImageIcon(this.getClass().getResource("/img/iconoFrame.png")).getImage());
		ImagenFondo imagen_Fondo = new ImagenFondo(new ImageIcon(this.getClass().getResource("/img/FondoJuego.jpg")).getImage());
		setContentPane(imagen_Fondo);
		setTitle("Las aventuras de Potter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		//Comienza el juego
		
		initJuego();
		
	}
	
	private void initJuego(){
		juego = new Juego();
		/*
		menteTeclado = new MenteTeclado();
		menteTeclado.setJuego(this);
		menteTeclado.setNave(jLabelNaveJugador);
		this.addKeyListener(menteTeclado);
		megaMente = new MegaMente();
		megaMente.setJuego(this);
		megaMente.setNave(jLabelBoss);
		megaMente.preparar();
		megaMente.jugar();
		*/
	}
}
