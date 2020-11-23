package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;

import audio.AudioPlayer;
import entidad.jugador.Jugador;

import javax.swing.SwingUtilities;

import img.ImagenFondo;
import juego.Juego;
import juego.TecladoJugador;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class JFrameJuego extends JFrame {
	private Juego juego;
	private JPanel jPanelNivel;
	private JLabel jLabelVida;
	private JLabel lbl_jugador;
	private JToggleButton jToggleButtonAudio;
	private AudioPlayer ap;
	private Thread audio;
	private JTextField textField;
	
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
		initGUI();
		
		//initAudio();
		
	}
	
	private void initJuego(){
		juego = new Juego();
		juego.iniciar();
	}
	
	private void initGUI() {
		try {
			
			this.setLocationByPlatform(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			
			{//Panel nivel
				jPanelNivel = new JPanel();
				getContentPane().add(jPanelNivel, BorderLayout.CENTER);
				jPanelNivel.setLayout(null);
				jPanelNivel.setOpaque(false);
				
				{//Jugador
					lbl_jugador = new JLabel();
					lbl_jugador.setIcon(juego.getJugador().getEntidadGraficaJugador().getGrafica());
					lbl_jugador.setBounds(200, 500, 100, 100);
					juego.getJugador().getEntidadGraficaJugador().setEtiqueta(lbl_jugador);
					juego.getJugador().mover();
					jPanelNivel.add(lbl_jugador);
					addKeyListener(new TecladoJugador(juego,juego.getJugador(),0,400));
					
				}
				{//Contador vida
					int cantVida = 100;
					JLabel lblCantVida = new JLabel("Vida: "+cantVida+ " %");
					lblCantVida.setHorizontalAlignment(SwingConstants.RIGHT);
					lblCantVida.setForeground(Color.WHITE);
					lblCantVida.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
					lblCantVida.setBounds(10, 11, 109, 29);
					jPanelNivel.add(lblCantVida);
				}
				{//Enemigos
					
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		cerrarJuego();
	}
	
	private void cerrarJuego() {
		this.dispose();
		System.exit(0);
	}
	
	//private void initAudio() {}
	
	//private void jToggleButtonAudioActionPerformed(ActionEvent evt) {}
}
