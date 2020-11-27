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
import javax.swing.border.LineBorder;

import audio.AudioPlayer;
import entidad.Entidad;
import entidad.jugador.Jugador;
import img.ImagenFondo;

import javax.swing.SwingUtilities;

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
	private Thread t;
	
	/**
	 * Metodo creo el frame del juego
	 */
	public JFrameJuego() {
		
		//Creo el panel
		this.setIconImage(new ImageIcon(this.getClass().getResource("/img/iconoFrame.png")).getImage());
		ImagenFondo imagen_Fondo = new ImagenFondo(new ImageIcon(this.getClass().getResource("/img/FondoJuego.jpg")).getImage());
		setContentPane(imagen_Fondo);
		setTitle("Las aventuras de Potter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		jPanelNivel = new JPanel();
		
		//Comienza el juego
		initJuego();
		initGUI();
		
		//initAudio();
		
	}
	
	/**
	 * Metodo inicio el juego
	 */
	private void initJuego(){
		juego = new Juego(this);
		juego.iniciar();
		t = new Thread(juego);
		t.start();
		
	}
	
	/**
	 * Metodo inicio la gui
	 */
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
			
			//Panel nivel
			getContentPane().add(jPanelNivel, BorderLayout.CENTER);
			jPanelNivel.setLayout(null);
			jPanelNivel.setOpaque(false);
				
			//Jugador
			lbl_jugador = new JLabel();
			lbl_jugador.setIcon(juego.getJugador().getEntidadGrafica().getGrafica());
			lbl_jugador.setBounds(200, 500, 100, 100);
			lbl_jugador.setBorder(new LineBorder(Color.black));
			juego.getJugador().getEntidadGrafica().setEtiqueta(lbl_jugador);
			juego.getJugador().mover();
			jPanelNivel.add(lbl_jugador);
			addKeyListener(new TecladoJugador(juego,juego.getJugador(),0,540));
				
			
			//Contador vida
			int cantVida = 100;
			JLabel lblCantVida = new JLabel("Vida: "+cantVida+ " %");
			lblCantVida.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCantVida.setForeground(Color.WHITE);
			lblCantVida.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
			lblCantVida.setBounds(10, 11, 109, 29);
			jPanelNivel.add(lblCantVida);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo cierro la ventana
	 * @param evt WindowEvent
	 */
	private void thisWindowClosing(WindowEvent evt) {
		cerrarJuego();
	}
	
	/**
	 * Metodo cerrar juego
	 */
	private void cerrarJuego() {
		this.dispose();
		System.exit(0);
	}
	
	public JPanel getPanel() {
		return jPanelNivel;
	}
	
	//private void initAudio() {}
	
	//private void jToggleButtonAudioActionPerformed(ActionEvent evt) {}
}
