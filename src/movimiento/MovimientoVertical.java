package movimiento;

public abstract class MovimientoVertical extends Movimiento{
	public static int ARRIBA = 1;
	public static int ABAJO = -1;
	protected int lim_inferior,lim_superior;
	
	@Override
	public void setDireccion(int d) {
		direccion = d;
		
	}
	
	@Override
	public int getDireccion() {
		return direccion;
	}

	@Override
	public abstract void mover();
}
