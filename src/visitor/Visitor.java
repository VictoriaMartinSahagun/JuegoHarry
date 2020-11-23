package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;
import entidad.jugador.*;

public abstract class Visitor {
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {}
	
	public void visitarEnemgioBeta(EnemigoBeta e) {}
	
	public void visitarJugador(Jugador j) {}
	
	public void visitarProyectilBase(ProyectilBase p) {}
	
	public void visitarProyectilMejorado(ProyectilMejorado p) {}
	
	public void visitarProyectilEnemigo(ProyectilEnemigo e) {}
	
	/*public void visitarEfectoCuarentena(EfectoCuarentena e) {}
	
	public void visitarEfectoSuperArma(EfectoSuperArma e) {}
	
	public void visitarPocion(Pocion p) {}*/
}
