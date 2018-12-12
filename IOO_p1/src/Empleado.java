
public abstract class Empleado {
	protected String dni;
	protected String nombre;
	
	public Empleado(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public abstract float calcularSueldo();
	
}
