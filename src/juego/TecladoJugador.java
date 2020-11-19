package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entidad.jugador.Jugador;

public class TecladoJugador implements KeyListener{
	
	private Jugador j;
	
	public TecladoJugador(Jugador j) {
		this.j = j;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int posX = j.getPosX();
		int factor_movimiento = 2;
		
		switch(e.getKeyCode()){
			
			//movimiento a izquierda
			case KeyEvent.VK_Q: {
				posX = posX - factor_movimiento;
				j.setPosX(posX);
				break;
			}
			//movimiento a derecha
			case KeyEvent.VK_S: {
				posX = posX + factor_movimiento;
				j.setPosX(posX);
				break;
			}
			//disparo
			case KeyEvent.VK_ENTER: {
				//TODO Disparo
				break;
			}
			
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	
}
