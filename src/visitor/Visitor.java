package visitor;

import entidad.enemigo.*;
import entidad.proyectil.*;
import entidad.jugador.*;
import entidad.premio.EfectoArma;
import entidad.premio.EfectoCuarentena;
import entidad.premio.MejoraPocion;

public abstract class Visitor {
	
	public void visitarEnemigoAlfa(EnemigoAlfa e) {}
	
	public void visitarEnemigoBeta(EnemigoBeta e) {}
	
	public void visitarJugador(Jugador j) {}
	
	public void visitarProyectilBase(ProyectilBase p) {}
	
	public void visitarProyectilMejorado(ProyectilMejorado p) {}
	
	public void visitarProyectilEnemigo(ProyectilEnemigo e) {}
	
	public void visitarEfectoCuarentena(EfectoCuarentena e) {}
	
	public void visitarEfectoSuperArma(EfectoArma e) {}
	
	public void visitarPocion(MejoraPocion p) {}
}
